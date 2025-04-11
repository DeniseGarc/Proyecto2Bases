/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *Excepción personalizada para representar errores relacionados con la capa de persistencia.
 * @author Alici
 */
public class PersistenciaException extends Exception {
     /**
     * Constructor que permite crear la excepción con un mensaje personalizado.
     * @param message Mensaje descriptivo del error ocurrido.
     */
    public PersistenciaException(String message) {
        super(message);
    }
    /**
     * Constructor que permite crear la excepción con un mensaje y una causa.
     * @param message message Mensaje descriptivo del error.
     * @param cause Causa original del error (otra excepción).
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
