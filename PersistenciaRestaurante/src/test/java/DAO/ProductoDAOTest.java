/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import entidades.Producto;
import enumeradores.TipoProducto;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alici
 */
public class ProductoDAOTest {

    public ProductoDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getInstanciaDAO method, of class ProductoDAO.
     */
    @Test
    public void testGetInstanciaDAO() {
        System.out.println("getInstanciaDAO");
        ProductoDAO expResult = null;
        ProductoDAO result = ProductoDAO.getInstanciaDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerProductos method, of class ProductoDAO.
     */
    @Test
    public void testObtenerProductos() throws Exception {
        System.out.println("obtenerProductos");
        ProductoDAO instance = ProductoDAO.getInstanciaDAO();
        List<Producto> expResult = null;
        List<Producto> result = instance.obtenerProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerProductoPorNombre method, of class ProductoDAO.
     */
    @Test
    public void testObtenerProductoPorNombre() throws Exception {
        System.out.println("obtenerProductoPorNombre");
        String nombre = "";
        ProductoDAO instance = null;
        Producto expResult = null;
        Producto result = instance.obtenerProductoPorNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarProducto method, of class ProductoDAO.
     */
    @Test
    public void testRegistrarProducto() throws Exception {
        System.out.println("registrarProducto");
        Producto producto = new Producto("Hola", 20.2, TipoProducto.PLATILLO, true);
        ProductoDAO instance = ProductoDAO.getInstanciaDAO();
        Producto expResult = producto;
        Producto result = instance.registrarProducto(producto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarProducto method, of class ProductoDAO.
     */
    @Test
    public void testActualizarProducto() throws Exception {
        System.out.println("actualizarProducto");
        Producto producto = null;
        ProductoDAO instance = null;
        boolean expResult = false;
        boolean result = instance.actualizarProducto(producto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deshabilitarHabilitarProducto method, of class ProductoDAO.
     */
    @Test
    public void testDeshabilitarHabilitarProducto() throws Exception {
        System.out.println("deshabilitarHabilitarProducto");
        Producto producto = null;
        ProductoDAO instance = null;
        boolean expResult = false;
        boolean result = instance.deshabilitarHabilitarProducto(producto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
