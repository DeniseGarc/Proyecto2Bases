/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package plantillas;

import DTOs.ProductoDTO;
import java.awt.Color;

/**
 *
 * @author Alici
 */
public class PanelProducto extends javax.swing.JPanel {

    /**
     * Creates new form PanelProducto
     * @param producto
     */
    public PanelProducto(ProductoDTO producto) {
        initComponents();
        cargarDatos(producto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
