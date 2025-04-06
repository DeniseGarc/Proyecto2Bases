/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import exception.PersistenciaException;
import interfaces.IComandaDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Maryr
 */
public class ComandaDAO implements IComandaDAO{
    
    public static ComandaDAO instanciaComandaDAO;

    public ComandaDAO() {
    }
    
    public static ComandaDAO getInstanciaDAO() {
        if(instanciaComandaDAO == null) {
            instanciaComandaDAO = new ComandaDAO();
        }
        return instanciaComandaDAO;
    }

    /**
     * Método para obtener una lista de comandas de un cliente especifico
     * @param clienteFrecuente del cual se requieren las comandas
     * @return la lista de comandas asociadas al cliente
     * @throws PersistenciaException 
     */
    @Override
    public List<Comanda> obtenerComandasPorCliente(ClienteFrecuente clienteFrecuente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Comanda c WHERE c.cliente = :cliente", Comanda.class)
                    .setParameter("cliente", clienteFrecuente)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar comandas por cliente: ", e);
        } finally {
            em.close();
        }
    }

}
