
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ClienteFrecuenteDTO;
import DTOs.ReporteClienteDTO;
import entidades.ClienteFrecuente;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IClienteFrecuenteBO;
import interfaces.IClienteFrecuenteDAO;
import interfaces.IComandaBO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejadorBO.ManejadorBO;
import mappers.ClienteMapper;
import seguridad.Seguridad;

/**
 *
 * @author Maryr
 */
public class ClienteFrecuenteBO implements IClienteFrecuenteBO {

    private IClienteFrecuenteDAO clienteFrecuenteDAO;
    private IComandaBO comandaBO = ManejadorBO.crearComandaBo();

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
                clientes = clienteFrecuenteDAO.obtenerClientesFrecuentes("", "");
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

    /**
     * Desencripta un número de celular dado
     *
     * @param telefono el cual se quiere desencriptar
     * @return el telefono desencriptado
     * @throws NegocioException
     */
    @Override
    public String desencriptarTelefono(String telefono) throws NegocioException {
        try {
            return Seguridad.desencriptar(telefono);
        } catch (Exception e) {
            throw new NegocioException("Hubo un error al desencriptar el telefono: ", e);
        }
    }

    /**
     * Obtiene un cliente que esté asociado al id
     *
     * @param id por el cual se buscará el cliente
     * @return el cliente asociado al id
     * @throws NegocioException
     */
    @Override
    public ClienteFrecuenteDTO obtenerClientePorId(Long id) throws NegocioException {
        try {
            return ClienteMapper.toDTO(clienteFrecuenteDAO.obtenerClientePorId(id));
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo recuperar el cliente: ", e);
        }
    }

    public List<ReporteClienteDTO> obtenerClientesPorVisitas(int numVisitas) throws NegocioException {
        try {
            List<ClienteFrecuenteDTO> clientes = obtenerClientesFrecuentes("", "");
            List<ReporteClienteDTO> clientesR = new ArrayList<>();
            for (ClienteFrecuenteDTO cliente : clientes) {
                if (cliente.getCantidadVisitas() >= numVisitas) {
                    clientesR.add(new ReporteClienteDTO(cliente.getNombre(), cliente.getCantidadVisitas(), cliente.getGastoTotal(), cliente.getPuntosFidelidad(), comandaBO.obtenerFechaUltimaComandaCliente(cliente)));
                }
            }
            return clientesR;
        } catch (NegocioException e) {
            throw new NegocioException("No se pudo consultar por número de visitas: ", e);
        }
    }

}
