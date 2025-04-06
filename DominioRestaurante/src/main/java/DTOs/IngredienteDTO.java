/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enumeradores.UnidadMedida;
import java.util.List;

/**
 *
 * @author erika
 */
public class IngredienteDTO {
    private Long id;
    private String nombre; 
    private UnidadMedida unidadMedida;
    private Integer stock;
    private List<IngredienteProductoDTO> ingredienteProducto;

    public List<IngredienteProductoDTO> getIngredienteProducto() {
        return ingredienteProducto;
    }

    public void setIngredienteProducto(List<IngredienteProductoDTO> ingredienteProducto) {
        this.ingredienteProducto = ingredienteProducto;
    }

    public IngredienteDTO() {
    }

    public IngredienteDTO(Long id, String nombre, UnidadMedida unidadMedida, Integer stock, List<IngredienteProductoDTO> ingredienteProducto) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
        this.ingredienteProducto = ingredienteProducto;
    }

    public IngredienteDTO(String nombre, UnidadMedida unidadMedida, Integer stock, List<IngredienteProductoDTO> ingredienteProducto) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
        this.ingredienteProducto = ingredienteProducto;
    }

    public IngredienteDTO(String nombre, UnidadMedida unidadMedida, Integer stock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    

    @Override
    public String toString() {
        return "IngredienteDTO{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", stock=" + stock + '}';
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
    
    
}
