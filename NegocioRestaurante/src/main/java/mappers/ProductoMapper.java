package mappers;

import DTOs.IngredienteProductoDTO;
import DTOs.ProductoDTO;
import DTOs.ProductoDetalleDTO;
import entidades.DetalleProductoIngrediente;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se utiliza para mapear entre entidades Producto y sus respectivos
 * DTOs.
 *
 * @author Alicia Denise García Acosta 0000252402
 */
public class ProductoMapper {

    /**
     * Convierte una lista de entidades Producto a una lista de ProductoDTO
     *
     * @param productos Lista de entidades Producto a convertir.
     * @return Lista de ProductoDTO equivalentes.
     */
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

    /**
     * Convierte una entidad Producto a un ProductoDetalleDTO
     *
     * @param producto Entidad Producto a convertir.
     * @return ProductoDetalleDTo con toda la información del producto.
     */
    public static ProductoDetalleDTO toProductoDetalleDTO(Producto producto) {
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

    /**
     * Convierte un ProductoDetalleDTO a una entidad Producto básica (nombre,
     * tipo, precio).
     *
     * @param productoDTO ProductoDetalleDTO a convertir.
     * @return Entidad Producto con la información básica (nombre, tipo,
     * precio).
     */
    public static Producto toEntity(ProductoDetalleDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setTipo(productoDTO.getTipo());
        producto.setPrecio(productoDTO.getPrecio());
        return producto;
    }

    /**
     * Convierte una entidad Producto a un ProductoDTO.
     *
     * @param producto Entidad Producto a convertir
     * @return ProductoDTO con la información de la entidad Producto
     */
    public static ProductoDTO toProductoDTO(Producto producto) {
        return new ProductoDTO(
                producto.getNombre(),
                producto.getTipo(),
                producto.getPrecio(),
                producto.isDisponible(),
                producto.isHabilitada());
    }
}
