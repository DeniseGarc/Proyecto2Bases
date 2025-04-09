package interfaces;

import entidades.Producto;
import enumeradores.TipoProducto;
import exception.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Producto
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public interface IProductoDAO {

    /**
     * Obtiene todos los productos registrados en la base de datos.
     *
     * @return lista de productos.
     * @throws PersistenciaException si ocurre un error al consultar los
     * productos.
     */
    public List<Producto> obtenerProductos() throws PersistenciaException;

    /**
     * Obtiene un producto por su nombre exacto.
     *
     * @param nombre el nombre del producto a buscar.
     * @return el producto encontrado, en caso de no encontrarlo regresa null.
     * @throws PersistenciaException si no se encuentra o ocurre un error
     * durante la consulta.
     */
    public Producto obtenerProductoPorNombre(String nombre) throws PersistenciaException;

    /**
     * Registra un nuevo producto en la base de datos.
     *
     * @param producto el producto a registrar.
     * @return true si es que fue posible registrar el producto, false en caso
     * contrario.
     * @throws PersistenciaException si ocurre un error durante el registro.
     */
    public boolean registrarProducto(Producto producto) throws PersistenciaException;

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param producto el producto a actualizar.
     * @return true si la actualización fue exitosa.
     * @throws PersistenciaException si ocurre un error durante la
     * actualización.
     */
    public boolean actualizarProducto(Producto producto) throws PersistenciaException;

    /**
     * Cambia el estado de habilitado de un producto.
     *
     * @param nombre Nombre exacto del producto a modificar
     * @param habilitado Nuevo estado de habilitado.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si el producto no existe o hay un error de
     * acceso a datos.
     */
    public boolean deshabilitarHabilitarProducto(String nombre, boolean habilitado) throws PersistenciaException;

    /**
     * Obtiene los productos filtrados según lo ingresado en los parámetros.
     *
     * @param nombre Nombre parcial del producto
     * @param categoria Categoria del producto
     * @return Lista de entidades Producto con los productos de la base de
     * datos.
     * @throws PersistenciaException Si ocurre un error de acceso de datos.
     */
    public List<Producto> buscarPorFiltros(String nombre, TipoProducto categoria) throws PersistenciaException;
}
