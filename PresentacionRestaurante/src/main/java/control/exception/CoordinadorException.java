package control.exception;

/**
 * Clase que representa una excepción en el coordinador
 *
 * @author Alici
 */
public class CoordinadorException extends Exception {

    public CoordinadorException(String message) {
        super(message);
    }

    public CoordinadorException(String message, Throwable cause) {
        super(message, cause);
    }

}
