
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Mesa;
import exception.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Mesa
 *
 * @author Maryr
 */
public interface IMesaDAO {

    /**
     * Metodo que Inserta 20 mesas directamente a la base de datos
     *
     * @throws PersistenciaException Si ocurre un error al insertar las mesas
     */
    public void insertarMesas() throws PersistenciaException;

    /**
     * Método para verificar si las mesas ya fueron insertadas
     *
     * @return true si las mesas ya estan en la base de datos
     * @throws PersistenciaException Si ocurre un error al consultar las mesas
     */
    public boolean consultarMesas() throws PersistenciaException;

    /**
     * Metodo para recuperar una lista con las mesas disponibles
     *
     * @return Lista de mesas disponibles
     * @throws PersistenciaException Si ocurre un error al consultar las mesas
     * disponibles
     */
    public List<Mesa> obtenerMesas() throws PersistenciaException;

    /**
     * Metodo para obtener una mesa buscandola por su numero
     *
     * @param numero Numero de la mesa a buscar
     * @return Mesa con el numero indicado
     * @throws PersistenciaException Si ocurre un error al consultar la mesa
     */
    public Mesa obtenerMesaPorNumero(Long numero) throws PersistenciaException;

    /**
     * Método para actualizar el estado de la mesa
     *
     * @param idMesa id de la mesa a ser actualizada
     * @param estado estado al que se declarará
     * @throws PersistenciaException Si ocurre un error
     */
    public void actualizarEstadoMesa(Long idMesa, boolean estado) throws PersistenciaException;
}
