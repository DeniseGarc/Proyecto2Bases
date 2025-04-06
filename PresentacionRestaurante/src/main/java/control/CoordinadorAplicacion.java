/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.IngredienteDTO;
import DTOs.ProductoDTO;
import DTOs.ProductoDetalleDTO;
import GUIs.ClienteFrecuente;
import GUIs.EliminarIngrediente;
import GUIs.MenuPrincipal;
import GUIs.PantallaAdministrarProducto;
import GUIs.PantallaDetallesProducto;
import GUIs.PantallaIngredientes;
import GUIs.PantallaInicio;
import GUIs.PantallaProductos;
import GUIs.PantallaTomaComanda;
import GUIs.RegistrarClienteNuevo;
import GUIs.frmAgregarIngrediente;
import control.exception.CoordinadorException;
import enumeradores.TipoProducto;
import exception.NegocioException;
import interfaces.IIngredienteBO;
import interfaces.IProductoBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import manejadorBO.ManejadorBO;
import modos.Modo;

/**
 *
 * @author erika
 */
public class CoordinadorAplicacion {

    private IProductoBO productoBO = ManejadorBO.crearProductoBO();
    private IIngredienteBO ingredienteBO = ManejadorBO.crearIngredienteBO();

    /**
     * Método que define a que pantalla se va redirigir cuando se le da a la
     * flecha de regreso en los titulos.
     *
     * @param target Frame destino
     * @param padre Frame que contiene la flecha
     */
    public void regresarPantalla(JFrame target, JFrame padre) {
        target.setVisible(true);
        padre.dispose();
    }
    
    public void PantallaInicio(){
        PantallaInicio inicio = new PantallaInicio();
        inicio.setVisible(true);
    }
    
