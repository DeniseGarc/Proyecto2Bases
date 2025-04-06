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
public class ClienteFrecuenteDTO extends ClienteDTO {

    private int puntosFidelidad;
    private int cantidadVisitas;
    private Double gastoTotal;

    public ClienteFrecuenteDTO() {
    }

    public ClienteFrecuenteDTO(String nombre, Calendar fechaRegistro, String telefono, String correoElectronico, int puntosFidelidad, int cantidadVisitas, Double gastoTotal) {
        super(nombre, fechaRegistro, telefono, correoElectronico);
        this.puntosFidelidad = puntosFidelidad;
        this.cantidadVisitas = cantidadVisitas;
        this.gastoTotal = gastoTotal;
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

    @Override
    public String toString() {
        return "ClienteFrecuenteDTO{" + "puntosFidelidad=" + puntosFidelidad + ", cantidadVisitas=" + cantidadVisitas + ", gastoTotal=" + gastoTotal + '}';
    }

}
