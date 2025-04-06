package BO;

import DTOs.IngredienteProductoDTO;
import DTOs.ProductoDTO;
import DTOs.ProductoDetalleDTO;
import entidades.DetalleProductoIngrediente;
import entidades.Producto;
import enumeradores.TipoProducto;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IIngredienteDAO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.ProductoMapper;

/**
 *
 * @author Alici
 */
public class ProductoBO implements IProductoBO {

    private IProductoDAO productoDAO;
    private IIngredienteDAO ingredienteDAO;

    public ProductoBO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    @Override
    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        try {
            List<Producto> productos = productoDAO.obtenerProductos();
            return ProductoMapper.toDTOList(productos);
        } catch (PersistenciaException e) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Ocurrió un error al obtener los productos", e);
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
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por nombre", e);
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
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por nombre y categoria", e);
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
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por categoria", e);
        }
    }

    @Override
    public ProductoDetalleDTO obtenerProductoDetallesPorNombre(String nombre) throws NegocioException {
        if (nombre == null) {
            throw new NegocioException("El nombre del producto a buscar es nulo");
        }
        try {
            Producto producto = productoDAO.obtenerProductoPorNombre(nombre);
            if (producto == null) {
                return null;
            }
            return ProductoMapper.toDTO(producto);
        } catch (PersistenciaException e) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Error al obtener producto de la base de datos: ", e);
        }
    }

    @Override
    public boolean agregarProducto(ProductoDetalleDTO productoNuevo) throws NegocioException {
        if (productoNuevo == null) {
            throw new NegocioException("El producto a agregar es nulo");
        }
        Producto producto = ProductoMapper.toEntity(productoNuevo);
        producto.setHabilitada(true);
        producto.setDisponible(true);
        try {

            List<DetalleProductoIngrediente> detallesProducto = new ArrayList(); // detalles de producto nuevos
//            for (IngredienteProductoDTO ingredienteProducto : productoNuevo.getIngredientes()) {
//                //obtener el ingrediente por nombre y unidad de medida
//                Ingrediente ingrediente = ingredienteDAO.
//                detallesProductoActualizados.add(
//                        new DetalleProductoIngrediente(
//                                ingredienteProducto.getCantidad(),
//                                producto,
//                                ingrediente
//                        ));
//            }
            producto.setDetallesProducto(detallesProducto);
            return productoDAO.registrarProducto(producto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ha ocurrido un error al cambiar el estado del producto", ex);
        }
    }

    @Override
    public boolean cambiarEstadoProducto(String nombre) throws NegocioException {
        if (nombre == null) {
            throw new NegocioException("El nombre del producto a cambiar de estado es nulo");
        }
        try {
            Producto producto = productoDAO.obtenerProductoPorNombre(nombre);
            boolean estado = !producto.isHabilitada();
            return productoDAO.deshabilitarHabilitarProducto(nombre, estado);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ha ocurrido un error al cambiar el estado del producto", ex);
        }
    }

    @Override
    public boolean actualizarProducto(ProductoDetalleDTO productoActualizar) throws NegocioException {
        if (productoActualizar == null) {
            throw new NegocioException("El producto a actualizar es nulo");
        }
        try {
            Producto producto = productoDAO.obtenerProductoPorNombre(productoActualizar.getNombre());
            if (producto == null) {
                throw new NegocioException("El producto a actualizar no existe");
            }
            producto.setPrecio(productoActualizar.getPrecio());
            List<DetalleProductoIngrediente> detallesProductoActualizados = new ArrayList(); // detalles de producto nuevos
//            for (IngredienteProductoDTO ingredienteProducto : productoActualizar.getIngredientes()) {
//                //obtener el ingrediente por nombre y unidad de medida
//                Ingrediente ingrediente = ingredienteDAO.
//                detallesProductoActualizados.add(
//                        new DetalleProductoIngrediente(
//                                ingredienteProducto.getCantidad(),
//                                producto,
//                                ingrediente
//                        ));
//            }
            producto.setDetallesProducto(detallesProductoActualizados);
            return productoDAO.actualizarProducto(producto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ha ocurrido un error al actualizar el producto", ex);
        }
    }

}
