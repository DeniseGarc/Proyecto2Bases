/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *Clase para crear la conexion con la base de datos
 * @author Alici
 */
public class Conexion {
    /**
     * Fábrica de EntityManagers, inicializada una sola vez al cargar la clase.
     * El nombre "ConexionPU" debe coincidir con el nombre definido en persistence.xml.
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
    /**
     * Metodo para crear la conexion
     * @return nuevo para operaciones de persistencia.
     */
    public static EntityManager crearConexion() {
        return emf.createEntityManager();
    } 
    /**
     * Metodo para cerrar la conexion con el entity Manager
     */
    public static void cerrar() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
