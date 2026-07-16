package util;

/**
 * Excepción personalizada que se dispara cuando el RUT ingresado no tiene el formato correcto.
 */
public class RutInvalidoException extends Exception {
	public RutInvalidoException() {
		super("El RUT ingresado no es válido.");
	}

	public RutInvalidoException(String mensaje) {
		super(mensaje);
	}
}
