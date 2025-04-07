/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import DTOs.ComandaDTO;
import DTOs.DetalleComandaDTO;
import DTOs.ProductoDTO;
import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import enumeradores.Estado;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import plantillas.PanelProductoComanda;

/**
 *
 * @author Alici
 */
public class PantallaTomaComanda extends javax.swing.JFrame {

    CoordinadorAplicacion control = new CoordinadorAplicacion();
    private List<PanelProductoComanda> productosComanda = new ArrayList<>();

    public PantallaTomaComanda() {
        initComponents();
        cargarBanner();
        configurarBarraBusqueda();
        panelContenedorProductosComanda.setLayout(new BoxLayout(panelContenedorProductosComanda, BoxLayout.Y_AXIS));
        panelProductos.setListener(producto -> {
            agregarProducto(producto);
        });
        cargarProductosMenu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblTotalTitulo = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        scrollPaneProductosComanda = new javax.swing.JScrollPane();
        panelContenedorProductosComanda = new javax.swing.JPanel();
        lblClienteNombre = new javax.swing.JLabel();
        lblNumeroMesa = new javax.swing.JLabel();
        lblClienteTitulo = new javax.swing.JLabel();
        banner = new plantillas.Titulo();
        panelProductos = new moduloBusquedaProductos.PanelVistaGridProductos();
        panelBusquedaProducto = new moduloBusquedaProductos.PanelBusquedaProducto();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1064, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 254, 245));
        jPanel1.setForeground(new java.awt.Color(255, 254, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 227, 242));
        jPanel2.setForeground(new java.awt.Color(255, 227, 242));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setText("Productos Agregados");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, -1));

        jButton1.setBackground(new java.awt.Color(164, 199, 255));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Mandar pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 310, 80));

        lblTotalTitulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalTitulo.setText("Total");
        jPanel2.add(lblTotalTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        lblTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("$ total...");
        jPanel2.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 230, -1));

        scrollPaneProductosComanda.setBackground(new java.awt.Color(255, 227, 242));
        scrollPaneProductosComanda.setBorder(null);
        scrollPaneProductosComanda.setHorizontalScrollBar(null);

        panelContenedorProductosComanda.setBackground(new java.awt.Color(255, 227, 242));

        javax.swing.GroupLayout panelContenedorProductosComandaLayout = new javax.swing.GroupLayout(panelContenedorProductosComanda);
        panelContenedorProductosComanda.setLayout(panelContenedorProductosComandaLayout);
        panelContenedorProductosComandaLayout.setHorizontalGroup(
            panelContenedorProductosComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        panelContenedorProductosComandaLayout.setVerticalGroup(
            panelContenedorProductosComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        scrollPaneProductosComanda.setViewportView(panelContenedorProductosComanda);

        jPanel2.add(scrollPaneProductosComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 300, 540));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 310, 700));

        lblClienteNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblClienteNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblClienteNombre.setText("Nombre...");
        lblClienteNombre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lblClienteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 250, 30));

        lblNumeroMesa.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblNumeroMesa.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroMesa.setText("num mesa");
        jPanel1.add(lblNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        lblClienteTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblClienteTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblClienteTitulo.setText("Cliente:");
        jPanel1.add(lblClienteTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));
        jPanel1.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(panelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        panelBusquedaProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(panelBusquedaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaTomaComanda.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaTomaComanda.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaTomaComanda.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaTomaComanda.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaTomaComanda().setVisible(true);
            }
        });
    }

    private void cargarProductosMenu() {
        try {
            panelProductos.mostrarProductos(control.obtenerProductos());
        } catch (CoordinadorException ex) {
            Logger.getLogger(PantallaTomaComanda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Ha ocurrido un error inesperado", JOptionPane.ERROR);
        }
    }

    private void agregarProducto(ProductoDTO producto) {
        PanelProductoComanda panelProductoComanda = new PanelProductoComanda(producto);
        panelContenedorProductosComanda.add(panelProductoComanda);
        productosComanda.add(panelProductoComanda);
        agregarListener(panelProductoComanda);

        panelContenedorProductosComanda.revalidate();
        panelContenedorProductosComanda.repaint();

    }

    private void agregarListener(PanelProductoComanda panelProductoComanda) {
        panelProductoComanda.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto(panelProductoComanda);
            }
        });
    }

    private void eliminarProducto(PanelProductoComanda panelProductoComanda) {
        panelContenedorProductosComanda.remove(panelProductoComanda);
        productosComanda.remove(panelProductoComanda);

        panelContenedorProductosComanda.revalidate();
        panelContenedorProductosComanda.repaint();
    }

    private void configurarBarraBusqueda() {
        panelBusquedaProducto.setVista(panelProductos);
        panelBusquedaProducto.setBackground(new Color(255, 176, 217));
    }

    private void cargarBanner() {
        banner.getLblTitulo().setText("Mesa:");
        banner.setFrmPadre(this);
        banner.setFrmTarget(new MenuPrincipal());
    }

    private void mandarComanda() {

    }

    private void generarComanda() {
//        ComandaDTO comanda = new ComandaDTO();
//        comanda.setFechaHora(Calendar.getInstance());
//        comanda.setNombrecliente(lblClienteNombre.getText().isBlank() ? null : lblClienteNombre.getText());
//        comanda.setEstado(Estado.ACTIVA);
//        
//        List<DetalleComandaDTO> detallesComanda = new ArrayList<>();
//        for (PanelProductoComanda panelProductoComanda : productosComanda) {
//            int cantidad = 
//            ProductoDTO producto = panelProductoComanda.getProducto();
//            detallesComanda.add(new DetalleComandaDTO(
//                    producto.getPrecio(),
//            cantidad
//                    (producto.getPrecio*cantidad))
//                            notas,
//                            producto.getNombre()
//            ));
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private plantillas.Titulo banner;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblClienteNombre;
    private javax.swing.JLabel lblClienteTitulo;
    private javax.swing.JLabel lblNumeroMesa;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalTitulo;
    private moduloBusquedaProductos.PanelBusquedaProducto panelBusquedaProducto;
    private javax.swing.JPanel panelContenedorProductosComanda;
    private moduloBusquedaProductos.PanelVistaGridProductos panelProductos;
    private javax.swing.JScrollPane scrollPaneProductosComanda;
    // End of variables declaration//GEN-END:variables
}
