/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.DetalleReporteComandaDTO;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import enumeradores.Estado;
import exception.PersistenciaException;
import extras.Periodo;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Comanda
 *
 * @author Maryr
 */
public interface IComandaDAO {

    /**
     * Obtiene todas las comandas asociadas a un cliente frecuente en especifico
     *
     * @param clienteFrecuente Cliente del que se quieren recuperar las comanda
     * @return Lista de comandas asociadas al cliente
     * @throws PersistenciaException Si ocurre un error al consultar las
     * comandas
     */
    public List<Comanda> obtenerComandasPorCliente(ClienteFrecuente clienteFrecuente) throws PersistenciaException;

    /**
     * Obtiene la fecha de la ultima comanda hecha por el cliente dado
     *
     * @param clienteF cliente del cual se requiere la fecha
     * @return la fecha de la ultima comanda del cliente
     * @throws PersistenciaException
     */
    public Calendar obtenerFechaUltimaComandaCliente(ClienteFrecuente clienteF) throws PersistenciaException;

    /**
     * Metodo para obtener todas las comandas de la base de datos
     *
     * @return Lista de todas las comandas en la base de datos
     * @throws PersistenciaException Si ocurre un error al consultar las
     * comandas
     */
    public List<Comanda> obtenerComandas() throws PersistenciaException;

    /**
     * Metodo para obtener todas las comandas de la base de datos cuyo estado
     * sea activas
     *
     * @return Lista de comandas con estado ACTIVA
     * @throws PersistenciaException Si ocurre algun error al consultar las
     * comandas
     */
    public List<Comanda> obtenerComandasActivas() throws PersistenciaException;

    /**
     * Metodo para registrar una nueva comanda en la base de datos
     *
     * @param comandaNueva Comanda a registrar
     * @return True si se registro la comanda exitosamente
     * @throws PersistenciaException Si ocurre algun error al registrar la
     * comanda
     */
    public boolean registrarComanda(Comanda comandaNueva) throws PersistenciaException;

    /**
     * Actualiza una comanda ya existente en la base de datos
     *
     * @param comanda Comanda a actualizar
     * @return True si se actualizo exitosamente
     * @throws PersistenciaException Si ocurre algun error al actualizar la
     * comanda
     */
    public boolean actualizarComanda(Comanda comanda) throws PersistenciaException;

    /**
     * Metodo para actualizar el estado de una comanda registrada
     *
     * @param comanda COmanda a actualizar
     * @param nuevoEstado Nuevo estado a registrar
     * @return True si se actualizo el estado exitosamente
     * @throws PersistenciaException Si ocurre un error al actualizar la comanda
     */
    public boolean actualizarEstadoComanda(Comanda comanda, Estado nuevoEstado) throws PersistenciaException;

    /**
     * Método para obtener la lista de detalles del reporte de comandas del
     * periodo seleccionado
     *
     * @param periodo Periodo del cual se va a obtener el reporte de comandas
     * @return Lista de DetalleReporteComandaDTO de los detalles del reporte
     * generado
     * @throws PersistenciaException Si sucede un error al consultar los datos
     */
    public List<DetalleReporteComandaDTO> generarReporteComandas(Periodo periodo) throws PersistenciaException;

    /**
     * Método para obtener la fecha de la primera comanda registrada
     *
     * @return Calendar con la fecha y hora de la primer comanda
     * @throws PersistenciaException Si es que ocurre un error de acceso a datos
     */
    public Calendar obtenerFechaPrimerComanda() throws PersistenciaException;

    /**
     * Método para obtener la fecha de la última comanda registrada
     *
     * @return Calendar con la fecha y hora de la ultima comanda registrada
     * @throws PersistenciaException Si es que ocurre un error de acceso a datos
     */
    public Calendar obtenerFechaUltimaComanda() throws PersistenciaException;

}
