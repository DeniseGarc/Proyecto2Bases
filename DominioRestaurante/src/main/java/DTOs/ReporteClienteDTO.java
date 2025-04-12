package DTOs;

import java.util.Calendar;
import java.util.Date;

/**
 * DTO que se utiliza para obtener la información de los registros que se van a
 * mostrar en el reporte de clientes.
 *
 * @author Maryr
 */
public class ReporteClienteDTO {

    private String nombreCompletoCliente;
    private int numeroVisitas;
    private Double totalGastado;
    private int puntosFidelidad;
    private Date fechaUltimaComanda;

    /**
     * Constructor vacio del DTO
     */
    public ReporteClienteDTO() {
    }

    /**
     * Constructor con todos los atributos del DTO
     *
     * @param nombreCompletoCliente Nombre completo del cliente
     * @param numeroVisitas Numero de visitas del cliente
     * @param totalGastado Total de dinero gastado del cliente
     * @param puntosFidelidad Total de puntos de fidelidad del cliente
     * @param fechaUltimaComanda Fecha de la última comanda registrada del
     * cliente
     */
    public ReporteClienteDTO(String nombreCompletoCliente, int numeroVisitas, Double totalGastado, int puntosFidelidad, Calendar fechaUltimaComanda) {
        this.nombreCompletoCliente = nombreCompletoCliente;
        this.numeroVisitas = numeroVisitas;
        this.totalGastado = totalGastado;
        this.puntosFidelidad = puntosFidelidad;
        this.fechaUltimaComanda = fechaUltimaComanda.getTime();
    }

    /**
     * Obtiene el nombre completo del cliente.
     *
     * @return String con el nombre completo
     */
    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    /**
     * Establece el nombre completo del cliente.
     *
     * @param nombreCompletoCliente Nombre completo a asignar
     */
    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }

    /**
     * Obtiene el número de visitas realizadas por el cliente.
     *
     * @return Entero con el total de visitas
     */
    public int getNumeroVisitas() {
        return numeroVisitas;
    }

    /**
     * Establece el número de visitas del cliente.
     *
     * @param numeroVisitas Cantidad de visitas a asignar
     */
    public void setNumeroVisitas(int numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    /**
     * Obtiene el total gastado por el cliente.
     *
     * @return Double con el monto total gastado
     */
    public Double getTotalGastado() {
        return totalGastado;
    }

    /**
     * Establece el total gastado por el cliente.
     *
     * @param totalGastado Monto total a asignar
     */
    public void setTotalGastado(Double totalGastado) {
        this.totalGastado = totalGastado;
    }

    /**
     * Obtiene los puntos de fidelidad acumulados.
     *
     * @return Entero con los puntos de fidelidad
     */
    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    /**
     * Establece los puntos de fidelidad del cliente.
     *
     * @param puntosFidelidad Puntos a asignar
     */
    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    /**
     * Obtiene la fecha de la última comanda en formato Date.
     *
     * @return Date con la fecha de la última comanda asociada al cliente
     */
    public Date getFechaUltimaComanda() {
        return fechaUltimaComanda;
    }

    /**
     * Establece la fecha de la última comanda asociada al cliente.
     *
     * @param fechaUltimaComanda Fecha a asignar (en formato Date)
     */
    public void setFechaUltimaComanda(Date fechaUltimaComanda) {
        this.fechaUltimaComanda = fechaUltimaComanda;
    }
}
