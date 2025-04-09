package interfaces;

import DTOs.ProductoDTO;
import DTOs.ProductoDetalleDTO;
import enumeradores.TipoProducto;
import exception.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones de lógica de negocio para la gestión de
 * productos.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public interface IProductoBO {

    /**
     * Obtiene todos los productos disponibles en el sistema.
     *
     * @return Lista de ProductoDTO con información básica de todos los
     * productos
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    public List<ProductoDTO> obtenerProductos() throws NegocioException;

    /**
     * Obtiene los detalles completos de un producto por su nombre exacto.
     *
     * @param nombre Nombre exacto del producto
     * @return ProductoDetalleDTO con toda la información del producto
     * incluyendo ingredientes
     * @throws NegocioException Si el producto no existe o hay un error en la
     * capa de negocio
     */
    public ProductoDetalleDTO obtenerProductoDetallesPorNombre(String nombre) throws NegocioException;

    /**
     * Registra un nuevo producto en el sistema.
     *
     * @param productoNuevo ProductoDetalleDTO con toda la información del nuevo
     * producto
     * @return true si el registro fue exitoso, false en caso contrario
     * @throws NegocioException Si hay errores de validación o en la capa de
     * negocio
     */
    public boolean agregarProducto(ProductoDetalleDTO productoNuevo) throws NegocioException;

    /**
     * Cambia el estado de habilitación de un producto (toggle).
     *
     * @param nombre Nombre exacto del producto a modificar
     * @return true si el cambio de estado fue exitoso, false si no se encontró
     * el producto
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    public boolean cambiarEstadoProducto(String nombre) throws NegocioException;

    /**
     * Actualiza la información de un producto existente.
     *
     * @param productoActualizar ProductoDetalleDTO con los datos actualizados
     * @return true si la actualización fue exitosa, false en caso contrario
     * @throws NegocioException Si el producto no existe o hay errores de
     * validación
     */
    public boolean actualizarProducto(ProductoDetalleDTO productoActualizar) throws NegocioException;

    /**
     * Obtiene el productoDTO del producto con el nombre dado
     *
     * @param nombre Nombre del producto a obtener
     * @return ProductoDTO del producto con el nombre ingresado como parametro
     * @throws NegocioException Si el producto no existe o si ocurre un error
     */
    public ProductoDTO obtenerProductoPorNombre(String nombre) throws NegocioException;

    /**
     * Obtiene los productos filtrados según el valor ingresado. En caso que de
     * no se quiera filtrar por ese campo se debe recibir un nulo como el valor
     * del parámetro.
     *
     * @param nombre Nombre parcial o completo del producto
     * @param categoria Categoria del producto
     * @return Lista de ProductoDTO de los productos filtrados según los
     * parámetros
     * @throws NegocioException Si sucede un error en el acceso a datos.
     */
    public List<ProductoDTO> obtenerProductosFiltrados(String nombre, TipoProducto categoria) throws NegocioException;

}
