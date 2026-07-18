package model;

import interfaces.Registrable;

/**
 * Clase Reserva representa la reserva de un tour por un cliente
 */

public class Reserva implements Registrable {
	private int contadorReservas = 1;
	private final int numeroReserva;
	private Cliente cliente;
	private Tour tour;


	/**
	 * Constructor de la clase reserva, asigna el numero de reservas
	 *
	 * @param cliente cliente que realiza la reserva.
	 * @param tour    tour que reserva el cliente.
	 */
	public Reserva(Cliente cliente, Tour tour) {
		this.numeroReserva = contadorReservas++;
		this.cliente = cliente;
		this.tour = tour;
	}

	/**
	 * Métodos Getters y Setters de la clase Reserva
	 */
	public int getNumeroReserva() {
		return numeroReserva;
	}

	public int getContadorReservas() {
		return contadorReservas;
	}

	public void setContadorReservas(int contadorReservas) {
		this.contadorReservas = contadorReservas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	@Override
	public void registrar() {
		System.out.println("Registrando reserva");
	}

	@Override
	public String mostrarDatos() {
		return toString();
	}

	@Override
	public String toString() {
		return "Reserva Nro " + numeroReserva + " | Cliente: " + cliente.getNombre() + " | Tour: " + tour.getNombreTour();
	}
}


