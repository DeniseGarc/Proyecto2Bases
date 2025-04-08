/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.Ingrediente;
import enumeradores.UnidadMedida;
import exception.PersistenciaException;
import interfaces.IIngredienteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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
            return em.createQuery("SELECT i FROM Ingrediente i WHERE LOWER(i.nombre) LIKE :nombre", Ingrediente.class)
                    .setParameter("nombre", "%" + nombre.toLowerCase() + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar ingredientes por nombre: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza el stock 
     * @param id del ingrediente a modificar
     * @param stock
     * @return ingrediente con stock modificado
     * @throws PersistenciaException 
     */
    @Override
    public Ingrediente modificarStock(Ingrediente ingrediente) throws PersistenciaException {
    EntityManager em = Conexion.crearConexion();
    try {
        Ingrediente existente = em.find(Ingrediente.class, ingrediente.getId());
        if (existente == null) {
            throw new PersistenciaException("Ingrediente no encontrado con ID: " + ingrediente.getId());
        }
        existente.setStock(ingrediente.getStock());
        
        em.getTransaction().begin();
        em.merge(existente);
        em.getTransaction().commit();

        return existente;

    } catch (PersistenciaException e) {
        throw new PersistenciaException("Error al modificar el stock del ingrediente", e);
    } finally {
        em.close();
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
    public List<Ingrediente> buscarIngredientesPorUnidadMedida(UnidadMedida unidad) throws PersistenciaException {
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
/**
 * Busca el ingrediente con el id dado
 * @param id del ingrediente a buscar
 * @return ingrediente
 * @throws PersistenciaException 
 */
    @Override
    public Ingrediente buscarIngredientePorId(Long id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            // Realizar la consulta para buscar el ingrediente por ID
            return em.createQuery(
                    "SELECT i FROM Ingrediente i WHERE i.id = :id", Ingrediente.class
            )
            .setParameter("id", id)
            .getSingleResult();
        } catch (NoResultException e) {
            
            throw new PersistenciaException("No se encontró un ingrediente con el ID: " + id, e);
        } catch (Exception e) {
            
            throw new PersistenciaException("Error al buscar el ingrediente por ID.", e);
        } finally {
            em.close(); 
        }
    }
/**
 * Muestra los ingredientes que no estan asociados a ningun producto
 * @return
 * @throws PersistenciaException 
 */
    @Override
    public List<Ingrediente> obtenerIngredientesSinProducto() throws PersistenciaException {
       EntityManager em = Conexion.crearConexion();
    try {
        return em.createQuery(
            "SELECT i FROM Ingrediente i WHERE i.detallesProducto IS EMPTY", Ingrediente.class
        ).getResultList();
    } catch (Exception e) {
        throw new PersistenciaException("Error al consultar ingredientes sin producto: ", e);
    } finally {
        em.close();
    }
    }
/**
 * Busca un ingrediente por nombre y unidad de medida
 * @param nombre
 * @param unidad
 * @return ingrediente
 * @throws PersistenciaException 
 */
    @Override
    public List<Ingrediente> buscarPorNombreYUnidad(String nombre, String unidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion(); 
        try {
            UnidadMedida unidadEnum = UnidadMedida.valueOf(unidad);  // Validamos aquí

            return em.createQuery(
                "SELECT i FROM Ingrediente i WHERE LOWER(i.nombre) LIKE :nombre AND i.unidadMedida = :unidadMedida",
                Ingrediente.class
            )
            .setParameter("nombre", "%" + nombre.toLowerCase() + "%")
            .setParameter("unidadMedida", unidadEnum)
            .getResultList();

        } catch (IllegalArgumentException e) {
            throw new PersistenciaException("Unidad de medida inválida: " + unidad, e);
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el ingrediente por nombre y unidad.", e);
        } finally {
            em.close(); 
        }
    }


    @Override
    public Ingrediente buscarPorNombreYUnidad1(String nombre, String unidad) throws PersistenciaException {
         EntityManager em = Conexion.crearConexion(); 
        try {

            return em.createQuery(
                    "SELECT i FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidadMedida",
                    Ingrediente.class
            )
            .setParameter("nombre", nombre)
            .setParameter("unidadMedida", UnidadMedida.valueOf(unidad)) 
            .getSingleResult();
        } catch (NoResultException e) {
            throw new PersistenciaException("No se encontró un ingrediente con el nombre '" + nombre + "' y la unidad '" + unidad + "'.", e);
        } catch (IllegalArgumentException e) {
            throw new PersistenciaException("Unidad de medida inválida: " + unidad, e);
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el ingrediente por nombre y unidad.", e);
        } finally {
            em.close(); 
        }
        
    }
    
}
