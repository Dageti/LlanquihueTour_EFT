package model;

import interfaces.Registrable;

public class Proveedor extends Persona implements Registrable {
	private String servicioProveedor;

	public Proveedor(String nombre, int telefono, Direccion direccion, Rut rut, String servicioProveedor) {
		super(nombre, telefono, direccion, rut);
		this.servicioProveedor = servicioProveedor;
	}

	public String getServicioProveedor() {
		return servicioProveedor;
	}

	public void setServicioProveedor(String servicioProveedor) {
		this.servicioProveedor = servicioProveedor;
	}

	@Override
	public void registrar() {
		System.out.println("Registrando Cliente");
	}

	@Override
	public String mostrarDatos() {
		return null;
	}
}

