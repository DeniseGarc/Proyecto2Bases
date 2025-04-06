/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import DTOs.IngredienteDTO;
import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import exception.NegocioException;
import interfaces.IIngredienteBO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import manejadorBO.ManejadorBO;

/**
 *
 * @author erika
 */
public class PantallaIngredientes extends javax.swing.JFrame {
    private final CoordinadorAplicacion coordinador = new CoordinadorAplicacion();
    private IIngredienteBO ingredienteBO = ManejadorBO.crearIngredienteBO();

    /**
     * Creates new form PantallaIngredientes
     */
    public PantallaIngredientes() {
        initComponents();
        try {
            cargarYMostrarIngredientes();
        } catch (NegocioException ex) {
            Logger.getLogger(PantallaProductos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void cargarYMostrarIngredientes() throws NegocioException {
        List<IngredienteDTO> lista = ingredienteBO.obtenerIngredientes(); 
        mostrarIngredientes(lista);
    }
    public void mostrarIngredientes(List<IngredienteDTO> listaIngredientes) {
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre tarjetas
        gbc.anchor = GridBagConstraints.NORTHWEST;

        int columnas = 3;
        int fila = 0;
        int columna = 0;

        for (IngredienteDTO ingrediente : listaIngredientes) {
            JPanel tarjeta = crearTarjetaIngrediente(ingrediente);

            gbc.gridx = columna;
            gbc.gridy = fila;

            jPanel3.add(tarjeta, gbc);

            columna++;
            if (columna >= columnas) {
                columna = 0;
                fila++;
            }
        }

        jPanel3.revalidate();
        jPanel3.repaint();
    }

    private JPanel crearTarjetaIngrediente(IngredienteDTO ingrediente) {
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 120));
        panel.setBackground(new Color(255, 227, 242)); // Fondo rosa
        panel.setLayout(new BorderLayout());

        // Panel central para el nombre
        JPanel panelNombre = new JPanel();
        panelNombre.setBackground(new Color(255, 192, 203)); // Rosa claro
        JLabel lblNombre = new JLabel(ingrediente.getNombre(), SwingConstants.CENTER);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        panelNombre.add(lblNombre);

        // Panel para la información de stock y unidad
        JLabel lblStock = new JLabel("Stock: " + ingrediente.getStock(), SwingConstants.LEFT);
        lblStock.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel lblUnidad = new JLabel("Unidad: " + ingrediente.getUnidadMedida(), SwingConstants.LEFT);
        lblUnidad.setFont(new Font("Arial", Font.PLAIN, 14));

        // Personalización de botones
        JButton btnMenos = new JButton("-");
        btnMenos.setFont(new Font("Arial", Font.BOLD, 14));
        btnMenos.setBackground(new Color(240, 128, 128)); 
        btnMenos.setForeground(Color.WHITE);
        btnMenos.setBorder(BorderFactory.createLineBorder(new Color(139, 0, 0), 2)); 
        
        //action listener para que funcionen los botones
       
         btnMenos.addActionListener(e -> {
        int nuevoStock = ingrediente.getStock() - 1;
        if (nuevoStock >= 0) {
            try {
                IngredienteDTO actualizado = coordinador.modificarStock(ingrediente.getId(), nuevoStock);
                ingrediente.setStock(actualizado.getStock());
                lblStock.setText("Stock: " + actualizado.getStock());
            } catch (CoordinadorException ex) {
                JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

        JButton btnMas = new JButton("+");
        btnMas.setFont(new Font("Arial", Font.BOLD, 14));
        btnMas.setBackground(new Color(60, 179, 113)); 
        btnMas.setForeground(Color.WHITE); 
        btnMas.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); 
        
        //action listener para que funcionen los botones
        btnMas.addActionListener(e -> {
        int nuevoStock = ingrediente.getStock() + 1;
        try {
            IngredienteDTO actualizado = coordinador.modificarStock(ingrediente.getId(), nuevoStock);
            ingrediente.setStock(actualizado.getStock());
            lblStock.setText("Stock: " + actualizado.getStock());
        } catch (CoordinadorException ex) {
            JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    });

        // Panel para botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 0)); // Espaciado entre botones
        panelBotones.add(btnMenos);
        panelBotones.add(btnMas);

        // Panel inferior donde se combina stock y botones
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(lblUnidad, BorderLayout.NORTH);
        panelInferior.add(lblStock, BorderLayout.CENTER);
        panelInferior.add(panelBotones, BorderLayout.SOUTH);

        // Combinar todas las partes
        panel.add(panelNombre, BorderLayout.NORTH);
        panel.add(panelInferior, BorderLayout.CENTER);

        return panel;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1070, 700));

        jPanel1.setBackground(new java.awt.Color(255, 254, 245));

        jPanel2.setBackground(new java.awt.Color(255, 176, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(1070, 78));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Ingredientes");
        jPanel2.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 500, 40));

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

        jPanel3.setBackground(new java.awt.Color(255, 178, 217));
        jPanel3.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(jPanel3);

        btnAgregar.setBackground(new java.awt.Color(255, 178, 217));
        btnAgregar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 178, 217));
        btnEliminar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 51, Short.MAX_VALUE))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        coordinador.PantallaPrinicipal(this);
    }//GEN-LAST:event_lblRegresarMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
      coordinador.PantallaAgregarIngrediente(this);
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        coordinador.PantallaEliminarIngrediente(this);
    }//GEN-LAST:event_btnEliminarMouseClicked
    
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
