/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enumeradores.UnidadMedida;
import java.io.Serializable;
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
 *
 * @author erika
 */
@Entity
@Table (name="ingredientes")
public class Ingrediente implements Serializable {

    /**
     * Identificador unico de la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del ingrediente, no puede ser nulo
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    /**
     * Unidad de medida del ingrediente
     */
    @Enumerated(EnumType.STRING)
    @Column (name="unidad_medida", nullable = false)
    private UnidadMedida unidadMedida;
    /**
     * Stock del ingrediente, no puede ser nulo
     */
    @Column (name="stock", nullable = false)
    private Integer stock;
    /**
     * Relacion uno a muchos con ingrediente, 
     */
    @OneToMany(mappedBy = "ingrediente",fetch = FetchType.LAZY)
    private List<DetalleProductoIngrediente> detallesProducto;
    /**
     * Constructor sin id y detallesProductoIngrediente
     * @param nombre Nombre del ingrediente
     * @param unidadMedida Unidad de medida del ingrediente
     * @param stock Stock del producti
     */
    public Ingrediente(String nombre, UnidadMedida unidadMedida, Integer stock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }
    /**
     * Constructor completo de ingrediente
     * @param id id del ingrediente en la base de datos
     * @param nombre nombre del ingrediente
     * @param unidadMedida Unidad de medida del ingrediente
     * @param stock Stock del ingrediente
     * @param detallesProducto detalles Producto del ingrediente 
     */
    public Ingrediente(Long id, String nombre, UnidadMedida unidadMedida, Integer stock, List<DetalleProductoIngrediente> detallesProducto) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
        this.detallesProducto = detallesProducto;
    }
    /**
     * Obtiene los detallesProductos asociados al ingrediente
     * @return Lista de detallesProductoIngrediente
     */
    public List<DetalleProductoIngrediente> getDetallesProducto() {
        return detallesProducto;
    }
    /**
     * Estableve los detallesProductoIngrediente del ingrediente
     * @param detallesProducto detallesProductoIngredienten nuevos
     */
    public void setDetallesProducto(List<DetalleProductoIngrediente> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }

 
    /**
     * Constructor vacio de ingrediente
     */
    public Ingrediente() {
    }
    /**
     * Obtiene el nombre del ingredientr
     * @return Nombre actual del ingrediente
     */
    public String getNombre() {
        return nombre;
    }   
    /**
     *  Establece el nombre del ingrediente
     * @param nombre nombre nuevo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene la unidad de medida actual del ingrediente
     * @return Unidad de medida actual del ingrediente
     */
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }
    /**
     * Establece la unidad de medida del ingrediente
     * @param unidadMedida unidad de medida nueva
     */
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    /**
     * Obtiene el stock del ingrediente
     * @return Stock actual
     */
    public Integer getStock() {
        return stock;
    }
    /**
     * Establece el stock del ingrediente
     * @param stock stock nuevo
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    /**
     * Obtiene el id de la base de datos
     * @return id del ingrediente
     */        
    public Long getId() {
        return id;
    }
    /**
     * Establece el id del ingrediente
     * @param id id nuevo
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", stock=" + stock + ", detallesProducto=" + detallesProducto + '}';
    }

    
    
}
