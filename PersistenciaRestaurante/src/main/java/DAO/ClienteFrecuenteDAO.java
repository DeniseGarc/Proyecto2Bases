/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.ClienteFrecuente;
import exception.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Maryr
 */
public class ClienteFrecuenteDAO {

    private static ClienteFrecuenteDAO instanciaClienteFrecuenteDAO;

    private ClienteFrecuenteDAO() {
    }

    public static ClienteFrecuenteDAO getInstanciaClienteFrecuenteDAO() {
        if (instanciaClienteFrecuenteDAO == null) {
            instanciaClienteFrecuenteDAO = new ClienteFrecuenteDAO();
        }
        return instanciaClienteFrecuenteDAO;
    }

    /**
     * Método para registrar un nuevo cliente frecuente.
     *
     * @param clienteFrecuente El cliente frecuente que será registrado.
     * @return El cliente frecuente registrado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public ClienteFrecuente registrarNuevoClienteFrecuente(ClienteFrecuente clienteFrecuente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(clienteFrecuente);
            em.getTransaction().commit();
            return clienteFrecuente;
        } catch (Exception e) {
            throw new PersistenciaException("Error al registrar cliente frecuente: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Método para obtener una lista de todos los clientes frecuentes.
     * @return Lista de clientes frecuentes.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public List<ClienteFrecuente> obtenerClientesFrecuentes() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE TYPE(c) = ClienteFrecuente", ClienteFrecuente.class)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener clientes frecuentes: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Método para obtener clientes frecuentes por nombre.
     *
     * @param nombre El nombre del cliente frecuente a buscar.
     * @return Lista de clientes frecuentes cuyo nombre coincida con el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public List<ClienteFrecuente> obtenerClientesPorNombre(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE TYPE(c) = ClienteFrecuente AND c.nombre LIKE :nombre", ClienteFrecuente.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar clientes frecuentes por nombre: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Método para obtener clientes frecuentes por teléfono.
     *
     * @param telefono El número de teléfono del cliente frecuente a buscar.
     * @return Lista de clientes frecuentes cuyo teléfono coincida con el
     * filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public List<ClienteFrecuente> obtenerClientesPorTelefono(String telefono) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE TYPE(c) = ClienteFrecuente AND c.telefono LIKE :telefono", ClienteFrecuente.class)
                    .setParameter("telefono", "%" + telefono + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar clientes frecuentes por teléfono: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Método para obtener clientes frecuentes por correo electrónico.
     *
     * @param correo El correo electrónico del cliente frecuente a buscar.
     * @return Lista de clientes frecuentes cuyo correo coincida con el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public List<ClienteFrecuente> obtenerClientesPorCorreo(String correo) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE TYPE(c) = ClienteFrecuente AND c.correoElectronico LIKE :correo", ClienteFrecuente.class)
                    .setParameter("correo", "%" + correo + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar clientes frecuentes por correo: ", e);
        } finally {
            em.close();
        }
    }
}
