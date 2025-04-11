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
    /**
     * Identificador de la comanda en la base de datos, debe ser unico en el sistema
     */
    private Long id;
    /**
     * Fecha y hora de cuando se creo la comanda
     */
    private Calendar fechaHora;
    /**
     * Total de la venta de la comanda, se obtiene con la sumatoria de los precios unitarios de los productor asociados a esta
     */
    private double totalVenta;
    /**
     * Estado de la comanda, ya sea activa, entregada o cancelada
     */
    private Estado estado;
    /**
     * Lista de DetallesComanda asociados a la comanda
     */
    private List<DetalleComandaDTO> detallesComanda = new ArrayList<>();
    /**
     * Telefono del cliente asociado a la comanda
     */
    private String telefonoCliente;
    /**
     * nombre del cliente asociado a la comanda
     */
    private String nombreCliente;
    /**
     * Numero de la mesa asociada a la comanda
     */
    private String numeroMesa;

    /**
     * Obtiene el id de la comanda
     * @return id 
     */
    public Long getId() {
        return id;
    }
    /**
     * Establece el id de la comandaDTO
     * @param id id de la comanda DTO
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Constructor vacio
     */
    public ComandaDTO() {
    }
    /**
     * COnstructor  sin cliente
     * @param id id de la comanda 
     * @param fechaHora fecha y hora de creacion de la comanda
     * @param totalVenta total de la venta
     * @param estado estado actual de la comanda
     * @param numeroMesa  numero de la mesa asociada a la comanda
     */
    public ComandaDTO(Long id, Calendar fechaHora, double totalVenta, Estado estado, String numeroMesa) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.totalVenta = totalVenta;
        this.estado = estado;
        this.numeroMesa = numeroMesa;
    }
    /**
     * Constructor completo con cliente
     * @param id de la comanda 
     * @param fechaHora fecha y hora de creacion de la comanda
     * @param totalVenta total de la venta
     * @param estado estado actual de la comanda
     * @param numeroMesa  numero de la mesa asociada a la comanda
     * @param telefonoCliente telefono del cliente asociado a la comanda
     * @param nombreCliente nombre del cliente asociado a la comanda
     */
    public ComandaDTO(Long id, Calendar fechaHora, double totalVenta, Estado estado, String telefonoCliente, String nombreCliente, String numeroMesa) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.totalVenta = totalVenta;
        this.estado = estado;
        this.telefonoCliente = telefonoCliente;
        this.nombreCliente = nombreCliente;
        this.numeroMesa = numeroMesa;
    }
    /**
     * COnstructor sin id 
     * @param fechaHora fecha y hora de creacion de la comanda
     * @param totalVenta total de la venta
     * @param estado estado actual de la comanda
     * @param numeroMesa  numero de la mesa asociada a la comanda
     * @param telefonoCliente telefono del cliente asociado a la comanda
     * @param nombreCliente nombre del cliente asociado a la comanda
     */
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
    /**
     * Obtiene la fecha y hora de la comanda
     * @return fecha hora actuales de la comanda
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }
    /**
     * Establece la fecha y hora de la comanda dto
     * @param fechaHora fecha hora  hueva
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }
    /**
     * Obtiene el total de la venta de la comanda
     * 
     * @return total de venta actual
     */
    public double getTotalVenta() {
        return totalVenta;
    }
    /**
     * Establece el total de venta de la comanda
     * @param totalVenta total de venta nuevo
     */
    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
    /**
     * Obtiene el estado de la comanda
     * @return estado actual
     */
    public Estado getEstado() {
        return estado;
    }
    /**
     * Establece el estado de la comanda DTO
     * @param estado estado nuevo
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    /**
     * Obtiene la lista de detalles comanda asociados a la comanda
     * @return detalles comanda actuales
     */
    public List<DetalleComandaDTO> getDetallesComanda() {
        return detallesComanda;
    }
    /**
     * Establece los detalles comanda asociados a la comanda
     * @param detallesComanda detalles comanda actuales
     */
    public void setDetallesComanda(List<DetalleComandaDTO> detallesComanda) {
        this.detallesComanda = detallesComanda;
    }
    /**
     * Obtiene el nombre del cliente asociado a la comanda
     * @return nombre del cliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }
    /**
     * Establece el nombre del cliente asociado a la comanda
     * @param nombreCliente nombre del cliente nuevo
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    /**
     * Obtiene el numero de telefono del cliente asociado a la comanda
     * @return numero de telefono del cliente actual
     */
    public String getTelefonoCliente() {
        return telefonoCliente;
    }
    /**
     * Establece el numero de telefono del cliente asociado a la comanda
     * @param telefonoCliente telefono nuevo
     * */
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    /**
     * obtiene el numero de mesa asociada a la comanda
     * @return numero de mesa
     */
    public String getNumeroMesa() {
        return numeroMesa;
    }
    /**
     *Establece el numero de la mesa asociada a la comanda 
     * @param numeroMesa numero de mesa nuevo
     */
    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

 
    

}
