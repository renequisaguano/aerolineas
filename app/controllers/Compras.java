package controllers;

import java.util.List;

import models.Reserva;
import models.Usuario;
import models.Vuelo_Categoria;
import play.mvc.Before;
import play.mvc.Controller;

public class Compras extends Controller {
	@Before
	public static void mostrarUsuario() {
		try {
			Usuario user = Usuario.find("byEmail", Security.connected())
					.first();
			// obteniendo datos del usuario que ha iniciado sesion
			if (Security.isConnected()) {
				renderArgs.put("conectado", user.nombre + " " + user.apellido);
			}
		} catch (Exception ex) {

		}
	}

	public static void index() {
		List<Vuelo_Categoria> boletos = Vuelo_Categoria.all().fetch();
		render(boletos);
	}

	public static void comprar(Long id, int cantidad, String tipo) {
		Usuario usu = Usuario.find("byEmail", Security.connected()).first();
		Vuelo_Categoria lista = Vuelo_Categoria.findById(id);
		if (tipo.equals("Ventana") && cantidad <= lista.puestosVentana) {
			lista.puestosVentana = lista.puestosVentana - cantidad;
			lista.save();
			Reserva resNueva = new Reserva(lista, usu, cantidad);
			resNueva.save();
			flash.success("Compra Exitosa");
		} else {
			if (tipo.equals("Passillo") && cantidad <= lista.puestosPasillo) {
				lista.puestosPasillo = lista.puestosPasillo - cantidad;
				lista.save();
				Reserva resNueva = new Reserva(lista, usu, cantidad);
				resNueva.save();
				flash.success("Compra Exitosa");
			} else {
				flash.error("Lo sentimos la transaccion no ha sido posible verifique que los datos sean correctos e intentelo de nuevo ");
			}

		}

		redirect("/compras#prin");
	}

	public static void uno(Long id) {
		Vuelo_Categoria lista = Vuelo_Categoria.findById(id);
		render(lista);
	}
	public static void repo(){
		Usuario usu = Usuario.find("byEmail", Security.connected()).first();
		List<Reserva> res= Reserva.find("cliente_id=?",usu.id).fetch();
		//res.get(1).lista.valor
		render(res);
	}

}
