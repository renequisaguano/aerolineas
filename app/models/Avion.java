package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Avion extends Model {
	@Required
	@Unique
	public String serie;
	@Required
	@Unique
	public String placa;
	@Required
	public String marca;
	@Required
	public int capacidad;
	@Required
	@ManyToOne
	public Aerolinea aerolinea;
	public String toString(){
		
		return "Serie: "+this.serie;
	}
	public String toAdicional1(){
		
		return "Marca: "+this.marca;
	}
	
	public String toAdicional2(){
		
		return "Capacidad: "+this.capacidad+" personas";
	}
	
	
	
    
}
