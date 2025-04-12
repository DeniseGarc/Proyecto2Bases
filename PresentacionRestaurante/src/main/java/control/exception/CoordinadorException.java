package control.exception;

/**
 * Clase que representa una excepción en el coordinador
 *
 * @author Alici
 */
public class CoordinadorException extends Exception {
    /**
     * Constructor que permite crear la excepción con un mensaje personalizado.
     * @param message Mensaje descriptivo del error ocurrido. 
     */
    public CoordinadorException(String message) {
        super(message);
    }
    /**
     * Constructor que permite crear la excepción con un mensaje y una causa.
     * @param message Mensaje descriptivo del error.
     * @param cause Causa original del error (otra excepción).
     */
    public CoordinadorException(String message, Throwable cause) {
        super(message, cause);
    }

}
