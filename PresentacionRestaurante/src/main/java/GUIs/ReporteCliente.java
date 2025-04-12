/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import DTOs.ReporteClienteDTO;
import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import java.awt.Image;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Pantalla para crear un reporte sobre clientes frecuentes
 * @author Maryr
 */
public class ReporteCliente extends javax.swing.JFrame {
    /**
     * Instancia unica de la clase control para aceder a los metodos BO
     */
    private CoordinadorAplicacion control = new CoordinadorAplicacion();

    /**
     * Creates new form ReporteCliente
     */
    public ReporteCliente() {
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        btnGenReporte = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1070, 700));
        setMinimumSize(new java.awt.Dimension(1070, 700));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 254, 245));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 176, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Reporte de clientes frecuentes");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 600, 40));

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
        jPanel1.add(lblRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 100, 100));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 82));

        lblCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCliente.setText("Cliente:");
        jPanel2.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 100, -1, -1));

        btnGenReporte.setBackground(new java.awt.Color(255, 119, 170));
        btnGenReporte.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnGenReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnGenReporte.setText("Generar reporte");
        btnGenReporte.setBorder(null);
        btnGenReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenReporteActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 133, 143, 26));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 132, 650, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        control.pantallaReporteSeleccionCliente(this);
    }//GEN-LAST:event_lblRegresarMouseClicked

    private void btnGenReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenReporteActionPerformed
        generarReportePDF();
    }//GEN-LAST:event_btnGenReporteActionPerformed

    /**
     * Método que genera un reporte de los clientes por su nombre
     */
    private void generarReportePDF() {
        String nombre = txtNombre.getText();
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre a filtrar los clientes del reporte", "Ingrese el campo de nombre", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // obtiene la lista de clientes del reporte
        List<ReporteClienteDTO> clientesReporte = new ArrayList<>();
        try {
            clientesReporte = control.obtenerClientesReporteClientes(null, nombre);
        } catch (CoordinadorException ex) {
            Logger.getLogger(ReporteClienteVisitas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar recuperar los datos necesarios para el reporte", "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
        }

        // Se le agrega un elemento al inicio de la lista que llena la tabla debido que la tabla se "come" el primer registro
        clientesReporte.add(0, new ReporteClienteDTO());

        try {
            // Se carga el archivo .jrxml del reporte desde los recursos del proyecto
            InputStream jrxmlStream = getClass().getClassLoader().getResourceAsStream("reportes/ReporteDeClientes.jrxml");

            // Si no se encuentra se muestra mensaje
            if (jrxmlStream == null) {
                JOptionPane.showMessageDialog(null, "No se encontró el archivo .jrxml del reporte", "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Se crea la fuente de datos para el reporte a partir de la lista de comandas
            JRBeanCollectionDataSource detallesReporteComanda = new JRBeanCollectionDataSource(clientesReporte);

            // Se crea el mapa de parámetros que se enviarán al reporte
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("nombreClienteFiltro", nombre);
            parametros.put("numeroVisitasFiltro", -1);

            // Se compila el archivo .jrxml
            JasperReport reporte = JasperCompileManager.compileReport(jrxmlStream);
            // Se llena el reporte con los datos y parametros
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, detallesReporteComanda);

            // Mostramos el visor de JasperReports como ventana modal
            JasperViewer viewer = new JasperViewer(print, false); // false para no cerrar la app al cerrar el visor
            viewer.setTitle("Vista previa del Reporte de Clientes");
            viewer.setVisible(true);
            // Se le da un tamaño 
            viewer.setSize(800, 600);
            // posicion para que salga al centro de la pantalla
            viewer.setLocationRelativeTo(this);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar generar el pdf del reporte", "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenReporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
