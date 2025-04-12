package PlantillaComandas;

import DTOs.ComandaDTO;
import GUIs.PantallaComandas;
import control.CoordinadorAplicacion;
import enumeradores.Estado;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Panel que representa las comandas activas.
 *
 * @author erika
 */
public class PanelComandasActivas extends javax.swing.JPanel {

    private ComandaDTO comanda;
    private final CoordinadorAplicacion coordinador = new CoordinadorAplicacion();
    private PantallaComandas frame;

    /**
     * Constructor que inicializa los componentes del panel y guarda el frame al
     * que pertenece el panel y los datos de la comanda.
     *
     * @param frame Frame en el que se añadió el panel.
     * @param comanda Comanda que representa este panel.
     */
    public PanelComandasActivas(PantallaComandas frame, ComandaDTO comanda) {
        this.comanda = comanda;
        this.frame = frame;
        initComponents();
    }

    /**
     * Devuelve el label donde se escribe el número de la mesa de la comanda.
     *
     * @return JLabel con el número de la mesa de la comanda
     */
    public JLabel getNumero() {
        return txtNumero;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtMesa = new javax.swing.JLabel();
        txtNumero = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEntregada = new javax.swing.JButton();
        btnCancelada = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(200, 280));
        setMinimumSize(new java.awt.Dimension(200, 280));
        setPreferredSize(new java.awt.Dimension(200, 280));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 255, 203));
        jPanel2.setMaximumSize(new java.awt.Dimension(200, 280));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 178, 217));

        txtMesa.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txtMesa.setForeground(new java.awt.Color(255, 255, 255));
        txtMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMesa.setText("Mesa");

        txtNumero.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(255, 255, 255));
        txtNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNumero.setText("#");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumero)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, -1));

        btnModificar.setBackground(new java.awt.Color(201, 220, 249));
        btnModificar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 105, 155, 40));

        btnEntregada.setBackground(new java.awt.Color(255, 178, 217));
        btnEntregada.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnEntregada.setForeground(new java.awt.Color(255, 255, 255));
        btnEntregada.setText("Marcar como entregada");
        btnEntregada.setBorder(null);
        btnEntregada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntregada.setMinimumSize(new java.awt.Dimension(120, 15));
        btnEntregada.setPreferredSize(new java.awt.Dimension(120, 15));
        btnEntregada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntregadaMouseClicked(evt);
            }
        });
        jPanel2.add(btnEntregada, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 163, 155, 40));

        btnCancelada.setBackground(new java.awt.Color(255, 119, 170));
        btnCancelada.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnCancelada.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelada.setText("Marcar como cancelada");
        btnCancelada.setToolTipText("");
        btnCancelada.setBorder(null);
        btnCancelada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCanceladaMouseClicked(evt);
            }
        });
        btnCancelada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanceladaActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelada, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 221, 155, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanceladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceladaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCanceladaActionPerformed


    private void btnEntregadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntregadaMouseClicked
        marcarComoEntregada();
    }//GEN-LAST:event_btnEntregadaMouseClicked

    private void btnCanceladaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanceladaMouseClicked
        marcarComoCancelada();
    }//GEN-LAST:event_btnCanceladaMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        coordinador.pantallaModificarComanda(frame, comanda);
    }//GEN-LAST:event_btnModificarMouseClicked

    /**
     * Método que marca como entregada la comanda de este panel
     */
    private void marcarComoEntregada() {
        Estado nuevoEstado = Estado.ENTREGADA;  // Definir el nuevo estado
        try {
            coordinador.actualizarEstadoMesa(Long.valueOf(comanda.getNumeroMesa()), true);
            coordinador.actualizarEstadoComanda(comanda, nuevoEstado);
            JOptionPane.showMessageDialog(this, "Comanda marcada como entregada");
            frame.cargarComandas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el estado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método que marca como cancelada la comanda de este panel
     */
    private void marcarComoCancelada() {
        Estado nuevoEstado = Estado.CANCELADA;
        try {
            coordinador.actualizarEstadoMesa(Long.valueOf(comanda.getNumeroMesa()), true);
            coordinador.actualizarEstadoComanda(comanda, nuevoEstado);
            JOptionPane.showMessageDialog(this, "Comanda marcada como cancelada");
            frame.cargarComandas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el estado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelada;
    private javax.swing.JButton btnEntregada;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel txtMesa;
    private javax.swing.JLabel txtNumero;
    // End of variables declaration//GEN-END:variables
}
