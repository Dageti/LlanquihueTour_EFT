package model;

/**
 * Modelado de clase Dirección, atributos número, calle y ciudad.
 */
public class Direccion {
	private int numero;
	private String calle;
	private String ciudad;

	/**
	 * Constructor clase Direccion
	 *
	 * @param numero numero de casa
	 * @param calle  nombre de la calle
	 * @param ciudad nombre de la ciudad
	 */
	public Direccion(int numero, String calle, String ciudad) {
		this.numero = numero;
		this.calle = calle;
		this.ciudad = ciudad;
	}

	/**
	 * Metodos Getters Y Setters de la clase Direccion
	 */
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return
				calle + ", " + numero + ", " + ciudad;
	}
}
