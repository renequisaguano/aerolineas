package controllers;


import java.util.Random;

import models.Usuario;
import play.mvc.With;



public class Security extends Secure.Security {
	
	static boolean authenticate(String username, String password){
        Usuario user = Usuario.find("byEmail", username).first();

        return user != null && user.password.equals(password);
    }
	
	
	public static void guardarUsuario(String email, String emailRepetido, String nombre,String apellido){
		
		flash.put("nombre", nombre);
		flash.put("apellido", apellido);
		flash.put("email", email);
		flash.put("emailRepetido", emailRepetido);
	
		if(email.equals(emailRepetido)){
			
			
			Usuario user = Usuario.find("byEmail",email).first(); //buscando si el usuario ya ha sido registrado
			System.out.println(user);
			System.out.println(user.equals(null));
			if (user.equals(null)){
				String password=generarClave(nombre);
				Usuario u=new Usuario(email,password,nombre,apellido);
				u.save();
				String mensaje="<h1>Bienvenido a la plataforma VUELOS </h1><br> Esta es su contraseña:<b> "+password+" </b><br>"+
							"Enlace para Iniciar Sesión: <h3>http://localhost:9000/login</h3>";
				Email mail=new Email(email,mensaje);
				redirect("/security/confirmacion");
				
			}else{
		
			flash.put("existente", "Esta cuenta ya esta en uso");
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


}
