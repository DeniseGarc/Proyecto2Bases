package BO;

import DTOs.IngredienteProductoDTO;
import DTOs.ProductoDTO;
import DTOs.ProductoDetalleDTO;
import entidades.DetalleProductoIngrediente;
import entidades.Ingrediente;
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
 * Clase que implementa la lógica de negocio para operaciones relacionadas con
 * productos.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 * @see IProductoBO
 */
public class ProductoBO implements IProductoBO {

    private IProductoDAO productoDAO;
    private IIngredienteDAO ingredienteDAO;

    /**
     * Constructor que inicializa las dependencias DAO necesarias.
     *
     * @param productoDAO Implementación de IProductoDAO para acceso a datos de
     * productos
     * @param ingredienteDAO Implementación de IIngredienteDAO para acceso a
     * datos de ingredientes
     */
    public ProductoBO(IProductoDAO productoDAO, IIngredienteDAO ingredienteDAO) {
        this.productoDAO = productoDAO;
        this.ingredienteDAO = ingredienteDAO;
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
    public List<ProductoDTO> obtenerProductosFiltrados(String texto, TipoProducto categoria) throws NegocioException {
        try {
            List<Producto> productos = productoDAO.buscarPorFiltros(texto, categoria);
            return ProductoMapper.toDTOList(productos);
        } catch (PersistenciaException e) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Ocurrió un error al obtener los productos filtrados por nombre", e);
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
            return ProductoMapper.toProductoDetalleDTO(producto);
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
            List<DetalleProductoIngrediente> detallesProducto = new ArrayList<>(); // detalles de producto nuevos
            // Se obtienen los ingredientes para crear el detalle producto
            for (IngredienteProductoDTO ingredienteProducto : productoNuevo.getIngredientes()) {
                Ingrediente ingrediente = ingredienteDAO.buscarPorNombreYUnidad1(ingredienteProducto.getNombre(), ingredienteProducto.getUnidadMedida().name());
                detallesProducto.add(
                        new DetalleProductoIngrediente(
                                ingredienteProducto.getCantidad(),
                                producto,
                                ingrediente
                        ));
            }
            // Se le asignan al producto para actualizarlo
            producto.setDetallesProducto(detallesProducto);
            return productoDAO.registrarProducto(producto);
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
            // Se obtiene el producto a actualizar
            Producto producto = productoDAO.obtenerProductoPorNombre(productoActualizar.getNombre());
            if (producto == null) {
                throw new NegocioException("El producto a actualizar no existe");
            }
            // Se le asigna el precio actualizado
            producto.setPrecio(productoActualizar.getPrecio());
            // Se obtienen los nuevos detalle producto, para saber los ingredientes necesarios para el producto
            List<DetalleProductoIngrediente> detallesProductoActualizados = new ArrayList<>();
            for (IngredienteProductoDTO ingredienteProducto : productoActualizar.getIngredientes()) {
                Ingrediente ingrediente = ingredienteDAO.buscarPorNombreYUnidad1(ingredienteProducto.getNombre(), ingredienteProducto.getUnidadMedida().name());
                detallesProductoActualizados.add(
                        new DetalleProductoIngrediente(
                                ingredienteProducto.getCantidad(),
                                producto,
                                ingrediente
                        ));
            }
            // Se le asignan los detalles producto al producto
            producto.setDetallesProducto(detallesProductoActualizados);
            return productoDAO.actualizarProducto(producto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ha ocurrido un error al actualizar el producto", ex);
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
    public ProductoDTO obtenerProductoPorNombre(String nombre) throws NegocioException {
        if (nombre == null) {
            throw new NegocioException("El nombre del producto a buscar es nulo");
        }
        try {
            Producto producto = productoDAO.obtenerProductoPorNombre(nombre);
            if (producto == null) {
                throw new NegocioException("No se ha encontrado el producto con el nombre dado");
            }
            ProductoDTO productoObtenido = ProductoMapper.toProductoDTO(producto);
            return productoObtenido;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ha ocurrido un error al obtener el producto", ex);
        }

    }

    @Override
    public boolean consultarProductoEnComandaActiva(String nombre) throws NegocioException {
        if (nombre == null) {
            throw new NegocioException("El nombre del producto a consultar si esta dentro de alguna comanda activa es nulo");
        }
        try {
            return productoDAO.productoEnComandaActiva(nombre);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ha ocurrido un error al realizar la consulta", ex);
        }
    }
}
