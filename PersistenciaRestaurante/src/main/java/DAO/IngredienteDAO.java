/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.Ingrediente;
import exception.PersistenciaException;
import interfaces.IIngredienteDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author erika
 */
public class IngredienteDAO implements IIngredienteDAO {
    private static IngredienteDAO instanceIngredienteDAO;

    public IngredienteDAO() {
    }
    
    public static IngredienteDAO getInstanceDAO(){
        if(instanceIngredienteDAO==null){
            instanceIngredienteDAO = new IngredienteDAO();
        }return instanceIngredienteDAO;
    }
    /**
     * metodo para recuperar una lista con los ingredientes registrados en la base de datos 
     * @return Lista de Ingredientes  
     * @throws PersistenciaException 
     */
    @Override
    public List<Ingrediente> obtenerIngredientes() throws PersistenciaException {
       EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar ingredientes registrados: ", e);
        } finally {
            em.close();
        }}

    /**
     * metodo para recuperar un ingredientes por su nombre 
     * @param nombre lista de ingredientes 
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public List<Ingrediente> buscarIngredientePorNombre(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.nombre = :nombre ", Ingrediente.class)
                    .setParameter("nombre", nombre).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar ingredientes por nombre: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Ingrediente aumentarStock(int stock) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ingrediente reducirStock(int stock) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ingrediente eliminarIngrediente(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
