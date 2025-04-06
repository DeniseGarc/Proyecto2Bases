/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.IngredienteDTO;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author erika
 */
public interface IIngredienteBO {
    public List<IngredienteDTO> obtenerIngredientes() throws NegocioException;
    public List<IngredienteDTO> obtenerIngredientesPorNombre(String nombre) throws NegocioException; 
    public boolean eliminarIngrediente(Long id )throws NegocioException; 
    public IngredienteDTO actualizarStock(Long id, int stock) throws NegocioException; 
    public IngredienteDTO agregarIngrediente(IngredienteDTO ingrediente) throws NegocioException; 
    public List<IngredienteDTO> obtenerIngredientesSinProducto() throws NegocioException;
    public IngredienteDTO buscarPorNombreYUnidad(String nombre, String unidad) throws NegocioException;
    
}
