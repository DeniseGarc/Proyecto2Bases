/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package moduloProductos;

import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import enumeradores.TipoProducto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Alici
 */
public class PanelBusquedaProducto extends javax.swing.JPanel {

    private CoordinadorAplicacion control = new CoordinadorAplicacion();
    private VistaProductos vista;

    public PanelBusquedaProducto(VistaProductos vista) {
        this.vista = vista;
        initComponents();
        cargarCategorias();
        cargarListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cBoxTipo = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        lblBusqueda = new javax.swing.JLabel();
        SearchPanel = new javax.swing.JPanel();
        lblBusquedaIcono1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(940, 70));
        setMinimumSize(new java.awt.Dimension(760, 70));
        setPreferredSize(new java.awt.Dimension(1070, 100));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cBoxTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cBoxTipo.setBorder(null);
        cBoxTipo.setFocusable(false);
        add(cBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 180, 30));

        lblCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblCategoria.setText("Categoria");
        add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        txtBusqueda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBusqueda.setBorder(null);
        txtBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 510, 30));

        lblBusqueda.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblBusqueda.setText("Búsqueda de producto");
        add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        SearchPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblBusquedaIcono1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icono-busqueda.png"))); // NOI18N
        SearchPanel.add(lblBusquedaIcono1);

        add(SearchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 30, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void cargarCategorias() {
        cBoxTipo.addItem("Seleccione una categoria");
        for (TipoProducto categoria : TipoProducto.values()) {
            cBoxTipo.addItem(categoria);
        }
    }

    private void cargarListeners() {
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                buscar();
            }
        });
        cBoxTipo.addActionListener(e -> {
            buscar();
        });
    }

    private void buscar() {
        try {
            if (txtBusqueda.getText().isBlank() && cBoxTipo.getSelectedIndex() == 0) {
                // obtener todos los productos
                vista.mostrarProductos(control.obtenerProductos());
            } else if (txtBusqueda.getText().isBlank() && cBoxTipo.getSelectedIndex() != 0) {
                // obtener todos los productos del tipo
                vista.mostrarProductos(control.obtenerProductosFiltrados(null, (TipoProducto) cBoxTipo.getSelectedItem()));
            } else if (!txtBusqueda.getText().isBlank() && cBoxTipo.getSelectedIndex() != 0) {
                //obtener productos que tengan tipo y nombre
                vista.mostrarProductos(control.obtenerProductosFiltrados(txtBusqueda.getText(), (TipoProducto) cBoxTipo.getSelectedItem()));
            } else if (!txtBusqueda.getText().isBlank() && cBoxTipo.getSelectedIndex() == 0) {
                // obtener los productos por nombre
                vista.mostrarProductos(control.obtenerProductosFiltrados(txtBusqueda.getText(), null));
            }
        } catch (CoordinadorException ex) {
            Logger.getLogger(PanelBusquedaProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Ha ocurrido un error inesperado", JOptionPane.ERROR);
        }
    }

    public JPanel getSearchPanel() {
        return SearchPanel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JComboBox<Object> cBoxTipo;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblBusquedaIcono1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
