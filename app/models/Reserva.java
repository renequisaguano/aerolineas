package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;
@Entity
public class Reserva extends Model {
	public Date fechaReserva;
	@ManyToOne
	public Vuelo vuelo;
	public boolean estado;
}
