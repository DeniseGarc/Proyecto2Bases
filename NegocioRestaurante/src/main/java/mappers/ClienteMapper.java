/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DTOs.ClienteDTO;
import DTOs.ClienteFrecuenteDTO;
import entidades.Cliente;
import entidades.ClienteFrecuente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maryr
 */
public class ClienteMapper {

    /**
     * Convierte una lista de entidades ClienteFrecuente a una lista de DTOs
     * ClienteFrecuenteDTO.
     * @param clientesFrecuentes Lista de entidades ClienteFrecuente.
     * @return Lista de DTOs ClienteFrecuenteDTO.
     */
    public static List<ClienteFrecuenteDTO> toDTOList(List<ClienteFrecuente> clientesFrecuentes) {
        List<ClienteFrecuenteDTO> clientesFrecuentesDTO = new ArrayList<>();
        for (ClienteFrecuente clienteFrecuente : clientesFrecuentes) {
            clientesFrecuentesDTO.add(
                    new ClienteFrecuenteDTO(
                            clienteFrecuente.getNombre(),
                            clienteFrecuente.getFechaRegistro(),
                            clienteFrecuente.getTelefono(),
                            clienteFrecuente.getCorreoElectronico(),
                            clienteFrecuente.getPuntosFidelidad(),
                            clienteFrecuente.getCantidadVisitas(),
                            clienteFrecuente.getGastoTotal()
                    )
            );
        }
        return clientesFrecuentesDTO;
    }

    /**
     * Convierte una entidad ClienteFrecuente a su DTO ClienteFrecuenteDTO.
     * @param clienteFrecuente Entidad ClienteFrecuente.
     * @return DTO ClienteFrecuenteDTO.
     */
    public static ClienteFrecuenteDTO toDTO(ClienteFrecuente clienteFrecuente) {
        return new ClienteFrecuenteDTO(
                clienteFrecuente.getNombre(),
                clienteFrecuente.getFechaRegistro(),
                clienteFrecuente.getTelefono(),
                clienteFrecuente.getCorreoElectronico(),
                clienteFrecuente.getPuntosFidelidad(),
                clienteFrecuente.getCantidadVisitas(),
                clienteFrecuente.getGastoTotal()
        );
    }

    /**
     * Convierte un DTO ClienteFrecuenteDTO a su entidad ClienteFrecuente.
     * @param clienteFrecuenteDTO DTO ClienteFrecuenteDTO.
     * @return Entidad ClienteFrecuente.
     */
    public static ClienteFrecuente toEntity(ClienteFrecuenteDTO clienteFrecuenteDTO) {
        ClienteFrecuente clienteFrecuente = new ClienteFrecuente();
        clienteFrecuente.setNombre(clienteFrecuenteDTO.getNombre());
        clienteFrecuente.setTelefono(clienteFrecuenteDTO.getTelefono());
        clienteFrecuente.setCorreoElectronico(clienteFrecuenteDTO.getCorreoElectronico());
        clienteFrecuente.setFechaRegistro(clienteFrecuenteDTO.getFechaRegistro());
        clienteFrecuente.setCantidadVisitas(clienteFrecuenteDTO.getCantidadVisitas());
        clienteFrecuente.setGastoTotal(clienteFrecuenteDTO.getGastoTotal());
        clienteFrecuente.setPuntosFidelidad(clienteFrecuenteDTO.getPuntosFidelidad());
        return clienteFrecuente;
    }
}
