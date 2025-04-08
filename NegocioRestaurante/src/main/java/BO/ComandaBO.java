/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ComandaDTO;
import entidades.Comanda;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IComandaBO;
import interfaces.IComandaDAO;
import java.util.List;
import mappers.ComandaMapper;

/**
 *
 * @author erika
 */
public class ComandaBO implements IComandaBO{
    private IComandaDAO comandaDAO;
    
    public ComandaBO(IComandaDAO comandaDAO){
        this.comandaDAO = comandaDAO;
    }
    /**
     * Metodo para obtener todas las comandas guardadas en la base de datos
     * @return Lista de comandas 
     * @throws NegocioException 
     */
    @Override
    public List<ComandaDTO> obtenerComandas() throws NegocioException {
        try{
         List<Comanda> comandas = comandaDAO.obtenerComandas();
         return ComandaMapper.toDtoList(comandas);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener las comandas");
        }
    }
    /**
     * Regresa la comandas activas
     * @return Lista de comandas 
     * @throws NegocioException 
     */
    @Override
    public List<ComandaDTO> obtenerComandsActivas() throws NegocioException {
        try{
         List<Comanda> comandas = comandaDAO.obtenerComandsActivas();
         return ComandaMapper.toDtoList(comandas);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener las comandas Activas");
        }
    }
    
}
