package model;

import interfaces.Registrable;

/**
 * Modelo que representa a un trabajador de Llanquihue Tours, hereda de persona, posee un cargo dentro de la organización.
 */

public class Empleado extends Persona implements Registrable {
	private String cargo;

	/**
	 * Constructor de la clase empleado
	 *
	 * @param nombre    nombre del empleado
	 * @param telefono  teléfono del empleado
	 * @param direccion dirección del empleado
	 * @param rut       rut del empleado
	 * @param cargo     cargo del empleado
	 */

	public Empleado(String nombre, String telefono, Direccion direccion, Rut rut, String cargo) {
		super(nombre, telefono, direccion, rut);
		this.cargo = cargo;
	}

	/**
	 * Métodos Getters y Setters de la clase Empleado
	 */
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


	@Override
	public String mostrarDatos() {
		return super.toString() + ", Cargo=" + cargo;
	}
}
