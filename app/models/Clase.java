package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Clase extends Model{
	public int numero;
	public Categoria clase;
	public String tipo;
}
