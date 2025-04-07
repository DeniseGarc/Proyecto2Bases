package plantillas;

import control.CoordinadorAplicacion;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Clase que representa un panel reutilizable para mostrar el titulo de una
 * pantalla y un botón para regresar. Este panel se utiliza como encabezado en
 * distintas pantallas de la aplicacion, permitiendo establecer dinámicamente el
 * título mostrado y regresar a una pantalla anterior al hacer clic en el ícono
 * de flecha.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public class Titulo extends javax.swing.JPanel {

    /**
     * CoordinadorAplicacion para la comunicación con capa de negocio y flujo de
     * pantallas.
     */
    private CoordinadorAplicacion control = new CoordinadorAplicacion();
    private JFrame frmPadre;
    private JFrame frmTarget;

    /**
     * Constructor que inicializa los componentes del panel.
     */
    public Titulo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 176, 217));
        setPreferredSize(new java.awt.Dimension(1070, 78));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Titulo");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 500, 40));

        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imgs/flecha-regresar.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(108, 81, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/flecha-regresar.png"))); // NOI18N
        lblRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
        });
        add(lblRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 100, 100));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta al presionar la flecha para regresar, llama al
     * coordinador para regresar a la pantalla anterior.
     */
    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        regresar();
    }//GEN-LAST:event_lblRegresarMouseClicked

    /**
     * Método que regresa el JLabel que representa el título del panel.
     *
     * @return
     */
    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    /**
     * Método que llama al coordinador para regresar a la pantalla anterior.
     */
    private void regresar() {
        control.regresarPantalla(frmTarget, frmPadre);
    }

    /**
     * Establece el frame actual.
     *
     * @param frmPadre el JFrame de la pantalla actual.
     */
    public void setFrmPadre(JFrame frmPadre) {
        this.frmPadre = frmPadre;
    }

    /**
     * Establece el frame destino al que se debe regresar.
     *
     * @param frmTarget el JFrame de la pantalla a la pantalla anterior.
     */
    public void setFrmTarget(JFrame frmTarget) {
        this.frmTarget = frmTarget;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
