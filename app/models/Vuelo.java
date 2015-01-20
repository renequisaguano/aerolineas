package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Vuelo extends Model{
	@Required
	@Unique
	public String numero;
	@Required
	public String fechaSalida;
	@Required
	public String fechaLlegada;
	@Required
	public String origen;
	@Required
	public String destino;
	@ManyToOne
	public Avion avion;
	
	
	public String toString(){
		
		return "# "+numero+" Desde "+this.origen+" -> Hacia "+this.destino;
				
	}
	
	public String toAdicional1(){
		return  "Salida: "+this.fechaSalida ;
	}
	
	public String toAdicional2(){
		return "LLegada: "+this.fechaLlegada;
	}
}


