/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.ComandaDTO;
import DTOs.DetalleReporteComandaDTO;
import enumeradores.Estado;
import exception.NegocioException;
import extras.Periodo;
import java.util.List;

/**
 *Interfaz que define las operaciones de lógica de negocio para la gestión de comandas
 * @author Maryr
 */
public interface IComandaBO {
    /**
     * Metodo para obtener todas las comandas registradas en la base de datos
     * @return Lista de comandasDTO registradas
     * @throws NegocioException Si ocurre algun error al obtener las comandas
     */
    public List<ComandaDTO> obtenerComandas() throws NegocioException;
    /**
     * Metodo para obtener las comandas cuyo estado sea ACTIVA
     * @return Lista de comandas DTO activas
     * @throws NegocioException Si ocutrre algun error al obtener las comandas
     */
    public List<ComandaDTO> obtenerComandasActivas() throws NegocioException;
    /**
     * Metodo para actualizar una comanda previamente registrada 
     * @param comandaActualizar comanda a actualizar
     * @return True si la comanda se actualizo exitosamente
     * @throws NegocioException Si ocurre algun error al actualizar la comanda
     */
    public boolean actualizarComanda(ComandaDTO comandaActualizar) throws NegocioException;
    /**
     * Metodo para agregar una comanda nueva a la base de datos
     * @param comandaNueva Comanda a registrar
     * @return True si la comanda se guardo exitosamente
     * @throws NegocioException Si ocurre algun error al guardar la comanda
     */
    public boolean agregarComanda(ComandaDTO comandaNueva) throws NegocioException;
    /**
     * Metodo para actualizar el estado de la comanda
     * @param comanda Comanda a actualizar
     * @param nuevoEstado Estado al que se va a actualizar
     * @return True si se actualizo el estado correctamente
     * @throws NegocioException  Si ocurre algun error al actualizar el estado de la comanda
     */
    public boolean actualizarEstadoComanda(ComandaDTO comanda, Estado nuevoEstado) throws NegocioException;
    /**
     * Método para obtener el DTO de las comandas para generar el reporte de comandas
     * @param periodo Periodo del cual se van a obtener las comandas para el reporte
     * @return Lista de comandas y sus detalles necesarios para generar el reporte
     * @throws NegocioException si ocurre algun error al intentar obtener los datos
     */
    public List<DetalleReporteComandaDTO> obtenerDetallesReporteComanda(Periodo periodo) throws NegocioException;
}
