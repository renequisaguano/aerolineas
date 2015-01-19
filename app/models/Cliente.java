package models;

import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {
	
	public String cedula;
	public String direccion;
	public String ciudad;
	public String telefono;
	public String celular;
	public Cliente(String nombre, String apellido, String email,
			String contraseña, String cedula, String direccion, String ciudad,
			String telefono, String celular) {
		super(nombre, apellido, email, contraseña);
		this.cedula = cedula;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.celular = celular;
	}	
	
}
