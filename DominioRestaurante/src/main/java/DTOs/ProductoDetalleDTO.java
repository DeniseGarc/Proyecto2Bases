package DTOs;

import enumeradores.TipoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO que representa un producto con sus ingredientes necesarios.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public class ProductoDetalleDTO {

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Categoría o tipo del producto según la clasificación del sistema.
     */
    private TipoProducto tipo;

    /**
     * Precio de venta del producto.
     */
    private double precio;

    /**
     * Lista de ingredientes que componen el producto, representados como DTOs.
     * Cada elemento contiene información sobre un ingrediente y su cantidad.
     */
    private List<IngredienteProductoDTO> ingredientes = new ArrayList<>();

    /**
     * Constructor por defecto necesario para la inicialización.
     */
    public ProductoDetalleDTO() {
    }

    /**
     * Constructor completo para crear un DTO de producto con detalle.
     *
     * @param nombre Nombre del producto
     * @param tipo Categoría del producto
     * @param precio Precio de venta
     * @param ingredientes Lista de ingredientes que componen el producto
     */
    public ProductoDetalleDTO(String nombre, TipoProducto tipo, double precio, List<IngredienteProductoDTO> ingredientes) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre actual del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nuevo nombre para el producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de producto.
     *
     * @return Categoría actual del producto
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de producto.
     *
     * @param tipo Nueva categoría para el producto
     */
    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio actual de venta
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Nuevo precio de venta
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la lista de ingredientes del producto.
     *
     * @return Lista actual de ingredientes con sus detalles
     */
    public List<IngredienteProductoDTO> getIngredientes() {
        return ingredientes;
    }

    /**
     * Establece la lista de ingredientes del producto.
     *
     * @param ingredientes Nueva lista de ingredientes con sus detalles
     */
    public void setIngredientes(List<IngredienteProductoDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
