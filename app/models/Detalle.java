package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Detalle extends Model{
	@ManyToOne
	public Reserva reserva;
	@ManyToOne
	public Usuario usuario;
	@ManyToOne
	public Puesto puesto;
	public int cantidad;
	public double valor;
}
