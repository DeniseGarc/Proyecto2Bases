/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DTOs.MesaDTO;
import entidades.Mesa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maryr
 */
public class MesaMapper {
    public static List<MesaDTO> ToDTOList(List<Mesa> mesas) {
        List<MesaDTO> mesaDTO = new ArrayList<>();
        for(Mesa mesa : mesas) {
            mesaDTO.add(new MesaDTO(mesa.getNumero().toString(), mesa.getEstado()));
        }
        return mesaDTO;
    }
    
    public static MesaDTO toDTO(Mesa mesa) {
        MesaDTO mesaDTO = new MesaDTO(mesa.getNumero().toString(), mesa.getEstado());
        return mesaDTO;
    }
    
    public static Mesa toEntity(MesaDTO mesaDTO) {
       Long numero = Long.valueOf(mesaDTO.getNumero());
        return new Mesa(numero, mesaDTO.getEstado());
    }
}
