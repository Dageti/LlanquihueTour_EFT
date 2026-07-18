package data;

import interfaces.Registrable;
import interfaces.TagBusqueda;
import model.*;
import util.RutInvalidoException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Encargado de la lógica de filtrados y entidades de la aplicación,
 */
public class GestorEntidades {
	private final ArrayList<Registrable> entidades = new ArrayList<>();

	/**
	 * Agregar una entidad a la lista.
	 *
	 * @param entidad entidad a registrar.
	 */
	public void agregarEntidad(Registrable entidad) {
		entidades.add(entidad);
	}

	/**
	 * Sobrecarga de metodo agregarEntidad, este agrega varias entidades en un uso.
	 *
	 * @param nuevasEntidades Lista de entidades que se registrarán
	 */
	public void agregarEntidad(List<Registrable> nuevasEntidades) {
		entidades.addAll(nuevasEntidades);
	}

	/**
	 * Devuelve la lista de entidades registradas.
	 *
	 * @return Copia de solo lectura de lista de entidades.
	 */
	public List<Registrable> getEntidades() {
		return List.copyOf(entidades);
	}

	/**
	 * Búsqueda de cliente por rut
	 *
	 * @param rut rut del cliente Ejemplo: "123456789-k"
	 * @return cliente encontrado, null si no existe.
	 */
	public Cliente buscarClientePorRut(String rut) {
		for (Registrable entidad : entidades) {
			if (entidad instanceof Cliente cliente && cliente.getRut().getNumero().equalsIgnoreCase(rut)) {
				return cliente;
			}
		}
		return null;
	}

	/**
	 * Búsqueda de Tour por ID.
	 *
	 * @param id identificación del tour.
	 * @return Tour encontrado, null si no existe.
	 */
	public Tour buscarTourPorId(String id) {
		for (Registrable entidad : entidades) {
			if (entidad instanceof Tour tour && tour.getId().equalsIgnoreCase(id)) {
				return tour;
			}
		}
		return null;
	}

	/**
	 * Filtro de entidades según la condición que se entregue, utiliza la interfaz TagBusqueda para hacerlo reutilizable
	 *
	 * @param criterio verifica que la entidad cumpla esta condición
	 * @return lista de identidades que cumplen el criterio
	 */
	public List<Registrable> filtrarEntidades(TagBusqueda criterio) {
		List<Registrable> lista = new ArrayList<>();
		for (Registrable entidad : entidades) {
			if (criterio.cumple(entidad)) {
				lista.add(entidad);
			}
		}
		return lista;
	}

	public void cargarDatosIniciales() {
		cargarDesdeTxt("src/main/java/Resources/datos.txt");
	}

	/**
	 * Lee archivo Datos.txt
	 *
	 * @param ruta ruta del archivo Datos.txt
	 */
	public void cargarDesdeTxt(String ruta) {
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.trim().isEmpty()) continue;
				String[] partes = linea.split(";");

				if (partes.length == 0) continue;

				try {
					if (partes.length == 3) {
						String id = partes[0].trim();
						String nombreTour = partes[1].trim();
						double precio = Double.parseDouble(partes[2].trim());
						entidades.add(new Tour(nombreTour, id, precio));
						continue;
					}

					String tipo = partes[0].trim().toUpperCase();
					switch (tipo) {
						case "CLIENTE":
						case "EMPLEADO":
						case "PROVEEDOR":
							if (partes.length >= 8) {
								String nombre = partes[1].trim();
								String telefono = partes[2].trim();
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
							System.out.println("Error en linea :" + linea);
							break;
					}
				} catch (NumberFormatException | RutInvalidoException e) {
					System.err.println("Error en linea :" + linea + "\n" + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.err.println("Error al leer archivo: " + e.getMessage());
		}
	}

	/**
	 * Arma el resumen de entidades
	 */
	public String resumenEntidades() {
		return resumenEntidades(entidades);
	}

	/**
	 * Resumen filtrado por tipo de entidad con sobrecarga
	 * se utilizan expresiones lambda para facilitar lectura
	 *
	 * @param tipo "CLIENTE", "EMPLEADO", "PROVEEDOR", "TOUR", "RESERVA"
	 */
	public String resumenEntidades(String tipo) {
		TagBusqueda criterio;
		switch (tipo.toUpperCase()) {
			case "CLIENTE":
				criterio = e -> e instanceof Cliente;
				break;
			case "EMPLEADO":
				criterio = e -> e instanceof Empleado;
				break;
			case "PROVEEDOR":
				criterio = e -> e instanceof Proveedor;
				break;
			case "TOUR":
				criterio = e -> e instanceof Tour;
				break;
			case "RESERVA":
				criterio = e -> e instanceof Reserva;
				break;
			default:
				System.out.println("Error en linea :" + tipo);
				return "No hay registros";
		}
		return resumenEntidades(filtrarEntidades(criterio));
	}

	private String resumenEntidades(List<Registrable> listaEntidades) {
		StringBuilder resumen = new StringBuilder();
		resumen.append("Registro\n\n");
		if (listaEntidades.isEmpty()) {
			return "No hay registros";
		}
		for (Registrable registrable : listaEntidades) {
			if (registrable instanceof Cliente) {
				resumen.append("[CLIENTE]");
			} else if (registrable instanceof Empleado) {
				resumen.append("[EMPLEADO]");
			} else if (registrable instanceof Proveedor) {
				resumen.append("[PROVEEDOR]");
			} else if (registrable instanceof Tour) {
				resumen.append("[TOUR]");
			} else if (registrable instanceof Reserva) {
				resumen.append("[Reserva]");
			}
			resumen.append(registrable.mostrarDatos()).append("\n");
		}
		return resumen.toString();
	}
}