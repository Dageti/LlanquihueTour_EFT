package model;

import interfaces.Registrable;

/**
 * Modelado de la clase Proveedor, representa a un externo que provee un servicio a Llanquihue Tour
 */
public class Proveedor extends Persona implements Registrable {
	private String servicioProveedor;

	/**
	 * Constructor de la clase Proveedor
	 *
	 * @param nombre            nombre del proveedor
	 * @param telefono          teléfono del proveedor
	 * @param direccion         dirección del proveedor
	 * @param rut               rut del proveedor
	 * @param servicioProveedor servicio prestado por el proveedor
	 */
	public Proveedor(String nombre, String telefono, Direccion direccion, Rut rut, String servicioProveedor) {
		super(nombre, telefono, direccion, rut);
		this.servicioProveedor = servicioProveedor;
	}

	/**
	 * Métodos Getters y Setters de la clase Proveedor
	 */
	public String getServicioProveedor() {
		return servicioProveedor;
	}

	public void setServicioProveedor(String servicioProveedor) {
		this.servicioProveedor = servicioProveedor;
	}

	@Override
	public void registrar() {
		System.out.println("Registrando Proveedor");
	}

	@Override
	public String mostrarDatos() {
		return toString();
	}

	@Override
	public String toString() {
		return super.toString() + ", Servicio=" + servicioProveedor;
	}
}

