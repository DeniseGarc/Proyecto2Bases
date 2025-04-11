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
 *
 * @author Maryr
 */
public interface IComandaBO {

    public List<ComandaDTO> obtenerComandas() throws NegocioException;

    public List<ComandaDTO> obtenerComandasActivas() throws NegocioException;

    public boolean actualizarComanda(ComandaDTO comandaActualizar) throws NegocioException;

    public boolean agregarComanda(ComandaDTO comandaNueva) throws NegocioException;

    public boolean actualizarEstadoComanda(ComandaDTO comanda, Estado nuevoEstado) throws NegocioException;

    public List<DetalleReporteComandaDTO> obtenerDetallesReporteComanda(Periodo periodo) throws NegocioException;
}
