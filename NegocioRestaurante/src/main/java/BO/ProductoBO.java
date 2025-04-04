/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ProductoDTO;
import entidades.Producto;
import enumeradores.TipoProducto;
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

    @Override
    public List<ProductoDTO> obtenerProductosFiltradosNombre(String texto) throws NegocioException {
        try {
            List<Producto> productos = productoDAO.obtenerProductosFiltrados(texto);
            return ProductoMapper.toDTOList(productos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por nombre");
        }
    }

    @Override
    public List<ProductoDTO> obtenerProductosFiltradosNombreyCategoria(String texto, TipoProducto categoria) throws NegocioException {
        try {
            List<Producto> productos = productoDAO.obtenerProductosFiltrados(texto, categoria);
            return ProductoMapper.toDTOList(productos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por nombre y categoria");
        }
    }

    @Override
    public List<ProductoDTO> obtenerProductosFiltradosCategoria(TipoProducto categoria) throws NegocioException {
        try {
            List<Producto> productos = productoDAO.obtenerProductosFiltrados(categoria);
            return ProductoMapper.toDTOList(productos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por categoria");
        }
    }

}
