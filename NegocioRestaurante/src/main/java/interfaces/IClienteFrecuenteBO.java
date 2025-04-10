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
    public ClienteFrecuenteDTO registrarNuevoClienteFrecuente(ClienteFrecuenteDTO clienteFrecuente) throws NegocioException;
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentes(String filtro, String dato) throws NegocioException;
    public String desencriptarTelefono(String telefono) throws NegocioException;
    public ClienteFrecuenteDTO obtenerClientePorId(int id) throws NegocioException;
}
