/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.ClienteFrecuenteDTO;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author Maryr
 */
public interface IClienteFrecuenteBO {
 public ClienteFrecuenteDTO registrarNuevoClienteFrecuente (ClienteFrecuenteDTO clienteFrecuente) throws NegocioException;
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentes() throws NegocioException;
    public List<ClienteFrecuenteDTO> obtenerClientesPorNombre(String nombre) throws NegocioException;
    public List<ClienteFrecuenteDTO> obtenerClientesPorTelefono(String telefono) throws NegocioException;
    public List<ClienteFrecuenteDTO> obtenerClientesPorCorreo(String correo) throws NegocioException;   
}
