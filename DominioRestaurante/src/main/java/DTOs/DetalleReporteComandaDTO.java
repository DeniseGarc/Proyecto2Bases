/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enumeradores.Estado;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alici
 */
public class DetalleReporteComandaDTO {

    private String folio;
    private Date fechaHora;
    private String mesa;
    private double totalVenta;
    private String estadoComanda;
    private String nombreCompletoCliente;

    public DetalleReporteComandaDTO() {
    }

    public DetalleReporteComandaDTO(Long folio, Calendar fechaHora, Long numeroMesa, Double totalVenta, Estado estadoComanda, String nombreClienteAsociado) {
        this.folio = folio.toString();
        this.fechaHora = fechaHora.getTime();
        this.mesa = numeroMesa.toString();
        this.totalVenta = totalVenta;
        this.estadoComanda = estadoComanda.toString();
        this.nombreCompletoCliente = nombreClienteAsociado;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getEstadoComanda() {
        return estadoComanda;
    }

    public void setEstadoComanda(String estadoComanda) {
        this.estadoComanda = estadoComanda;
    }

    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }

    @Override
    public String toString() {
        return "DetalleReporteComandaDTO{" + "folio=" + folio + ", fechaHora=" + fechaHora + ", numeroMesa=" + mesa + ", totalVenta=" + totalVenta + ", estadoComanda=" + estadoComanda + ", nombreClienteAsociado=" + nombreCompletoCliente + '}';
    }

}
