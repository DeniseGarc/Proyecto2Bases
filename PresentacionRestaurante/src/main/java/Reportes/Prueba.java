/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Reportes;

import DTOs.DetalleReporteComandaDTO;
import control.CoordinadorAplicacion;
import control.exception.CoordinadorException;
import extras.Periodo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alici
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comanda comanda = new Comanda();
        comanda.setCliente("Juan Pérez");
        comanda.setFecha(new Date());

        List<DetalleProducto> detalles = List.of(
                new DetalleProducto("Taco", 2, 25.0),
                new DetalleProducto("Quesadilla", 1, 20.0)
        );

        comanda.setDetalles(detalles);

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("cliente", comanda.getCliente());
        parametros.put("fecha", comanda.getFecha());
        parametros.put("detalles", comanda.getDetalles());

        JasperReport reporte = JasperCompileManager.compileReport("ruta/reporte_comanda.jrxml");
        JasperPrint print = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, "comanda_generada.pdf");

    }

}
