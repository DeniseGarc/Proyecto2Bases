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
    
    
    
    @Override
    public List<IngredienteDTO> obtenerIngredientes() throws NegocioException {
        try{
            List<Ingrediente> ingredientes = ingredienteDAO.obtenerIngredientes();
            return IngredienteMapper.ToDTOList(ingredientes);
        }catch(PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener los productos");
        }
        
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesPorNombre(String nombre) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
