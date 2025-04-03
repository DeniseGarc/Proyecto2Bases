/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ProductoDTO;
import entidades.Producto;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;
import java.util.List;
import mappers.ProductoMapper;

/**
 *
 * @author Alici
 */
public class ProductoBO implements IProductoBO {

    private IProductoDAO productoDAO;

    public ProductoBO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    @Override
    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        try {
            List<Producto> productos = productoDAO.obtenerProductos();
            return ProductoMapper.toDTOList(productos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los productos");
        }
    }

}
