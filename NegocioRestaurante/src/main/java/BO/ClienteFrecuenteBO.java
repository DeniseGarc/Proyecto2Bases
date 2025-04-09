
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ClienteFrecuenteDTO;
import entidades.ClienteFrecuente;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IClienteFrecuenteBO;
import interfaces.IClienteFrecuenteDAO;
import java.util.ArrayList;
import java.util.List;
import mappers.ClienteMapper;
import seguridad.Seguridad;

/**
 *
 * @author Maryr
 */
public class ClienteFrecuenteBO implements IClienteFrecuenteBO {

    private IClienteFrecuenteDAO clienteFrecuenteDAO;

    public ClienteFrecuenteBO(IClienteFrecuenteDAO clienteFrecuenteDAO) {
        this.clienteFrecuenteDAO = clienteFrecuenteDAO;
    }

    /**
     * Método para registrar un nuevo cliente frecuente
     *
     * @param clienteFrecuente Cliente a registrar.
     * @return DTO con datos del cliente registrado.
     * @throws NegocioException Si ocurre un error en la operación.
     */
    @Override
    public ClienteFrecuenteDTO registrarNuevoClienteFrecuente(ClienteFrecuenteDTO clienteFrecuente) throws NegocioException {
        try {
            clienteFrecuente.setTelefono(Seguridad.encriptar(clienteFrecuente.getTelefono()));
            ClienteFrecuente registrado = clienteFrecuenteDAO.registrarNuevoClienteFrecuente(ClienteMapper.toEntity(clienteFrecuente));
            registrado.setTelefono(Seguridad.desencriptar(registrado.getTelefono()));
            return ClienteMapper.toDTO(registrado);
        } catch (Exception e) {
            throw new NegocioException("Error al registrar cliente frecuente: ", e);
        }
    }

    /**
     * Método donde se filtra la lista de clientes dependiendo del tipo de
     * busqueda y el dato a buscar
     *
     * @param filtro el tipo de busqueda que se quiere realizar
     * @param dato el dato el cual se buscará
     * @return la lista de cliente filtrada
     * @throws NegocioException
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentes(String filtro, String dato) throws NegocioException {
        try {
            List<ClienteFrecuente> clientes;
            List<ClienteFrecuenteDTO> filtrados = new ArrayList<>();
            if (filtro.equalsIgnoreCase("telefono")) {
                clientes = clienteFrecuenteDAO.obtenerClientesFrecuentes(null, null);
                desencriptarTelefonos(clientes);
                for (ClienteFrecuente cliente : clientes) {
                    if (cliente.getTelefono().contains(dato)) {
                        filtrados.add(ClienteMapper.toDTO(cliente));
                    }
                }
            } else {
                clientes = clienteFrecuenteDAO.obtenerClientesFrecuentes(filtro, dato);
                desencriptarTelefonos(clientes); 
                filtrados = ClienteMapper.toDTOList(clientes);
            }
            return filtrados;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar clientes frecuentes: ", e);
        }
    }

    /**
     * Desencripta los teléfonos de una lista de clientes frecuentes.
     *
     * @param clientes Lista de clientes frecuentes.
     * @throws PersistenciaException Si ocurre un error en la desencriptación.
     */
    private void desencriptarTelefonos(List<ClienteFrecuente> clientes) throws NegocioException {
        try {
            for (ClienteFrecuente cliente : clientes) {
                cliente.setTelefono(Seguridad.desencriptar(cliente.getTelefono()));
            }
        } catch (Exception e) {
            throw new NegocioException("Error al desencriptar los teléfonos: ", e);
        }
    }

}
