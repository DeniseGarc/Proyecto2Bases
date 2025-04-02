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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column (name="unidad_medida", nullable = false)
    private UnidadMedida unidadMedida;
    @Column (name="stock", nullable = false)
    private Integer stock;
    
    @OneToMany(mappedBy = "ingrediente",fetch = FetchType.LAZY)
    private List<DetalleProductoIngrediente> detallesProducto;

    public Ingrediente(String nombre, UnidadMedida unidadMedida, Integer stock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    public Ingrediente(Long id, String nombre, UnidadMedida unidadMedida, Integer stock, List<DetalleProductoIngrediente> detallesProducto) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
        this.detallesProducto = detallesProducto;
    }

    public List<DetalleProductoIngrediente> getDetallesProducto() {
        return detallesProducto;
    }

    public void setDetallesProducto(List<DetalleProductoIngrediente> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }

 

    public Ingrediente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
            
    public Long getId() {
        return id;
    }

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
        return "entidades.Ingrediente[ id=" + id + " ]";
    }
    
}
