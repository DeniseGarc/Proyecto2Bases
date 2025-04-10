/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ComandaDTO;
import entidades.Comanda;
import enumeradores.Estado;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IComandaBO;
import interfaces.IComandaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.ComandaMapper;

/**
 *
 * @author erika
 */
public class ComandaBO implements IComandaBO {

    private IComandaDAO comandaDAO;

    public ComandaBO(IComandaDAO comandaDAO) {
        this.comandaDAO = comandaDAO;
    }

    /**
     * Metodo para obtener todas las comandas guardadas en la base de datos
     *
     * @return Lista de comandas
     * @throws NegocioException
     */
    @Override
    public List<ComandaDTO> obtenerComandas() throws NegocioException {
        try {
            List<Comanda> comandas = comandaDAO.obtenerComandas();
            return ComandaMapper.toDtoList(comandas);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener las comandas");
        }
    }

    /**
     * Regresa la comandas activas
     *
     * @return Lista de comandas
     * @throws NegocioException
     */
    @Override
    public List<ComandaDTO> obtenerComandasActivas() throws NegocioException {
        try {
            List<Comanda> comandas = comandaDAO.obtenerComandasActivas();
            return ComandaMapper.toDtoList(comandas);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener las comandas Activas");
        }
    }

    @Override
    public boolean actualizarComanda(ComandaDTO comandaActualizar) throws NegocioException {
        if (comandaActualizar == null) {
            throw new NegocioException("La comanda a actualizar es nula");
        }
        try {
            Comanda comanda = ComandaMapper.toEntity(comandaActualizar);
            return comandaDAO.actualizarComanda(comanda);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComandaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ocurrió un error al actualizar la comanda");
        }
    }

    @Override
    public boolean agregarComanda(ComandaDTO comandaNueva) throws NegocioException {
        if (comandaNueva == null) {
            throw new NegocioException("La comanda a registrar es nula");
        }
        try {
            Comanda comanda = ComandaMapper.toEntity(comandaNueva);
            return comandaDAO.registrarComanda(comanda);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComandaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ocurrió un error al registrar la comanda");
        }
    }
    /**
     * Metodo para actualizar el estado de las comandas
     * @param comanda Comanda a actualizar
     * @param nuevoEstado Esrado al que se va a actualizar la comanda
     * @return True si la comanda se actualizo correctamente
     * @throws NegocioException 
     */
    @Override
    public boolean actualizarEstadoComanda(ComandaDTO comanda, Estado nuevoEstado) throws NegocioException {
        try {
            if (comanda == null) {
                throw new NegocioException("La comandaDTO no puede ser nula");
            }
            if (nuevoEstado == null) {
                throw new NegocioException("El nuevo estado no puede ser nulo");
            }

            // Convertir el DTO a entidad Comanda utilizando el Mapper
            Comanda comandaEntidad = ComandaMapper.toEntity(comanda);
            
            // Llamar al DAO para actualizar el estado
            return comandaDAO.actualizarEstadoComanda(comandaEntidad, nuevoEstado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el estado de la comanda: " + e.getMessage(), e);
        }
    }



}
