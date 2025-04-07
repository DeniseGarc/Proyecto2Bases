/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enumeradores.Estado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Alici
 */
public class ComandaDTO {

    private Calendar fechaHora;
    private double totalVenta;
    private Estado estado;
    private List<DetalleComandaDTO> detallesComanda = new ArrayList<>();
    private String nombrecliente;

    public ComandaDTO() {
    }

    public ComandaDTO(Calendar fechaHora, double totalVenta, Estado estado, String nombrecliente) {
        this.fechaHora = fechaHora;
        this.totalVenta = totalVenta;
        this.estado = estado;
        this.nombrecliente = nombrecliente;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<DetalleComandaDTO> getDetallesComanda() {
        return detallesComanda;
    }

    public void setDetallesComanda(List<DetalleComandaDTO> detallesComanda) {
        this.detallesComanda = detallesComanda;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

}
