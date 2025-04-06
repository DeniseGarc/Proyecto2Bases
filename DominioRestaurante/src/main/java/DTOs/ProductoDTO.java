package DTOs;

import enumeradores.TipoProducto;

/**
 * DTO que representa un Producto sin sus ingredientes asociados.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public class ProductoDTO {

    /**
     * Nombre identificador del producto. Debe ser único en el sistema.
     */
    private String nombre;
    /**
     * Categoría o clasificación del producto según el enumerador TipoProducto.
     */
    private TipoProducto tipo;
    /**
     * Precio de venta actual del producto. Representado como valor decimal.
     */
    private double precio;
    /**
     * Estado de disponibilidad inmediata del producto. true = disponible, false
     * = no disponible temporalmente
     */
    private boolean disponible;
    /**
     * Estado de habilitado del producto en el sistema. true = habilitado y
     * false = deshabilitado
     */
    private boolean habilitado;

    /**
     * Constructor por defecto necesario para la inicialización.
     */
    public ProductoDTO() {
    }

    /**
     * Constructor completo para crear un DTO de producto con todos sus
     * atributos.
     *
     * @param nombre Nombre identificador del producto
     * @param tipo Categoría del producto
     * @param precio Precio de venta actual
     * @param disponible Estado de disponibilidad
     * @param habilitado Estado de habilitación en el sistema
     */
    public ProductoDTO(String nombre, TipoProducto tipo, double precio, boolean disponible, boolean habilitado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
        this.habilitado = habilitado;
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
     * Obtiene la categoría del producto.
     *
     * @return TipoProducto que representa la categoría actual
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    /**
     * Establece la categoría del producto.
     *
     * @param tipo Nueva categoría para el producto
     */
    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el precio de venta del producto.
     *
     * @return Precio actual como valor decimal
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de venta del producto.
     *
     * @param precio Nuevo precio como valor decimal
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Verifica la disponibilidad actual del producto.
     *
     * @return true si está disponible para venta, false en caso contrario
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del producto.
     *
     * @param disponible Nuevo estado de disponibilidad
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Verifica si el producto está habilitado en el sistema.
     *
     * @return true si está habilitado y visible, false si está deshabilitado
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     * Establece el estado de habilitado del producto.
     *
     * @param habilitado Nuevo estado de habilitación
     */
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}
