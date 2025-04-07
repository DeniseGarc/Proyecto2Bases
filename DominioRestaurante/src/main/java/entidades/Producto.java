package entidades;

import enumeradores.TipoProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa un producto en el sistema.
 *
 * @author Alicia Denise García Acosta 00000252402
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    /**
     * Identificador único del producto en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del producto. Debe ser único en el sistema.
     */
    @Column(name = "nombre", nullable = false, length = 100, unique = true)
    private String nombre;
    /**
     * Precio de venta del producto.
     */
    @Column(name = "precio", nullable = false)
    private Double precio;
    /**
     * Tipo de producto según la clasificación del sistema.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoProducto tipo;
    /**
     * Indica si hay stock suficiente en inventario para vender el producto.
     */
    @Column(name = "disponible", nullable = false)
    private boolean disponible;
    /**
     * Indica si el producto se encuentra habilitado, es decir, si este esta
     * presente en el menú
     */
    @Column(name = "habilitada", nullable = false)
    private boolean habilitada;
    /**
     * Lista de ingredientes que componen este producto, con sus cantidades
     * respectivas. Relación uno a muchos con la entidad
     * DetalleProductoIngrediente.
     */
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetalleProductoIngrediente> detallesProducto = new ArrayList<>();

    /**
     * Constructor por defecto necesario para JPA.
     */
    public Producto() {
    }

    /**
     * Constructor completo para crear un producto con todos sus atributos.
     *
     * @param id Identificador único del producto
     * @param nombre Nombre del producto
     * @param precio Precio de venta
     * @param tipo Categoría del producto
     * @param disponible Estado de disponibilidad
     * @param habilitada Estado de habilitado en el sistema
     */
    public Producto(Long id, String nombre, Double precio, TipoProducto tipo, boolean disponible, boolean habilitada) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.disponible = disponible;
        this.habilitada = habilitada;
    }

    /**
     * Constructor para crear un producto sin especificar ID, útil para agregar
     * nuevos productos.
     *
     * @param nombre Nombre del producto
     * @param precio Precio de venta
     * @param tipo Categoría del producto
     * @param disponible Estado de disponibilidad
     * @param habilitada Estado de habilitado en el sistema
     */
    public Producto(String nombre, Double precio, TipoProducto tipo, boolean disponible, boolean habilitada) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.disponible = disponible;
        this.habilitada = habilitada;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return Identificador único del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     *
     * @param id Nuevo identificador único
     */
    public void setId(Long id) {
        this.id = id;
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
     * Obtiene el precio del producto.
     *
     * @return Precio actual de venta
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Nuevo precio de venta
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
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
     * Verifica si el producto está disponible.
     *
     * @return true si está disponible, false en caso contrario
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
     * @return true si está habilitado, false en caso contrario
     */
    public boolean isHabilitada() {
        return habilitada;
    }

    /**
     * Establece el estado de habilitado del producto.
     *
     * @param habilitada Nuevo estado de habilitado
     */
    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    /**
     * Obtiene la lista de ingredientes asociados al producto.
     *
     * @return Lista de detalles de ingredientes
     */
    public List<DetalleProductoIngrediente> getDetallesProducto() {
        return detallesProducto;
    }

    /**
     * Establece la lista de ingredientes asociados al producto.
     *
     * @param detallesProducto Nueva lista de detalles de ingredientes
     */
    public void setDetallesProducto(List<DetalleProductoIngrediente> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }

    /**
     * Método toString del producto.
     *
     * @return Cadena con los valores de todos los atributos
     */
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", disponible=" + disponible + ", habilitada=" + habilitada + ", detallesProducto=" + detallesProducto + '}';
    }

}
