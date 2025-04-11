/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import conexion.Conexion;
import entidades.Comanda;
import enumeradores.Estado;
import exception.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import entidades.ClienteFrecuente;
import entidades.Mesa;
import java.util.Calendar;
import org.junit.jupiter.api.Order;

/**
 * Clase de prueba unitaria para ComandaDAO.
 */
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComandaDAOTest {

    private static ComandaDAO comandaDAO;
    private static MesaDAO mesaDAO;

    private static Mesa mesaPrueba;
    private static ClienteFrecuente clientePrueba;

    @BeforeAll
    public static void setup() throws PersistenciaException {
        comandaDAO = ComandaDAO.getInstanciaDAO();
        mesaDAO = MesaDAO.getInstanciaDAO();

        // Verifica e inserta mesas si es necesario
        if (!mesaDAO.consultarMesas()) {
            mesaDAO.insertarMesas();
        }

        // Obtiene una mesa válida
        mesaPrueba = mesaDAO.obtenerMesaPorNumero(1L);
        assertNotNull(mesaPrueba);

        // Limpia base de datos
        EntityManager em = conexion.Conexion.crearConexion();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM DetalleComanda").executeUpdate();
        em.createQuery("DELETE FROM Comanda").executeUpdate();
        em.createQuery("DELETE FROM Cliente").executeUpdate();
        em.getTransaction().commit();

        // Crea cliente con teléfono único
        clientePrueba = new ClienteFrecuente(
                "Juan Prueba",
                Calendar.getInstance(),
                String.valueOf(System.currentTimeMillis() % 10000000000L), // Teléfono único
                "juan" + System.nanoTime() + "@test.com" // Correo único
        );

        // Persiste cliente
        em.getTransaction().begin();
        em.persist(clientePrueba);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    @Order(1)
    public void testRegistrarComanda() throws PersistenciaException {
        Comanda comanda = new Comanda(Calendar.getInstance(), 250.0, Estado.ACTIVA, mesaPrueba);
        comanda.setCliente(clientePrueba);

        boolean resultado = comandaDAO.registrarComanda(comanda);
        assertTrue(resultado);
        assertNotNull(comanda.getId());
    }

    @Test
    @Order(2)
    public void testObtenerComandas() throws PersistenciaException {
        List<Comanda> comandas = comandaDAO.obtenerComandas();
        assertNotNull(comandas);
        assertFalse(comandas.isEmpty());
    }

    @Test
    @Order(3)
    public void testObtenerComandasActivas() throws PersistenciaException {
        List<Comanda> activas = comandaDAO.obtenerComandasActivas();
        assertNotNull(activas);
        assertTrue(activas.stream().allMatch(c -> c.getEstado() == Estado.ACTIVA));
    }

    @Test
    @Order(4)
    public void testObtenerComandasPorCliente() throws PersistenciaException {
        List<Comanda> comandasCliente = comandaDAO.obtenerComandasPorCliente(clientePrueba);
        assertNotNull(comandasCliente);
        assertFalse(comandasCliente.isEmpty());
        assertTrue(comandasCliente.stream().allMatch(c -> c.getCliente().getId().equals(clientePrueba.getId())));
    }

    @Test
    @Order(5)
    public void testActualizarEstadoComanda() throws PersistenciaException {
        List<Comanda> comandas = comandaDAO.obtenerComandas();
        Comanda comanda = comandas.get(0);
        boolean actualizado = comandaDAO.actualizarEstadoComanda(comanda, Estado.ENTREGADA);
        assertTrue(actualizado);

        Comanda actualizada = comandaDAO.obtenerComandas()
                .stream()
                .filter(c -> c.getId().equals(comanda.getId()))
                .findFirst()
                .orElseThrow();

        assertEquals(Estado.ENTREGADA, actualizada.getEstado());
    }

    @Test
    @Order(6)
    public void testActualizarComanda() throws PersistenciaException {
        List<Comanda> comandas = comandaDAO.obtenerComandas();
        Comanda comanda = comandas.get(0);
        comanda.setTotalVenta(999.99);

        boolean actualizado = comandaDAO.actualizarComanda(comanda);
        assertTrue(actualizado);

        Comanda modificada = comandaDAO.obtenerComandas()
                .stream()
                .filter(c -> c.getId().equals(comanda.getId()))
                .findFirst()
                .orElseThrow();

        assertEquals(999.99, modificada.getTotalVenta());
    }
}