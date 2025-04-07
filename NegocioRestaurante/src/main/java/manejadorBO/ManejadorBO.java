/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorBO;

import BO.ClienteFrecuenteBO;
import BO.IngredienteBO;
import BO.ProductoBO;
import DAO.ClienteFrecuenteDAO;
import DAO.IngredienteDAO;
import DAO.ProductoDAO;
import interfaces.IClienteFrecuenteDAO;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;
import interfaces.IClienteFrecuenteBO;

/**
 *
 * @author Alici
 */
public class ManejadorBO {

    /**
     * Método que crea y regresa la instancia de ProductoBO.
     *
     * @return clase ProductoBO que implementa la interfaz IProductoBO.
     */
    public static IProductoBO crearProductoBO() {
        IProductoDAO productoDAO = ProductoDAO.getInstanciaDAO();
        IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstanceDAO();
        IProductoBO productoBO = new ProductoBO(productoDAO, ingredienteDAO);
        return productoBO;
    }

    public static IIngredienteBO crearIngredienteBO() {
        IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstanceDAO();
        IIngredienteBO ingredienteBO = new IngredienteBO(ingredienteDAO);
        return ingredienteBO;
    }
    
    public static IClienteFrecuenteBO crearClienteFrecuenteBO() {
        IClienteFrecuenteDAO clienteFrecuenteDAO = ClienteFrecuenteDAO.getInstanciaDAO();
        IClienteFrecuenteBO clienteFrecuenteBO = new ClienteFrecuenteBO(clienteFrecuenteDAO);
        return clienteFrecuenteBO;
    }
}