    public void PantallaPrinicipal(JFrame frame) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        frame.dispose();
    }

    public void PantallaComandas(JFrame frame) {

    }

    public void PantallaIngredientes(JFrame frame) {
        PantallaIngredientes pantallaIngredientes = new PantallaIngredientes();
        pantallaIngredientes.setVisible(true);
        frame.dispose();
    }

    public void PantallaAgregarIngrediente(JFrame frame) {
        frmAgregarIngrediente pantallaAgregar = new frmAgregarIngrediente();
        pantallaAgregar.setVisible(true);
        frame.dispose();
    }

    public void PantallaEliminarIngrediente(JFrame frame) {
        EliminarIngrediente pantallaEliminar = new EliminarIngrediente();
        pantallaEliminar.setVisible(true);
        frame.dispose();
    }

    public void PantallaClienteFrecuente(JFrame frame) {
        ClienteFrecuente pantallaCliente = new ClienteFrecuente();
        pantallaCliente.setVisible(true);
        frame.dispose();
    }

    public void PantallaTomaComanda(JFrame frame) {
        PantallaTomaComanda pantallaComanda = new PantallaTomaComanda();
        pantallaComanda.setVisible(true);
        frame.dispose();
    }

    public void PantallaRegistrarCliente(JFrame frame) {
        RegistrarClienteNuevo PantallaRegistrarCliente = new RegistrarClienteNuevo();
        PantallaRegistrarCliente.setVisible(true);
        frame.dispose();
    }

    /**
     * Método para redirigir a la pantalla de productos.
     *
     * @param frame Frame padre desde el cual se invoca la siguiente pantalla.
     */
    public void pantallaProductos(JFrame frame) {
        PantallaProductos pantallaProductos = new PantallaProductos();
        pantallaProductos.setVisible(true);
        frame.dispose();
    }

    /**
     * Método para redirigir a la pantalla que muestra los detalles del producto
     * seleccionado.
     *
     * @param frame Frame padre desde el cual se invoca la siguiente pantalla
     * @param producto Producto y sus ingredientes los cuales se van a cargar en
     * la pantalla
     */
    public void pantallaDetallesProducto(JFrame frame, ProductoDetalleDTO producto) {
        PantallaDetallesProducto pantallaDetallesProducto = new PantallaDetallesProducto(producto);
        pantallaDetallesProducto.setVisible(true);
        frame.dispose();
    }

    public void pantallaAgregarProducto(JFrame frame) {
        PantallaAdministrarProducto pantallaAdministrarProducto = new PantallaAdministrarProducto(Modo.AGREGAR, null);
        pantallaAdministrarProducto.setVisible(true);
        frame.dispose();
    }

    public void pantallaModificarProducto(JFrame frame, ProductoDetalleDTO producto) {
        PantallaAdministrarProducto pantallaAdministrarProducto = new PantallaAdministrarProducto(Modo.MODIFICAR, producto);
        pantallaAdministrarProducto.setVisible(true);
        frame.dispose();
    }

    /**
     * Obtiene todos los productos registrados.
     *
     * @return
     * @throws CoordinadorException
     */
    public List<ProductoDTO> obtenerProductos() throws CoordinadorException {
        try {
            return productoBO.obtenerProductos();
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al obtener los productos");
        }
    }

    /**
     * Obtiene los productos filtrados.
     *
     * @param texto
     * @param categoria
     * @return
     * @throws CoordinadorException
     */
    public List<ProductoDTO> obtenerProductosFiltrados(String texto, TipoProducto categoria) throws CoordinadorException {
        try {
            if (texto != null && categoria != null) {
                return productoBO.obtenerProductosFiltradosNombreyCategoria(texto, categoria);
            } else if (texto == null) {
                return productoBO.obtenerProductosFiltradosCategoria(categoria);
            } else {
                return productoBO.obtenerProductosFiltradosNombre(texto);
            }
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al filtrar los productos");
        }
    }

    /**
     * Obtiene el producto y sus ingredientes a partir de su nombre
     *
     * @param nombre
     * @return
     * @throws CoordinadorException
     */
    public ProductoDetalleDTO obtenerDetallesDelProducto(String nombre) throws CoordinadorException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new CoordinadorException("No ha sido posible recuperar el nombre del producto");
        }
        try {
            ProductoDetalleDTO producto = productoBO.obtenerProductoDetallesPorNombre(nombre);
            if (producto == null) {
                throw new CoordinadorException("No ha sido posible recuperar el producto con el nombre recuperado");
            }
            return producto;
        } catch (NegocioException e) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, e);
            throw new CoordinadorException("Ha ocurrido un error al obtener el producto y sus detalles");
        }
    }

    public boolean validarNombre(String nombre) throws CoordinadorException {
        if (nombre == null || nombre.trim().isEmpty() || nombre.length() > 100) {
            return false;
        }
        try {
            return productoBO.obtenerProductoDetallesPorNombre(nombre) == null;
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al validar la existencia de otro producto con el mismo nombre");
        }
    }

    public boolean agregarProducto(ProductoDetalleDTO producto) throws CoordinadorException {
        if (validarDatosProducto(producto)) {
            try {
                return productoBO.agregarProducto(producto);
            } catch (NegocioException ex) {
                Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
                throw new CoordinadorException("Ha ocurrido un error al intentar agregar el producto");
            }
        }
        return false;
    }

    public boolean actualizarProducto(ProductoDetalleDTO producto) throws CoordinadorException {
        if (validarDatosProducto(producto)) {
            try {
                return productoBO.actualizarProducto(producto);
            } catch (NegocioException ex) {
                Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
                throw new CoordinadorException("Ha ocurrido un error al intentar actualizar el producto");
            }
        }
        return false;
    }

    private boolean validarDatosProducto(ProductoDetalleDTO producto) throws CoordinadorException {
        if (producto == null) {
            throw new CoordinadorException("El producto a agregar no puede ser nulo");
        }
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new CoordinadorException("El nombre del producto es nulo o esta vacio");
        }
        if (producto.getTipo() == null) {
            throw new CoordinadorException("El producto no tiene una categoria asignada");
        }
        if (producto.getPrecio() <= 0) {
            throw new CoordinadorException("El producto tiene un precio negativo");
        }
        if (producto.getIngredientes().isEmpty() || producto.getIngredientes() == null) {
            throw new CoordinadorException("El producto no tiene ingredientes asociados");
        }
        return true;
    }
    
    public IngredienteDTO agregarIngrediente(IngredienteDTO ingrediente) throws CoordinadorException{
        if(ingrediente==null){
            throw new CoordinadorException("El producto a agregar no puede ser nulo");
        }
        if(ingrediente.getNombre() == null){
            throw new CoordinadorException("El nombre no puede ser nulo");
        }
        if(ingrediente.getUnidadMedida() == null){
            throw new CoordinadorException("El ingrediente no tiene una Unidad de medida asignada");
        }
        else{
            try {
                ingredienteBO.agregarIngrediente(ingrediente);
            } catch (NegocioException ex) {
                Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
                throw new CoordinadorException("No se pudo guardar el ingrediente");
            }
        }
        return ingrediente;
    }
    /**
     * Muestra todos los ingredientes
     * @return lista de ingredientesDTO
     * @throws CoordinadorException 
     */
    public List<IngredienteDTO> mostrarIngredientes () throws CoordinadorException{
        try {
           return ingredienteBO.obtenerIngredientes();
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al obtener los ingredientes");
        }
    }
    
    public List<IngredienteDTO> mostrarIngredientesSinProducto() throws CoordinadorException{
        try {
           return ingredienteBO.obtenerIngredientesSinProducto();
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al obtener los Ingredientes");
        }
    }
    
    public IngredienteDTO modificarStock(Long id, int stock)throws CoordinadorException{
        try {
           return ingredienteBO.actualizarStock(id, stock);
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al actualizar el stock");
        }
    }
    
    public IngredienteDTO buscarPorNombreYUnidad(String nombre, String unidad) throws CoordinadorException{
        try{
        return ingredienteBO.buscarPorNombreYUnidad(nombre, unidad);
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al actualizar el stock");
        }
    }

    public boolean actualizarEstadoProducto(String nombre) throws CoordinadorException {
        try {
            return productoBO.cambiarEstadoProducto(nombre);
        } catch (NegocioException e) {
            throw new CoordinadorException("Ha ocurrido un problema al actualizar el estado del producto");
        }
    }
}
