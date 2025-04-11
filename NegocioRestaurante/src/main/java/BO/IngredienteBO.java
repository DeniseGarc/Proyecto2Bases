/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.IngredienteDTO;
import entidades.Ingrediente;
import enumeradores.UnidadMedida;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import mappers.IngredienteMapper;

/**
 *Clase que implementa la lógica de negocio para operaciones relacionadas con Ingredientes
 * @author erika
 */
public class IngredienteBO implements IIngredienteBO{
    
    private IIngredienteDAO ingredienteDAO;
    /**
     * Constructor que inicializa la dependencia dao necesaria
     * @param ingredienteDAO implementacion de IIngredienteDAO para acceso de datos de ingredientes
     */
    public IngredienteBO(IIngredienteDAO ingredienteDAO) {
        this.ingredienteDAO = ingredienteDAO;
    }
    
    
    /**
     * Obtiene todos los ingredientes 
     * @return Lista de ingredientes DTO
     * @throws NegocioException 
     */
    @Override
    public List<IngredienteDTO> obtenerIngredientes() throws NegocioException {
        try{
            List<Ingrediente> ingredientes = ingredienteDAO.obtenerIngredientes();
            return IngredienteMapper.ToDTOList(ingredientes);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los ingredientes");
        }
        
    }

    /**
     * Elimina el ingrediente indicado, llama al metodo en la DAO para eliminar
     * @param id del ingrediente a eliminar
     * @return true si se elimino el ingrediente
     * @throws NegocioException 
     */
    @Override
    public boolean eliminarIngrediente(Long id) throws NegocioException {
        try {
        Ingrediente ingrediente = ingredienteDAO.buscarIngredientePorId(id);
        if (ingrediente == null) {
            throw new NegocioException("El ingrediente con ID " + id + " no existe.");
        }
        ingredienteDAO.eliminarIngrediente(ingrediente.getId());
        return true;
    } catch (PersistenciaException e) {
        throw new NegocioException("Error al eliminar el ingrediente.", e);
    }
    }
/**
 * Llama al metodo en la dao para actualizar el stock
 * @param id del ingrediente a actualizar
 * @param stock a actualizar
 * @return ingredienteDTO actualizado
 * @throws NegocioException 
 */
    @Override
    public IngredienteDTO actualizarStock(Long id, int stock) throws NegocioException {
        try {
        Ingrediente ingrediente = ingredienteDAO.buscarIngredientePorId(id);
        if (ingrediente == null) {
            throw new NegocioException("El ingrediente con ID " + id + " no existe.");
        }
        if (stock < 0) {
            throw new NegocioException("El stock no puede ser negativo.");
        }
        ingrediente.setStock(stock);
        ingredienteDAO.modificarStock(ingrediente);
        return IngredienteMapper.ToDTO(ingrediente);
    } catch (PersistenciaException e) {
        throw new NegocioException("Error al actualizar el stock.", e);
    }
    }
    /**
     * Llama al metodo en la DAO para agregar ingredientes a la base de datos
     * @param ingredienteDTO ingrediente a registrar
     * @return ingrediente registrado
     * @throws NegocioException 
     */
    @Override
    public IngredienteDTO agregarIngrediente(IngredienteDTO ingredienteDTO) throws NegocioException {
        try {
        // Buscar ingredientes que tengan el mismo nombre
        List<Ingrediente> ingredientesConMismoNombre = ingredienteDAO.buscarIngredientePorNombre(ingredienteDTO.getNombre());

        // Validar si ya existe un ingrediente con el mismo nombre Y unidad de medida
        for (Ingrediente ingrediente : ingredientesConMismoNombre) {
            if (ingrediente.getUnidadMedida().equals(ingredienteDTO.getUnidadMedida())) {
                throw new NegocioException("Ya existe un ingrediente con el mismo nombre y unidad de medida.");
            }
        }

        // Crear y guardar el nuevo ingrediente
        Ingrediente nuevoIngrediente = new Ingrediente();
        nuevoIngrediente.setNombre(ingredienteDTO.getNombre());
        nuevoIngrediente.setUnidadMedida(ingredienteDTO.getUnidadMedida());
        nuevoIngrediente.setStock(ingredienteDTO.getStock());

        Ingrediente guardado = ingredienteDAO.guardarIngredinete(nuevoIngrediente);

        return IngredienteMapper.ToDTO(guardado);

    } catch (PersistenciaException e) {
        throw new NegocioException("Error al agregar el ingrediente.", e);
    }
    }
    /**
     * Metodo que obtiene los ingredientes que no forman parte de un producto
     * @return Lista de ingredientes dto
     * @throws NegocioException si hay algun error inesperado
     */
    @Override
    public List<IngredienteDTO> obtenerIngredientesSinProducto() throws NegocioException{
        try{
            List<Ingrediente> ingredientes = ingredienteDAO.obtenerIngredientesSinProducto();
            return IngredienteMapper.ToDTOList(ingredientes);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los ingredientes");
        }
    }


    /**
     * Metodo para buscar un ingrediente por su nombre y unidad de medida
     * @param nombre Nombre del ingrediente a buscar
     * @param unidad Unidad de medida del ingrediente a buscar
     * @return IngredienteDTO filtrado
     * @throws NegocioException 
     */
    @Override
    public IngredienteDTO buscarPorNombreYUnidad1(String nombre, String unidad) throws NegocioException {
        try{
           Ingrediente ingrediente = ingredienteDAO.buscarPorNombreYUnidad1(nombre, unidad);
           return IngredienteMapper.ToDTO(ingrediente);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener el ingrediente");
        }
    }
    /**
     * Metodo para buscar ingredientes con filtros de nombre y unidad de medida
     * @param nombre Nombre del ingrediente a buscar
     * @param unidad Unidad de medida del ingrediente a buscar
     * @return Lista de ingredientesDTO filtrados
     * @throws NegocioException 
     */
    @Override
    public List<IngredienteDTO> buscarIngredientes(String nombre, UnidadMedida unidad) throws NegocioException {
        try {
            String nombreFiltrado = (nombre != null && !nombre.isBlank()) ? "%" + nombre.trim() + "%" : null;
            UnidadMedida unidadFiltrada = unidad;
            
            List<Ingrediente> encontrados = ingredienteDAO.buscarConFiltros(nombreFiltrado, unidadFiltrada );
            return IngredienteMapper.ToDTOList(encontrados);
        } catch (PersistenciaException ex) {
            Logger.getLogger(IngredienteBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ocurrió un error al obtener los ingredientes");
        }
        
    }
    
}
