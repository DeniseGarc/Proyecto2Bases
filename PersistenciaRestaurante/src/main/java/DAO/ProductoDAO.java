/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.Producto;
import exception.PersistenciaException;
import interfaces.IProductoDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alici
 */
public class ProductoDAO implements IProductoDAO {

    private static ProductoDAO instanciaProductoDAO;

    private ProductoDAO() {
    }

    public static ProductoDAO getInstanciaDAO() {
        if (instanciaProductoDAO == null) {
            instanciaProductoDAO = new ProductoDAO();
        }
        return instanciaProductoDAO;
    }

    @Override
    public List<Producto> obtenerProductos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT p FROM Producto p", Producto.class)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar productos registrados: ", e);
        } finally {
            em.close();
        }
    }

    public Producto obtenerProductoPorNombre(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT p FROM Producto p WHERE p.nombre = :nombre ", Producto.class)
                    .setParameter("nombre", nombre).getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar producto por nombre: ", e);
        } finally {
            em.close();
        }
    }

    public Producto registrarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            if (producto.getId() == null) {
                return null;
            }
            return producto;
        } catch (Exception e) {
            throw new PersistenciaException("Error al registrar producto: ", e);
        } finally {
            em.close();
        }
    }

    public boolean actualizarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al registrar producto: ", e);
        } finally {
            em.close();
        }
    }

    public boolean deshabilitarHabilitarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            if (producto.isHabilitada()) {
                producto.setHabilitada(false);
            } else {
                producto.setHabilitada(true);
            }
            em.merge(producto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al registrar producto: ", e);
        } finally {
            em.close();
        }
    }
}
