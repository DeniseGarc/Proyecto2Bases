/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *Excepción personalizada para representar errores relacionados con la capa de negocio.
 * @author erika
 */
public class NegocioException extends Exception {
    /**
     * Constructor que permite crear la excepción con un mensaje personalizado.
     * @param message Mensaje descriptivo del error ocurrido. 
     */
    public NegocioException(String message) {
        super(message);
    }
    /**
     * Constructor que permite crear la excepción con un mensaje y una causa.
     * @param message Mensaje descriptivo del error.
     * @param cause Causa original del error (otra excepción).
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

}
