/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import entidades.ClienteFrecuente;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maryr
 */
public class ClienteFrecuenteDAOTest {
    
    public ClienteFrecuenteDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetInstanciaDAO() {
        System.out.println("getInstanciaDAO");
        ClienteFrecuenteDAO expResult = null;
        ClienteFrecuenteDAO result = ClienteFrecuenteDAO.getInstanciaDAO();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistrarNuevoClienteFrecuente() throws Exception {
        System.out.println("registrarNuevoClienteFrecuente");
        ClienteFrecuente clienteFrecuente = null;
        ClienteFrecuenteDAO instance = null;
        ClienteFrecuente expResult = null;
        ClienteFrecuente result = instance.registrarNuevoClienteFrecuente(clienteFrecuente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerClientesFrecuentes() throws Exception {
        System.out.println("obtenerClientesFrecuentes");
        String filtro = "";
        String dato = "";
        ClienteFrecuenteDAO instance = null;
        List<ClienteFrecuente> expResult = null;
        List<ClienteFrecuente> result = instance.obtenerClientesFrecuentes(filtro, dato);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerClientePorId() throws Exception {
        System.out.println("obtenerClientePorId");
        Long id = null;
        ClienteFrecuenteDAO instance = null;
        ClienteFrecuente expResult = null;
        ClienteFrecuente result = instance.obtenerClientePorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
