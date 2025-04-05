package GUIs;

import DTOs.IngredienteProductoDTO;
import DTOs.ProductoDetalleDTO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alici
 */
public class PantallaDetallesProducto extends javax.swing.JFrame {

    private ProductoDetalleDTO producto;

    /**
     * Creates new form DetallesProducto
     */
    public PantallaDetallesProducto(ProductoDetalleDTO producto) {
        this.producto = producto;
        initComponents();
        cargarBanner();
        cargarInformacionProducto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        banner = new plantillas.Titulo();
        jPanel2 = new javax.swing.JPanel();
        lblTituloNombreProducto = new javax.swing.JLabel();
        lblTituloCategoriaProducto = new javax.swing.JLabel();
        lblTituloPrecioProducto = new javax.swing.JLabel();
        lblCategoriaProducto = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblPrecioProducto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTituloIngredientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1064, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 254, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(201, 220, 249));

        lblTituloNombreProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTituloNombreProducto.setText("Nombre:");

        lblTituloCategoriaProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTituloCategoriaProducto.setText("Categoria:");

        lblTituloPrecioProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTituloPrecioProducto.setText("Precio:");

        lblCategoriaProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCategoriaProducto.setText("categoria...");

        lblNombreProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombreProducto.setText("nombre...");

        lblPrecioProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPrecioProducto.setText("$ precio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTituloNombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreProducto)
                .addGap(33, 33, 33)
                .addComponent(lblTituloCategoriaProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCategoriaProducto)
                .addGap(30, 30, 30)
                .addComponent(lblTituloPrecioProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPrecioProducto)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 330, 270));

        jPanel3.setBackground(new java.awt.Color(255, 227, 242));

        lblTituloIngredientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblTituloIngredientes.setText("Ingredientes necesarios");

        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ingrediente", "Unidad", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaIngredientes.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tablaIngredientes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTituloIngredientes)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 650, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cargarBanner() {
        banner.getLblTitulo().setText("Detalles del producto");
        banner.setFrmPadre(this);
        banner.setFrmTarget(new PantallaProductos());
    }

    private void cargarInformacionProducto() {
        lblNombreProducto.setText(producto.getNombre());
        lblCategoriaProducto.setText(producto.getTipo().toString().toLowerCase());
        lblPrecioProducto.setText("$ " + producto.getPrecio());

        DefaultTableModel modeloTablaIngredientes = (DefaultTableModel) tablaIngredientes.getModel();
        modeloTablaIngredientes.setRowCount(0); // limpia las filas actuales

        for (IngredienteProductoDTO ingrediente : producto.getIngredientes()) {
            modeloTablaIngredientes.addRow(new Object[]{
                ingrediente.getNombre(),
                ingrediente.getUnidadMedida().toString().toLowerCase(),
                ingrediente.getCantidad()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private plantillas.Titulo banner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoriaProducto;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecioProducto;
    private javax.swing.JLabel lblTituloCategoriaProducto;
    private javax.swing.JLabel lblTituloIngredientes;
    private javax.swing.JLabel lblTituloNombreProducto;
    private javax.swing.JLabel lblTituloPrecioProducto;
    private javax.swing.JTable tablaIngredientes;
    // End of variables declaration//GEN-END:variables
}
