/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Ingrediente;
import enumeradores.UnidadMedida;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author erika
 */
public interface IIngredienteDAO {
    public List<Ingrediente> obtenerIngredientes() throws PersistenciaException;  
    public List<Ingrediente> buscarIngredientePorNombre(String nombre) throws PersistenciaException;
    public Ingrediente buscarIngredientePorId(Long id) throws PersistenciaException;
    public Ingrediente modificarStock(Ingrediente ingrediente ) throws PersistenciaException;

    public boolean eliminarIngrediente (Long id) throws PersistenciaException;
    public Ingrediente guardarIngredinete (Ingrediente ingredienteGuardar) throws PersistenciaException; 
    public List<Ingrediente> obtenerIngredientesSinProducto() throws PersistenciaException;  
    public Ingrediente buscarPorNombreYUnidad1(String nombre,String unidad)throws PersistenciaException;
    public List<Ingrediente> buscarConFiltros (String nombre, UnidadMedida unidadMedida) throws PersistenciaException;
}
