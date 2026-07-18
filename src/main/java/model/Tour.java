package model;

import interfaces.Registrable;

/**
 * Modelado de la clase Tour, representa la parrilla de ofertas que tiene la empresa Llanquihue Tour
 */
public class Tour implements Registrable {
	private String nombreTour;
	private String id;
	private double precio;

	/**
	 * Constructor de la clase Tour
	 *
	 * @param nombreTour nombre del tour
	 * @param id         identificador del tour, permite hacer reservas al cliente con este código.
	 * @param precio     precio del tour
	 */
	public Tour(String nombreTour, String id, double precio) {
		this.nombreTour = nombreTour;
		this.id = id;
		this.precio = precio;
	}

	/**
	 * Métodos Getters y Setters de la clase Reserva
	 */
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
		return toString();
	}

	@Override
	public String toString() {
		return id + " - " + nombreTour + " - $" + precio;
	}
}

