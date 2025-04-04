/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Ingrediente;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author erika
 */
public interface IIngredienteDAO {
    public List<Ingrediente> obtenerIngredientes() throws PersistenciaException;  
    public List<Ingrediente> buscarIngredientePorNombre(String nombre) throws PersistenciaException;
    public Ingrediente aumentarStock(int stock) throws PersistenciaException;
    public Ingrediente reducirStock (int stock) throws PersistenciaException;
    public Ingrediente eliminarIngrediente (Long id) throws PersistenciaException;
    
}
