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
     * Busca productos cuyo nombre contenga el texto especificado.
     *
     * @param texto Fragmento del nombre a buscar
     * @return Lista de ProductoDTO que coinciden con el criterio
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    public List<ProductoDTO> obtenerProductosFiltradosNombre(String texto) throws NegocioException;

    /**
     * Busca productos por nombre parcial y categoría específica.
     *
     * @param texto Fragmento del nombre a buscar
     * @param categoria Tipo de producto para filtrar
     * @return Lista de ProductoDTO que coinciden con ambos criterios
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    public List<ProductoDTO> obtenerProductosFiltradosNombreyCategoria(String texto, TipoProducto categoria) throws NegocioException;

    /**
     * Obtiene todos los productos de una categoría específica.
     *
     * @param categoria Tipo de producto para filtrar
     * @return Lista de ProductoDTO que pertenecen a la categoría especificada
     * @throws NegocioException Si ocurre un error en la capa de negocio
     */
    public List<ProductoDTO> obtenerProductosFiltradosCategoria(TipoProducto categoria) throws NegocioException;

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
}
