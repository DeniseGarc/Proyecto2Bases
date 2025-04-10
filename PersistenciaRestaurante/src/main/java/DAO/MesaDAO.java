
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.Mesa;
import exception.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Maryr
 */
public class MesaDAO implements IMesaDAO {

    private static MesaDAO instanciaMesaDAO;

    public MesaDAO() {
    }

    public static MesaDAO getInstanciaDAO() {
        if (instanciaMesaDAO == null) {
            instanciaMesaDAO = new MesaDAO();
        }
        return instanciaMesaDAO;
    }

    /**
     * Método para insertar las mesa del restaurante
     *
     * @throws PersistenciaException
     */
    @Override
    public void insertarMesas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            for (int i = 0; i < 20; i++) {
                em.getTransaction().begin();
                em.persist(new Mesa(true));
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron insertar las mesas: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Método para verificar si las mesas ya fueron insertadas
     *
     * @return true si ya estan en la base de datos, false en caso contrario
     * @throws PersistenciaException
     */
    @Override
    public boolean consultarMesas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Long count = em.createQuery("SELECT COUNT(m) FROM Mesa m", Long.class).getSingleResult();
            return count >= 20;
        } catch (Exception e) {
            throw new PersistenciaException("Hubo un error al consultar las mesas: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    /**
     * Métod para recuperar una lista con las mesas disponibles
     * @return 
     * @throws PersistenciaException 
     */
    @Override
    public List<Mesa> obtenerMesas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT m FROM Mesa m WHERE m.estado = 1", Mesa.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Hubo un error al consultar las mesas: ", e);
        } finally {
            em.close();
        }
    }

}