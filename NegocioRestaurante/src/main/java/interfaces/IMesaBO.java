/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.MesaDTO;
import exception.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones de lógica de negocio para la gestión de
 * mesas
 *
 * @author Maryr
 */
public interface IMesaBO {

    /**
     * Metodo que Inserta 20 mesas directamente a la base de datos
     *
     * @throws exception.NegocioException Si ocurre algun error al insertar las
     * mesas
     */
    public void insertarMesas() throws NegocioException;

    /**
     * Método para verificar si las mesas ya fueron insertadas
     *
     * @return Lista de mesas disponibles
     * @throws NegocioException Si ocurre un error al consultar las mesas
     */
    public boolean consultarMesas() throws NegocioException;

    /**
     * Metodo para obtener las mesas disponibles
     *
     * @return Lista de mesasDTO
     * @throws NegocioException
     */
    public List<MesaDTO> obtenerMesas() throws NegocioException;

    /**
     * Método para actualizar el estado de la mesa
     *
     * @param idMesa id de la mesa a ser actualizada
     * @param estado estado al que se declarará
     * @throws NegocioException Si ocurre un error
     */
    public void actualizarEstadoMesa(Long idMesa, boolean estado) throws NegocioException;
}
