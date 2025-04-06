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
public class ClienteDTO {

    private Long id;
    private String nombre;
    private Calendar fechaRegistro;
    private String telefono;
    private String correoElectronico;

    public ClienteDTO() {
    }

    public ClienteDTO(String nombre, Calendar fechaRegistro, String telefono, String correoElectronico) {
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Calendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", nombre=" + nombre + ", fechaRegistro=" + fechaRegistro + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico + '}';
    }

}
