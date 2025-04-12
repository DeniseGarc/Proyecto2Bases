/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import entidades.Mesa;
import exception.PersistenciaException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Maryr
 */
public class MesaDAOTest {
    private MesaDAO mesaDAO;

    @BeforeEach
    public void setUp() {
        mesaDAO = MesaDAO.getInstanciaDAO();
    }

    @Test
    public void testInsertarMesas() {
        assertDoesNotThrow(() -> mesaDAO.insertarMesas());
    }

    @Test
    public void testConsultarMesas() throws PersistenciaException {
        mesaDAO.insertarMesas(); // Asegura que estén insertadas
        boolean resultado = mesaDAO.consultarMesas();
        assertTrue(resultado, "Debe devolver true si ya hay 20 mesas");
    }

    @Test
    public void testObtenerMesasDisponibles() throws PersistenciaException {
        mesaDAO.insertarMesas(); // Asegura que existan
        List<Mesa> disponibles = mesaDAO.obtenerMesas();
        assertNotNull(disponibles);
        assertTrue(disponibles.size() > 0, "Debe haber al menos una mesa disponible");
    }

    @Test
    public void testObtenerMesaPorNumero() throws PersistenciaException {
        mesaDAO.insertarMesas();
        Mesa mesa = mesaDAO.obtenerMesaPorNumero(1L);
        assertNotNull(mesa);
        assertEquals(1L, mesa.getNumero());
    }

    @Test
    public void testActualizarEstadoMesa() throws PersistenciaException {
        mesaDAO.insertarMesas();
        mesaDAO.actualizarEstadoMesa(1L, false);
        Mesa mesa = mesaDAO.obtenerMesaPorNumero(1L);
        assertFalse(mesa.getEstado(), "El estado de la mesa debe ser false");
    }

    @Test
    public void testObtenerMesaPorNumeroInvalido() {
        assertThrows(PersistenciaException.class, () -> mesaDAO.obtenerMesaPorNumero(9999L));
    }

    @Test
    public void testActualizarEstadoMesaInvalido() {
        assertThrows(PersistenciaException.class, () -> mesaDAO.actualizarEstadoMesa(9999L, false));
    }
}
