package controllers;

import java.util.List;

import models.Reserva;
import models.Usuario;
import models.Vuelo_Categoria;
import play.mvc.Before;
import play.mvc.Controller;

public class Compras extends Controller{
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
	
	public static void  index() {
		List<Vuelo_Categoria> boletos= Vuelo_Categoria.findAll();
		render(boletos);
	}
	public static void comprar(Long id){
		Usuario usu = Usuario.find("byEmail", Security.connected()).first();
		Vuelo_Categoria lista = Vuelo_Categoria.findById(id);
		Reserva resNueva = new Reserva(lista, usu);
		resNueva.save();
		redirect("/compras");
	}

}
