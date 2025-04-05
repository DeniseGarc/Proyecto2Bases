/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import DTOs.IngredienteDTO;
import exception.NegocioException;
import interfaces.IIngredienteBO;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
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
public class Ingredientes extends javax.swing.JFrame {
    private IIngredienteBO ingredienteBO = ManejadorBO.crearIngredienteBO();
    /**
     * Creates new form Ingredientes
     */
    public Ingredientes() {
        initComponents();
        MostrarIngredientes();
    }
    
    private void MostrarIngredientes() {
        try {
            List<IngredienteDTO> lista = ingredienteBO.obtenerIngredientes();
            mostrarIngredientes(lista);
        }catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener los ingredientes", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void mostrarIngredientes(List<IngredienteDTO> listaIngredientes) {
        // Configurar el diseño de jPanel3 como BorderLayout
        jPanel3.setLayout(new BorderLayout());

        // Crear un panel para las tarjetas y usar GridBagLayout para su distribución
        JPanel panelTarjetas = new JPanel(new GridBagLayout());
        panelTarjetas.setBackground(new Color(255,178,217));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.NORTHWEST;

        // Configuración inicial para la distribución en columnas y filas
        int columnas = 3;
        int fila = 0;
        int columna = 0;

        // Agregar cada tarjeta al panelTarjetas
        for (IngredienteDTO ingrediente : listaIngredientes) {
            JPanel tarjeta = crearTarjetaIngrediente(ingrediente);

            gbc.gridx = columna;
            gbc.gridy = fila;

            panelTarjetas.add(tarjeta, gbc);

            columna++;
            if (columna >= columnas) {
                columna = 0;
                fila++;
            }
        }

        //  botón Agregar
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 14));
        btnAgregar.setBackground(new Color(255, 119, 170)); 
        btnAgregar.setForeground(Color.WHITE); // 
        btnAgregar.setBorder(BorderFactory.createLineBorder(new Color(139, 0, 0), 2)); 
        // boton eliminar
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEliminar.setBackground(new Color(255, 119, 170)); 
        btnEliminar.setForeground(Color.WHITE); // 
        btnEliminar.setBorder(BorderFactory.createLineBorder(new Color(139, 0, 0), 2)); 
        //Panel para los botones
        JPanel panelBotones = new JPanel(new GridLayout(2, 1, 10, 0));
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        
        jPanel3.add(panelBotones, BorderLayout.WEST); 
        jPanel3.add(panelTarjetas, BorderLayout.CENTER);

        
        jPanel3.revalidate();
        jPanel3.repaint();
    }

    
    private JPanel crearTarjetaIngrediente(IngredienteDTO ingrediente) {
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 120));
        panel.setBackground(new Color(255, 227, 242)); 
        panel.setLayout(new BorderLayout());

        // Panel central para el nombre
        JPanel panelNombre = new JPanel();
        panelNombre.setBackground(new Color(255, 192, 203)); 
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

        JButton btnMas = new JButton("+");
        btnMas.setFont(new Font("Arial", Font.BOLD, 14));
        btnMas.setBackground(new Color(60, 179, 113)); 
        btnMas.setForeground(Color.WHITE);
        btnMas.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 2)); 

        // Panel para botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 0)); // Espaciado entre botones
        panelBotones.add(btnMenos);
        panelBotones.add(btnMas);

        // Panel inferior 
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 700));
        setSize(new java.awt.Dimension(1064, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 254, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 700));

        jPanel2.setBackground(new java.awt.Color(255, 176, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(1070, 100));

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Ingredientes");

        lblRegresar.setText("Regresar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(469, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(lblTitulo))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 176, 217));
        jScrollPane1.setForeground(new java.awt.Color(255, 176, 217));

        jPanel3.setBackground(new java.awt.Color(255, 176, 217));
        jPanel3.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
