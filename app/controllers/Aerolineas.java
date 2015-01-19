package controllers;

import models.Usuario;
import play.mvc.*;

@With(Secure.class)
public class Aerolineas extends CRUD {
	@Before
	public static void mostrarUsuario(){
		Usuario user = Usuario.find("byEmail", Security.connected()).first();
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
	        renderArgs.put("conectado", user.nombre+" "+user.apellido); 
	    }
	}
  

}
