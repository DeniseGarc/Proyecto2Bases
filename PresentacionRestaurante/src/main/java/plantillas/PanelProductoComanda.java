/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package plantillas;

import DTOs.ProductoDTO;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author Alici
 */
public class PanelProductoComanda extends javax.swing.JPanel {

    private final ProductoDTO producto;

    /**
     * Creates new form PanelIngredienteProducto
     *
     * @param producto
     */
    public PanelProductoComanda(ProductoDTO producto) {
        this.producto = producto;
        initComponents();
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreProducto = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblComentario = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaComentario = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 228, 242));
        setMaximumSize(new java.awt.Dimension(280, 202));
        setMinimumSize(new java.awt.Dimension(280, 202));
        setPreferredSize(new java.awt.Dimension(280, 202));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreProducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombreProducto.setText("nombre...");
        add(lblNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, -1));

        lblPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPrecio.setText("$ precio...");
        add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 60, -1));

        lblComentario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblComentario.setText("Comentario:");
        add(lblComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, -1));

        btnEliminar.setBackground(new java.awt.Color(234, 50, 119));
        btnEliminar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 158, 90, -1));

        jSeparator1.setBackground(new java.awt.Color(207, 106, 158));
        jSeparator1.setForeground(new java.awt.Color(207, 106, 158));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 280, 20));

        txtAreaComentario.setColumns(20);
        txtAreaComentario.setRows(5);
        jScrollPane1.setViewportView(txtAreaComentario);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 260, 80));
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    private void cargarDatos() {
        lblNombreProducto.setText(producto.getNombre());
        lblPrecio.setText(String.format("$ %.2f", producto.getPrecio()));
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public JTextArea getTxtAreaComentario() {
        return txtAreaComentario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JTextArea txtAreaComentario;
    // End of variables declaration//GEN-END:variables
}
