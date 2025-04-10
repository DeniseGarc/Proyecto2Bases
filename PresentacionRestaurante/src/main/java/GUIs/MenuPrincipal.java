/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alici
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private CoordinadorAplicacion coordinador = new CoordinadorAplicacion();

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        verificarMesas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnComandas = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnMesas = new javax.swing.JButton();
        btnIngredientes = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnClientesFrecuentes = new javax.swing.JButton();
        lblBtnIngredientes = new javax.swing.JLabel();
        lblBtnMesas = new javax.swing.JLabel();
        lblBtnReportes = new javax.swing.JLabel();
        lblBtnComandas = new javax.swing.JLabel();
        lblBtnClientes = new javax.swing.JLabel();
        lblBtnProductos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icono-logo.png"))); // NOI18N
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 240, -1));

        jPanel1.setBackground(new java.awt.Color(255, 254, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 176, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(1070, 78));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnComandas.setBackground(new java.awt.Color(254, 255, 203));
        btnComandas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnComandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/comanda-icono.png"))); // NOI18N
        btnComandas.setMaximumSize(new java.awt.Dimension(240, 220));
        btnComandas.setMinimumSize(new java.awt.Dimension(240, 220));
        btnComandas.setPreferredSize(new java.awt.Dimension(240, 220));
        btnComandas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComandasMouseClicked(evt);
            }
        });
        jPanel1.add(btnComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 240, 220));

        btnReportes.setBackground(new java.awt.Color(255, 140, 200));
        btnReportes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/reporte-icono.png"))); // NOI18N
        btnReportes.setPreferredSize(new java.awt.Dimension(150, 150));
        jPanel1.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 240, 220));

        btnMesas.setBackground(new java.awt.Color(201, 220, 249));
        btnMesas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnMesas.setForeground(new java.awt.Color(255, 255, 255));
        btnMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMesasMouseClicked(evt);
            }
        });
        btnMesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/mesas-icon.png"))); // NOI18N
        btnMesas.setMaximumSize(new java.awt.Dimension(240, 220));
        btnMesas.setMinimumSize(new java.awt.Dimension(240, 220));
        btnMesas.setPreferredSize(new java.awt.Dimension(240, 220));
        jPanel1.add(btnMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 240, 220));
        btnIngredientes.setBackground(new java.awt.Color(255, 178, 217));
        btnIngredientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnIngredientes.setForeground(new java.awt.Color(255, 255, 255));
        btnIngredientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/ingredientes-icono.png"))); // NOI18N
        btnIngredientes.setPreferredSize(new java.awt.Dimension(150, 150));
        btnIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngredientesMouseClicked(evt);
            }
        });
        jPanel1.add(btnIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 240, 220));

        btnProductos.setBackground(new java.awt.Color(255, 178, 217));
        btnProductos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/productos-icono.png"))); // NOI18N
        btnProductos.setPreferredSize(new java.awt.Dimension(150, 150));
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jPanel1.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 240, 220));

        btnClientesFrecuentes.setBackground(new java.awt.Color(255, 178, 217));
        btnClientesFrecuentes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnClientesFrecuentes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientesFrecuentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/clientes-icono.png"))); // NOI18N
        btnClientesFrecuentes.setPreferredSize(new java.awt.Dimension(150, 150));
        btnClientesFrecuentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesFrecuentesMouseClicked(evt);
            }
        });
        btnClientesFrecuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesFrecuentesActionPerformed(evt);
            }
        });
        jPanel1.add(btnClientesFrecuentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 240, 220));

        lblBtnIngredientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblBtnIngredientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnIngredientes.setText("Ingredientes");
        lblBtnIngredientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblBtnIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 640, 240, -1));

        lblBtnMesas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblBtnMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnMesas.setText("Generar Mesas");
        lblBtnMesas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblBtnMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 240, -1));

        lblBtnReportes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblBtnReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnReportes.setText("Reportes");
        lblBtnReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblBtnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 240, -1));

        lblBtnComandas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblBtnComandas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnComandas.setText("Comandas");
        lblBtnComandas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblBtnComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 240, -1));

        lblBtnClientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblBtnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnClientes.setText("Clientes Frecuentes");
        lblBtnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblBtnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 640, 240, -1));

        lblBtnProductos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblBtnProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnProductos.setText("Productos");
        lblBtnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblBtnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 640, 240, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesFrecuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesFrecuentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientesFrecuentesActionPerformed

    private void btnIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngredientesMouseClicked
        coordinador.PantallaIngredientes(this);
    }//GEN-LAST:event_btnIngredientesMouseClicked

    private void btnClientesFrecuentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesFrecuentesMouseClicked
        coordinador.PantallaClienteFrecuente(this);
    }//GEN-LAST:event_btnClientesFrecuentesMouseClicked

    private void btnComandasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComandasMouseClicked
        coordinador.PantallaComandas(this);
    }//GEN-LAST:event_btnComandasMouseClicked

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        coordinador.pantallaProductos(this);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesasMouseClicked
        insertarMesas();
    }//GEN-LAST:event_btnMesasMouseClicked

    private void verificarMesas() {
        try {
            if (coordinador.consultarMesas()) {
                btnMesas.setEnabled(false);
            }
        } catch (CoordinadorException e) {
            JOptionPane.showMessageDialog(this, "Error al verificar las mesas: " + e.getMessage());
        }
    }

    private void insertarMesas() {
        try {
            if (!coordinador.consultarMesas()) {
                coordinador.insertarMesas();
                btnMesas.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Las mesas se registraron exitosamente.");
            }
        } catch (CoordinadorException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar mesas: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientesFrecuentes;
    private javax.swing.JButton btnComandas;
    private javax.swing.JButton btnIngredientes;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBtnClientes;
    private javax.swing.JLabel lblBtnComandas;
    private javax.swing.JLabel lblBtnIngredientes;
    private javax.swing.JLabel lblBtnMesas;
    private javax.swing.JLabel lblBtnProductos;
    private javax.swing.JLabel lblBtnReportes;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
