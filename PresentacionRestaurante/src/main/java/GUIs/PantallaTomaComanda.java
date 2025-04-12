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
import modos.Modo;
import plantillas.PanelProductoComanda;

/**
 *Pantalla para regitrar los productos de una comanda
 * @author Alici
 */
public class PantallaTomaComanda extends javax.swing.JFrame {
    /**
     * Instancia del coordinador de la aplicacion para acceder a los metodos de negocio
     */
    CoordinadorAplicacion control = new CoordinadorAplicacion();

    private List<PanelProductoComanda> panelesProductoComanda = new ArrayList<>();
    private List<DetalleComandaDTO> productosComandaSeleccionados = new ArrayList<>();
    private List<DetalleComandaDTO> productosAgrupados = new ArrayList<>();
    private final Modo modo;
    private final ComandaDTO comanda;
    private final CoordinadorAplicacion coordinador = new CoordinadorAplicacion();
    /**
     * Metodo para configurar la pantallam modo tomar comanda o modificar
     * @param modo modo de la pantalla
     * @param comanda comanda a modificar o tomar
     */
    public PantallaTomaComanda(Modo modo, ComandaDTO comanda) {
        this.modo = modo;
        this.comanda = comanda;
        initComponents();
        cargarBanner();
        configurarBarraBusqueda();
        panelContenedorProductosComanda.setLayout(new BoxLayout(panelContenedorProductosComanda, BoxLayout.Y_AXIS));
        panelProductos.setListener(producto -> {
            agregarProducto(producto);
        });
        cargarProductosMenu();
        if (modo == Modo.MODIFICAR) {
            configurarModoActualizar();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAccion = new javax.swing.JButton();
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

        btnAccion.setBackground(new java.awt.Color(164, 199, 255));
        btnAccion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnAccion.setForeground(new java.awt.Color(255, 255, 255));
        btnAccion.setText("Mandar pedido");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });
        jPanel2.add(btnAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 310, 80));

        lblTotalTitulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalTitulo.setText("Total");
        jPanel2.add(lblTotalTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        lblTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
        jPanel1.add(lblClienteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 340, 30));

        lblNumeroMesa.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblNumeroMesa.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroMesa.setText("num mesa");
        jPanel1.add(lblNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 50, -1));

        lblClienteTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblClienteTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblClienteTitulo.setText("Cliente:");
        jPanel1.add(lblClienteTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));
        jPanel1.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(panelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        panelBusquedaProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(panelBusquedaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Actualiza el estado de la mesa 
     * @param evt 
     */
    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        generarDetallesComanda();
        try {
            coordinador.actualizarEstadoMesa(Long.valueOf(comanda.getNumeroMesa()), false);
        } catch (CoordinadorException ex) {
        }
    }//GEN-LAST:event_btnAccionActionPerformed
    /**
     * Muestra los productos del menu
     */
    private void cargarProductosMenu() {
        try {
            panelProductos.mostrarProductos(control.obtenerProductos());
        } catch (CoordinadorException ex) {
            Logger.getLogger(PantallaTomaComanda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Ha ocurrido un error inesperado", JOptionPane.ERROR);
        }
    }
    /**
     * Agrega producto a la comanda
     * @param producto producto a agregar
     */
    private void agregarProducto(ProductoDTO producto) {
        PanelProductoComanda panelProductoComanda = new PanelProductoComanda(producto);
        panelContenedorProductosComanda.add(panelProductoComanda);
        panelesProductoComanda.add(panelProductoComanda);
        agregarListener(panelProductoComanda);
        panelContenedorProductosComanda.revalidate();
        panelContenedorProductosComanda.repaint();
        actualizarTotal();
    }
    /**
     * Listener para la pantalla
     * @param panelProductoComanda  
     */
    private void agregarListener(PanelProductoComanda panelProductoComanda) {
        panelProductoComanda.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto(panelProductoComanda);
            }
        });
    }
    /**
     * Metodo para calcular el total de la venta con la sumatoria de el precio de los productos
     * @return  precio total de la venta
     */
    private double calcularTotalVenta() {
        return productosAgrupados.stream()
                .mapToDouble(DetalleComandaDTO::getImporteTotal)
                .sum();
    }
    /**
     * Metodo para configurar el modo de vista de la pantalla cuando es modo actualizar una comanda existente
     */
    private void configurarModoActualizar() {
        btnAccion.setText("Actualizar pedido");
        cargarProductosComanda();
        actualizarTotal();
    }
    /**
     * Muestra los productos que ya tiene una comanda
     */
    private void cargarProductosComanda() {
        if (comanda.getDetallesComanda() != null) {
            for (DetalleComandaDTO detalle : comanda.getDetallesComanda()) {
                for (int i = 0; i < detalle.getCantidad(); i++) {
                    ProductoDTO producto = obtenerProductoPorNombre(detalle.getNombreProducto());
                    if (producto != null) {
                        PanelProductoComanda panel = new PanelProductoComanda(producto);
                        panel.getTxtAreaComentario().setText(detalle.getNotas());
                        panelesProductoComanda.add(panel);
                        panelContenedorProductosComanda.add(panel);
                        agregarListener(panel);
                    }
                }
            }
            panelContenedorProductosComanda.revalidate();
            panelContenedorProductosComanda.repaint();
        }
    }
    /**
     * Obtiene los productos por nombre
     * @param nombre nombre del producto a buscar
     * @return producto dto encontrado
     */
    private ProductoDTO obtenerProductoPorNombre(String nombre) {
        try {
            return control.obtenerProductoPorNombre(nombre);
        } catch (CoordinadorException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar producto", "Error inesperado", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    /**
     * Metodo para elimianar un producto de la comanda
     * @param panelProductoComanda 
     */
    private void eliminarProducto(PanelProductoComanda panelProductoComanda) {
        panelContenedorProductosComanda.remove(panelProductoComanda);
        panelesProductoComanda.remove(panelProductoComanda);
        panelContenedorProductosComanda.revalidate();
        panelContenedorProductosComanda.repaint();
        actualizarTotal();
    }
    /**
     * Configuracion para la barra de busqueda
     */
    private void configurarBarraBusqueda() {
        panelBusquedaProducto.setVista(panelProductos);
        panelBusquedaProducto.setBackground(new Color(255, 176, 217));
    }
    /**
     * Carga el banner con los datos del cliente y mesa
     */
    private void cargarBanner() {
        banner.getLblTitulo().setText("Mesa:");
        banner.setFrmPadre(this);
        banner.setFrmTarget(new MenuPrincipal());
        lblClienteNombre.setText(comanda.getNombreCliente() != null ? comanda.getNombreCliente() : "");
        lblNumeroMesa.setText(comanda.getNumeroMesa());
        System.out.println(comanda.getIdCliente());
    }
    /**
     * Metodo para guardar el producto en la comanda
     */
    private void mandarComanda() {
        for (PanelProductoComanda panelProductoComanda : panelesProductoComanda) {
            DetalleComandaDTO detalleComanda = new DetalleComandaDTO();
            ProductoDTO producto = panelProductoComanda.getProducto();
            detalleComanda.setNombreProducto(producto.getNombre());
            detalleComanda.setNotas(panelProductoComanda.getTxtAreaComentario().getText());
            productosComandaSeleccionados.add(detalleComanda);
        }
    }
    /**
     * Metodo para actualizar el total de la venta
     */
    private void actualizarTotal() {
        double total = 0.0;
        for (PanelProductoComanda panel : panelesProductoComanda) {
            total += panel.getProducto().getPrecio();
        }
        lblTotal.setText(String.format("$ %.2f", total));
    }
    /**
     * Metodo para generar los detalles de la comanda 
     */
    private void generarDetallesComanda() {
        if (panelesProductoComanda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione al menos un producto para la comanda", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (PanelProductoComanda panelProductoComanda : panelesProductoComanda) {
            DetalleComandaDTO detalle = new DetalleComandaDTO();
            ProductoDTO producto = panelProductoComanda.getProducto();
            detalle.setNombreProducto(producto.getNombre());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setNotas(panelProductoComanda.getTxtAreaComentario().getText());
            detalle.setCantidad(1); // Ya que cada producto agregado representa 1 unidad
            detalle.setImporteTotal(producto.getPrecio()); // precio * cantidad

            productosComandaSeleccionados.add(detalle);
        }

        agruparDetalles(); // agrupamos productos repetidos
        generarComanda();
    }
    /**
     * Metodo para agrupar los detalles de los diferentes productos
     */
    private void agruparDetalles() {
        for (DetalleComandaDTO detalle : productosComandaSeleccionados) {
            DetalleComandaDTO existente = productosAgrupados.stream()
                    .filter(d -> d.getNombreProducto().equals(detalle.getNombreProducto())
                    && d.getNotas().equals(detalle.getNotas())) // solo agrupamos si nombre y nota coinciden
                    .findFirst()
                    .orElse(null);

            if (existente != null) {
                existente.setCantidad(existente.getCantidad() + 1);
                existente.setImporteTotal(existente.getImporteTotal() + detalle.getPrecioUnitario());
            } else {
                productosAgrupados.add(detalle);
            }
        }
    }
    /**
     * Obtiene todos los detalles de la comanda y la guarda en la base de datos
     */
    private void generarComanda() {
        double totalVenta = calcularTotalVenta();

        ComandaDTO comandaMandar;

        if (modo == Modo.AGREGAR) {
            comandaMandar = comanda;
            comandaMandar.setFechaHora(Calendar.getInstance());
            comandaMandar.setEstado(Estado.ACTIVA);
        } else {
            comandaMandar = comanda;
        }
        comandaMandar.setDetallesComanda(productosAgrupados);
        comandaMandar.setTotalVenta(totalVenta);

        try {
            if (modo == Modo.AGREGAR) {
                control.agregarComanda(comandaMandar);
                JOptionPane.showMessageDialog(this, "Comanda creada exitosamente");
            } else {
                control.actualizarComanda(comandaMandar);
                JOptionPane.showMessageDialog(this, "Comanda modificada exitosamente");
            }
            control.PantallaComandas(this);
        } catch (CoordinadorException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private plantillas.Titulo banner;
    private javax.swing.JButton btnAccion;
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
