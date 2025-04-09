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
    private String telefonoCliente;
    private String nombreCliente;
    private String numeroMesa;

    public ComandaDTO() {
    }

    public ComandaDTO(Calendar fechaHora, double totalVenta, Estado estado, String nombreCliente, String telefonoCliente, String numeroMesa) {
        this.fechaHora = fechaHora;
        this.totalVenta = totalVenta;
        this.estado = estado;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.numeroMesa = numeroMesa;
    }

    public ComandaDTO(Calendar fechaHora, double totalVenta, Estado estado) {
        this.fechaHora = fechaHora;
        this.totalVenta = totalVenta;
        this.estado = estado;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

 
    

}
