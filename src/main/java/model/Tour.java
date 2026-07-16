package model;

import interfaces.Registrable;

public class Tour implements Registrable {
	private String nombreTour;
	private String id;
	private double precio;

	public Tour(String nombreTour, String id, double precio) {
		this.nombreTour = nombreTour;
		this.id = id;
		this.precio = precio;
	}

	public String getNombreTour() {
		return nombreTour;
	}

	public void setNombreTour(String nombreTour) {
		this.nombreTour = nombreTour;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public void registrar() {
		System.out.println("Registrando Tour");
	}

	@Override
	public String mostrarDatos() {
		return null;
	}
}
