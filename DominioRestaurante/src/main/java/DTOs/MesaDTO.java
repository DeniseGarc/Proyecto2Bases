/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Maryr
 */
public class MesaDTO {
    /**
     * Numero de la mesa (identificador)
     */
    private String numero;
    /**
     * estado de la mesa
     */
    private boolean estado;
    /**
     * Constructor vacio
     */
    public MesaDTO() {
    }
    /**
     * COnstructor completo
     * @param numero
     * @param estado 
     */
    public MesaDTO(String numero, boolean estado) {
        this.numero = numero;
        this.estado = estado;
    }
    /**
     * Obtiene el numero de la mesa
     * @return numero de la mesa 
     */
    public String getNumero() {
        return numero;
    }
    /**
     * Establece el numero de la mesa
     * @param numero numero nuevo
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    /**
     * Obtiene el estado de la mesa
     * @return estado actual
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
        return "MesaDTO{" + "numero=" + numero + ", estado=" + estado + '}';
    }

}
