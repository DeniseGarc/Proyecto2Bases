/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import extras.Periodo;

/**
 *
 * @author Alici
 */
public class ReporteComandasDTO {

    private Periodo periodo;
    private Double totalAcumuladoVentas;
    private DetalleReporteComandaDTO detallesReporteComanda;

    public ReporteComandasDTO(Periodo periodo, Double totalAcumuladoVentas, DetalleReporteComandaDTO detallesReporteComanda) {
        this.periodo = periodo;
        this.totalAcumuladoVentas = totalAcumuladoVentas;
        this.detallesReporteComanda = detallesReporteComanda;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Double getTotalAcumuladoVentas() {
        return totalAcumuladoVentas;
    }

    public void setTotalAcumuladoVentas(Double totalAcumuladoVentas) {
        this.totalAcumuladoVentas = totalAcumuladoVentas;
    }

    public DetalleReporteComandaDTO getDetallesReporteComanda() {
        return detallesReporteComanda;
    }

    public void setDetallesReporteComanda(DetalleReporteComandaDTO detallesReporteComanda) {
        this.detallesReporteComanda = detallesReporteComanda;
    }

}
