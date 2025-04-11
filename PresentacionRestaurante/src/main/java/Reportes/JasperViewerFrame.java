package Reportes;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import javax.swing.*;
import java.util.HashMap;
import java.io.InputStream;
import net.sf.jasperreports.swing.JRViewer;

public class JasperViewerFrame extends JFrame {

    public JasperViewerFrame(String resourcePath) {
        super("Visor de JasperReports desde Resources");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        try {
            // Obtener el recurso desde el classloader
            InputStream reportStream = getClass().getResourceAsStream(resourcePath);

            if (reportStream == null) {
                throw new JRException("Recurso no encontrado: " + resourcePath);
            }

            // Cargar el informe directamente desde el InputStream
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);

            // Parámetros y llenado del informe
            HashMap<String, Object> parametros = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());

            // Configurar el visor
            JRViewer viewer = new JRViewer(jasperPrint);
            getContentPane().add(viewer);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Ruta relativa desde resources (usar / si está en raíz de resources)
            String resourcePath = "/reportes/prueba.jrxml";

            JasperViewerFrame viewer = new JasperViewerFrame(resourcePath);
            viewer.setVisible(true);
        });
    }
}
