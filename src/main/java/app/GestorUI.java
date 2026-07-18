package app;

import data.GestorEntidades;
import model.Cliente;
import model.Direccion;
import model.Empleado;
import model.Reserva;
import model.Rut;
import model.Tour;
import util.RutInvalidoException;

import java.util.Scanner;

/**
 * Menú interactivo por consola, permite inputs al usuario y se guardan en una coleccion de entidades.
 */
public class GestorUI {
	private GestorEntidades gestor;
	private Scanner scanner;

	public GestorUI() {
		this.gestor = new GestorEntidades();
		this.scanner = new Scanner(System.in);
	}

	public void iniciar() {
		gestor.cargarDatosIniciales();
		int opcion = -1;
		while (opcion != 0) {
			mostrarMenu();
			try {
				opcion = Integer.parseInt(scanner.nextLine());
				verificarOpcion(opcion);
			} catch (NumberFormatException e) {
				System.out.println("Ingrese una opción válida.");
			}
		}
		scanner.close();
	}

	private void mostrarMenu() {
		System.out.println("\n======= Llanquihue Tour =======");
		System.out.println("Seleccione una opción: ");
		System.out.println("1.- Mostrar todos los datos");
		System.out.println("2.- Ingresar nuevo cliente");
		System.out.println("3.- Generar una reserva");
		System.out.println("4.- Ingresar nuevo trabajador");
		System.out.println("0.- Salir");
	}

	private void verificarOpcion(int opcion) {
		switch (opcion) {
			case 1:
				System.out.println("\n" + gestor.resumenEntidades());
				break;
			case 2:
				registrarCliente();
				break;
			case 3:
				generarReserva();
				break;
			case 4:
				registrarNuevoTrabajador();
				break;
			case 0:
				System.out.println("¡Hasta Pronto!");
				break;
			default:
				System.out.println("Opción no válida, intente nuevamente.");
		}
	}

	/**
	 * Pide inputs por consola para llenar los datos de un nuevo cliente.
	 */
	private void registrarCliente() {
		System.out.println("\n--- NUEVO CLIENTE ---");
		try {
			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();
			System.out.print("Teléfono: ");
			String telefono = scanner.nextLine();
			System.out.print("RUT (ej: 12345678-9): ");
			Rut rut = new Rut(scanner.nextLine());
			System.out.print("Email: ");
			String email = scanner.nextLine();

			Direccion dir = new Direccion(0, "", "");
			Cliente nuevoCliente = new Cliente(nombre, telefono, dir, rut, email);
			nuevoCliente.registrar();
			gestor.agregarEntidad(nuevoCliente);
			System.out.println("Cliente agregado con éxito.");
		} catch (RutInvalidoException e) {
			System.out.println("Error de RUT: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error: El teléfono debe ser un número.");
		}
	}

	/**
	 * Pide inputs por consola el RUT del cliente para asignar una reserva de un tour.
	 */
	private void generarReserva() {
		System.out.println("\n--- NUEVA RESERVA ---");
		System.out.print("RUT del Cliente (ej: 12345678-9): ");
		String rutBuscado = scanner.nextLine();

		Cliente clienteEncontrado = gestor.buscarClientePorRut(rutBuscado);

		if (clienteEncontrado == null) {
			System.out.println("Error: No existe ningún cliente con el RUT " + rutBuscado);
			return;
		}

		System.out.print("Ingrese el ID del Tour a reservar (ej: 00001): ");
		String codigoTour = scanner.nextLine();

		Tour tourEncontrado = gestor.buscarTourPorId(codigoTour);

		if (tourEncontrado == null) {
			System.out.println("Error: No se encontró ningún tour con el código " + codigoTour);
			return;
		}


		Reserva nuevaReserva = new Reserva(clienteEncontrado, tourEncontrado);
		nuevaReserva.registrar();
		gestor.agregarEntidad(nuevaReserva);
		System.out.println("Reserva creada con éxito para " + clienteEncontrado.getNombre());
	}

	/**
	 * Pide inputs por consola para llenar los datos de un nuevo trabajador.
	 */
	private void registrarNuevoTrabajador() {
		System.out.println("\n--- NUEVO TRABAJADOR ---");
		try {
			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();
			System.out.print("Teléfono: ");
			String telefono = scanner.nextLine();
			System.out.print("RUT (ej: 12345678-9): ");
			Rut rut = new Rut(scanner.nextLine());
			System.out.print("Cargo (ej: Guía Turístico, Chofer): ");
			String cargo = scanner.nextLine();
			System.out.println("Calle;");
			String calle = scanner.nextLine();
			System.out.println("Número de casa: ");
			int numCasa = Integer.parseInt(scanner.nextLine());
			System.out.println("Ciudad: ");
			String ciudad = scanner.nextLine();
			Direccion dir = new Direccion(numCasa, calle, ciudad);
			Empleado nuevoEmpleado = new Empleado(nombre, telefono, dir, rut, cargo);
			nuevoEmpleado.registrar();
			gestor.agregarEntidad(nuevoEmpleado);
			System.out.println("Trabajador agregado con éxito.");
		} catch (RutInvalidoException e) {
			System.out.println("Error de RUT: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error: El teléfono debe ser un número.");
		}
	}
}