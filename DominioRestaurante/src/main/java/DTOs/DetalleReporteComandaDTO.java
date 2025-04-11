package DTOs;

import enumeradores.Estado;
import java.util.Calendar;
import java.util.Date;

/**
 * DTO para guardar los registros de las comandas y los detalles necesarios para
 * generar el reporte de comandas.
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

    /**
     * Constructor vacio del DTO
     */
    public DetalleReporteComandaDTO() {
    }

    /**
     * Constructor que define todos los campos del DTO.
     *
     * @param folio folio de la comanda
     * @param fechaHora fecha y hora de la comanda
     * @param numeroMesa numero de la mesa a la que pertenece la comanda
     * @param totalVenta total de la venta de la comanda
     * @param estadoComanda estado de la comanda
     * @param nombreClienteAsociado nombre del cliente asociado a la comanda
     */
    public DetalleReporteComandaDTO(Long folio, Calendar fechaHora, Long numeroMesa, Double totalVenta, Estado estadoComanda, String nombreClienteAsociado) {
        this.folio = folio.toString();
        this.fechaHora = fechaHora.getTime();
        this.mesa = numeroMesa.toString();
        this.totalVenta = totalVenta;
        this.estadoComanda = estadoComanda.toString();
        this.nombreCompletoCliente = nombreClienteAsociado;
    }

    /**
     * Obtiene el folio de la comanda en formato String.
     *
     * @return String con el identificador único de la comanda
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Establece el folio de la comanda.
     *
     * @param folio Identificador único a asignar (en formato String)
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Obtiene la fecha y hora de registro de la comanda.
     *
     * @return Date con la fecha y hora de registro
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de registro de la comanda.
     *
     * @param fechaHora Fecha y hora a asignar (en formato Date)
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el número de mesa asociada a la comanda.
     *
     * @return String con el número de mesa
     */
    public String getMesa() {
        return mesa;
    }

    /**
     * Establece el número de mesa asociada a la comanda.
     *
     * @param mesa Número de mesa a asignar (en formato String)
     */
    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    /**
     * Obtiene el monto total de la venta.
     *
     * @return double con el total de la venta
     */
    public double getTotalVenta() {
        return totalVenta;
    }

    /**
     * Establece el monto total de la venta.
     *
     * @param totalVenta Valor total de la venta a asignar
     */
    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    /**
     * Obtiene el estado actual de la comanda.
     *
     * @return String con la representación textual del estado
     */
    public String getEstadoComanda() {
        return estadoComanda;
    }

    /**
     * Establece el estado de la comanda.
     *
     * @param estadoComanda Estado a asignar (en formato String)
     */
    public void setEstadoComanda(String estadoComanda) {
        this.estadoComanda = estadoComanda;
    }

    /**
     * Obtiene el nombre completo del cliente asociado a la comanda.
     *
     * @return String con el nombre completo del cliente
     */
    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    /**
     * Establece el nombre completo del cliente asociado a la comanda.
     *
     * @param nombreCompletoCliente Nombre completo a asignar
     */
    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }
}
