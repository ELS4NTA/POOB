package domain;

/**
 * Excepciones para el automata
 * @Autor Angie Mojica - Daniel Santanilla
 * @Version 0.2
 */

public class AutomataException extends Exception{
	
	public static final String OPCION_CONSTRUCCION = "Opcion en construccion.";
	public static final String ARCHIVO_NO_ENCONTRADO = "Archivo no encontrado.";
	
	/**
	 * Constructor de la Excepcion
	 * @param message Mensaje de la excepcion 
	 */
	public AutomataException(String message) {
		super(message);
	}
	
}
