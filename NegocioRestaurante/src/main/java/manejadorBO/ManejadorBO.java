/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorBO;

import BO.ProductoBO;
import DAO.ProductoDAO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;

/**
 *
 * @author Alici
 */
public class ManejadorBO {

    public static IProductoBO crearProductoBO() {
        IProductoDAO productoDAO = ProductoDAO.getInstanciaDAO();
        IProductoBO productoBO = new ProductoBO(productoDAO);
        return productoBO;
    }
}
