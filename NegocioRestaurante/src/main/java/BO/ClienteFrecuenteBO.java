
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
     * Método donde se filtra la lista de clientes dependiendo del tipo de busqueda y el dato a buscar
     * @param filtro el tipo de busqueda que se quiere realizar
     * @param dato el dato el cual se buscará
     * @return la lista de cliente filtrada
     * @throws NegocioException
     */
    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentes(String filtro, String dato) throws NegocioException {
        try {
            List<ClienteFrecuente> clientes = clienteFrecuenteDAO.obtenerClientesFrecuentes();
            desencriptarTelefonos(clientes);
            if (filtro != null && dato != null && !dato.isEmpty()) {
                clientes = clientes.stream()
                        .filter(cliente -> {
                            switch (filtro) {
                                case "Nombre":
                                    return cliente.getNombre().toLowerCase().contains(dato.toLowerCase());
                                case "Telefono":
                                    return cliente.getTelefono().contains(dato);
                                case "Correo":
                                    return cliente.getCorreoElectronico().toLowerCase().contains(dato.toLowerCase());
                                default:
                                    return false;
                            }
                        })
                        .toList();
            }
            return ClienteMapper.toDTOList(clientes);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener clientes frecuentes por filtro: " + filtro, e);
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
