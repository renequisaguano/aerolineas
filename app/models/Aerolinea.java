package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Aerolinea extends Model {
	
    @Required
    @Unique
    public String nombre;
    @Required
	public String descripcion;
	
	public String toString(){
			
			return this.nombre;
		}
	public String toAdicional1(){
		return this.descripcion;
	}
	
	public String toAdicional2(){
		return null;
	}
}
