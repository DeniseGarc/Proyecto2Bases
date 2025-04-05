/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ProductoDTO;
import DTOs.ProductoDetalleDTO;
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
        if (texto == null) {
            throw new NegocioException("El texto para filtrar los productos no puede ser nulo");
        }
        try {
            List<Producto> productos = productoDAO.obtenerProductosFiltrados(texto);
            return ProductoMapper.toDTOList(productos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por nombre");
        }
    }

    @Override
    public List<ProductoDTO> obtenerProductosFiltradosNombreyCategoria(String texto, TipoProducto categoria) throws NegocioException {
        if (texto == null || categoria == null) {
            throw new NegocioException("El texto para filtrar ni la categoria del producto pueden ser nulos");
        }
        try {
            List<Producto> productos = productoDAO.obtenerProductosFiltrados(texto, categoria);
            return ProductoMapper.toDTOList(productos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por nombre y categoria");
        }
    }

    @Override
    public List<ProductoDTO> obtenerProductosFiltradosCategoria(TipoProducto categoria) throws NegocioException {
        if (categoria == null) {
            throw new NegocioException("La categoria para filtrar los productos no puede ser nula");
        }
        try {
            List<Producto> productos = productoDAO.obtenerProductosFiltrados(categoria);
            return ProductoMapper.toDTOList(productos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por categoria");
        }
    }

    @Override
    public ProductoDetalleDTO obtenerProductoDetallesPorNombre(String nombre) throws NegocioException {
        if (nombre == null) {
            throw new NegocioException("El nombre del producto a buscar no puede ser nulo");
        }
        try {
            Producto producto = productoDAO.obtenerProductoPorNombre(nombre);
            return ProductoMapper.toDTO(producto);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

}
