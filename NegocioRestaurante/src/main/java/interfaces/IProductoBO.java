/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.ProductoDTO;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IProductoBO {

    public List<ProductoDTO> obtenerProductos() throws NegocioException;
}
