/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Producto;
import enumeradores.TipoProducto;
import exception.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Producto
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public interface IProductoDAO {

    /**
     * Obtiene todos los productos registrados en la base de datos.
     *
     * @return lista de productos.
     * @throws PersistenciaException si ocurre un error al consultar los
     * productos.
     */
    public List<Producto> obtenerProductos() throws PersistenciaException;

    /**
     * Obtiene un producto por su nombre exacto.
     *
     * @param nombre el nombre del producto a buscar.
     * @return el producto encontrado.
     * @throws PersistenciaException si no se encuentra o ocurre un error
     * durante la consulta.
     */
    public Producto obtenerProductoPorNombre(String nombre) throws PersistenciaException;

    /**
     * Registra un nuevo producto en la base de datos.
     *
     * @param producto el producto a registrar.
     * @return el producto registrado con su ID asignado.
     * @throws PersistenciaException si ocurre un error durante el registro.
     */
    public Producto registrarProducto(Producto producto) throws PersistenciaException;

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param producto el producto a actualizar.
     * @return {@code true} si la actualización fue exitosa.
     * @throws PersistenciaException si ocurre un error durante la
     * actualización.
     */
    public boolean actualizarProducto(Producto producto) throws PersistenciaException;

   
    public boolean deshabilitarHabilitarProducto(String nombre, boolean habilitado) throws PersistenciaException;

    /**
     * Obtiene una lista de productos cuyo nombre contenga el texto
     * especificado.
     *
     * @param nombre parte del nombre del producto a buscar.
     * @return lista de productos que coinciden con el filtro.
     * @throws PersistenciaException si ocurre un error al consultar.
     */
    public List<Producto> obtenerProductosFiltrados(String nombre) throws PersistenciaException;

    /**
     * Obtiene una lista de productos cuyo nombre contenga el texto especificado
     * y pertenezcan a una categoría específica.
     *
     * @param nombre parte del nombre del producto a buscar.
     * @param categoria categoría del producto.
     * @return lista de productos filtrados por nombre y categoría.
     * @throws PersistenciaException si ocurre un error durante la consulta.
     */
    public List<Producto> obtenerProductosFiltrados(String nombre, TipoProducto categoria) throws PersistenciaException;

    /**
     * Obtiene una lista de productos los cuales pertenezcan a una categoría
     * específica.
     *
     * @param categoria categoría del producto.
     * @return lista de productos filtrados por categoria.
     * @throws PersistenciaException si ocurre un error durante la consulta.
     */
    public List<Producto> obtenerProductosFiltrados(TipoProducto categoria) throws PersistenciaException;


}
