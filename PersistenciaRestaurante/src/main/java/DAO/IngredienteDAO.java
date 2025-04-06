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
    public Ingrediente modificarStock(Long id,int stock) throws PersistenciaException {
         EntityManager em = Conexion.crearConexion();
         try {
        Ingrediente ingrediente = em.find(Ingrediente.class, id);
        if (ingrediente == null) {
            throw new PersistenciaException("Ingrediente no encontrado con ID: " + id);
        }
        ingrediente.setStock(stock);
        em.merge(ingrediente);
        return ingrediente;
    } catch (Exception e) {
        throw new PersistenciaException("Error al modificar el stock del ingrediente", e);
    }
    }

    
    /**
     * Elimina el ingrediente si este no esta asociado a un producto
     * @param id del producto a eliminar
     * @return verdadero si el producto se pudo eliminar
     * @throws PersistenciaException 
     */
    @Override
    public boolean eliminarIngrediente(Long id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Ingrediente ingrediente = em.find(Ingrediente.class, id);
            
            if (ingrediente != null) {
                if(ingrediente.getDetallesProducto().isEmpty()){
                    em.getTransaction().begin();
                    em.remove(ingrediente);
                    em.getTransaction().commit();
                }else{
                    throw new PersistenciaException("El ingrediente con ID " + id + " tiene productos asociados.");
                }
                return true;
            } else {
                throw new PersistenciaException("El ingrediente con ID " + id + " no existe.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar la clase: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    /**
     * Guarda el ingediente en la base de datos
     * @param ingredienteGuardar ingrediente a guardar
     * @return ingrediente
     * @throws PersistenciaException 
     */
    @Override
    public Ingrediente guardarIngredinete(Ingrediente ingredienteGuardar) throws PersistenciaException {
         EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(ingredienteGuardar);
            em.getTransaction().commit();
            return ingredienteGuardar;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar el ingrediente: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    /**
     * Busca los ingrecdientes con la unidad de medida dada
     * @param unidad de medida
     * @return lista de ingredientes 
     * @throws PersistenciaException 
     */
    @Override
    public List<Ingrediente> buscarIngredientesPorUnidadMedida(String unidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.unidadMedida = :unidad ", Ingrediente.class)
                    .setParameter("unidad", unidad).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar ingredientes por unidad de medida: ", e);
        } finally {
            em.close();
        }
    } 

    @Override
    public Ingrediente buscarIngredientePorId(Long id) throws PersistenciaException {
         EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.id = :id ", Ingrediente.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar ingredientes por unidad de medida: ", e);
        } finally {
            em.close();
        }
    }
    
}
