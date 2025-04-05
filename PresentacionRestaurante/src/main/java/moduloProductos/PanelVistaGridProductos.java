package moduloProductos;

import DTOs.ProductoDTO;
import java.util.List;
import plantillas.PanelProducto;

/**
 * Panel que implementa la interfaz VistaProductos. Este Panel se encarga de
 * mostrar los productos registrados en la base de datos dentro de un contenedor
 * con diseño de cuadricula.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public class PanelVistaGridProductos extends javax.swing.JPanel implements VistaProductos {

    /**
     * Se crea el panel y se inicializan sus elementos
     */
    public PanelVistaGridProductos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanelProductos = new javax.swing.JScrollPane();
        panelContenedorProductos = new javax.swing.JPanel();

        scrollPanelProductos.setBackground(new java.awt.Color(255, 254, 245));
        scrollPanelProductos.setBorder(null);
        scrollPanelProductos.setHorizontalScrollBar(null);

        panelContenedorProductos.setBackground(new java.awt.Color(255, 254, 245));
        panelContenedorProductos.setMaximumSize(new java.awt.Dimension(790, 578));
        panelContenedorProductos.setMinimumSize(new java.awt.Dimension(790, 578));
        panelContenedorProductos.setLayout(new java.awt.GridLayout(0, 5));
        scrollPanelProductos.setViewportView(panelContenedorProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(scrollPanelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(scrollPanelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelContenedorProductos;
    private javax.swing.JScrollPane scrollPanelProductos;
    // End of variables declaration//GEN-END:variables

    /**
     * Muestra una lista de productos en el panel. Cada producto es representado
     * por un PanelProducto que se añade dinámicamente al panel contenedor en
     * formato de cuadrícula. Agrega solamente los productos habilitados.
     *
     * @param productos Lista de productos a mostrar.
     */
    @Override
    public void mostrarProductos(List<ProductoDTO> productos) {

        panelContenedorProductos.removeAll();
        for (ProductoDTO producto : productos) {
            if (producto.isHabilitado()) {
                panelContenedorProductos.add(new PanelProducto(producto));
            }
        }
        panelContenedorProductos.revalidate();
        panelContenedorProductos.repaint();
    }
}
