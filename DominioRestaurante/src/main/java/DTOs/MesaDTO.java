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

    private String numero;
    private boolean estado;

    public MesaDTO() {
    }

    public MesaDTO(String numero, boolean estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MesaDTO{" + "numero=" + numero + ", estado=" + estado + '}';
    }

}
