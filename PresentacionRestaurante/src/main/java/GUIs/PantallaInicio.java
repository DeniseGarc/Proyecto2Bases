/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import control.CoordinadorAplicacion;

/**
 *
 * @author erika
 */
public class PantallaInicio extends javax.swing.JFrame {
     private CoordinadorAplicacion coordinador = new CoordinadorAplicacion();
    /**
     * Creates new form PantallaInicio
     */
    public PantallaInicio() {
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
        btnMesero = new javax.swing.JButton();
        btnAdministrador = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1070, 700));
        setMinimumSize(new java.awt.Dimension(1070, 700));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 254, 245));
        jPanel1.setMaximumSize(new java.awt.Dimension(1070, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1070, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 178, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMesero.setBackground(new java.awt.Color(255, 119, 170));
        btnMesero.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnMesero.setText("Soy Mesero");
        btnMesero.setBorder(null);
        btnMesero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMeseroMouseClicked(evt);
            }
        });
        jPanel2.add(btnMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 469, 320, 38));

        btnAdministrador.setBackground(new java.awt.Color(255, 119, 170));
        btnAdministrador.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnAdministrador.setText("Soy Administrador");
        btnAdministrador.setBorder(null);
        btnAdministrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdministradorMouseClicked(evt);
            }
        });
        jPanel2.add(btnAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 320, 38));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logo-inicio.png"))); // NOI18N
        jPanel2.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 490, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 56, -1, 565));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMeseroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMeseroMouseClicked
        
    }//GEN-LAST:event_btnMeseroMouseClicked

    private void btnAdministradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdministradorMouseClicked
        coordinador.PantallaPrinicipal(this);
    }//GEN-LAST:event_btnAdministradorMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrador;
    private javax.swing.JButton btnMesero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
