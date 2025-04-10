/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listener;

import entidades.Comanda;
import entidades.DetalleComanda;
import entidades.DetalleProductoIngrediente;
import entidades.Ingrediente;
import entidades.Producto;
import enumeradores.Estado;
import javax.persistence.PreUpdate;

/**
 *
 * @author erika
 */
public class ModificarStockIngredientesListener {
    public class DescontarStockListener {

    @PreUpdate
    public void verificarCambioEstado(Comanda comanda) {
        // Solo continuar si el nuevo estado es ENTREGADA
        if (comanda.getEstado() == Estado.ENTREGADA) {
            descontarStock(comanda);
        }
    }

    private void descontarStock(Comanda comanda) {
        for (DetalleComanda detalle : comanda.getDetallesComanda()) {
            Producto producto = detalle.getProducto();
            int cantidadComanda = detalle.getCantidad();

            for (DetalleProductoIngrediente dpi : producto.getDetallesProducto()) {
                Ingrediente ingrediente = dpi.getIngrediente();
                int cantidadIngrediente = dpi.getCantidad() * cantidadComanda;

                Integer nuevoStock = ingrediente.getStock() - cantidadIngrediente;

                // Validar si hay suficiente stock
                if (nuevoStock < 0) {
                    throw new IllegalStateException("No hay suficiente stock para el ingrediente: " + ingrediente.getNombre());
                }

                ingrediente.setStock(nuevoStock);
            }
        }
    }
}

    
}
