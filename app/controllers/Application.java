package controllers;

import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;

public class Application extends Controller {
	
	@Before
	public static void mostrarUsuario(){
	
		Usuario user = Usuario.find("byEmail", Security.connected()).first();
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
	        renderArgs.put("conectado", user.nombre+" "+user.apellido); 
	    }
		
	}
    

    public static void index() {
   	
        render();
    }
       

}
