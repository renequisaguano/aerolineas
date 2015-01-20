package models;

import play.*;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Escala extends Model {
	@Required
	@ManyToOne
	public Vuelo vuelo;
	@Required
	@Unique
	public String ciudad;

	

	public String toString(){
		
		return this.ciudad;
	}
	public String toAdicional1(){
		
		return "# "+vuelo.numero+" Desde "+vuelo.origen+" -> Hacia "+vuelo.destino;
	}
	
	public String toAdicional2(){
		
		return null;
	}
	
	
    
}
