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
	
	
	public String toString(){
		
		return descripcion;
				
	}
	
	public String toAdicional1(){
		return String.valueOf(this.valor);
	}
	
	public String toAdicional2(){
		return this.avion.serie+" "+this.avion.marca;
	}
}
