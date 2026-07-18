package interfaces;

/**
 * Interfaz de metodo abstracto para poder filtrar con polimorfismo y funciones lambda con un criterio arbitrario
 */
public interface TagBusqueda {
	boolean cumple(Registrable entidad);
}
