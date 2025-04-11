/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.IngredienteDTO;
import enumeradores.UnidadMedida;
import exception.NegocioException;
import java.util.List;

/**
 *Interfaz que define las operaciones de lógica de negocio para la gestión de ingredientes
 * @author erika
 */
public interface IIngredienteBO {
    /**
     * Metodo para obtener todos los ingredientes
     * @return Lista de ingredientesDTO con todos los ingredientes en la base de datos
     * @throws NegocioException Si ocurre algun error inesperado al obtener los ingredientes
     */
    public List<IngredienteDTO> obtenerIngredientes() throws NegocioException;
    /**
     * Metodo para eliminar un ingrediente de la base de datos con su id
     * @param id Id del ingrediente a eliminar
     * @return True si se elimino el ingrediente correctamente
     * @throws NegocioException si ocurre algun error al eliminar el ingrediente
     */
    public boolean eliminarIngrediente(Long id )throws NegocioException; 
    /**
     * Metodo para actualizar el stock de un ingrediente
     * @param id Id del ingrediente a acualizar
     * @param stock Nuevo stock del ingrediente
     * @return IngredienteDTO actualizado
     * @throws NegocioException Si ocurre algun error al actualizar el ingrediente
     */
    public IngredienteDTO actualizarStock(Long id, int stock) throws NegocioException; 
    /**
     * Metodo para insertar un ingrediente a la base de datos
     * @param ingrediente IngredienteDTO a insertar
     * @return IngredienteDTO insertado
     * @throws NegocioException Si ocurre algun error al insertar el ingrediente a la base de datos
     */
    public IngredienteDTO agregarIngrediente(IngredienteDTO ingrediente) throws NegocioException; 
    /**
     * Metodo que obtiene los ingredientes de la base de datos que no esten asociados a un producto
     * @return Lista de ingredientesDTO sin productos asociados
     * @throws NegocioException Si ocurre algun error al obtener los ingredientes
     */
    public List<IngredienteDTO> obtenerIngredientesSinProducto() throws NegocioException;
    /**
     * Metodo que recupera un producto buscandolo por nombre y unidad
     * @param nombre Nombre del producto a buscar
     * @param unidad Unidad de medida del producto
     * @return Ingrediente encontrado
     * @throws NegocioException Si ocurre algun error al recuperar el producto
     */
    public IngredienteDTO buscarPorNombreYUnidad1 (String nombre, String unidad) throws NegocioException;
    /**
     * Metodo para buscar ingredientes en la base de datos con distintos filtros de nombre y unidad
     * @param nombre Nombre del producto a buscar
     * @param unidad Unidad de medida del ingrediente
     * @return Lista de ingredientesDTO filtrados
     * @throws NegocioException Si ocurre algun error al buscar los ingredientes
     */
    public List<IngredienteDTO> buscarIngredientes(String nombre, UnidadMedida unidad) throws NegocioException;
    
}
