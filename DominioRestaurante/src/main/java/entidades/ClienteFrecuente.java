/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enumeradores.Estado;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Maryr
 */
@Entity
@Table(name = "clientesFrecuentes")
public class ClienteFrecuente extends Cliente implements Serializable {

    @Transient
    private int puntosFidelidad;

    @Transient
    private int cantidadVisitas;

    @Transient
    private Double gastoTotal;

    public ClienteFrecuente() {
    }

    public ClienteFrecuente(String nombre, Calendar fechaRegistro, String telefono, String correoElectronico) {
        super(nombre, fechaRegistro, telefono, correoElectronico);
    }

    public int calcularPuntosFidelidad(List<Comanda> comandasCliente) {
        int puntos = 0;
        for (Comanda comanda : comandasCliente) {
            if (comanda.getEstado() == Estado.ENTREGADA) {
                puntos += comanda.getTotalVenta();
            }
        }
        return (int) (puntos / 20);
    }

    public int calcularCantidadVisitas(List<Comanda> comandasCliente) {
        int numVisitas = 0;
        for (Comanda comanda : comandasCliente) {
            if (comanda.getEstado() == Estado.ENTREGADA) {
                numVisitas++;
            }
        }
        return numVisitas;
    }

    public double calcularGastoTotal(List<Comanda> comandasCliente) {
        double gasto = 0.0;
        for (Comanda comanda : comandasCliente) {
            if (comanda.getEstado() == Estado.ENTREGADA) {
                gasto += comanda.getTotalVenta();
            }
        }
        return gasto;
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public int getCantidadVisitas() {
        return cantidadVisitas;
    }

    public void setCantidadVisitas(int cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

    public Double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(Double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

}
