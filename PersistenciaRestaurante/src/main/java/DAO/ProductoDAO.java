package DAO;

import conexion.Conexion;
import entidades.Producto;
import enumeradores.TipoProducto;
import exception.PersistenciaException;
import interfaces.IProductoDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad
 * Producto. La clase aplica el patrón Sinbleton para que se maneje una sola
 * instancia de la clase
 *
 * @author Alicia Denise Garcia Acosta 00000252402
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

    /**
     * Método que obtiene todos los productos registrados en la base de datos
     *
     * @return lista de productos
     * @throws PersistenciaException Si ocurre un error al consultar los
     * productos
     */
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
     * Obtiene un producto por su nombre exacto.
     *
     * @param nombre el nombre del producto a buscar.
     * @return el producto encontrado.
     * @throws PersistenciaException si no se encuentra o ocurre un error
     * durante la consulta.
     */
    @Override
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

    /**
     * Registra un nuevo producto en la base de datos.
     *
     * @param producto el producto a registrar.
     * @return el producto registrado con su ID asignado.
     * @throws PersistenciaException si ocurre un error durante el registro.
     */
    @Override
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

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param producto el producto a actualizar.
     * @return {@code true} si la actualización fue exitosa.
     * @throws PersistenciaException si ocurre un error durante la
     * actualización.
     */
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
     * Cambia el estado de un producto entre habilitado y deshabilitado.
     *
     * @param producto el producto cuyo estado se cambiará.
     * @return {@code true} si el cambio fue exitoso.
     * @throws PersistenciaException si ocurre un error al cambiar el estado del
     * producto.
     */
    @Override
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
            throw new PersistenciaException("Error al intentar cambiar estado del producto: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene una lista de productos cuyo nombre contenga el texto
     * especificado.
     *
     * @param nombre parte del nombre del producto a buscar.
     * @return lista de productos que coinciden con el filtro.
     * @throws PersistenciaException si ocurre un error al consultar.
     */
    @Override
    public List<Producto> obtenerProductosFiltrados(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE CONCAT('%',:nombre,'%') ", Producto.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar productos filtrados por nombre: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene una lista de productos cuyo nombre contenga el texto especificado
     * y pertenezcan a una categoría específica.
     *
     * @param nombre parte del nombre del producto a buscar.
     * @param categoria categoría del producto.
     * @return lista de productos filtrados por nombre y categoría.
     * @throws PersistenciaException si ocurre un error durante la consulta.
     */
    @Override
    public List<Producto> obtenerProductosFiltrados(String nombre, TipoProducto categoria) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE CONCAT('%',:nombre,'%') AND p.tipo = :categoria", Producto.class)
                    .setParameter("nombre", nombre)
                    .setParameter("categoria", categoria)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar productos filtrados por nombre: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene una lista de productos los cuales pertenezcan a una categoría
     * específica.
     *
     * @param categoria categoría del producto.
     * @return lista de productos filtrados por categoria.
     * @throws PersistenciaException si ocurre un error durante la consulta.
     */
    @Override
    public List<Producto> obtenerProductosFiltrados(TipoProducto categoria) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT p FROM Producto p WHERE  p.tipo = :categoria", Producto.class)
                    .setParameter("categoria", categoria)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar productos filtrados por categoria: ", e);
        } finally {
            em.close();
        }
    }

}
