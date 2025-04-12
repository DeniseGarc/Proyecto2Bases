/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.ClienteFrecuenteDTO;
import DTOs.ReporteClienteDTO;
import exception.NegocioException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Maryr
 */
public interface IClienteFrecuenteBO {

    /**
     * Registra a un nuevo cliente frecuente en la base de datos
     *
     * @param clienteFrecuente el cual será registrado
     * @return el cliente que fue registrado
     * @throws NegocioException
     */
    public ClienteFrecuenteDTO registrarNuevoClienteFrecuente(ClienteFrecuenteDTO clienteFrecuente) throws NegocioException;

    /**
     * obtiene una lista de clientes dependiendo del filtro y dato que se le da
     *
     * @param filtro por el cual se realizará la busqueda
     * @param dato por el que se buscara
     * @return la lista de clientes que coincidan con el dato
     * @throws NegocioException
     */
    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentes(String filtro, String dato) throws NegocioException;

    /**
     * desencripta el telefono que se le de
     *
     * @param telefono el cual será desencriptado
     * @return el telefono en su forma desencriptada
     * @throws NegocioException
     */
    public String desencriptarTelefono(String telefono) throws NegocioException;

    /**
     * Obtiene un cliente que esté asociado al id
     *
     * @param id por el cual se buscará el cliente
     * @return el cliente asociado al id
     * @throws NegocioException
     */
    public ClienteFrecuenteDTO obtenerClientePorId(Long id) throws NegocioException;

    /**
     * Obtiene los clientes filtrados por el minimo de visitas para generar el
     * reporte de clientes.
     *
     * @param numVisitas Numero de minimo de visitas que deben tener los
     * clientes.
     * @return Lista de clientes con sus datos para realizar el reporte
     * @throws NegocioException Si ocurre un error al obtener el cliente y sus
     * datos.
     */
    public List<ReporteClienteDTO> obtenerClientesPorVisitas(int numVisitas) throws NegocioException;

}
