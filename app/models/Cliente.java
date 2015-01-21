package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Cliente extends Model {

	public String cedula;
	public String direccion;
	public String ciudad;
	public String telefono;
	public String celular;
	@Unique
	@OneToOne
	public Usuario user;
	public Cliente(String cedula, String direccion, String ciudad,
			String telefono, String celular, Usuario user) {
		super();
		this.cedula = cedula;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.celular = celular;
		this.user = user;
	}

	

}
