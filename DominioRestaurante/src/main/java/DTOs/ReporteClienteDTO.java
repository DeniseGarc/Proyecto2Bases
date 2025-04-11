/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Calendar;

/**
 *
 * @author Maryr
 */
public class ReporteClienteDTO {

    private String nombreCompletoCliente;
    private int numeroVisitas;
    private Double totalGastado;
    private int puntosFidelidad;
    private Calendar fechaUltimaComanda;

    public ReporteClienteDTO() {
    }

    public ReporteClienteDTO(String nombreCompletoCliente, int numeroVisitas, Double totalGastado, int puntosFidelidad, Calendar fechaUltimaComanda) {
        this.nombreCompletoCliente = nombreCompletoCliente;
        this.numeroVisitas = numeroVisitas;
        this.totalGastado = totalGastado;
        this.puntosFidelidad = puntosFidelidad;
        this.fechaUltimaComanda = fechaUltimaComanda;
    }

    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }

    public int getNumeroVisitas() {
        return numeroVisitas;
    }

    public void setNumeroVisitas(int numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    public Double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(Double totalGastado) {
        this.totalGastado = totalGastado;
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public Calendar getFechaUltimaComanda() {
        return fechaUltimaComanda;
    }

    public void setFechaUltimaComanda(Calendar fechaUltimaComanda) {
        this.fechaUltimaComanda = fechaUltimaComanda;
    }

    @Override
    public String toString() {
        return "ReporteClienteDTO{" + "nombreCompletoCliente=" + nombreCompletoCliente + ", numeroVisitas=" + numeroVisitas + ", totalGastado=" + totalGastado + ", puntosFidelidad=" + puntosFidelidad + ", fechaUltimaComanda=" + fechaUltimaComanda + '}';
    }

}
