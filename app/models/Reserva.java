package models;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;
@Entity
public class Reserva extends Model {
	public Date fechaReserva;
	@ManyToOne
	public Vuelo_Categoria lista;
	@ManyToOne
	public Usuario cliente;
	public int cantidad;
	
	public Reserva(Vuelo_Categoria lista, Usuario cliente,int cantidad) {
		super();
		this.fechaReserva = new Date();
		this.lista = lista;
		this.cliente = cliente;
		this.cantidad=cantidad;
		
	}
	
}
