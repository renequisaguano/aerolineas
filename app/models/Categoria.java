package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Categoria extends Model{
	public String descripcion;

	
	public String toString(){
		
		return descripcion;
				
	}
	
	public String toAdicional1(){
		return null;
	}
	
	public String toAdicional2(){
		return null;
	}
}
