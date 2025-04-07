package moduloBusquedaProductos;

import DTOs.ProductoDTO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Panel que implementa la interfaz VistaProductos. Este panel se encarga de
 * mostrar una lista de productos en una tabla.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public class PanelVistaListaProductos extends javax.swing.JPanel implements VistaProductos {

    /**
     * Se crea el panel y se inicializan sus elementos
     */
    public PanelVistaListaProductos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        tblProductos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "Precio", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setGridColor(new java.awt.Color(0, 0, 0));
        tblProductos.setShowGrid(true);
        tblProductos.getTableHeader().setResizingAllowed(false);
        tblProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables

    /**
     * Método que muestra una lista de productos en la tabla.
     *
     * @param productos Lista de productos a mostrar.
     */
    @Override
    public void mostrarProductos(List<ProductoDTO> productos) {
        DefaultTableModel modeloTablaProductos = (DefaultTableModel) tblProductos.getModel();
        modeloTablaProductos.setRowCount(0); // limpia las filas actuales

        for (ProductoDTO producto : productos) {
            modeloTablaProductos.addRow(new Object[]{
                producto.getNombre(),
                producto.getTipo().toString().toLowerCase(),
                String.format("$ %.2f", producto.getPrecio()),
                producto.isHabilitado() ? "Habilitado" : "Deshabilitado"
            });
        }
    }

    public JTable getTblProductos() {
        return tblProductos;
    }

}
