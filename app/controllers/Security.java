package controllers;


import java.util.Random;

import models.Usuario;
import play.data.validation.Required;
import play.mvc.Before;
import play.mvc.With;



public class Security extends Secure.Security {
	@Before
	public static void mostrarUsuario(){
		Usuario user = Usuario.find("byEmail", Security.connected()).first();
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
	        renderArgs.put("conectado", user.nombre+" "+user.apellido); 
	    }
	}
	
	static boolean authenticate(@Required String username, String password){
        Usuario user = Usuario.find("byEmail", username).first();
        return user != null && user.password.equals(password);
        
    }
	

	
	
	public static void guardarUsuario(String email, String emailRepetido, String nombre,String apellido){
		
		flash.put("nombre", nombre);
		flash.put("apellido", apellido);
		flash.put("email", email);
		flash.put("emailRepetido", emailRepetido);
	
		if(email.equals(emailRepetido)){
			
			//buscando si el usuario ya ha sido registrado
			Usuario user = Usuario.find("byEmail",emailRepetido).first(); 
			System.out.println(user);
			if (user == null){
				String password=generarClave(nombre);
				Usuario u=new Usuario(email,password,nombre,apellido);
				u.save();
				String mensaje="<h1>Bienvenido a la plataforma VUELOS </h1><br> <h4>Esta es su contraseña: </h4> <b> "+password+" </b><br>"+
							"<h4>Este es el Enlace para Iniciar Sesión:</4> <h3>http://localhost:9000/login</h3>"+
							"<br><h3>NOTA: Se recomienda no copiar y pegar la contraseña, es mejor verla y escribirla uno mismo.</h3>";
				Email mail=new Email(email,mensaje);
				redirect("/security/confirmacion");
		
			}else{
		
			flash.put("existente", "Error: Esta cuenta ya esta en uso");
			redirect("/security/registro");
			}
	
		}else
		{
			
			
			flash.error("Error: El email ingresado no coincide");
			redirect("/security/registro");
		}
		
		
	}
	
	public static String generarClave(String nombre){
		String clave=nombre;
		Random rnd = new Random();
		for(int i = 1; i<=5; i++)
			clave+=rnd.nextInt(20);
		return clave;
	}
	  public static void confirmacion(){
		   render();
	   }
	
	  public static void registro(){
		   render();
	   }
	  
	  public static void cuenta(){
		  Usuario user = Usuario.find("byEmail", Security.connected()).first();
			flash.put("nombre", user.nombre);
			flash.put("apellido", user.apellido);
			flash.put("email", user.email);
		  
		  render();
	  }
	  
	  public static void actualizarCuenta(String nombre, String apellido, String password, String passwordNuevo){
		  Usuario user = Usuario.find("byEmail", Security.connected()).first();
		  String pass=user.password;
		  if (password.equals(pass)){
			  
			  user.nombre=nombre;
			  user.apellido=apellido;
			  flash.put("confirmacion", "Los Datos se han Actualizado");		  
			  if (!passwordNuevo.equals("")){
				  user.password=passwordNuevo;
				  flash.put("confirmacion", "Los Datos / Contraseña se han Actualizado ");
				  
			  }
			  user.save();
			  redirect("/security/cuenta");
			  
			  
		  }else{
			  flash.put("error", "Contraseña Incorrecta");
			  redirect("/security/cuenta");
		  }
	  }


}
