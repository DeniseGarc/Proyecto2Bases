/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import exception.PersistenciaException;
import interfaces.IClienteFrecuenteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Maryr
 */
public class ClienteFrecuenteDAO implements IClienteFrecuenteDAO {

    private static ClienteFrecuenteDAO instanciaClienteFrecuenteDAO;

    private ClienteFrecuenteDAO() {
    }

    public static ClienteFrecuenteDAO getInstanciaDAO() {
        if (instanciaClienteFrecuenteDAO == null) {
            instanciaClienteFrecuenteDAO = new ClienteFrecuenteDAO();
        }
        return instanciaClienteFrecuenteDAO;
    }

    /**
     * Método para registrar un nuevo cliente frecuente.
     *
     * @param clienteFrecuente El cliente frecuente que será registrado.
     * @return El cliente frecuente registrado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    @Override
    public ClienteFrecuente registrarNuevoClienteFrecuente(ClienteFrecuente clienteFrecuente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(clienteFrecuente);
            em.getTransaction().commit();
            return clienteFrecuente;
        } catch (Exception e) {
            throw new PersistenciaException("Error al registrar cliente frecuente: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Método para obtener una lista de todos los clientes frecuentes.
     *
     * @return Lista de clientes frecuentes.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    @Override
    public List<ClienteFrecuente> obtenerClientesFrecuentes() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        ComandaDAO comandaDAO = ComandaDAO.getInstanciaDAO();
        try {
            List<ClienteFrecuente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE TYPE(c) = ClienteFrecuente", ClienteFrecuente.class)
                    .getResultList();
            for (ClienteFrecuente cliente : clientes) {
                List<Comanda> comandas = comandaDAO.obtenerComandasPorCliente(cliente);
                cliente.setPuntosFidelidad(cliente.calcularPuntosFidelidad(comandas));
                cliente.setCantidadVisitas(cliente.calcularCantidadVisitas(comandas));
                cliente.setGastoTotal(cliente.calcularGastoTotal(comandas));
            }
            return clientes;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener clientes frecuentes: ", e);
        } finally {
            em.close();
        }
    }

}
