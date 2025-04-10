/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import DTOs.ComandaDTO;
import DTOs.IngredienteDTO;
import PlantillaComandas.PanelComandasActivas;
import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author erika
 */
public class PantallaComandas extends javax.swing.JFrame {

    /**
     * Creates new form PantallaComandas
     */
    private final CoordinadorAplicacion coordinador = new CoordinadorAplicacion();
    public PantallaComandas() {
        initComponents();
    }
    private void cargarComandas(){
        try {
            List<ComandaDTO> comandas = coordinador.obtenerComandasActivas();
            mostrarComandas(comandas);
        } catch (CoordinadorException ex) {
            Logger.getLogger(PantallaComandas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void mostrarComandas(List<ComandaDTO> comandas){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre tarjetas
        gbc.anchor = GridBagConstraints.NORTHWEST;

        int columnas = 3;
        int fila = 0;
        int columna = 0;

        for (ComandaDTO comanda : comandas) {
            PanelComandasActivas panelComandas = new PanelComandasActivas();
            panelComandas.getNumero().setText(comanda.getNumeroMesa());
            gbc.gridx = columna;
            gbc.gridy = fila;

            jPanel3.add(panelComandas, gbc);

            columna++;
            if (columna >= columnas) {
                columna = 0;
                fila++;
            }
        }

        jPanel3.revalidate();
        jPanel3.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        btnAgregarComanda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1070, 700));
        setMinimumSize(new java.awt.Dimension(1070, 700));
        setPreferredSize(new java.awt.Dimension(1070, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 254, 245));
        jPanel1.setMaximumSize(new java.awt.Dimension(1070, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1070, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarComanda.setBackground(new java.awt.Color(255, 119, 170));
        btnAgregarComanda.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 70)); // NOI18N
        btnAgregarComanda.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarComanda.setText("+");
        btnAgregarComanda.setMinimumSize(new java.awt.Dimension(100, 100));
        btnAgregarComanda.setPreferredSize(new java.awt.Dimension(100, 100));
        btnAgregarComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarComandaMouseClicked(evt);
            }
        });
        jPanel1.add(btnAgregarComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 228, 242));
        jPanel3.setLayout(new java.awt.GridLayout(4, 4, 10, 10));
        jScrollPane2.setViewportView(jPanel3);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 920, 620));

        jPanel2.setBackground(new java.awt.Color(255, 176, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(1070, 78));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Comandas");
        jPanel2.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 250, 40));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1088, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        coordinador.PantallaPrinicipal(this);
    }//GEN-LAST:event_lblRegresarMouseClicked

    private void btnAgregarComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarComandaMouseClicked
        coordinador.pantallaComandaAgregarCliente(this);
    }//GEN-LAST:event_btnAgregarComandaMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarComanda;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
