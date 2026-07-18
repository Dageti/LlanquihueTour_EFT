package model;

/**
 * Modelado de clase Persona(persona), atributos: nombre, teléfono y dirección
 */
public class Persona {
	private String nombre;
	private String telefono;
	private Direccion direccion;
	private Rut rut;

	/**
	 * Constructor de la clase Persona
	 *
	 * @param nombre    el nombre de la persona
	 * @param telefono  el teléfono de la persona
	 * @param direccion la dirección de la persona
	 * @param rut       el RUT de la persona
	 */
	public Persona(String nombre, String telefono, Direccion direccion, Rut rut) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.rut = rut;
	}

	/**
	 * Métodos Getters y Setters de la clase Persona
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Rut getRut() {
		return rut;
	}

	public void setRut(Rut rut) {
		this.rut = rut;
	}

	@Override
	public String toString() {
		return
				nombre + " " + rut + ", Teléfono=" + telefono + ", Dirección=" + direccion;
	}
}
