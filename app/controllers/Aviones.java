package controllers;

import models.Avion;
import models.Usuario;
import play.mvc.Before;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(Avion.class)
public class Aviones extends CRUD{
	@Before
	public static void mostrarUsuario(){
		Usuario user = Usuario.find("byEmail", Security.connected()).first();
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
	        renderArgs.put("conectado", user.nombre+" "+user.apellido); 
	    }
	}

}
