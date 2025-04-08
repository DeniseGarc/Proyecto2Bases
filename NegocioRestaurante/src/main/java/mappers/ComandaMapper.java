/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DTOs.ComandaDTO;
import entidades.Comanda;
import enumeradores.Estado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erika
 */
public class ComandaMapper {
    public static List<ComandaDTO> toDtoList(List<Comanda> comandasEntidad){
        List<ComandaDTO> comandasDTO = new ArrayList<>();
        for(Comanda comanda : comandasEntidad){
            comandasDTO.add(new ComandaDTO(comanda.getFechaHora(), comanda.getTotalVenta(),comanda.getEstado()));
        }return comandasDTO;
    }
    
    public static ComandaDTO toDTO(Comanda comandaEntidad){
        ComandaDTO comandaDTO = new ComandaDTO(comandaEntidad.getFechaHora(), comandaEntidad.getTotalVenta(), comandaEntidad.getEstado());
        return comandaDTO;
    }
    
    public static Comanda toEntity (ComandaDTO comandaDTO){
        Comanda comandaEntidad = new Comanda(comandaDTO.getFechaHora(), comandaDTO.getTotalVenta(), comandaDTO.getEstado());
        return comandaEntidad;
    }
}
