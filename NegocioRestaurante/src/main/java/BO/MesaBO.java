/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.MesaDTO;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IMesaBO;
import interfaces.IMesaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.MesaMapper;

/**
 * Clase que implementa la lógica de negocio para operaciones relacionadas con
 * Mesa
 *
 * @author Maryr
 */
public class MesaBO implements IMesaBO {

    private IMesaDAO mesaDAO;

    public MesaBO() {
    }

    /**
     * Constructor que inicializa la dependencia dao necesaria
     *
     * @param mesaDAO implementacion de IMesaDAO para acceso de datos de mesas
     */
    public MesaBO(IMesaDAO mesaDAO) {
        this.mesaDAO = mesaDAO;
    }

    /**
     * Método para insertar las mesas en la base de datos. Llama al DAO para
     * insertar las mesas.
     *
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public void insertarMesas() throws NegocioException {
        try {
            mesaDAO.insertarMesas();
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudieron insertar las mesas: ", e);
        }
    }

    /**
     * Método para verificar si las mesas ya estan insertadas.
     *
     * @return true si las mesas ya están insertadas, false si no.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public boolean consultarMesas() throws NegocioException {
        try {
            return mesaDAO.consultarMesas();
        } catch (PersistenciaException e) {
            throw new NegocioException("Hubo un error al consultar las mesas: ", e);
        }
    }

    /**
     * Metodo para obtener las mesas disponibles
     *
     * @return Lista de mesasDTO disponibles
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<MesaDTO> obtenerMesas() throws NegocioException {
        try {
            return MesaMapper.ToDTOList(mesaDAO.obtenerMesas());
        } catch (PersistenciaException e) {
            throw new NegocioException("Ha ocurrido un error al obtener las mesas: ", e);
        }
    }

    /**
     * Método para actualizar el estado de la mesa
     *
     * @param idMesa id de la mesa a ser actualizada
     * @param estado estado al que se declarará
     * @throws NegocioException Si ocurre un error
     */
    @Override
    public void actualizarEstadoMesa(Long idMesa, boolean estado) throws NegocioException {
        try {
            mesaDAO.actualizarEstadoMesa(idMesa, estado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Hubo un error al actualizar el estado de la mesa: ", e);
        }
    }
}
