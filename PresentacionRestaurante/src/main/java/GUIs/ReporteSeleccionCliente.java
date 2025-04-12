/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import control.CoordinadorAplicacion;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Maryr
 */
public class ReporteSeleccionCliente extends javax.swing.JFrame {

    private CoordinadorAplicacion control = new CoordinadorAplicacion();

    /**
     * Creates new form ReporteSeleccionClientes
     */
    public ReporteSeleccionCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        btnReporteCliente = new javax.swing.JButton();
        btnReporteNumVisitas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1070, 700));
        setMinimumSize(new java.awt.Dimension(1070, 700));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 254, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 176, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(1070, 78));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Reportes de clientes");
        jPanel2.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 500, 40));

        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imgs/flecha-regresar.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(108, 81, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/flecha-regresar.png"))); // NOI18N
        lblRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
        });
        jPanel2.add(lblRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 100, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnReporteCliente.setBackground(new java.awt.Color(255, 178, 217));
        btnReporteCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnReporteCliente.setText("Por cliente");
        btnReporteCliente.setToolTipText("⚠ bajo construcción ⚠");
        btnReporteCliente.setEnabled(false);
        btnReporteCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporteCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 210, 200));

        btnReporteNumVisitas.setText("Por número de visitas");
        btnReporteNumVisitas.setBackground(new java.awt.Color(255, 178, 217));
        btnReporteNumVisitas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnReporteNumVisitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteNumVisitasMouseClicked(evt);
            }
        });
        jPanel1.add(btnReporteNumVisitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, -1, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        control.pantallaReportes(this);
    }//GEN-LAST:event_lblRegresarMouseClicked

    private void btnReporteNumVisitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteNumVisitasMouseClicked
        control.pantallaClienteVisitas(this);
    }//GEN-LAST:event_btnReporteNumVisitasMouseClicked

    private void btnReporteClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteClienteActionPerformed
        control.pantallaReportesClientes(this);
    }//GEN-LAST:event_btnReporteClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporteCliente;
    private javax.swing.JButton btnReporteNumVisitas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
