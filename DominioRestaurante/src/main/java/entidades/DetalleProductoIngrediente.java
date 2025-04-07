/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa la relación entre Productos e Ingredientes en el
 * sistema. Almacena la cantidad necesaria de cada ingrediente para realiza el
 * producto.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
@Entity
@Table(name = "detallesProductosIngredientes")
public class DetalleProductoIngrediente implements Serializable {

    /**
     * Identificador único del detalle en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cantidad del ingrediente requerida para el producto.
     */
    @Column(name = "cantidadIngrediente", nullable = false)
    private Integer cantidad;

    /**
     * Producto al que pertenece este detalle. Relación muchos a uno con la
     * entidad Producto.
     */
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    /**
     * Ingrediente asociado a este detalle. Relación muchos a uno con la entidad
     * Ingrediente.
     */
    @ManyToOne
    @JoinColumn(name = "ingrediente_id", nullable = false)
    private Ingrediente ingrediente;

    /**
     * Constructor por defecto necesario para JPA.
     */
    public DetalleProductoIngrediente() {
    }

    /**
     * Constructor para crear un detalle sin ID.
     *
     * @param cantidad Cantidad del ingrediente requerida
     * @param producto Producto asociado
     * @param ingrediente Ingrediente asociado
     */
    public DetalleProductoIngrediente(Integer cantidad, Producto producto, Ingrediente ingrediente) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }

    /**
     * Constructor completo para crear un detalle con todos sus atributos.
     *
     * @param id Identificador único
     * @param cantidad Cantidad del ingrediente requerida
     * @param producto Producto asociado
     * @param ingrediente Ingrediente asociado
     */
    public DetalleProductoIngrediente(Long id, Integer cantidad, Producto producto, Ingrediente ingrediente) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }

    /**
     * Obtiene el ID del detalle.
     *
     * @return Identificador único
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del detalle.
     *
     * @param id Nuevo identificador único
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la cantidad de ingrediente requerida.
     *
     * @return Cantidad actual
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de ingrediente requerida.
     *
     * @param cantidad Nueva cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el producto asociado.
     *
     * @return Producto actual
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado.
     *
     * @param producto Nuevo producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene el ingrediente asociado.
     *
     * @return Ingrediente actual
     */
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    /**
     * Establece el ingrediente asociado.
     *
     * @param ingrediente Nuevo ingrediente
     */
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * Método toString del DetalleProductoIngrediente.
     *
     * @return Cadena con los valores de todos los atributos
     */
    @Override
    public String toString() {
        return "DetalleProductoIngrediente{"
                + "id=" + id
                + ", cantidad=" + cantidad
                + ", producto=" + producto
                + ", ingrediente=" + ingrediente
                + '}';
    }
}
