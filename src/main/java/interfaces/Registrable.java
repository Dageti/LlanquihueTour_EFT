package interfaces;

/**
 * Interfaz que define el contrato de comportamiento común entre entidades de la agencia(clases Empleado, Vehiculo y ServicioTuristico)
 * Permite que las clases puedan mostrar el resumen de los datos.
 */

public interface Registrable {
	void registrar();
	String mostrarDatos();
}
