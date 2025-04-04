/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DTOs.ProductoDTO;
import entidades.Producto;
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

}
