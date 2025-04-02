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
import javax.persistence.Transient;

/**
 *
 * @author Alici
 */
@Entity
@Table(name = "detallesComandas")
public class DetalleComanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "precioUnitario", nullable = false)
    private Double precioUnitario;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Transient //Ver como funcionan los calculados desde JPA
    private Double importeTotal;
    @Column(name = "notas", nullable = true, length = 500)
    private String notas;
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    
   @ManyToOne
   @JoinColumn (name = "idComanda",nullable = false)
    private Comanda comanda;
    // falta relacion con comanda, extras

    public DetalleComanda(Double precioUnitario, Integer cantidad, Double importeTotal, String notas, Producto producto, Comanda comanda) {
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.importeTotal = importeTotal;
        this.notas = notas;
        this.producto = producto;
        this.comanda = comanda;
    }

    public DetalleComanda(Long id, Double precioUnitario, Integer cantidad, Double importeTotal, String notas, Producto producto, Comanda comanda) {
        this.id = id;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.importeTotal = importeTotal;
        this.notas = notas;
        this.producto = producto;
        this.comanda = comanda;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public DetalleComanda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleComanda{" + "id=" + id + ", precioUnitario=" + precioUnitario + ", cantidad=" + cantidad + ", importeTotal=" + importeTotal + ", notas=" + notas + ", producto=" + producto + ", comanda=" + comanda + '}';
    }

}
