/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Producto;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IProductoDAO {

    public List<Producto> obtenerProductos() throws PersistenciaException;

    public Producto obtenerProductoPorNombre(String nombre) throws PersistenciaException;

    public Producto registrarProducto(Producto producto) throws PersistenciaException;

    public boolean actualizarProducto(Producto producto) throws PersistenciaException;

    public boolean deshabilitarHabilitarProducto(Producto producto) throws PersistenciaException;
}
