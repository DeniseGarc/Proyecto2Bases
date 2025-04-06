/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.ProductoDTO;
import DTOs.ProductoDetalleDTO;
import enumeradores.TipoProducto;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IProductoBO {

    public List<ProductoDTO> obtenerProductos() throws NegocioException;

    public List<ProductoDTO> obtenerProductosFiltradosNombre(String texto) throws NegocioException;

    public List<ProductoDTO> obtenerProductosFiltradosNombreyCategoria(String texto, TipoProducto categoria) throws NegocioException;

    public List<ProductoDTO> obtenerProductosFiltradosCategoria(TipoProducto categoria) throws NegocioException;

    public ProductoDetalleDTO obtenerProductoDetallesPorNombre(String nombre) throws NegocioException;

    public ProductoDetalleDTO agregarProducto(ProductoDetalleDTO productoNuevo) throws NegocioException;

    public boolean cambiarEstadoProducto(String nombre) throws NegocioException;
}
