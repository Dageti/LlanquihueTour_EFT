package data;

import interfaces.Registrable;
import model.*;
import util.RutInvalidoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorEntidades {
	public ArrayList<Registrable> entidades = new ArrayList<>();

	public void agregarEntidad(Registrable entidad) {
		entidades.add(entidad);
	}

	public void cargarDatosIniciales() {
		cargarDesdeTxt("datos.txt");
	}

	private void cargarDesdeTxt(String ruta) {
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.trim().isEmpty()) continue;
				String[] partes = linea.split(";");

				if (partes.length == 0) continue;

				String tipo = partes[0].trim().toUpperCase();

				try {
					switch (tipo) {
						case "TOUR":
							if (partes.length == 4) {
								String codigo = partes[1].trim();
								String nombre = partes[2].trim();
								double precio = Double.parseDouble(partes[3].trim());
								entidades.add(new Tour(codigo, nombre, precio));
							}
							break;

						case "CLIENTE":
						case "EMPLEADO":
						case "PROVEEDOR":
							if (partes.length >= 8) {
								String nombre = partes[1].trim();
								int telefono = Integer.parseInt(partes[2].trim());
								String rutString = partes[3].trim();
								int numCasa = Integer.parseInt(partes[4].trim());
								String calle = partes[5].trim();
								String ciudad = partes[6].trim();
								String datoExtra = partes[7].trim();

								Direccion dir = new Direccion(numCasa, calle, ciudad);
								Rut rut = new Rut(rutString);

								if (tipo.equals("CLIENTE")) {
									entidades.add(new Cliente(nombre, telefono, dir, rut, datoExtra));
								} else if (tipo.equals("EMPLEADO")) {
									entidades.add(new Empleado(nombre, telefono, dir, rut, datoExtra));
								} else if (tipo.equals("PROVEEDOR")) {
									entidades.add(new Proveedor(nombre, telefono, dir, rut, datoExtra));
								}
							}
							break;

						default:
							System.out.println("Tipo de entidad desconocida: " + tipo);
							break;
					}
				} catch (NumberFormatException | RutInvalidoException e) {
					System.err.println("Error de formato procesando línea: " + linea + " (" + e.getMessage() + ")");
				}
			}
		} catch (IOException e) {
			System.err.println("Error al leer el archivo único: " + e.getMessage());
		}
	}

	public String resumenEntidades() {
		StringBuilder resumen = new StringBuilder();
		resumen.append("======== Registro General ========\n\n");

		if (entidades.isEmpty()) {
			return "No hay entidades registradas.";
		}

		for (Registrable entidad : entidades) {
			if (entidad instanceof Cliente) {
				resumen.append("[CLIENTE] ");
			} else if (entidad instanceof Empleado) {
				resumen.append("[EMPLEADO] ");
			} else if (entidad instanceof Proveedor) {
				resumen.append("[PROVEEDOR] ");
			} else if (entidad instanceof Tour) {
				resumen.append("[TOUR] ");
			} else if (entidad instanceof Reserva) {
				resumen.append("[RESERVA] ");
			}

			resumen.append(entidad.mostrarDatos()).append("\n");
		}

		return resumen.toString();
	}
}