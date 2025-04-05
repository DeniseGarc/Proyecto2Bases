/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DTOs.IngredienteDTO;
import DTOs.IngredienteProductoDTO;
import DTOs.ProductoDTO;
import DTOs.ProductoDetalleDTO;
import entidades.DetalleProductoIngrediente;
import entidades.Producto;
import enumeradores.UnidadMedida;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alici
 */
public class ProductoMapper {

    public static List<ProductoDTO> toDTOList(List<Producto> productos) {
        List<ProductoDTO> productosDTO = new ArrayList<>();
        for (Producto producto : productos) {
            productosDTO.add(
                    new ProductoDTO(
                            producto.getNombre(),
                            producto.getTipo(),
                            producto.getPrecio(),
                            producto.isDisponible(),
                            producto.isHabilitada())
            );
        }
        return productosDTO;
    }

    public static ProductoDetalleDTO toDTO(Producto producto) {
        ProductoDetalleDTO detallesProducto = new ProductoDetalleDTO();
        detallesProducto.setNombre(producto.getNombre());
        detallesProducto.setTipo(producto.getTipo());
        detallesProducto.setPrecio(producto.getPrecio());
        List<DetalleProductoIngrediente> listaDetallesProducto = producto.getDetallesProducto();
        for (DetalleProductoIngrediente detalleProductoIngrediente : listaDetallesProducto) {
            IngredienteProductoDTO ingrediente = new IngredienteProductoDTO(
                    detalleProductoIngrediente.getIngrediente().getNombre(),
                    detalleProductoIngrediente.getIngrediente().getUnidadMedida(),
                    detalleProductoIngrediente.getCantidad()
            );
            detallesProducto.getIngredientes().add(ingrediente);
        }
        return detallesProducto;
    }

}
