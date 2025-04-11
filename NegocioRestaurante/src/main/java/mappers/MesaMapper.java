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
 *Clase que se utiliza para mapear entre entidades Mesa y sus respectivos
 * DTOs.
 * @author Maryr
 */
public class MesaMapper {
    /**
     * Convierte una lista de entidades Producto a una lista de ProductoDTO
     *
     * @param mesas Lista de entidades Producto a convertir.
     * @return Lista de ProductoDTO equivalentes.
     */
    public static List<MesaDTO> ToDTOList(List<Mesa> mesas) {
        List<MesaDTO> mesaDTO = new ArrayList<>();
        for(Mesa mesa : mesas) {
            mesaDTO.add(new MesaDTO(mesa.getNumero().toString(), mesa.getEstado()));
        }
        return mesaDTO;
    }
    /**
     * Metodo que convierte Mesa a mesaDTO con todos sus atributos
     * @param mesa Mesa a convertir
     * @return MesaDTO con los datos
     */
    public static MesaDTO toDTO(Mesa mesa) {
        MesaDTO mesaDTO = new MesaDTO(mesa.getNumero().toString(), mesa.getEstado());
        return mesaDTO;
    }
    /**
     * Convierte una Entidad mesa a MesaDTO
     * @param mesaDTO MesaDTO a convertir
     * @return mesa entidad con los datos
     */
    public static Mesa toEntity(MesaDTO mesaDTO) {
       Long numero = Long.valueOf(mesaDTO.getNumero());
        return new Mesa(numero, mesaDTO.getEstado());
    }
}
