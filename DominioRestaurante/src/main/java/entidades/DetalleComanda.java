package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa un detalle individual dentro de una comanda. Esta entidad mapea la
 * relación entre una comanda y los productos solicitados.
 *
 * @author Alicia Denise García Acosta 00000252402
 */
@Entity
@Table(name = "detallesComandas")
public class DetalleComanda implements Serializable {

    /**
     * Identificador único del detalle de comanda.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Precio unitario del producto al momento de realizar la comanda. Se
     * almacena para mantener histórico de precios.
     */
    @Column(name = "precioUnitario", nullable = false)
    private Double precioUnitario;

    /**
     * Cantidad solicitada del producto.
     */
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    /**
     * Importe total calculado (precioUnitario * cantidad).
     */
    @Column(name = "importeTotal", nullable = false)
    private Double importeTotal;

    /**
     * Observaciones o instrucciones especiales para la preparación del
     * producto.
     */
    @Column(name = "notas", nullable = true, length = 500)
    private String notas;

    /**
     * Producto asociado a este detalle. Relación muchos a uno con la entidad
     * Producto.
     */
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    /**
     * Comanda a la que pertenece este detalle. Relación muchos a uno con la
     * entidad Comanda.
     */
    @ManyToOne
    @JoinColumn(name = "idComanda", nullable = false)
    private Comanda comanda;

    /**
     * Constructor para crear un nuevo detalle de comanda (sin ID).
     *
     * @param precioUnitario Precio unitario del producto
     * @param cantidad Cantidad solicitada
     * @param importeTotal Total calculado para este ítem
     * @param notas Observaciones especiales
     * @param producto Producto asociado
     * @param comanda Comanda padre
     */
    public DetalleComanda(Double precioUnitario, Integer cantidad, Double importeTotal,
            String notas, Producto producto, Comanda comanda) {
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.importeTotal = importeTotal;
        this.notas = notas;
        this.producto = producto;
        this.comanda = comanda;
    }

    /**
     * Constructor completo para crear un detalle de comanda con todos los
     * atributos.
     *
     * @param id Identificador único
     * @param precioUnitario Precio unitario del producto
     * @param cantidad Cantidad solicitada
     * @param importeTotal Total calculado para este ítem
     * @param notas Observaciones especiales
     * @param producto Producto asociado
     * @param comanda Comanda padre
     */
    public DetalleComanda(Long id, Double precioUnitario, Integer cantidad,
            Double importeTotal, String notas, Producto producto,
            Comanda comanda) {
        this.id = id;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.importeTotal = importeTotal;
        this.notas = notas;
        this.producto = producto;
        this.comanda = comanda;
    }

    /**
     * Constructor vacío requerido por JPA.
     */
    public DetalleComanda() {
    }

    /**
     * Obtiene el ID del detalle.
     *
     * @return Identificador único
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del detalle.
     *
     * @param id Nuevo identificador
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el precio unitario del producto.
     *
     * @return Precio unitario registrado
     */
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Establece el precio unitario del producto.
     *
     * @param precioUnitario Nuevo precio unitario
     */
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Obtiene la cantidad solicitada.
     *
     * @return Cantidad del producto
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad solicitada.
     *
     * @param cantidad Nueva cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el importe total calculado.
     *
     * @return Total del ítem (precio x cantidad)
     */
    public Double getImporteTotal() {
        return importeTotal;
    }

    /**
     * Establece el importe total calculado.
     *
     * @param importeTotal Nuevo importe total
     */
    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    /**
     * Obtiene las indicaciones del producto.
     *
     * @return Notas o instrucciones especiales
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Establece las indicaciones del producto.
     *
     * @param notas Nuevas notas o instrucciones
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * Obtiene el producto asociado.
     *
     * @return Producto del detalle
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado.
     *
     * @param producto Nuevo producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la comanda a la que pertenece.
     *
     * @return Comanda padre
     */
    public Comanda getComanda() {
        return comanda;
    }

    /**
     * Establece la comanda a la que pertenece.
     *
     * @param comanda Nueva comanda padre
     */
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    /**
     * Método toString del detalle de comanda.
     *
     * @return String con todos los atributos
     */
    @Override
    public String toString() {
        return "DetalleComanda{"
                + "id=" + id
                + ", precioUnitario=" + precioUnitario
                + ", cantidad=" + cantidad
                + ", importeTotal=" + importeTotal
                + ", notas=" + notas
                + ", producto=" + producto
                + ", comanda=" + comanda
                + '}';
    }

}
