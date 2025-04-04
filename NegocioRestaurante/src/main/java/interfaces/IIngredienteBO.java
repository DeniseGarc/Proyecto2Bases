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
    
}
