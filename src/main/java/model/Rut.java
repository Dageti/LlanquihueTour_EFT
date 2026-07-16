package model;

import util.RutInvalidoException;

/**
 * Lógica de validación del RUT, encapsulada para reutilizar código en distintas instancias.
 */
public class Rut {
	private String numero;

	public Rut(String numero) throws RutInvalidoException {
		setNumero(numero);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) throws RutInvalidoException {
		if (numero == null || !numero.matches("[0-9]{7,8}-[0-9kK]")) {
			throw new RutInvalidoException("RUT inválido, por favor ingrese un RUT válido con guión");
		}
		this.numero = numero.toUpperCase();
	}

	@Override
	public String toString() {
		return "RUT: " + numero;
	}
}
