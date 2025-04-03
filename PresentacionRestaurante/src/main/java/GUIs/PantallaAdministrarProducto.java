/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import java.awt.Color;
import javax.swing.BoxLayout;
import plantillas.PanelIngredienteProducto;

/**
 *
 * @author Alici
 */
public class PantallaAdministrarProducto extends javax.swing.JFrame {

    /**
     * Creates new form AdministrarProducto
     */
    public PantallaAdministrarProducto() {
        initComponents();
        cargarBanner();
        panelContenedorIngredientesProducto.setLayout(new BoxLayout(panelContenedorIngredientesProducto, BoxLayout.Y_AXIS));
        panelContenedorIngredientesProducto.add(new PanelIngredienteProducto());
        panelContenedorIngredientesProducto.add(new PanelIngredienteProducto());
        panelContenedorIngredientesProducto.add(new PanelIngredienteProducto());
        panelContenedorIngredientesProducto.add(new PanelIngredienteProducto());
        panelContenedorIngredientesProducto.add(new PanelIngredienteProducto());
        cargarBarraBusqueda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlResumenProducto = new javax.swing.JPanel();
        lblNombreTitulo = new javax.swing.JLabel();
        lblCategoriaTitulo = new javax.swing.JLabel();
        lblPrecioTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblResumenProducto = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        lblIngredientesNecesario = new javax.swing.JLabel();
        scrollPanelIngredientes = new javax.swing.JScrollPane();
        panelContenedorIngredientesProducto = new javax.swing.JPanel();
        banner = new plantillas.Titulo();
        panelBusquedaProducto = new modulos.PanelBusquedaProducto();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1064, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 254, 245));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 228, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlResumenProducto.setBackground(new java.awt.Color(255, 255, 255));
        pnlResumenProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombreTitulo.setText("Nombre:");
        pnlResumenProducto.add(lblNombreTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lblCategoriaTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCategoriaTitulo.setText("Categoria:");
        pnlResumenProducto.add(lblCategoriaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblPrecioTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPrecioTitulo.setText("Precio: ");
        pnlResumenProducto.add(lblPrecioTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombre.setText("nombre...");
        pnlResumenProducto.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 180, -1));

        lblCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCategoria.setText("categoria...");
        pnlResumenProducto.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 170, -1));

        lblPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPrecio.setText("$ precio");
        pnlResumenProducto.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 190, -1));

        lblResumenProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblResumenProducto.setText("Resumen del producto");
        pnlResumenProducto.add(lblResumenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));

        jPanel1.add(pnlResumenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 130));

        btnAgregar.setBackground(new java.awt.Color(255, 119, 170));
        btnAgregar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar producto");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 310, 70));

        lblIngredientesNecesario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblIngredientesNecesario.setText("Ingredientes necesarios");
        jPanel1.add(lblIngredientesNecesario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 200, -1));

        scrollPanelIngredientes.setBorder(null);

        panelContenedorIngredientesProducto.setBackground(new java.awt.Color(255, 228, 242));
        panelContenedorIngredientesProducto.setAutoscrolls(true);
        panelContenedorIngredientesProducto.setLayout(new javax.swing.BoxLayout(panelContenedorIngredientesProducto, javax.swing.BoxLayout.LINE_AXIS));
        scrollPanelIngredientes.setViewportView(panelContenedorIngredientesProducto);

        jPanel1.add(scrollPanelIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 300, 460));

        fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 310, 700));
        fondo.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        fondo.add(panelBusquedaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaAdministrarProducto().setVisible(true);
            }
        });
    }

    private void cargarBarraBusqueda() {
        panelBusquedaProducto.setBackground(new Color(255, 254, 245));
    }

    private void cargarBanner() {
        banner.getLblTitulo().setText("Agregar producto");
        banner.setFrmPadre(this);
        banner.setFrmTarget(new PantallaProductos());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private plantillas.Titulo banner;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCategoriaTitulo;
    private javax.swing.JLabel lblIngredientesNecesario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreTitulo;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecioTitulo;
    private javax.swing.JLabel lblResumenProducto;
    private modulos.PanelBusquedaProducto panelBusquedaProducto;
    private javax.swing.JPanel panelContenedorIngredientesProducto;
    private javax.swing.JPanel pnlResumenProducto;
    private javax.swing.JScrollPane scrollPanelIngredientes;
    // End of variables declaration//GEN-END:variables
}
