/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import entidades.ClienteFrecuente;
import DTOs.ComandaDTO;
import DTOs.DetalleComandaDTO;
import entidades.Comanda;
import entidades.DetalleComanda;
import entidades.Mesa;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se utiliza para mapear entre entidades Comanda y sus respectivos
 * DTOs.
 * @author erika
 */
public class ComandaMapper {
    /**
     * Convierte una lista de Comandas a una lista de ComandasDTO
     * @param comandasEntidad Lista de entidades comanda a convertir
     * @return Lista de ComandaDTO equivalentes
     */
    public static List<ComandaDTO> toDtoList(List<Comanda> comandasEntidad) {
        List<ComandaDTO> comandasDTO = new ArrayList<>();
        for (Comanda comanda : comandasEntidad) {
            comandasDTO.add(toDTO(comanda));
        }
        return comandasDTO;
    }
    /**
     * Convierte una entidad comanda a comandaDTO
     * @param comandaEntidad Entidad comanda a convertir
     * @return ComandaDTO con la informacion del producto
     */
    public static ComandaDTO toDTO(Comanda comandaEntidad) {
        ComandaDTO comandaDTO = new ComandaDTO(
                comandaEntidad.getId(),
                comandaEntidad.getFechaHora(),
                comandaEntidad.getTotalVenta(),
                comandaEntidad.getEstado(),
                comandaEntidad.getCliente() != null ? comandaEntidad.getCliente().getId() : null,
                comandaEntidad.getCliente() != null ? comandaEntidad.getCliente().getNombre() : null,
                comandaEntidad.getMesa().getNumero().toString()
        );
        List<DetalleComandaDTO> detallesComandaDTO = new ArrayList<>();
        for (DetalleComanda detalleComanda : comandaEntidad.getDetallesComanda()) {
            detallesComandaDTO.add(
                    new DetalleComandaDTO(detalleComanda.getPrecioUnitario(),
                            detalleComanda.getCantidad(),
                            detalleComanda.getImporteTotal(),
                            detalleComanda.getNotas(),
                            detalleComanda.getProducto().getNombre()
                    )
            );
        }
        comandaDTO.setDetallesComanda(detallesComandaDTO);
        return comandaDTO;
    }
    /**
     * Convierte una ComandaDTO a entidad comanda 
     * @param comandaDTO Comanda a convertir
     * @param cliente cliente asociado a la comanda
     * @param mesa mesa asociada a la comanda
     * @return 
     */
    public static Comanda toEntity(ComandaDTO comandaDTO, ClienteFrecuente cliente, Mesa mesa) {
        Comanda comandaEntidad = new Comanda(
                comandaDTO.getId(),
                comandaDTO.getFechaHora(),
                comandaDTO.getTotalVenta(),
                comandaDTO.getEstado(),
                mesa,
                cliente);
        return comandaEntidad;
    }
}
