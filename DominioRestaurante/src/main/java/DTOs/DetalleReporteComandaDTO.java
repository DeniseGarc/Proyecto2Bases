/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import entidades.Comanda;
import enumeradores.Estado;
import java.util.Calendar;

/**
 *
 * @author Alici
 */
public class DetalleReporteComandaDTO {

    private String folio;
    private Calendar fechaHora;
    private String numeroMesa;
    private double totalVenta;
    private String estadoComanda;
    private String nombreClienteAsociado;

    public DetalleReporteComandaDTO(Comanda comanda) {
        this.folio = comanda.getId().toString();
    }

    public DetalleReporteComandaDTO(Long folio, Calendar fechaHora, Long numeroMesa, Double totalVenta, Estado estadoComanda, String nombreClienteAsociado) {
        this.folio = folio.toString();
        this.fechaHora = fechaHora;
        this.numeroMesa = numeroMesa.toString();
        this.totalVenta = totalVenta;
        this.estadoComanda = estadoComanda.toString();
        this.nombreClienteAsociado = nombreClienteAsociado;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
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

    public String getNombreClienteAsociado() {
        return nombreClienteAsociado;
    }

    public void setNombreClienteAsociado(String nombreClienteAsociado) {
        this.nombreClienteAsociado = nombreClienteAsociado;
    }

    @Override
    public String toString() {
        return "DetalleReporteComandaDTO{" + "folio=" + folio + ", fechaHora=" + fechaHora + ", numeroMesa=" + numeroMesa + ", totalVenta=" + totalVenta + ", estadoComanda=" + estadoComanda + ", nombreClienteAsociado=" + nombreClienteAsociado + '}';
    }

}
