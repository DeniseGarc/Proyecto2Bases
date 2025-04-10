package DAO;

import conexion.Conexion;
import entidades.Producto;
import enumeradores.TipoProducto;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para ProductoDAO.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public class ProductoDAOTest {

    /**
     * Instancia de ProductoDAO.
     */
    private final ProductoDAO instanciaProductoDAO = ProductoDAO.getInstanciaDAO();
    /**
     * Lista que guarda los productos de prueba.
     */
    private List<Producto> productosAgregados = new ArrayList<>();
    /**
     * Guarda el producto agregado durante la prueba de registrarProducto().
     */
    private Producto productoAgregado;

    public ProductoDAOTest() {
    }

    /**
     * Agrega 3 productos a la base de datos y los guarda en la lista de
     * productos agregados para su utilización durante las pruebas.
     */
    @BeforeEach
    public void setUp() {
        Producto producto1 = new Producto("producto1", 50.0, TipoProducto.BEBIDA, true, true);
        Producto producto2 = new Producto("producto2", 100.0, TipoProducto.BEBIDA, true, true);
        Producto producto3 = new Producto("producto3", 150.0, TipoProducto.PLATILLO, true, true);
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(producto1);
            em.persist(producto2);
            em.persist(producto3);
            em.getTransaction().commit();
            productosAgregados.add(producto1);
            productosAgregados.add(producto2);
            productosAgregados.add(producto3);
        } catch (Exception e) {
            em.getTransaction().rollback();
            fail("Error al insertar productos de prueba: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Elimina los productos que fueron agregados durante las pruebas.
     */
    @AfterEach
    public void tearDown() {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            if (productoAgregado != null) {
                Producto productoGestionado = em.merge(productoAgregado);
                em.remove(productoGestionado);
                productoAgregado = null;
            }
            for (Producto productoAgregado : productosAgregados) {
                Producto productoGestionado = em.merge(productoAgregado);
                em.remove(productoGestionado);
            }
            em.getTransaction().commit();
            productosAgregados.clear();
        } catch (Exception e) {
            em.getTransaction().rollback();
            fail("Error al eliminar productos de prueba: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Prueba del método obtenerProductos().
     */
    @Test
    public void testObtenerProductos() throws Exception {
        System.out.println("Prueba de método obtenerProductos()");
        try {

            List<Producto> resultado = instanciaProductoDAO.obtenerProductos();
            assertTrue(!resultado.isEmpty());
            assertNotNull(resultado);
        } catch (PersistenciaException e) {
            fail("Excepcion al obtener los productos: " + e.getMessage());
        }
    }

    /**
     * Prueba del método obtenerProductoPorNombre().
     */
    @Test
    public void testObtenerProductoPorNombre() throws Exception {
        System.out.println("Prueba de método obtenerProductoPorNombre()");
        String nombre = "producto1";
        try {
            Producto resultado = instanciaProductoDAO.obtenerProductoPorNombre(nombre);
            assertNotNull(resultado);
            assertEquals(nombre, resultado.getNombre());
        } catch (PersistenciaException e) {
            fail("Excepcion al obtener el producto por su nombre: " + e.getMessage());
        }
    }

    /**
     * Prueba del método registrarProducto() cuando su funcionamiento debe ser
     * correcto.
     */
    @Test
    public void testRegistrarProductoOk() throws Exception {
        System.out.println("Prueba de método registrarProducto()");
        Producto producto = new Producto("productoNuevo", 50.0, TipoProducto.BEBIDA, true, true);
        try {
            boolean resultado = instanciaProductoDAO.registrarProducto(producto);
            productoAgregado = instanciaProductoDAO.obtenerProductoPorNombre("productoNuevo");
            assertTrue(resultado);
            assertNotNull(productoAgregado);
            assertAll(
                    () -> assertEquals(producto.getNombre(), productoAgregado.getNombre()),
                    () -> assertEquals(producto.getPrecio(), productoAgregado.getPrecio()),
                    () -> assertEquals(producto.getTipo(), productoAgregado.getTipo())
            );
        } catch (PersistenciaException e) {
            fail("Excepcion al registrar el producto: " + e.getMessage());
        }
    }

    /**
     * Prueba del método registrarProducto() cuando lanza excepción porque el
     * producto es nulo.
     *
     */
    @Test
    public void testRegistrarProductoNulo() throws Exception {
        System.out.println("Prueba de método registrarProducto() para un producto nulo");
        Producto producto = null;
        PersistenciaException ex = assertThrows(PersistenciaException.class, () -> instanciaProductoDAO.registrarProducto(producto));
        assertNotNull(ex);
    }

    /**
     * Prueba del método registrarProducto() cuando lanza excepción porque el
     * nombre del producto ya esta registrado en otro producto.
     *
     */
    @Test
    public void testRegistrarProductoNombreRepetido() throws Exception {
        System.out.println("Prueba de método registrarProducto() para un producto con nombre que ya esta en la base de datos");
        Producto producto = new Producto("producto1", 25.0, TipoProducto.POSTRE, true, true);
        PersistenciaException ex = assertThrows(PersistenciaException.class, () -> instanciaProductoDAO.registrarProducto(producto));
        assertNotNull(ex);
    }

    /**
     * Prueba del método registrarProducto() cuando lanza excepción porque el
     * precio del producto es nulo.
     *
     */
    @Test
    public void testRegistrarProductoSinPrecio() throws Exception {
        System.out.println("Prueba de método registrarProducto() para un producto con precio nulo");
        Producto producto = new Producto("productoNuevo", null, TipoProducto.POSTRE, true, true);
        PersistenciaException ex = assertThrows(PersistenciaException.class, () -> instanciaProductoDAO.registrarProducto(producto));
        assertNotNull(ex);
    }

    /**
     * Prueba del método registrarProducto() cuando lanza excepción porque la
     * categoria del producto es nula.
     *
     */
    @Test
    public void testRegistrarProductoSinCategoria() throws Exception {
        System.out.println("Prueba de método registrarProducto() para un producto con categoria nula");
        Producto producto = new Producto("productoNuevo", 25.0, null, true, true);
        PersistenciaException ex = assertThrows(PersistenciaException.class, () -> instanciaProductoDAO.registrarProducto(producto));
        assertNotNull(ex);
    }

    /**
     * Prueba del método registrarProducto() cuando lanza excepción porque el
     * nombre del producto es nulo.
     *
     */
    @Test
    public void testRegistrarProductoSinNombre() throws Exception {
        System.out.println("Prueba de método registrarProducto() para un producto con nombre nulo");
        Producto producto = new Producto(null, 25.0, TipoProducto.POSTRE, true, true);
        PersistenciaException ex = assertThrows(PersistenciaException.class, () -> instanciaProductoDAO.registrarProducto(producto));
        assertNotNull(ex);
    }

    /**
     * Prueba del método actualizarProducto().
     */
    @Test
    public void testActualizarProducto() throws Exception {
        System.out.println("prueba de método actualizarProducto()");
        Producto producto = productosAgregados.get(1);
        Double precio = 75.0;
        producto.setPrecio(precio);
        boolean actualizado = instanciaProductoDAO.actualizarProducto(producto);
        Producto productoActualizado = instanciaProductoDAO.obtenerProductoPorNombre(producto.getNombre());
        assertTrue(actualizado);
        assertEquals(precio, productoActualizado.getPrecio());
    }

    /**
     * Prueba del método deshabilitarHabilitarProducto()
     *
     */
    @Test
    public void testDeshabilitarHabilitarProducto() throws Exception {
        System.out.println("Prueba de método deshabilitarHabilitarProducto()");
        Producto producto = productosAgregados.get(0);
        boolean nuevoEstado = !producto.isHabilitada();
        boolean resultado = instanciaProductoDAO.deshabilitarHabilitarProducto(producto.getNombre(), nuevoEstado);
        Producto modificado = instanciaProductoDAO.obtenerProductoPorNombre(producto.getNombre());
        assertTrue(resultado);
        assertEquals(nuevoEstado, modificado.isHabilitada());
    }

    /**
     * Prueba del método buscarPorFiltros(nombre).
     */
    @Test
    public void testBuscarPorFiltrosPorNombre() throws Exception {
        System.out.println("Prueba de método buscarPorFiltros(nombre)");
        List<Producto> resultado = instanciaProductoDAO.buscarPorFiltros("producto1", null);
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        List<Producto> resultado2 = instanciaProductoDAO.buscarPorFiltros("prod", null);
        assertNotNull(resultado2);
        assertTrue(resultado2.size() >= 3);
    }

    /**
     * Prueba del método buscarPorFiltros(nombre, categoria).
     */
    @Test
    public void testBuscarPorFiltrosPorNombreYCategoria() throws Exception {
        System.out.println("Prueba de método buscarPorFiltros(nombre, tipo)");
        List<Producto> resultado = instanciaProductoDAO.buscarPorFiltros("producto", TipoProducto.BEBIDA);
        assertNotNull(resultado);
        assertTrue(resultado.size() >= 2);
    }

    /**
     * Prueba del método buscarPorFiltros(categoria).
     */
    @Test
    public void testBuscarPorFiltrosPorCategoria() throws Exception {
        System.out.println("Prueba de método buscarPorFiltros(tipo)");
        List<Producto> resultado = instanciaProductoDAO.buscarPorFiltros(null, TipoProducto.PLATILLO);
        assertNotNull(resultado);
        assertTrue(resultado.size() >= 1);
    }

    /**
     * Prueba del método productoEnComandaActiva()
     */
    @Test
    public void testProductoEnComandaActiva() throws Exception {
        System.out.println("Prueba de método productoEnComandaActiva()");
        boolean resultado = instanciaProductoDAO.productoEnComandaActiva("producto1");
        assertTrue(resultado == false);
    }
}
