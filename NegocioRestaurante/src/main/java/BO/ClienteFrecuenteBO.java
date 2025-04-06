/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ClienteFrecuenteDTO;
import entidades.ClienteFrecuente;
import exception.NegocioException;
import interfaces.IClienteFrecuenteBO;
import interfaces.IClienteFrecuenteDAO;
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
            validarCliente(clienteFrecuente);
            clienteFrecuente.setTelefono(Seguridad.encriptar(clienteFrecuente.getTelefono()));
            ClienteFrecuente registrado = clienteFrecuenteDAO.registrarNuevoClienteFrecuente(ClienteMapper.toEntity(clienteFrecuente));
            registrado.setTelefono(Seguridad.desencriptar(registrado.getTelefono()));
            return ClienteMapper.toDTO(registrado);
        } catch (Exception e) {
            throw new NegocioException("Error al registrar cliente frecuente: ", e);
        }
    }

    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentes() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesPorNombre(String nombre) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesPorTelefono(String telefono) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteFrecuenteDTO> obtenerClientesPorCorreo(String correo) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Valida los datos de un cliente.
     * @param clienteFrecuente Cliente a validar.
     * @throws NegocioException Si los datos son inválidos.
     */
    private void validarCliente(ClienteFrecuenteDTO clienteFrecuente) throws NegocioException {
        if (clienteFrecuente == null) {
            throw new NegocioException("El cliente no puede ser nulo.");
        }
        if (clienteFrecuente.getNombre() == null || clienteFrecuente.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre del cliente es obligatorio.");
        }
        if (clienteFrecuente.getTelefono() == null || clienteFrecuente.getTelefono().trim().isEmpty()) {
            throw new NegocioException("El teléfono es obligatorio.");
        }
        if (!clienteFrecuente.getTelefono().matches("\\d{10,15}")) {
            throw new NegocioException("El teléfono debe contener entre 10 y 15 dígitos.");
        }
    }

}
