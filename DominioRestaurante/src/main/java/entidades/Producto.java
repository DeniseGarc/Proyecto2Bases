/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alici
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 100, unique = true)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoProducto tipo;
    @Column(name = "disponible", nullable = false)
    private boolean disponible;
    @Column(name = "habilitada", nullable = false)
    private boolean habilitada;
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<DetalleProductoIngrediente> detallesProducto = new ArrayList<>();

    public Producto() {
    }

    public Producto(String nombre, Double precio, TipoProducto tipo, boolean disponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public Producto(Long id, String nombre, Double precio, TipoProducto tipo, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<DetalleProductoIngrediente> getDetallesProducto() {
        return detallesProducto;
    }

    public void setDetallesProducto(List<DetalleProductoIngrediente> detallesProducto) {
        this.detallesProducto = detallesProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", disponible=" + disponible + '}';
    }

}
