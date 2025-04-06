package moduloBusquedaProductos;

import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import enumeradores.TipoProducto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Método que representa el panel de búsqueda de producto. Permite realizar
 * búsquedas dinámicas filtrando por nombre y categoría e indica a la vista que
 * datos debe mostrar.
 *
 * @author Alicia Denise García Acosta 00000252402
 */
public class PanelBusquedaProducto extends javax.swing.JPanel {

    /**
     * CoordinadorAplicacion para la comunicación con capa de negocio y flujo de
     * pantallas.
     */
    private CoordinadorAplicacion control = new CoordinadorAplicacion();
    /**
     * Clase que implementa VistaProductos, la cual implementa la manera en que
     * se van a mostrar los productos.
     */
    private VistaProductos vista;

    /**
     * Constructor que inicializa los componentes del panel, carga las
     * categorias en el comboBox y carga los listeners para los eventos de
     * búsqueda.
     */
    public PanelBusquedaProducto() {
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
        txtBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
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

    /**
     * Establece la vista asociada a este panel para mostrar los productos
     * resultantes de las búsquedas.
     *
     * @param vista Instancia de VistaProducto que mostrará los productos.
     */
    public void setVista(VistaProductos vista) {
        this.vista = vista;
    }

    /**
     * Carga las categoría disponibles desde el enumerador TipoProducto en el
     * JComboBox. Se incluye una opción inicial que indica que seleccione
     * cualquier categoría.
     */
    private void cargarCategorias() {
        cBoxTipo.addItem("Seleccione una categoria");
        for (TipoProducto categoria : TipoProducto.values()) {
            cBoxTipo.addItem(categoria);
        }
    }

    /**
     * Configura los listeners para el campo de texto y el combo box. Realiza
     * una búsqueda automática cada vez que se modifica el texto o se cambia la
     * categoría seleccionada.
     */
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

    /**
     * Ejecuta la búsqueda de productos según los criterios actuales. Actualiza
     * la vista con los resultados obtenidos del coordinados.
     */
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

    /**
     * Obtiene el combo box de categorías.
     *
     * @return JComboBox con las categorías disponibles.
     */
    public JComboBox<Object> getcBoxTipo() {
        return cBoxTipo;
    }

    /**
     * Obtiene el campo de texto para búsqueda.
     *
     * @return JTextField donde se ingresa el texto de búsqueda.
     */
    public JTextField getTxtBusqueda() {
        return txtBusqueda;
    }

    /**
     * Establece el combo box de categorías.
     *
     * @param cBoxTipo Nuevo JComboBox con categorías.
     */
    public void setcBoxTipo(JComboBox<Object> cBoxTipo) {
        this.cBoxTipo = cBoxTipo;
    }

    /**
     * Establece el campo de texto para búsqueda.
     *
     * @param txtBusqueda Nuevo JTextField para búsqueda.
     */
    public void setTxtBusqueda(JTextField txtBusqueda) {
        this.txtBusqueda = txtBusqueda;
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
