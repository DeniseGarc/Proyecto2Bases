/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.Cliente;
import entidades.ClienteFrecuente;
import exception.PersistenciaException;
import interfaces.IClienteDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Maryr
 */
public class ClienteDAO implements IClienteDAO {

    private static ClienteDAO instanciaClienteDAO;

    private ClienteDAO() {
    }

    public static ClienteDAO getInstanciaClienteDAO() {
        if (instanciaClienteDAO == null) {
            instanciaClienteDAO = new ClienteDAO();
        }
        return instanciaClienteDAO;
    }

    /**
     * Método para registrar un nuevo cliente en la base de datos
     * @param cliente el cual será registrado
     * @return el cliente que fue registrado
     * @throws PersistenciaException 
     */
    @Override
    public Cliente registrarNuevoCliente (Cliente cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            if(cliente.getId() == null) {
                return null;
            }
            return cliente;
        } catch (Exception e) {
            throw new PersistenciaException("Error al registrar cliente: ", e);
        } finally {
            em.close();
        }
    }
    
    /**
     * Método para registrar nuevo cliente frecuente en la base de datos
     * @param clienteFrecuente el cual será registrado
     * @return el cliente frecuente que fue registrado
     * @throws PersistenciaException 
     */
    @Override
    public ClienteFrecuente registrarNuevoClienteFrecuente (ClienteFrecuente clienteFrecuente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(clienteFrecuente);
            em.getTransaction().commit();
            if(clienteFrecuente.getId() == null) {
                return null;
            }
            return clienteFrecuente;
        } catch (Exception e) {
            throw new PersistenciaException("Error al registrar cliente frecuente: ", e);
        } finally {
            em.close();
        }
    }
    
    /**
     * Método para obtener una lista con todos los clientes  en la base de datos
     * @return una lista con todos los clientes
     * @throws PersistenciaException 
     */
    @Override
    public List<Cliente> obtenerClientes() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                    .getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("Error al obtener la lista de clientes: ", e);
        } finally {
            em.close();
        }
    }
    
    /**
     * Método para obtener una lista de clientes que coincidan con el nombre ingresado
     * @param nombre por el que se filtrará la busqueda
     * @return lista de clientes cuyo nombre coincida con el filtro
     * @throws PersistenciaException 
     */
    @Override
    public List<Cliente> obtenerClientesPorNombre(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE CONCAT('%',:nombre,'%')", Cliente.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar clientes por nombre: ", e);
        } finally {
            em.close();
        }
    }
    
    /**
     * Método para obtener una lista de clientes que coincidan con el telefono ingresado
     * @param telefono por el cual se filtrará la busqueda
     * @return lista de clientes cuyo telefono coincide con el filtro
     * @throws PersistenciaException 
     */
    @Override
    public List<Cliente> obtenerClientesPorTelefono(String telefono) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.telefono LIKE CONCAT('%',:telefono,'%')", Cliente.class)
                    .setParameter("telefono", telefono)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar clientes por telefono: ", e);
        } finally {
            em.close();
        }
    }
    
    /**
     * Método para obtener una lista de clientes que coincidan con el correo ingresado
     * @param correo por el cual se filtrará la busqueda
     * @return lista de clientes cuyo correo coincide con el filtro
     * @throws PersistenciaException 
     */
    @Override
    public List<Cliente> obtenerClientesPorCorreo(String correo) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.correoElectronico LIKE CONCAT('%',:correo,'%')", Cliente.class)
                    .setParameter("correo", correo)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar clientes por correo: ", e);
        } finally {
            em.close();
        }
    }
}
