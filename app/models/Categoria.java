package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Categoria extends Model{
	public String descripcion;
	public Double valor;
	@ManyToOne
	public Avion avion;
}
