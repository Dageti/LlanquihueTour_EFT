package model;

import interfaces.Registrable;

public class Cliente extends Persona implements Registrable {
	private String correo;

	public Cliente(String nombre, int telefono, Direccion direccion, Rut rut, String correo) {
		super(nombre, telefono, direccion, rut);
		this.correo = correo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public void registrar() {
		System.out.println("Registrando Cliente");
	}


	// Recordar modificar esta parte
	@Override
	public String mostrarDatos() {
		return null;
	}
}
