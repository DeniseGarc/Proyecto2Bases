/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Maryr
 */
@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {
    /**
     * Identificador unico de la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    /**
     * Estado de la mesa , no puede ser nulo
     */
    @Column(nullable = false)
    private boolean estado;
    /**
     * Constructor vacio
     */
    public Mesa() {
    }
    /**
     * Constructor con estado 
     * @param estado  
     */
    public Mesa(boolean estado) {
        this.estado = estado;
    }
    /**
     * Constructor completo de la mesa
     * @param numero numero de mesa
     * @param estado Estado de la mesa 
     */
    public Mesa(Long numero, boolean estado) {
        this.numero = numero;
        this.estado = estado;
    }
    /**
     * Obtiene el numero de la mesa
     * @return Numero
     */
    public Long getNumero() {
        return numero;
    }
    /**
     * Establece el numero de la mesa
     * @param numero numero nuevo
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }
    /**
     * Obtiene el estado de la mesa
     * @return estado actual de la mesa
     */
    public boolean getEstado() {
        return estado;
    }
    /**
     * Establece el estado de la mesa
     * @param estado estado nuevo
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mesa{" + "numero=" + numero + ", estado=" + estado + '}';
    }

}
