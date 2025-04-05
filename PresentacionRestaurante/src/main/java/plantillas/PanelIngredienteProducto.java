package plantillas;

import DTOs.IngredienteProductoDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

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
     * Contador de cantidad del ingrediente
     */
    private int cantidad = 0;
    /**
     * Timer para aumentar el contador de cantidad
     */
    private final Timer timerAumentar;
    /**
     * Timer para disminuir el contador de cantidad
     */
    private final Timer timerDisminuir;

    /**
     * Creates new form PanelIngredienteProducto
     *
     * @param ingrediente
     */
    public PanelIngredienteProducto(IngredienteProductoDTO ingrediente) {
        this.ingrediente = ingrediente;
        initComponents();
        cargarIngrediente();
        timerAumentar = new Timer(100, e -> {
            agregarCantidad();
        });
        timerDisminuir = new Timer(100, e -> {
            disminuirCantidad();
        });
        agregarListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreIngrediente = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblUnidadMedida = new javax.swing.JLabel();
        lblCantidadTitulo = new javax.swing.JLabel();
        btnMas = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 228, 242));
        setPreferredSize(new java.awt.Dimension(280, 109));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreIngrediente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombreIngrediente.setText("nombre...");
        add(lblNombreIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, -1));

        lblCantidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCantidad.setText("cantidad...");
        add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 60, -1));

        lblUnidadMedida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUnidadMedida.setText("unidad...");
        add(lblUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        lblCantidadTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCantidadTitulo.setText("Cantidad:");
        add(lblCantidadTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 60, -1));

        btnMas.setBackground(new java.awt.Color(172, 204, 255));
        btnMas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnMas.setText("+");
        btnMas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 60, -1));

        btnMenos.setBackground(new java.awt.Color(172, 204, 255));
        btnMenos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnMenos.setText("—");
        btnMenos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 60, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 280, 10));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que agrega los Listeners para los botones de aumentar y disminuir,
     * escuchan cuando se clickea el boton y cuando se mantiene presionado.
     *
     */
    private void agregarListeners() {
        btnMas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerAumentar.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timerAumentar.stop();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!timerAumentar.isRunning()) {
                    agregarCantidad();
                }
            }
        });

        btnMenos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerDisminuir.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timerDisminuir.stop();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!timerDisminuir.isRunning()) {
                    disminuirCantidad();
                }
            }
        });
    }

    /**
     * Método que carga los datos del ingrediente en el panel
     */
    private void cargarIngrediente() {
        lblNombreIngrediente.setText("<html><center>" + ingrediente.getNombre() + "</center></html>");
        lblUnidadMedida.setText(ingrediente.getUnidadMedida().name().toLowerCase());
        lblCantidad.setText(String.valueOf(cantidad));
    }

    /**
     * Método que aumenta el contador de cantidad y actualiza el valor mostrado
     * en el panel.
     */
    private void agregarCantidad() {
        cantidad++;
        lblCantidad.setText(String.valueOf(cantidad));
        this.repaint();
    }

    /**
     * Método que disminuye el contador de cantidad y actualiza el valor
     * mostrado en el panel.
     */
    private void disminuirCantidad() {
        if (cantidad > 0) {
            cantidad--;
            lblCantidad.setText(String.valueOf(cantidad));
            this.repaint();
        }
    }

    /**
     * Método que devuelve la información del ingrediente que se encuentra en el
     * panel.
     *
     * @return IngredienteProductoDTO con su cantidad actualizada;
     */
    public IngredienteProductoDTO getIngrediente() {
        ingrediente.setCantidad(Integer.parseInt(lblCantidad.getText()));
        return ingrediente;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnMenos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCantidadTitulo;
    private javax.swing.JLabel lblNombreIngrediente;
    private javax.swing.JLabel lblUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
