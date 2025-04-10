/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DAO.MesaDAO;
import DTOs.ComandaDTO;
import entidades.Comanda;
import entidades.Mesa;
import enumeradores.Estado;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erika
 */
public class ComandaMapper {
   
    public static List<ComandaDTO> toDtoList(List<Comanda> comandasEntidad){
        List<ComandaDTO> comandasDTO = new ArrayList<>();
        for(Comanda comanda : comandasEntidad){
            comandasDTO.add(new ComandaDTO(comanda.getId(),comanda.getFechaHora(), comanda.getTotalVenta(),comanda.getEstado(),comanda.getCliente().getNombre(),comanda.getCliente().getTelefono(),comanda.getMesa().getNumero().toString()));
        }return comandasDTO;
    }
    
    public static ComandaDTO toDTO(Comanda comandaEntidad){
        ComandaDTO comandaDTO = new ComandaDTO(comandaEntidad.getId(),comandaEntidad.getFechaHora(), comandaEntidad.getTotalVenta(), comandaEntidad.getEstado(),comandaEntidad.getMesa().getNumero().toString());
        return comandaDTO;
    }
    
    public static Comanda toEntity (ComandaDTO comandaDTO){

        try {
            Comanda comandaEntidad = new Comanda();
            comandaEntidad.setId(comandaDTO.getId());
            comandaEntidad.setFechaHora(comandaDTO.getFechaHora());
            comandaEntidad.setTotalVenta(comandaDTO.getTotalVenta());
            comandaEntidad.setEstado(comandaDTO.getEstado());
            MesaDAO mesaDAO = new MesaDAO();
            // Obtener la mesa utilizando el método del DAO
            Long numero = Long.valueOf(comandaDTO.getNumeroMesa());
            Mesa mesa = mesaDAO.obtenerMesaPorNumero(numero); // Llamada al método DAO
            comandaEntidad.setMesa(mesa);
            return comandaEntidad;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComandaMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
