package moduloBusquedaProductos;

import DTOs.ProductoDTO;
import java.util.List;

/**
 * Interfaz que representa una vista capaz de mostrar una lista de productos.
 * Las clases que implementan esta interfaz deben proporcionar una manera de
 * desplegar los productos proporcionados en la lista.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public interface VistaProductos {

    /**
     * Muestra una lista de productos en la vista.
     *
     * @param productos Lista de productos que se desea mostrar.
     */
    public void mostrarProductos(List<ProductoDTO> productos);
}
