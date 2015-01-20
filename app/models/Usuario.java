package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Usuario extends Model {
	public String email;
	public String password;
	public String nombre;
	public String apellido;
	public boolean isAdmin;
	public Usuario(String email, String password, String nombre, String apellido) {
		super();
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.isAdmin=false;
	}
    
	
}
