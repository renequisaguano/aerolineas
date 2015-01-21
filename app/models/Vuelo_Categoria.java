package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Vuelo_Categoria extends Model {
	@Required
	@ManyToOne
	public Vuelo vuelo;
	@Required
	@ManyToOne
	public Categoria categoria;  
	@Required
	public double valor;
	@Required
	public String puertaEmbarque;	
	public String toString(){
		
			return this.categoria.descripcion;
		}
	public String toAdicional1(){
		return "# " +this.vuelo.numero+" DESDE: "+this.vuelo.origen+" -> HACIA: "+this.vuelo.destino;
	}
	
	public String toAdicional2(){
		return " FECHA DE SALIDA: "+this.vuelo.fechaSalida+" -> FECHA DE LLEGADA: "+this.vuelo.fechaSalida+" -> PUERTA DE EMARQUE: "+puertaEmbarque+ " >VALOR: $"+this.valor;
	}
	public int getDisponibles(){
		long comprados = Reserva.count("lista_id = ?",this.id);
		return (int) (this.vuelo.avion.capacidad-comprados);		
	}
}
