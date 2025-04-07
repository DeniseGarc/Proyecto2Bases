/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Alici
 */
public class DetalleComandaDTO {

    private double precioUnitario;
    private int cantidad;
    private double importeTotal;
    private String notas;
    private String nombreProducto;

    public DetalleComandaDTO() {
    }

    public DetalleComandaDTO(double precioUnitario, int cantidad, double importeTotal, String notas, String nombreProducto) {
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.importeTotal = importeTotal;
        this.notas = notas;
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

}
