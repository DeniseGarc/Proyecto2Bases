/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
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

    public ClienteFrecuente(String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaRegistro, String telefono, String correoElectronico) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaRegistro, telefono, correoElectronico);
    }

//    por mientras para ver como esta el rollo        
//    public int calularPuntosFidelidad() {
//        return puntosFidelidad;
//    }
//    
//    public int calcularCantidadVisitas() {
//        return cantidadVisitas;
//    }
//    
//    public double calcularGastoTotal() {
//        return gastoTotal;
//    }
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
