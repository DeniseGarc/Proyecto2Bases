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
 *
 * @author erika
 */
public class ComandaMapper {

    public static List<ComandaDTO> toDtoList(List<Comanda> comandasEntidad) {
        List<ComandaDTO> comandasDTO = new ArrayList<>();
        for (Comanda comanda : comandasEntidad) {
            comandasDTO.add(toDTO(comanda));
        }
        return comandasDTO;
    }

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
