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

    @Override
    public void insertarMesas(List<Mesa> mesas) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            for (int i = 0; i < 20; i++) {
                em.persist(new Mesa(true));
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron insertar las mesas: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean consultarMesas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            int count = em.createQuery("SELECT COUNT(m) FROM Mesa m", int.class).getSingleResult();
            return count >= 20;
        } catch (Exception e) {
            throw new PersistenciaException("Hubo un error al consultar las mesas: ", e);
        } finally {
            em.close();
        }
    }

}
