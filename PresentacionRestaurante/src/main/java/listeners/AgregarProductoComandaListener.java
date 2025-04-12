package listeners;

import DTOs.ProductoDTO;

/**
 * Interfaz que se utiliza como listener para cuando se agregar productos a la
 * barra lateral en la pantalla de toma de comanda
 *
 * @author Alici
 */
public interface AgregarProductoComandaListener {

    /**
     * Método que recibe un ProductoDTO
     *
     * @param producto datos del producto a agregar
     */
    public void agregarProducto(ProductoDTO producto);
}
