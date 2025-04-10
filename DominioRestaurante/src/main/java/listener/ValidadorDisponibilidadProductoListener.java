package listener;

import entidades.DetalleProductoIngrediente;
import entidades.Producto;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author Alici
 */
public class ValidadorDisponibilidadProductoListener {

    @PreUpdate
    @PrePersist
    private void validarStock(Producto producto) {
        try {
            for (DetalleProductoIngrediente detalleProducto : producto.getDetallesProducto()) {
                if (detalleProducto.getCantidad() > detalleProducto.getIngrediente().getStock()) {
                    producto.setDisponible(false);
                } else {
                    producto.setDisponible(true);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al validar la disponibilidad del producto: " + producto.getNombre());
        }
    }

}
