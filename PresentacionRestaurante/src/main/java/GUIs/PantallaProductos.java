package GUIs;

import DTOs.ProductoDetalleDTO;
import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que representa la pantalla para la gestión de productos dentro del
 * sistema.
 * <p>
 * Permite realizar acciones como:
 * </p>
 * <ul>
 * <li>Visualizar la lista de productos disponibles</li>
 * <li>Consultar los ingredientes de un producto</li>
 * <li>Agregar un nuevo producto</li>
 * <li>Actualizar la información de un producto</li>
 * <li>Habilitar o deshabilitar un producto existente</li>
 * </ul>
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public class PantallaProductos extends javax.swing.JFrame {

    /**
     * CoordinadorAplicacion para la comunicación con capa de negocio y flujo de
     * pantallas.
     */
    private CoordinadorAplicacion control = new CoordinadorAplicacion();

    /**
     * Constructor que inicializa los componentes de la pantalla, banner, barra
     * de búsqueda y tabla de productos.
     */
    public PantallaProductos() {
        initComponents();
        cargarBanner();
        configurarBarraBusqueda();
        cargarTablaProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultarIngredientes = new javax.swing.JButton();
        btnHabilitarDeshabilitar = new javax.swing.JButton();
        btnActualizarProducto = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        panelTablaProductos = new moduloBusquedaProductos.PanelVistaListaProductos();
        jPanel2 = new javax.swing.JPanel();
        banner = new plantillas.Titulo();
        panelBusquedaProducto = new moduloBusquedaProductos.PanelBusquedaProducto();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 254, 245));
        setResizable(false);
        setSize(new java.awt.Dimension(1064, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConsultarIngredientes.setBackground(new java.awt.Color(172, 204, 255));
        btnConsultarIngredientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnConsultarIngredientes.setText("Consultar ingredientes");
        btnConsultarIngredientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultarIngredientes.setName(""); // NOI18N
        btnConsultarIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarIngredientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultarIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 210, 40));

        btnHabilitarDeshabilitar.setBackground(new java.awt.Color(255, 119, 170));
        btnHabilitarDeshabilitar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnHabilitarDeshabilitar.setForeground(new java.awt.Color(255, 255, 255));
        btnHabilitarDeshabilitar.setText("Habilitar/Deshabilitar producto");
        btnHabilitarDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarDeshabilitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnHabilitarDeshabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 630, 250, 40));

        btnActualizarProducto.setBackground(new java.awt.Color(255, 119, 170));
        btnActualizarProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnActualizarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarProducto.setText("Actualizar producto");
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 630, 210, 40));

        btnAgregarProducto.setBackground(new java.awt.Color(255, 119, 170));
        btnAgregarProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 630, 210, 40));
        getContentPane().add(panelTablaProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 254, 245));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel2.add(panelBusquedaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 750, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta al presionar el botón de habilitar/deshabilitar,
     * llama a los métodos necesarios para cambiar el estado del producto.
     */
    private void btnHabilitarDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHabilitarDeshabilitarActionPerformed
        String nombre = obtenerNombreSeleccionTabla();
        cambiarEstadoProducto(nombre);
    }

    /**
     * Método que se ejecuta al presionar el botón de agregar producto, llama a
     * los métodos necesarios para pasar a la pantalla de agregar producto.
     */
    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarProductoActionPerformed
        control.pantallaAgregarProducto(this);
    }

    /**
     * Método que se ejecuta al presionar el botón de actualizar producto, llama
     * a los métodos necesarios para poder actualizar el producto.
     */
    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnActualizarProductoActionPerformed
        String nombre = obtenerNombreSeleccionTabla();
        pasarAActualizarProducto(nombre);
    }

    /**
     * Método que se ejecuta al presionar el botón de consultar ingredientes,
     * llama a los métodos necesarios para pasar a la pantalla que permite
     * visualizar los detalles del producto.
     */
    private void btnConsultarIngredientesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConsultarIngredientesActionPerformed
        String nombre = obtenerNombreSeleccionTabla();
        verDetallesDelProducto(nombre);
    }

    /**
     * Método que indica al PanelVistaListaProductos que muestre los productos
     * que recibe como parámetro.
     */
    private void cargarTablaProductos() {
        try {
            panelTablaProductos.mostrarProductos(control.obtenerProductos());
        } catch (CoordinadorException ex) {
            Logger.getLogger(PantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método que configura el titulo del panel superior de la pantalla y
     * establece los frames destino y padre para la navegación del botón para
     * regresar.
     */
    private void cargarBanner() {
        banner.getLblTitulo().setText("Productos");
        banner.setFrmPadre(this);
        banner.setFrmTarget(new MenuPrincipal());
    }

    /**
     * Método que le indica a la barra de búsqueda el tipo de vista que se va a
     * manejar y cambia el color del panel de fondo de la barra de búsqueda.
     */
    private void configurarBarraBusqueda() {
        panelBusquedaProducto.setVista(panelTablaProductos);
        panelBusquedaProducto.setBackground(new Color(255, 254, 245));
    }

    /**
     * Método para obtner el nombre del producto que ha sido seleccionado en la
     * tabla.
     *
     * @return Nombre del producto seleccionado.
     */
    private String obtenerNombreSeleccionTabla() {
        int filaSeleccionada = panelTablaProductos.getTblProductos().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto", "", JOptionPane.INFORMATION_MESSAGE);
            return null;
        } else {
            return (String) panelTablaProductos.getTblProductos().getValueAt(filaSeleccionada, 0);
        }
    }

    /**
     * Método que cambia el estado del producto que ha sido seleccionado. Si su
     * esta era habilitado cambia a deshabilitado y viceversa.
     *
     * @param nombre Nombre del producto seleccionado.
     */
    private void cambiarEstadoProducto(String nombre) {
        if (nombre != null) {
            try {
                boolean resultado = control.actualizarEstadoProducto(nombre);
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Se ha cambiado el estado del producto " + nombre + " con éxito", "Se cambio de estado exitoso", JOptionPane.INFORMATION_MESSAGE);
                    String texto = panelBusquedaProducto.getTxtBusqueda().getText();
                    panelBusquedaProducto.getTxtBusqueda().setText(texto);
                    Object categoria = panelBusquedaProducto.getcBoxTipo().getSelectedItem();
                    panelBusquedaProducto.getcBoxTipo().setSelectedItem(categoria);
                }
            } catch (CoordinadorException ex) {
                Logger.getLogger(PantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método que manda el nombre del producto seleccionado para que se muestren
     * sus detalles en otra pantalla.
     *
     * @param nombre Nombre del producto seleccionado.
     */
    private void verDetallesDelProducto(String nombre) {
        if (nombre != null) {
            try {
                ProductoDetalleDTO producto = control.obtenerDetallesDelProducto(nombre);
                control.pantallaDetallesProducto(this, producto);
            } catch (CoordinadorException ex) {
                Logger.getLogger(PantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método que manda el nombre del producto seleccionado para poder
     * actualizarlo en otra pantalla.
     *
     * @param nombre Nombre del producto seleccionado.
     */
    private void pasarAActualizarProducto(String nombre) {
        if (nombre != null) {
            try {
                ProductoDetalleDTO producto = control.obtenerDetallesDelProducto(nombre);
                control.pantallaModificarProducto(this, producto);
            } catch (CoordinadorException ex) {
                Logger.getLogger(PantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private plantillas.Titulo banner;
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnConsultarIngredientes;
    private javax.swing.JButton btnHabilitarDeshabilitar;
    private javax.swing.JPanel jPanel2;
    private moduloBusquedaProductos.PanelBusquedaProducto panelBusquedaProducto;
    private moduloBusquedaProductos.PanelVistaListaProductos panelTablaProductos;
    // End of variables declaration//GEN-END:variables
}
