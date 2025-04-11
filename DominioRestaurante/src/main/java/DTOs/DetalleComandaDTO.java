/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import entidades.Mesa;

/**
 *
 * @author Alici
 */
public class DetalleComandaDTO {
    /**
     * Precio unitario del produto al momento de la venta
     */
    private double precioUnitario;
    /**
     * Cantidad de producto
     */
    private int cantidad;
    /**
     * Importe total del producto, suma de los precios unitarios
     */
    private double importeTotal;
    /**
     * Notas relacionadas con el prducto
     */
    private String notas;
    /**
     * nombre del producto asociado
     */
    private String nombreProducto;
    /**
     * Constructor vacio
     */
    public DetalleComandaDTO() {
    }
    /**
     * Constructor completo
     * @param precioUnitario precio unitario del producto
     * @param cantidad cantidad del producto
     * @param importeTotal importe total del producto segun su cantidad
     * @param notas notas del producto
     * @param nombreProducto nombre del producto
     */
    public DetalleComandaDTO(double precioUnitario, int cantidad, double importeTotal, String notas, String nombreProducto) {
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.importeTotal = importeTotal;
        this.notas = notas;
        this.nombreProducto = nombreProducto;
    }
    /**
     * Obtiene Precio unitario del producto
     * @return precio unitario de cuando se realizo la comanda
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    /**
     * Establece el precio unitario del producto
     * @param precioUnitario precio unitario nuevo
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    /**
     * Obtiene la cantidad del producto
     * @return cantidad actual
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Establece la cantidad del producto
     * @param cantidad cantidad nueva
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Obtiene el importe total actual del producto la comanda
     * @return importe total actual
     */
    public double getImporteTotal() {
        return importeTotal;
    }
    /**
     * Establece el importe total del producto de la comanda
     * @param importeTotal importe total nuevo
     */
    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }
    /**
     * Obtiene las notas del producto
     * @return notas actuales
     */
    public String getNotas() {
        return notas;
    }
    /**
     * Establece las notas del producto
     * @param notas notas nuevas
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }
    /**
     * Obtiene el nombre actual del producto
     * @return nombre actual
     */
    public String getNombreProducto() {
        return nombreProducto;
    }   
    /**
     * Establece el nombre del producto
     * @param nombreProducto nombre nuevo
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public String toString() {
        return "DetalleComandaDTO{" + "precioUnitario=" + precioUnitario + ", cantidad=" + cantidad + ", importeTotal=" + importeTotal + ", notas=" + notas + ", nombreProducto=" + nombreProducto + '}';
    }

}
