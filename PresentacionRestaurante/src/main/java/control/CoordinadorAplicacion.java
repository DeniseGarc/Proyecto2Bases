/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.ProductoDTO;
import GUIs.ClienteFrecuente;
import GUIs.EliminarIngrediente;
import GUIs.Ingredientes;
import GUIs.MenuPrincipal;
import GUIs.PantallaDetallesProducto;
import GUIs.PantallaProductos;
import GUIs.PantallaTomaComanda;
import GUIs.RegistrarClienteNuevo;
import GUIs.frmAgregarIngrediente;
import control.exception.CoordinadorException;
import enumeradores.TipoProducto;
import exception.NegocioException;
import interfaces.IProductoBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import manejadorBO.ManejadorBO;

/**
 *
 * @author erika
 */
public class CoordinadorAplicacion {

    private IProductoBO productoBO = ManejadorBO.crearProductoBO();

    public void PantallaPrinicipal(JFrame frame) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        frame.dispose();
    }

    public void PantallaComandas(JFrame frame) {

    }

    public void PantallaIngredientes(JFrame frame) {
        Ingredientes pantallaIngredientes = new Ingredientes();
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

    public void pantallaProductos(JFrame frame) {
        PantallaProductos pantallaProductos = new PantallaProductos();
        pantallaProductos.setVisible(true);
        frame.dispose();
    }

    public void pantallaDetallesProducto(JFrame frame) {
        PantallaDetallesProducto pantallaDetallesProducto = new PantallaDetallesProducto();
        pantallaDetallesProducto.setVisible(true);
        frame.dispose();
    }

    public void pantallaAgregarProducto() {
    }

    public void pantallaModificarProducto() {
    }

    public List<ProductoDTO> obtenerProductos() throws CoordinadorException {
        try {
            return productoBO.obtenerProductos();
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al obtener los productos");
        }
    }

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
}
