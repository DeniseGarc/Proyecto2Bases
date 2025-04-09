package DAO;

import conexion.Conexion;
import entidades.Producto;
import enumeradores.TipoProducto;
import exception.PersistenciaException;
import interfaces.IProductoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad
 * Producto, utilizando JPA para persistencia. La clase aplica el patrón
 * Singleton para que se maneje una sola instancia de la clase.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 * @see IProductoDAO
 */
public class ProductoDAO implements IProductoDAO {

    /**
     * Instancia única de la clase ProductoDAO
     */
    private static ProductoDAO instanciaProductoDAO;

    /**
     * Constructor privado para aplicar el patrón Singleton
     */
    private ProductoDAO() {
    }

    /**
     * Método que devuelve la instancia única de ProductoDAO
     *
     * @return instancia única de ProductoDAO
     */
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

    /**
     * {@inheritDoc}
     *
     * <p>
     * Esta implementación específica maneja el caso donde no se encuentra el
     * producto devolviendo null en lugar de lanzar una excepción.</p>
     */
    @Override
    public Producto obtenerProductoPorNombre(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            try {
                return em.createQuery("SELECT p FROM Producto p WHERE p.nombre = :nombre ", Producto.class)
                        .setParameter("nombre", nombre).getSingleResult();
            } catch (NoResultException ex) {
                return null;
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar producto por nombre: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean registrarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            return producto.getId() != null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al registrar producto: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean actualizarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar producto: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Implementación específica que usa una consulta de actualización masiva
     * para cambiar el estado de habilitación.</p>
     */
    @Override
    public boolean deshabilitarHabilitarProducto(String nombre, boolean habilitado) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            int numFilas = em.createQuery("UPDATE Producto p SET p.habilitada = :estado WHERE p.nombre = :nombre")
                    .setParameter("estado", habilitado)
                    .setParameter("nombre", nombre)
                    .executeUpdate();
            em.getTransaction().commit();
            return numFilas != 0;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al intentar actualizar el estado del producto: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Producto> buscarPorFiltros(String nombre, TipoProducto categoria) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery(
                    "SELECT p FROM Producto p WHERE (:nombre IS NULL OR p.nombre LIKE CONCAT('%',:nombre,'%')) "
                    + "AND (:categoria IS NULL OR p.tipo = :categoria)")
                    .setParameter("nombre", nombre)
                    .setParameter("categoria", categoria)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al intentar filtrar los productos: ", e);
        } finally {
            em.close();
        }
    }
}
