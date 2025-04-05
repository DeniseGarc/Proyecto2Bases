/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import DTOs.ProductoDetalleDTO;
import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alici
 */
public class PantallaProductos extends javax.swing.JFrame {

    private CoordinadorAplicacion control = new CoordinadorAplicacion();

    /**
     * Creates new form FrmProductos
     */
    public PantallaProductos() {
        initComponents();
        cargarBanner();
        configurarBarraBusqueda();
        try {
            panelTablaProductos.mostrarProductos(control.obtenerProductos());
        } catch (CoordinadorException ex) {
            Logger.getLogger(PantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
        }
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

    private void btnHabilitarDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHabilitarDeshabilitarActionPerformed
        // TODO add your handling code here:
    }

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarProductoActionPerformed
        control.pantallaAgregarProducto(this);
    }

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnActualizarProductoActionPerformed
        // TODO add your handling code here:
    }

    private void btnConsultarIngredientesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnConsultarIngredientesActionPerformed
        cargarDetalleDelProducto();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaProductos.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaProductos.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaProductos.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaProductos.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaProductos().setVisible(true);
            }
        });
    }

    private void cargarBanner() {
        banner.getLblTitulo().setText("Productos");
        banner.setFrmPadre(this);
        banner.setFrmTarget(new MenuPrincipal());
    }

    private void configurarBarraBusqueda() {
        panelBusquedaProducto.setVista(panelTablaProductos);
        panelBusquedaProducto.setBackground(new Color(255, 254, 245));
    }

    private void cargarDetalleDelProducto() {
        int filaSeleccionada = panelTablaProductos.getTblProductos().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto para ver sus detalles", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String nombre = (String) panelTablaProductos.getTblProductos().getValueAt(filaSeleccionada, 0);
            try {
                ProductoDetalleDTO producto = control.obtenerDetallesDelProducto(nombre);
                control.pantallaDetallesProducto(this, producto);
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
