package model;

import interfaces.Registrable;

public class Reserva implements Registrable {
	private int numeroReserva;
	private Cliente cliente;
	private Tour tour;

	public Reserva(int numeroReserva, Cliente cliente, Tour tour) {
		this.numeroReserva = numeroReserva;
		this.cliente = cliente;
		this.tour = tour;
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
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
		System.out.println("mostrando Reserva");
		return "";
	}
}

