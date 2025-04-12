package DAO;

import conexion.Conexion;
import entidades.ClienteFrecuente;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteFrecuenteDAOTest {

    private final ClienteFrecuenteDAO clienteFrecuenteDAO = ClienteFrecuenteDAO.getInstanciaDAO();
    private final List<ClienteFrecuente> clientesCreados = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            ClienteFrecuente c1 = new ClienteFrecuente("Juan", Calendar.getInstance(), "1234567890", "juan@mail.com");
            ClienteFrecuente c2 = new ClienteFrecuente("Ana", Calendar.getInstance(), "0987654321", "ana@mail.com");
            em.persist(c1);
            em.persist(c2);
            em.getTransaction().commit();
            clientesCreados.add(c1);
            clientesCreados.add(c2);
        } catch (Exception e) {
            em.getTransaction().rollback();
            fail("Error en setUp: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            for (ClienteFrecuente c : clientesCreados) {
                ClienteFrecuente gestionado = em.merge(c);
                em.remove(gestionado);
            }
            em.getTransaction().commit();
            clientesCreados.clear();
        } catch (Exception e) {
            em.getTransaction().rollback();
            fail("Error al limpiar datos de prueba: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Test
    public void testRegistrarNuevoClienteFrecuente() throws PersistenciaException {
        ClienteFrecuente cliente = new ClienteFrecuente("Carlos", Calendar.getInstance(), "1112223333", "carlos@mail.com");
        ClienteFrecuente resultado = clienteFrecuenteDAO.registrarNuevoClienteFrecuente(cliente);
        assertNotNull(resultado.getId());
        clientesCreados.add(resultado);  // Añadir a la lista para limpiar después
    }

    @Test
    public void testObtenerClientePorId() throws PersistenciaException {
        ClienteFrecuente cliente = clientesCreados.get(0);
        ClienteFrecuente resultado = clienteFrecuenteDAO.obtenerClientePorId(cliente.getId());
        assertNotNull(resultado);
        assertEquals(cliente.getId(), resultado.getId());
    }

    @Test
    public void testObtenerClientesFrecuentesPorNombre() throws PersistenciaException {
        List<ClienteFrecuente> resultado = clienteFrecuenteDAO.obtenerClientesFrecuentes("Nombre", "Juan");
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertTrue(resultado.stream().anyMatch(c -> c.getNombre().equalsIgnoreCase("Juan")));
    }

    @Test
    public void testObtenerClientesFrecuentesPorCorreo() throws PersistenciaException {
        List<ClienteFrecuente> resultado = clienteFrecuenteDAO.obtenerClientesFrecuentes("Correo", "ana@mail.com");
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertTrue(resultado.stream().anyMatch(c -> c.getCorreoElectronico().equalsIgnoreCase("ana@mail.com")));
    }

    @Test
    public void testObtenerTodosLosClientesFrecuentesSinFiltro() throws PersistenciaException {
        List<ClienteFrecuente> resultado = clienteFrecuenteDAO.obtenerClientesFrecuentes("", "");
        assertNotNull(resultado);
        assertTrue(resultado.size() >= 2);
    }
}
