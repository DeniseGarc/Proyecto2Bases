/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enumeradores.Estado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import listener.ModificarStockIngredientesListener;

/**
 *
 * @author erika
 */
@EntityListeners(ModificarStockIngredientesListener.class)

@Entity
@Table(name = "comanda")
public class Comanda implements Serializable {
    /**
     * Identificador unico de la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Fecha y hora en la que se realizo la comanda
     */
    @Column(name = "fechaHora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;
    /**
     * Total de la venta, se calcula con la sumatoria del precio de los productos
     */
    @Column(name = "totalVenta", nullable = false)
    private Double totalVenta;
    /**
     * Estado de la comanda
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;
    /**
     * Relacion con DetalleComanda donde se guarda la informacion sobre los productos de la comanda
     */
    @OneToMany(mappedBy = "comanda", cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<DetalleComanda> detallesComanda = new ArrayList<>();
    
   /**
    * Relacion uno a uno con mesa para indicar a que mesa pertenece la comanda, no acepta nulos
    */
    @OneToOne()
    @JoinColumn(name = "mesa", nullable = false)
    private Mesa mesa; 
    /**
     * Relacion Muchos a uno con cliente, indica a que cliente pertenece la comanda, puede aceptar valores nulos
     */
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = true)
    private ClienteFrecuente cliente;
    /**
     * Constructor de comanda 
     * @param fechaHora Fecha y hora a la que se realiza la comanda
     * @param totalVenta Total de la venta 
     * @param estado Estado actual de la comanda
     */
    public Comanda(Calendar fechaHora, Double totalVenta, Estado estado) {
        this.fechaHora = fechaHora;
        this.totalVenta = totalVenta;
        this.estado = estado;
    }
    /**
     * Constructor de comanda que no incluye cliente frecuente
     * @param fechaHora fecha y hora a la que se realiza la comanda
     * @param totalVenta Total de la venta
     * @param estado estado actual de la comanda
     * @param mesa mesa a la que pertenece la comanda
     */
    public Comanda(Calendar fechaHora, Double totalVenta, Estado estado, Mesa mesa) {
        this.fechaHora = fechaHora;
        this.totalVenta = totalVenta;
        this.estado = estado;
        this.mesa = mesa;
    }
    /**
     * Constructor completo de la comanda 
     * @param id id de la comanda en la base de datos
     * @param fechaHora fecha y hora a la que se realiza la comanda
     * @param totalVenta Total de la venta
     * @param estado estado actual de la comanda
     * @param mesa mesa a la que pertenece la comanda
     * @param cliente clienteFrecuente al cual pertenece la comanda
     */
    public Comanda(Long id, Calendar fechaHora, Double totalVenta, Estado estado, Mesa mesa, ClienteFrecuente cliente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.totalVenta = totalVenta;
        this.estado = estado;
        this.mesa = mesa;
        this.cliente = cliente;
    }
    /**
     * constructor vacio
     */
    public Comanda() {
    }
    /**
     * Obtiene la mesa de la comanda
     * @return Mesa 
     */
    public Mesa getMesa() {
        return mesa;
    }
    /**
     * Establece la mesa de la comanda
     * @param mesa Mesa nueva para la comanda
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    /**
     * Fecha y hora a la que se realizo la comanda
     * @return fecha y hora
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }
    /**
     * Establece la fecha y hora de la comanda
     * @param fechaHora Fecha y hora del momento en el que se realiza la comanda
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }
    /**
     * Obtiene el total de la venta de la comanda
     * @return Total de venta de la comanda
     */
    public Double getTotalVenta() {
        return totalVenta;
    }
    /**
     * Establece el total de la venta de la comanda
     * @param totalVenta 
     */
    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }
    /**
     * Obtiene el estado actual de la comanda
     * @return Estado actual
     */
    public Estado getEstado() {
        return estado;
    }
    /**
     * Establece el estado de la comanda
     * @param estado estado nuevo de la comanda
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    /**
     * Obtiene los detalles de la comanda
     * @return Detalles actuales de la comanda
     */
    public List<DetalleComanda> getDetallesComanda() {
        return detallesComanda;
    }
    /**
     * Establece los detalles actuales de la comanda
     * @param detallesComanda 
     */
    public void setDetallesComanda(List<DetalleComanda> detallesComanda) {
        this.detallesComanda = detallesComanda;
    }
    /**
     * Obtiene el id de la comanda
     * @return id
     */
    public Long getId() {
        return id;
    }
    /**
     * establece el id de la comanda
     * @param id id nuevo
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Obtiene el cliente frecuente asociado a la comanda
     * @return Cliente frecuente
     */
    public ClienteFrecuente getCliente() {
        return cliente;
    }
    /**
     * Establece un cliente frecuente a la comanda
     * @param cliente ClienteFrecuente nuevo
     */
    public void setCliente(ClienteFrecuente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", fechaHora=" + fechaHora + ", totalVenta=" + totalVenta + ", estado=" + estado + ", detallesComanda=" + detallesComanda + '}';
    }

}
