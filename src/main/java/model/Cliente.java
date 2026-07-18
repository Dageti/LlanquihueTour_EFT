package model;

import interfaces.Registrable;

/**
 * Modelo que representa a un cliente, hereda de persona, puede generar reservas de tours.
 */

public class Cliente extends Persona implements Registrable {
	private String correo;

	/**
	 * Constructor de la clase Cliente
	 *
	 * @param nombre    nombre del cliente
	 * @param telefono  teléfono del cliente
	 * @param direccion dirección del cliente
	 * @param rut       rut del cliente
	 * @param correo    correo del cliente
	 */
	public Cliente(String nombre, String telefono, Direccion direccion, Rut rut, String correo) {
		super(nombre, telefono, direccion, rut);
		this.correo = correo;
	}

	/**
	 * Métodos Getters y Setters de la clase Cliente
	 */

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

	@Override
	public String mostrarDatos() {
		return toString();
	}

	@Override
	public String toString() {
		return super.toString() + ", Correo=" + correo;
	}
}

