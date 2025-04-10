/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.ClienteFrecuente;
import entidades.Comanda;
import enumeradores.Estado;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Maryr
 */
public interface IComandaDAO {

    public List<Comanda> obtenerComandasPorCliente(ClienteFrecuente clienteFrecuente) throws PersistenciaException;

    public List<Comanda> obtenerComandas() throws PersistenciaException;

    public List<Comanda> obtenerComandasActivas() throws PersistenciaException;

    public boolean registrarComanda(Comanda comandaNueva) throws PersistenciaException;

    public boolean actualizarComanda(Comanda comanda) throws PersistenciaException;
    
    public boolean actualizarEstadoComanda(Comanda comanda, Estado nuevoEstado) throws PersistenciaException;
}
