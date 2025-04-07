package plantillas;

import DTOs.ProductoDTO;
import java.awt.Color;

/**
 * Panel que representa visualmente un producto. Este panel muestra un botón el
 * cual muestra el nombre del producto y, si es que no se encuentra disponible
 * muestra un mensaje indicandolo y el botón ya no puede ser clickeado.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public class PanelProducto extends javax.swing.JPanel {

    /**
     * Constructor que inicializa los componentes del panel y carga los datos
     * del producto dado.
     *
     * @param producto el producto que se a representar en el panel.
     */
    public PanelProducto(ProductoDTO producto) {
        initComponents();
        cargarDatos(producto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEstado = new javax.swing.JLabel();
        btnProducto = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 254, 245));
        setMaximumSize(new java.awt.Dimension(150, 150));
        setMinimumSize(new java.awt.Dimension(150, 150));
        setPreferredSize(new java.awt.Dimension(150, 150));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 6, 140, -1));

        btnProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnProducto.setText("jButton1");
        add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 150));
    }// </editor-fold>//GEN-END:initComponents
   /**
     * Método que carga los datos del producto en los componentes del panel.
     * Establece el nombre del producto como el texto del botón e indica la
     * disponiblidad del mismo, asimismo ajusta los estilos.
     *
     * @param producto el producto cuyos datos serán cargados.
     */
    private void cargarDatos(ProductoDTO producto) {
        String nombre = producto.getNombre();
        btnProducto.setText("<html><center>" + nombre + "</center></html>");
        btnProducto.setToolTipText(nombre);
        btnProducto.setEnabled(producto.isDisponible());
        if (!producto.isDisponible()) {
            lblEstado.setText("No disponible");
        }
        btnProducto.setBackground(new Color(254, 255, 203));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProducto;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables
}
