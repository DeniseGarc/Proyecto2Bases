/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.IngredienteDTO;
import entidades.Ingrediente;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import java.util.List;
import mappers.IngredienteMapper;

/**
 *
 * @author erika
 */
public class IngredienteBO implements IIngredienteBO{
    
    private IIngredienteDAO ingredienteDAO;

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
     * Busca los ingredientes con el nombre indicaso
     * @param nombre a buscar
     * @return lista de ingredientes DTO
     * @throws NegocioException 
     */
    @Override
    public List<IngredienteDTO> obtenerIngredientesPorNombre(String nombre) throws NegocioException {
        try{
            List<Ingrediente> ingredientes = ingredienteDAO.buscarIngredientePorNombre(nombre);
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
    
    @Override
    public List<IngredienteDTO> obtenerIngredientesSinProducto() throws NegocioException{
        try{
            List<Ingrediente> ingredientes = ingredienteDAO.obtenerIngredientesSinProducto();
            return IngredienteMapper.ToDTOList(ingredientes);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los ingredientes");
        }
    }

    @Override
    public List<IngredienteDTO> buscarPorNombreYUnidad(String nombre, String unidad) throws NegocioException {
        try{
           List<Ingrediente> ingredientes = ingredienteDAO.buscarPorNombreYUnidad(nombre, unidad);
           return IngredienteMapper.ToDTOList(ingredientes);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener el ingrediente");
        }
    }
    
    public List<IngredienteDTO> buscarPorUnidad(String unidad) throws NegocioException{
        try{
           List<Ingrediente> ingredientes = ingredienteDAO.buscarIngredientesPorUnidadMedida(unidad);
           return IngredienteMapper.ToDTOList(ingredientes);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener el ingrediente");
        }
    }

    @Override
    public IngredienteDTO buscarPorNombreYUnidad1(String nombre, String unidad) throws NegocioException {
        try{
           Ingrediente ingrediente = ingredienteDAO.buscarPorNombreYUnidad1(nombre, unidad);
           return IngredienteMapper.ToDTO(ingrediente);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener el ingrediente");
        }
    }
    
}
