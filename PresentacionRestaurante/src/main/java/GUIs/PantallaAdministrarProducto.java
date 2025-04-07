package GUIs;

import DTOs.IngredienteProductoDTO;
import DTOs.ProductoDetalleDTO;
import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import enumeradores.TipoProducto;
import enumeradores.UnidadMedida;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modos.Modo;
import moduloBusquedaIngredientes.PanelBuscarIngrediente;

import plantillas.PanelIngredienteProducto;

/**
 * Clase que representa una pantalla de interfaz gráfica para administrar
 * productos, permitiendo agregar nuevos productos o modificar existentes.
 *
 * @author Alicia Denise Garcia Acosta
 */
public class PantallaAdministrarProducto extends javax.swing.JFrame {

    /**
     * Modo en el que se va a utilizar la pantalla (AGREGAR o MODIFICAR).
     */
    private final Modo modo;
    /**
     * CoordinadorAplicacion para la comunicación con capa de negocio y flujo de
     * pantallas.
     */
    private final CoordinadorAplicacion control = new CoordinadorAplicacion();
    /**
     * Lista de paneles que muestran los ingredientes agregados al producto.
     */
    List<PanelIngredienteProducto> ingredientesPanelLateral;
    /**
     * Producto que se esta editando, puede ser null si el producto es nuevo.
     */
    private final ProductoDetalleDTO producto;

    /**
     * Constructor que inicializa la pantalla con el modo deseado.
     *
     * @param modo Modo de operación de la pantalla (AGREGAR o MODIFICAR0.)
     * @param producto Producto a modificar, null en caso de ser modo AGREGAR
     */
    public PantallaAdministrarProducto(Modo modo, ProductoDetalleDTO producto) {
        ingredientesPanelLateral = new ArrayList<>();
        this.modo = modo;
        this.producto = producto;
        initComponents();
        configurarBanner();
        cargarCategorias();
        btnAccion.setEnabled(false);
        panelContenedorIngredientesProducto.setLayout(new BoxLayout(panelContenedorIngredientesProducto, BoxLayout.Y_AXIS));
        agregarListeners();
        if (modo == Modo.MODIFICAR) {
            configurarModoModificar();
        }
        configurarTablaIngredientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlResumenProducto = new javax.swing.JPanel();
        lblNombreTituloResumen = new javax.swing.JLabel();
        lblCategoriaTituloResumen = new javax.swing.JLabel();
        lblPrecioTituloResumen = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblResumenProducto = new javax.swing.JLabel();
        btnAccion = new javax.swing.JButton();
        lblIngredientesNecesario = new javax.swing.JLabel();
        scrollPanelIngredientes = new javax.swing.JScrollPane();
        panelContenedorIngredientesProducto = new javax.swing.JPanel();
        banner = new plantillas.Titulo();
        txtNombre = new javax.swing.JTextField();
        cBoxCategoria = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JSpinner();
        lblProductoNombreTitulo = new javax.swing.JLabel();
        lblDisponibilidadNombre = new javax.swing.JLabel();
        lblCategoriaTitulo = new javax.swing.JLabel();
        lblPrecioTitulo = new javax.swing.JLabel();
        panelContenedorIngredientes = new javax.swing.JPanel();

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

        lblNombreTituloResumen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombreTituloResumen.setText("Nombre:");
        pnlResumenProducto.add(lblNombreTituloResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lblCategoriaTituloResumen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCategoriaTituloResumen.setText("Categoria:");
        pnlResumenProducto.add(lblCategoriaTituloResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblPrecioTituloResumen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPrecioTituloResumen.setText("Precio: ");
        pnlResumenProducto.add(lblPrecioTituloResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pnlResumenProducto.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 180, -1));

        lblCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pnlResumenProducto.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 170, -1));

        lblPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pnlResumenProducto.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 190, -1));

        lblResumenProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblResumenProducto.setText("Resumen del producto");
        pnlResumenProducto.add(lblResumenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));

        jPanel1.add(pnlResumenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 130));

        btnAccion.setBackground(new java.awt.Color(255, 119, 170));
        btnAccion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnAccion.setForeground(new java.awt.Color(255, 255, 255));
        btnAccion.setText("Agregar producto");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });
        jPanel1.add(btnAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 310, 70));

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

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 480, 30));

        cBoxCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fondo.add(cBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 140, 30));

        txtPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.01d));
        fondo.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 80, 30));

        lblProductoNombreTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblProductoNombreTitulo.setText("Nombre del producto");
        fondo.add(lblProductoNombreTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lblDisponibilidadNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fondo.add(lblDisponibilidadNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 180, 20));

        lblCategoriaTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCategoriaTitulo.setText("Categoría");
        fondo.add(lblCategoriaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));

        lblPrecioTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPrecioTitulo.setText("Precio");
        fondo.add(lblPrecioTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, -1));

        panelContenedorIngredientes.setBackground(new java.awt.Color(255, 228, 242));
        fondo.add(panelContenedorIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 750, 520));

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        mandarProducto();
    }//GEN-LAST:event_btnAccionActionPerformed

    /**
     * Método que configura la pantalla cuando se inicia en modo MODIFICAR.
     * Carga los datos del producto a modificar.
     */
    private void configurarModoModificar() {
        btnAccion.setText("Actualizar producto");
        txtNombre.setEnabled(false);
        cBoxCategoria.setEnabled(false);
        cargarDatosProducto();
        cargarIngredientesProducto();
        cargarResumen();
    }

    /**
     * Método que configura el panel que contiene el buscador de ingredientes y
     * la tabla para seleccionar el ingrediente.
     */
    private void configurarTablaIngredientes() {
        PanelBuscarIngrediente panelBuscarIngrediente = new PanelBuscarIngrediente();
        panelContenedorIngredientes.add(panelBuscarIngrediente);
        JTable tablaIngredientes = panelBuscarIngrediente.getTblIngredientes();
        ListSelectionModel seleccion = tablaIngredientes.getSelectionModel();
        seleccion.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tablaIngredientes.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        agregarIngrediente(new IngredienteProductoDTO(
                                (String) tablaIngredientes.getValueAt(filaSeleccionada, 1),
                                (UnidadMedida) tablaIngredientes.getValueAt(filaSeleccionada, 2),
                                1));
                    }
                }
            }
        });
    }

    /**
     * Método que carga los datos del producto en los campos para ingresar
     * información. Se utiliza para el modo MODIFICAR.
     */
    private void cargarDatosProducto() {
        txtNombre.setText(producto.getNombre());
        cBoxCategoria.setSelectedItem(producto.getTipo());
        txtPrecio.setValue(producto.getPrecio());
    }

    /**
     * Método que carga los ingredientes del producto en la barra lateral,
     * cuando se esta en el modo MODIFICAR.
     */
    private void cargarIngredientesProducto() {
        for (IngredienteProductoDTO ingrediente : producto.getIngredientes()) {
            agregarIngrediente(ingrediente);
        }
    }

    /**
     * Método que agrega el ingrediente dado a la barra lateral de ingredientes.
     *
     * @param ingrediente
     */
    private void agregarIngrediente(IngredienteProductoDTO ingrediente) {
        // Buscar si el ingrediente ya está en la barra lateral
        for (PanelIngredienteProducto panelIngredienteProducto : ingredientesPanelLateral) {
            if (panelIngredienteProducto.getIngrediente().equals(ingrediente)) {
                // si ya está, incrementar el valor del spinner de cantidad en 1
                JSpinner cantidadIngredienteSpinner = panelIngredienteProducto.getTxtCantidad();
                int cantidadActual = (int) cantidadIngredienteSpinner.getValue();
                cantidadIngredienteSpinner.setValue(cantidadActual + 1);
                return; //salir del método
            }
        }
        // si no se encontró, creaun un nuevo panel con el producto para agregarlo a la barra lateral
        PanelIngredienteProducto panelIngrediente = new PanelIngredienteProducto(ingrediente);
        panelContenedorIngredientesProducto.add(panelIngrediente);
        ingredientesPanelLateral.add(panelIngrediente);
        panelContenedorIngredientesProducto.revalidate();
        panelContenedorIngredientesProducto.repaint();
        agregarListenerCantidadIngrediente(panelIngrediente);
    }

    /**
     * Método que agrega un listener al PanelIngredienteProducto que contiene el
     * ingrediente. Este listener remueve el panel de la barra lateral cuando la
     * cantidad del ingrediente es menor o igual a 0.
     *
     * @param panelIngrediente
     */
    private void agregarListenerCantidadIngrediente(PanelIngredienteProducto panelIngrediente) {
        panelIngrediente.getTxtCantidad().addChangeListener(e -> {
            if ((Integer) panelIngrediente.getTxtCantidad().getValue() <= 0) {
                panelContenedorIngredientesProducto.remove(panelIngrediente);
                ingredientesPanelLateral.remove(panelIngrediente);
                panelContenedorIngredientesProducto.revalidate();
                panelContenedorIngredientesProducto.repaint();
            }
        });
    }

    /**
     * Método que carga las categorias de producto en el combo box.
     */
    private void cargarCategorias() {
        cBoxCategoria.addItem("Categoria");
        for (TipoProducto categoria : TipoProducto.values()) {
            cBoxCategoria.addItem(categoria);
        }
    }

    /**
     * Método que agrega los listeners para el campo de ingresar nombre del
     * producto, combo box de categoria y spinner de precio. Cada que los campos
     * se actualizan o cambian su valor se manda a comprobar si puede escribirse
     * el resumen del producto.
     */
    private void agregarListeners() {
        if (modo == Modo.AGREGAR) {
            txtNombre.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    cambiarMensajeValidezNombre();
                    cargarResumen();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    cambiarMensajeValidezNombre();
                    cargarResumen();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    cambiarMensajeValidezNombre();
                    cargarResumen();
                }
            });
            cBoxCategoria.addActionListener(e -> {
                cargarResumen();
            });
        }
        txtPrecio.addChangeListener(e -> {
            cargarResumen();
        });
    }

    /**
     * Método que comprueba si los campos estan llenos y tienen información
     * correcta. Cuando los datos son correctos escribe el resumen del producto.
     */
    private void cargarResumen() {
        boolean lleno;
        if (modo == Modo.AGREGAR) {
            lleno = (validarNombre()
                    && cBoxCategoria.getSelectedIndex() != 0
                    && validarPrecio());
        } else {
            lleno = (!txtNombre.getText().isBlank()
                    && cBoxCategoria.getSelectedIndex() != 0
                    && validarPrecio());
        }
        btnAccion.setEnabled(lleno);

        if (lleno) {
            lblNombre.setText(txtNombre.getText());

            String categoria = cBoxCategoria.getSelectedItem().toString();
            lblCategoria.setText(categoria.substring(0, 1).toUpperCase() + categoria.substring(1).toLowerCase());

            double precio = ((Double) txtPrecio.getValue());
            lblPrecio.setText(String.format("$ %.2f", precio));

            pnlResumenProducto.repaint();
        } else {
            lblNombre.setText("");
            lblCategoria.setText("");
            lblPrecio.setText("");
        }
    }

    /**
     * Método que valida si el nombre ingresado no se encuentra ya registrado en
     * la base de datos.
     *
     * @return true si el nombre es valido, false en caso contrario.
     */
    private boolean validarNombre() {
        boolean validez = false;
        try {
            validez = control.validarNombreProducto(txtNombre.getText());
        } catch (CoordinadorException ex) {
            Logger.getLogger(PantallaAdministrarProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
        }
        return validez;
    }

    /**
     * Método que comprueba que el precio ingresado sea válido.
     *
     * @return true si el precio es un decimal (double) mayor a 0, false en caso
     * contrario.
     */
    private boolean validarPrecio() {
        try {
            double precio = ((double) txtPrecio.getValue());
            return (precio > 0);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Método que se encarga de cambiar el mensaje que indica si el nombre es
     * válido o inválido. Comprueba la validez del nombre utilizando el método
     * de que valida el nombre.
     */
    private void cambiarMensajeValidezNombre() {
        if (validarNombre()) {
            lblDisponibilidadNombre.setForeground(new Color(26, 164, 33));
            lblDisponibilidadNombre.setText("Nombre disponible");
        } else {
            lblDisponibilidadNombre.setForeground(Color.red);
            lblDisponibilidadNombre.setText("Nombre no disponible");
        }
        fondo.repaint();
    }

    /**
     * Método que configura el titulo del panel superior de la pantalla y
     * establece los frames destino y padre para la navegación del botón para
     * regresar.
     */
    private void configurarBanner() {
        String titulo;
        if (modo == Modo.AGREGAR) {
            titulo = "Agregar producto";
        } else {
            titulo = "Modificar producto";
        }
        banner.getLblTitulo().setText(titulo);
        banner.setFrmPadre(this);
        banner.setFrmTarget(new PantallaProductos());
    }

    /**
     * Método que se encarga de mandar a guardar el producto a actualizar o
     * agregar e informar si el producto fue posible de procesar.
     */
    private void mandarProducto() {
        if (ingredientesPanelLateral.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione al menos un ingrediente para el producto", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ProductoDetalleDTO producto = generarProducto();
            try {
                if (modo == Modo.AGREGAR) {
                    if (control.agregarProducto(producto)) {
                        JOptionPane.showMessageDialog(null, "Producto agregado con éxito", "", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No ha sido posible agregar el producto", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    if (control.actualizarProducto(producto)) {
                        JOptionPane.showMessageDialog(null, "Producto actualizado con éxito", "", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No ha sido posible actualizar el producto", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                control.pantallaProductos(this);
            } catch (CoordinadorException ex) {
                Logger.getLogger(PantallaAdministrarProducto.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método que toma los valores de los campos para crear un
     * IngredieneProductoDTO, para obtener los ingredientes se recorre la lista
     * de paneles laterales, los cuales devuelven el IngredienteProductoDTO que
     * contienen.
     *
     * @return ProductoDetalleDTO que guarda los datos del producto y sus
     * ingredientes con cantidades.
     */
    private ProductoDetalleDTO generarProducto() {
        List<IngredienteProductoDTO> ingredientesProducto = new ArrayList<>();
        for (PanelIngredienteProducto panelIngrediente : ingredientesPanelLateral) {
            ingredientesProducto.add(panelIngrediente.getIngrediente());
        }
        return new ProductoDetalleDTO(
                lblNombre.getText(),
                (TipoProducto) cBoxCategoria.getSelectedItem(),
                (double) txtPrecio.getValue(),
                ingredientesProducto);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private plantillas.Titulo banner;
    private javax.swing.JButton btnAccion;
    private javax.swing.JComboBox<Object> cBoxCategoria;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCategoriaTitulo;
    private javax.swing.JLabel lblCategoriaTituloResumen;
    private javax.swing.JLabel lblDisponibilidadNombre;
    private javax.swing.JLabel lblIngredientesNecesario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreTituloResumen;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecioTitulo;
    private javax.swing.JLabel lblPrecioTituloResumen;
    private javax.swing.JLabel lblProductoNombreTitulo;
    private javax.swing.JLabel lblResumenProducto;
    private javax.swing.JPanel panelContenedorIngredientes;
    private javax.swing.JPanel panelContenedorIngredientesProducto;
    private javax.swing.JPanel pnlResumenProducto;
    private javax.swing.JScrollPane scrollPanelIngredientes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JSpinner txtPrecio;
    // End of variables declaration//GEN-END:variables
}
