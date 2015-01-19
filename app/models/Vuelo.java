package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Vuelo extends Model{
	public String numero;
	public Date fechaSalida;
	public Date fechaLlegada;
	public String origen;
	public String destino;
	public String puertaEmbarque;
	@ManyToOne
	public Avion avion;
	
}
