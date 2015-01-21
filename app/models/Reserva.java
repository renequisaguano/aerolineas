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
	public Reserva(Vuelo_Categoria lista, Usuario cliente) {
		super();
		this.fechaReserva = new Date();
		this.lista = lista;
		this.cliente = cliente;
	}
	
}
