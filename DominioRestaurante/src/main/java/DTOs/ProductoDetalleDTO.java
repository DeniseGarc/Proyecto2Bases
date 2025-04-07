/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enumeradores.TipoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alici
 */
public class ProductoDetalleDTO {

    private String nombre;
    private TipoProducto tipo;
    private double precio;
    List<IngredienteProductoDTO> ingredientes = new ArrayList<>();

    public ProductoDetalleDTO() {
    }

    public ProductoDetalleDTO(String nombre, TipoProducto tipo, double precio, List<IngredienteProductoDTO> ingredientes) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<IngredienteProductoDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteProductoDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
