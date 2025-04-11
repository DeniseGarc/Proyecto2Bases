/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author erika
 */
import DAO.IngredienteDAO;
import conexion.Conexion;
import entidades.Ingrediente;
import enumeradores.UnidadMedida;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class IngredienteDAOTest {

    private final IngredienteDAO instanciaIngredienteDAO = IngredienteDAO.getInstanceDAO();
    private List<Ingrediente> ingredientesAgregados = new ArrayList<>();
    private Ingrediente ingredienteAgregado;

    @BeforeEach
    public void setUp() {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Ingrediente i1 = new Ingrediente("Sal", UnidadMedida.GRAMOS, 10);
            Ingrediente i2 = new Ingrediente("Azúcar", UnidadMedida.GRAMOS, 20);
            Ingrediente i3 = new Ingrediente("Leche", UnidadMedida.MILILITROS, 5);
            em.persist(i1);
            em.persist(i2);
            em.persist(i3);
            em.getTransaction().commit();

            ingredientesAgregados.add(i1);
            ingredientesAgregados.add(i2);
            ingredientesAgregados.add(i3);
        } catch (Exception e) {
            em.getTransaction().rollback();
            fail("Error al insertar ingredientes de prueba: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            if (ingredienteAgregado != null) {
                Ingrediente gestionado = em.merge(ingredienteAgregado);
                em.remove(gestionado);
                ingredienteAgregado = null;
            }
            for (Ingrediente ing : ingredientesAgregados) {
                Ingrediente gestionado = em.merge(ing);
                em.remove(gestionado);
            }
            em.getTransaction().commit();
            ingredientesAgregados.clear();
        } catch (Exception e) {
            em.getTransaction().rollback();
            fail("Error al eliminar ingredientes de prueba: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Test
    public void testGuardarIngrediente() throws Exception {
        Ingrediente ing = new Ingrediente("Harina", UnidadMedida.GRAMOS, 15);
        Ingrediente resultado = instanciaIngredienteDAO.guardarIngredinete(ing);
        assertNotNull(resultado.getId());
        ingredienteAgregado = resultado;
    }

    @Test
    public void testBuscarIngredientePorNombre() throws Exception {
        List<Ingrediente> resultado = instanciaIngredienteDAO.buscarIngredientePorNombre("sal");
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertTrue(resultado.stream().anyMatch(i -> i.getNombre().equalsIgnoreCase("Sal")));
    }

    @Test
    public void testModificarStock() throws Exception {
        Ingrediente ingrediente = ingredientesAgregados.get(0);
        ingrediente.setStock(99);
        Ingrediente actualizado = instanciaIngredienteDAO.modificarStock(ingrediente);
        assertEquals(99, actualizado.getStock());
    }

    @Test
    public void testEliminarIngredienteSinAsociaciones() throws Exception {
        Ingrediente ing = new Ingrediente("Ajo",  UnidadMedida.GRAMOS,12);
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(ing);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        boolean eliminado = instanciaIngredienteDAO.eliminarIngrediente(ing.getId());
        assertTrue(eliminado);
    }

    @Test
    public void testBuscarIngredientePorId() throws Exception {
        Ingrediente ing = ingredientesAgregados.get(1);
        Ingrediente resultado = instanciaIngredienteDAO.buscarIngredientePorId(ing.getId());
        assertNotNull(resultado);
        assertEquals(ing.getId(), resultado.getId());
    }

    @Test
    public void testObtenerIngredientes() throws Exception {
        List<Ingrediente> resultado = instanciaIngredienteDAO.obtenerIngredientes();
        assertNotNull(resultado);
        assertTrue(resultado.size() >= 3);
    }

    @Test
    public void testBuscarPorNombreYUnidad() throws Exception {
        Ingrediente resultado = instanciaIngredienteDAO.buscarPorNombreYUnidad1("Sal", "GRAMOS");
        assertNotNull(resultado);
        assertEquals("Sal", resultado.getNombre());
        assertEquals(UnidadMedida.GRAMOS, resultado.getUnidadMedida());
    }

    @Test
    public void testBuscarConFiltros() throws Exception {
        List<Ingrediente> resultado = instanciaIngredienteDAO.buscarConFiltros("Sal", UnidadMedida.GRAMOS);
        assertNotNull(resultado);
        assertTrue(resultado.size() >= 1);
    }

    @Test
    public void testObtenerIngredientesSinProducto() throws Exception {
        List<Ingrediente> resultado = instanciaIngredienteDAO.obtenerIngredientesSinProducto();
        assertNotNull(resultado);
        assertTrue(resultado.stream().allMatch(i -> i.getDetallesProducto().isEmpty()));
    }
}
