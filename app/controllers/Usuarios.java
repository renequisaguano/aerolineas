package controllers;

import java.util.List;

import models.Cliente;
import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
@With(Secure.class)
public class Usuarios extends Controller {
	@Before
	public static void mostrarUsuario(){
		try{
			Usuario user = Usuario.find("byEmail", Security.connected()).first();
			//obteniendo datos del usuario que ha iniciado sesion
			if(Security.isConnected()) {
		        renderArgs.put("conectado", user.nombre+" "+user.apellido); 
		    }
			}catch(Exception ex){
				
			}
	}
	public static void index()  {
		Usuario usu = Usuario.find("byEmail", Security.connected()).first();
		Cliente cli= Cliente.find("user_id=?", usu.id).first();
		if(cli== null)
		{
			flash.error("no");
		}
		render(usu,cli);
	}
	public static void guardarCliente(String ced,String cel,String ciu,String dir,String tel) {
		
		Usuario usua = Usuario.find("byEmail", Security.connected()).first();
		Cliente cliNuevo = new Cliente(ced, dir, ciu, tel, cel, usua);
		cliNuevo.save();	
		flash.success("si");
		
		redirect("/usuarios");
	}
}
