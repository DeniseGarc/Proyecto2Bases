package plantillas;

import DTOs.IngredienteProductoDTO;
import javax.swing.JSpinner;

/**
 * Panel que muestra los datos de un ingrediente que forma parte de un producto.
 * Se utiliza para mostrar el ingrediente en la barra lateral al modificar o
 * agregar un producto.
 *
 * @author Alicia Denise García Acosta 00000252402
 */
public class PanelIngredienteProducto extends javax.swing.JPanel {

    /**
     * Datos del producto a cargar
     */
    private final IngredienteProductoDTO ingrediente;

    /**
     * Constructor que inicializa los componentes del panel y carga los datos
     * del ingrediente ingresado.
     *
     * @param ingrediente ingrediente del cual se van a cargar sus datos en el
     * panel.
     */
    public PanelIngredienteProducto(IngredienteProductoDTO ingrediente) {
        this.ingrediente = ingrediente;
        initComponents();
        cargarIngrediente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreIngrediente = new javax.swing.JLabel();
        lblUnidadMedida = new javax.swing.JLabel();
        lblCantidadTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtCantidad = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(255, 228, 242));
        setMaximumSize(new java.awt.Dimension(280, 109));
        setMinimumSize(new java.awt.Dimension(280, 109));
        setPreferredSize(new java.awt.Dimension(280, 109));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreIngrediente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombreIngrediente.setText("nombre...");
        add(lblNombreIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 20));

        lblUnidadMedida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUnidadMedida.setText("unidad...");
        add(lblUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        lblCantidadTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCantidadTitulo.setText("Cantidad:");
        add(lblCantidadTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, 20));

        jSeparator1.setBackground(new java.awt.Color(207, 106, 158));
        jSeparator1.setForeground(new java.awt.Color(207, 106, 158));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 280, 10));

        txtCantidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        txtCantidad.setBorder(null);
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 90, 30));
    }// </editor-fold>//GEN-END:initComponents
/**
     * Método que carga los datos del ingrediente en el panel
     */
    private void cargarIngrediente() {
        lblNombreIngrediente.setText("<html><center>" + ingrediente.getNombre() + "</center></html>");
        lblUnidadMedida.setText(ingrediente.getUnidadMedida().name().toLowerCase());
        txtCantidad.setValue(ingrediente.getCantidad());
    }

    /**
     * Método que devuelve la información del ingrediente que se encuentra en el
     * panel.
     *
     * @return IngredienteProductoDTO con su cantidad actualizada;
     */
    public IngredienteProductoDTO getIngrediente() {
        ingrediente.setCantidad((Integer) txtCantidad.getValue());
        return ingrediente;
    }

    /**
     * Método que devuelve el JSpinner el cual contiene la cantidad del
     * ingrediente necesaria para el producto.
     *
     * @return JSpinner el cual sirve para ingresar la cantidad de ingrediente
     * necesaria.
     */
    public JSpinner getTxtCantidad() {
        return txtCantidad;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCantidadTitulo;
    private javax.swing.JLabel lblNombreIngrediente;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JSpinner txtCantidad;
    // End of variables declaration//GEN-END:variables
}
