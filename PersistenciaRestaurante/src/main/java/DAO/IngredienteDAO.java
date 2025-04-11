/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.DetalleProductoIngrediente;
import entidades.Ingrediente;
import entidades.Producto;
import enumeradores.UnidadMedida;
import exception.PersistenciaException;
import interfaces.IIngredienteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *Clase que implementa las operaciones de acceso a datos para la entidad
 * Producto, utilizando JPA para persistencia.
 * @author erika
 */
public class IngredienteDAO implements IIngredienteDAO {
    /**
     * Instancia única de la clase IngredienteDAO
     */
    private static IngredienteDAO instanceIngredienteDAO;
     /**
     * Constructor privado para aplicar el patrón Singleton
     */
    public IngredienteDAO() {
    }
    /**
     * Metodo que devuelve la instancia única de IngredienteDAO
     *
     * @return instancia única de IngredienteDAO
     */
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
     * @param ingrediente
     * @return ingrediente con stock modificado
     * @throws PersistenciaException 
     */
    @Override
    public Ingrediente modificarStock(Ingrediente ingrediente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            Ingrediente existente = em.find(Ingrediente.class, ingrediente.getId());
            if (existente == null) {
                throw new PersistenciaException("Ingrediente no encontrado con ID: " + ingrediente.getId());
            }

            existente.setStock(ingrediente.getStock());

            // Forzar carga de los detalles y productos relacionados
            existente.getDetallesProducto().size();
            for (DetalleProductoIngrediente dpi : existente.getDetallesProducto()) {
                dpi.getProducto().getDetallesProducto().size();
            }

            em.merge(existente);
            actualizarDisponibilidadProductosAfectados(existente, em);

            em.getTransaction().commit();
            return existente;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al modificar el stock del ingrediente", e);
        } finally {
            em.close();
        }
    }

    /**
     * Metodo privado para modificar la disponibilidad de los productos segun el stock de los ingredientes
     * @param ingrediente Ingrediente al que se le esta modificando el stock
     * @param em 
     */
    private void actualizarDisponibilidadProductosAfectados(Ingrediente ingrediente, EntityManager em) {
        for (DetalleProductoIngrediente dpi : ingrediente.getDetallesProducto()) {
            Producto producto = dpi.getProducto();
            boolean disponible = true;

            // Validamos si todos los ingredientes tienen suficiente stock
            for (DetalleProductoIngrediente det : producto.getDetallesProducto()) {
                Ingrediente ing = det.getIngrediente();
                int stockDisponible = ing.getStock();
                int cantidadNecesaria = det.getCantidad();

                if (stockDisponible < cantidadNecesaria) {
                    disponible = false;
                    break;
                }
            }

            // Solo actualizamos si hay un cambio
            if (producto.isDisponible() != disponible) {
                producto.setDisponible(true);
                em.merge(producto);
            }
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
 * Metodo que regresa un ingrediente al consular su nombre y unidad de medida
 * @param nombre Nombre del ingrediente a buscar
 * @param unidad Unidad de medida del ingrediente a buscar
 * @return Ingrediente filtrado
 * @throws PersistenciaException si ocurre algun error inesperado 
 */
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
/**
 * Metodo para buscar ingredientes con distintos filtros
 * @param nombre Nombre del ingrediente a buscar
 * @param unidadMedida Uniad de medida del ingrediente a buscar
 * @return Lista de ingredientes filtrados
 * @throws PersistenciaException 
 */
    @Override
    public List<Ingrediente> buscarConFiltros(String nombre, UnidadMedida unidadMedida) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT i FROM Ingrediente i "
                        + "WHERE (:nombre IS NULL OR LOWER(i.nombre) LIKE LOWER(:nombre)) "
                        + "AND (:unidadMedida IS NULL OR i.unidadMedida = :unidadMedida)";

            TypedQuery<Ingrediente> query = em.createQuery(jpql, Ingrediente.class);
            query.setParameter("nombre", nombre);  // puede ser null y está bien
            query.setParameter("unidadMedida", unidadMedida);  // también puede ser null

            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar ingrediente por filtros", e);
        } finally {
            em.close();
        }
    }

    
}
