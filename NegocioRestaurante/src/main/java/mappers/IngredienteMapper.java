/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DTOs.IngredienteDTO;
import entidades.Ingrediente;
import enumeradores.UnidadMedida;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erika
 */
public class IngredienteMapper {
    /**
     * Maper para pasar de lista de ingredientes a lista de ingredientesDTO 
     * @param ingredientes Lista de Ingredientes
     * @return Lista de ingredientesDTO
     */
    public static List<IngredienteDTO> ToDTOList(List<Ingrediente> ingredientes){
        List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
        for(Ingrediente ingrediente : ingredientes){
            ingredientesDTO.add(
                    new IngredienteDTO(ingrediente.getNombre(), ingrediente.getUnidadMedida(), ingrediente.getStock())
            );
        }
        return ingredientesDTO;
    }
    /**
     * Mapper que convierte Ingrediente a IngredienteDTO
     * @param ingrediente
     * @return IngredienteDTO
     */
    public static IngredienteDTO ToDTO(Ingrediente ingrediente){
        IngredienteDTO ingredienteDTO = new IngredienteDTO(ingrediente.getNombre(), ingrediente.getUnidadMedida(), ingrediente.getStock());
        return ingredienteDTO;
    }
    
    public static Ingrediente ToEntity(IngredienteDTO ingredienteDTO){
        Ingrediente ingrediente = new Ingrediente(ingredienteDTO.getNombre(), ingredienteDTO.getUnidadMedida(), ingredienteDTO.getStock());
        return ingrediente; 
    }
}
