package model;

import interfaces.Registrable;

public class Empleado extends Persona implements Registrable {
	private String cargo;

	public Empleado(String nombre, int telefono, Direccion direccion, Rut rut, String cargo) {
		super(nombre, telefono, direccion, rut);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public void registrar() {
		System.out.println("Registrando empleado");
	}


	// Recordar modificar esta parte
	@Override
	public String mostrarDatos() {
		return null;
	}
}
