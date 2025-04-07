/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package moduloBusquedaIngredientes;

import DTOs.IngredienteDTO;
import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import enumeradores.UnidadMedida;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author erika
 */
public class PanelBuscarIngrediente extends javax.swing.JPanel {
    private final CoordinadorAplicacion coordinador = new CoordinadorAplicacion();

    /**
     * Creates new form PanelBuscarIngrediente
     */
    public PanelBuscarIngrediente() {
        initComponents();
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
        @Override
            public void insertUpdate(DocumentEvent e) { realizarBusqueda(); }
            @Override
            public void removeUpdate(DocumentEvent e) { realizarBusqueda(); }
            @Override
            public void changedUpdate(DocumentEvent e) { realizarBusqueda(); }
        });

    cBoxUnidad.addActionListener(e -> realizarBusqueda());

        cargarIngredientes();
        String[] unidades = Arrays.stream(UnidadMedida.values())
                          .map(Enum::name)
                          .toArray(String[]::new);

        String[] unidadesConTodos = new String[unidades.length + 1];
        unidadesConTodos[0] = "Todos";
        System.arraycopy(unidades, 0, unidadesConTodos, 1, unidades.length);

        cBoxUnidad.setModel(new DefaultComboBoxModel<>(unidadesConTodos));
    }
    private void realizarBusqueda() {
    try {
        String texto = txtBusqueda.getText().trim();
        String tipoSeleccionado = cBoxUnidad.getSelectedItem().toString();

        List<IngredienteDTO> ingredientes;
        
        boolean buscarPorNombre = !texto.isEmpty();
        boolean buscarPorUnidad = !tipoSeleccionado.equalsIgnoreCase("Todos");
        if(texto.isEmpty()){
            UnidadMedida unidad = UnidadMedida.valueOf(tipoSeleccionado);
            ingredientes = coordinador.buscarIngredientePorUniad(tipoSeleccionado);
        }
        if (!buscarPorNombre && !buscarPorUnidad) {
            cargarIngredientes(); // Mostrar todo si no hay filtros
            return;
        }

        if (buscarPorNombre && buscarPorUnidad) {
            UnidadMedida unidad = UnidadMedida.valueOf(tipoSeleccionado);
            ingredientes = coordinador.buscarPorNombreYUnidad(texto, tipoSeleccionado);
        } else if (buscarPorNombre) {
            ingredientes = coordinador.buscarPorNombre(texto);
        } else {
            UnidadMedida unidad = UnidadMedida.valueOf(tipoSeleccionado);
            ingredientes = coordinador.buscarIngredientePorUniad(tipoSeleccionado);
        }

        mostrarIngredientesEnTabla(ingredientes);
        

    } catch (CoordinadorException ex) {
        JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, "Unidad de medida no válida.", "Error", JOptionPane.ERROR_MESSAGE);
    }


    }
    
    private void cargarIngredientes(){
        try {
            List<IngredienteDTO> ingredientes = coordinador.mostrarIngredientes();
            mostrarIngredientesEnTabla(ingredientes);
        } catch (CoordinadorException ex) {
            Logger.getLogger(PanelBuscarIngrediente.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    private void mostrarIngredientesEnTabla (List<IngredienteDTO> ingredientes){
         // Columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Unidad de Medida", "Stock"};

            // modelo de la tabla
            DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Las celdas no serán editables
            }
        };

        // Llenar tabla con ingredientes 
        for (IngredienteDTO ing : ingredientes) {
            Object[] fila = {
                ing.getId(),
                ing.getNombre(),
                ing.getUnidadMedida(),
                ing.getStock()
            };
            modelo.addRow(fila);
        }

        // Asignamos el modelo a la tabla de la interfaz
        tblIngredientes.setModel(modelo);

    } 

    public JTable getTblIngredientes() {
        return tblIngredientes;
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
        cBoxUnidad = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        lblBusqueda = new javax.swing.JLabel();
        SearchPanel = new javax.swing.JPanel();
        lblBusquedaIcono1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIngredientes = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 228, 242));

        jPanel1.setBackground(new java.awt.Color(255, 228, 242));
        jPanel1.setMaximumSize(new java.awt.Dimension(940, 70));
        jPanel1.setMinimumSize(new java.awt.Dimension(760, 70));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cBoxUnidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cBoxUnidad.setBorder(null);
        cBoxUnidad.setFocusable(false);
        cBoxUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxUnidadActionPerformed(evt);
            }
        });
        jPanel1.add(cBoxUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 180, 30));

        lblCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblCategoria.setText("Unidad de Medida");
        jPanel1.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        txtBusqueda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        txtBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 510, 30));

        lblBusqueda.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblBusqueda.setText("Búsqueda de Ingrediente");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        SearchPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblBusquedaIcono1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icono-busqueda.png"))); // NOI18N
        SearchPanel.add(lblBusquedaIcono1);

        jPanel1.add(SearchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 30, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 178, 217));

        tblIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblIngredientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxUnidadActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        realizarBusqueda();
    }//GEN-LAST:event_txtBusquedaKeyReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JComboBox<Object> cBoxUnidad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblBusquedaIcono1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JTable tblIngredientes;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
