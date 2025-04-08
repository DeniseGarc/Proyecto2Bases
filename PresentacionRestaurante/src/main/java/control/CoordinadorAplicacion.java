/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.ClienteFrecuenteDTO;
import DTOs.IngredienteDTO;
import DTOs.ProductoDTO;
import DTOs.ProductoDetalleDTO;
import GUIs.ClienteFrecuente;
import GUIs.ComandaAgregarCliente;
import GUIs.EliminarIngrediente;
import GUIs.MenuPrincipal;
import GUIs.PantallaAdministrarProducto;
import GUIs.PantallaComandas;
import GUIs.PantallaDetallesProducto;
import GUIs.PantallaIngredientes;
import GUIs.PantallaInicio;
import GUIs.PantallaProductos;
import GUIs.PantallaTomaComanda;
import GUIs.RegistrarClienteNuevo;
import GUIs.frmAgregarIngrediente;
import control.exception.CoordinadorException;
import enumeradores.TipoProducto;
import exception.NegocioException;
import interfaces.IClienteFrecuenteBO;
import interfaces.IIngredienteBO;
import interfaces.IProductoBO;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import manejadorBO.ManejadorBO;
import modos.Modo;

/**
 *
 * @author erika
 */
public class CoordinadorAplicacion {

    private IProductoBO productoBO = ManejadorBO.crearProductoBO();
    private IIngredienteBO ingredienteBO = ManejadorBO.crearIngredienteBO();
    private IClienteFrecuenteBO clienteFrecuenteBO = ManejadorBO.crearClienteFrecuenteBO();

    /**
     * Método que define a que pantalla se va redirigir cuando se le da a la
     * flecha de regreso en los titulos.
     *
     * @param target Frame destino
     * @param padre Frame que contiene la flecha
     */
    public void regresarPantalla(JFrame target, JFrame padre) {
        target.setVisible(true);
        padre.dispose();
    }

    public void PantallaInicio() {
        PantallaInicio inicio = new PantallaInicio();
        inicio.setVisible(true);
    }

    public void PantallaPrinicipal(JFrame frame) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        frame.dispose();
    }

    public void PantallaComandas(JFrame frame) {
        PantallaComandas comandas = new PantallaComandas();
        comandas.setVisible(true);
        frame.dispose();
    }

    public void PantallaIngredientes(JFrame frame) {
        PantallaIngredientes pantallaIngredientes = new PantallaIngredientes();
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

    /**
     * Método para redirigir a la pantalla de productos.
     *
     * @param frame Frame padre desde el cual se invoca la siguiente pantalla.
     */
    public void pantallaProductos(JFrame frame) {
        PantallaProductos pantallaProductos = new PantallaProductos();
        pantallaProductos.setVisible(true);
        frame.dispose();
    }

    /**
     * Método para redirigir a la pantalla que muestra los detalles del producto
     * seleccionado.
     *
     * @param frame Frame padre desde el cual se invoca la siguiente pantalla.
     * @param producto Producto y sus ingredientes los cuales se van a cargar en
     * la pantalla.
     */
    public void pantallaDetallesProducto(JFrame frame, ProductoDetalleDTO producto) {
        PantallaDetallesProducto pantallaDetallesProducto = new PantallaDetallesProducto(producto);
        pantallaDetallesProducto.setVisible(true);
        frame.dispose();
    }

    /**
     * Método para redirigir a la pantalla que permite agregar un producto.
     *
     * @param frame Frame padre desde el cual se invoca la siguiente pantalla.
     */
    public void pantallaAgregarProducto(JFrame frame) {
        PantallaAdministrarProducto pantallaAdministrarProducto = new PantallaAdministrarProducto(Modo.AGREGAR, null);
        pantallaAdministrarProducto.setVisible(true);
        frame.dispose();
    }

    /**
     * Método para redirigir a la pantalla que permite actualizar un producto.
     *
     * @param frame Frame padre desde el cual se invoca la siguiente pantalla.
     * @param producto Producto y sus ingredientes los cuales se van a cargar en
     * la pantalla.
     */
    public void pantallaModificarProducto(JFrame frame, ProductoDetalleDTO producto) {
        PantallaAdministrarProducto pantallaAdministrarProducto = new PantallaAdministrarProducto(Modo.MODIFICAR, producto);
        pantallaAdministrarProducto.setVisible(true);
        frame.dispose();
    }
    
    /**
     * Método para redirigir a la pantalla que permite agregar mesa 
     * @param frame 
     */
    public void pantallaComandaAgregarCliente(JFrame frame) {
        ComandaAgregarCliente pantallaComandaAgregarCliente = new ComandaAgregarCliente();
        pantallaComandaAgregarCliente.setVisible(true);
        frame.dispose();
    }

    /**
     * Obtiene todos los productos registrados en el sistema.
     *
     * @return Lista de DTOs con información básica de los productos
     * @throws CoordinadorException Si ocurre un error al recuperar los
     * productos
     */
    public List<ProductoDTO> obtenerProductos() throws CoordinadorException {
        try {
            return productoBO.obtenerProductos();
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al obtener los productos");
        }
    }

    /**
     * Obtiene productos filtrados por nombre y/o categoría.
     *
     * @param texto Texto para búsqueda parcial en nombres (puede ser null)
     * @param categoria Categoría para filtrar (puede ser null)
     * @return Lista de productos que coinciden con los criterios
     * @throws CoordinadorException Si ocurre un error en el filtrado
     */
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

    /**
     * Obtiene los detalles completos de un producto por su nombre.
     *
     * @param nombre Nombre exacto del producto a buscar
     * @return DTO con todos los detalles del producto
     * @throws CoordinadorException Si el producto no existe o hay un error al
     * recuperarlo
     */
    public ProductoDetalleDTO obtenerDetallesDelProducto(String nombre) throws CoordinadorException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new CoordinadorException("No ha sido posible recuperar el nombre del producto");
        }
        try {
            ProductoDetalleDTO producto = productoBO.obtenerProductoDetallesPorNombre(nombre);
            if (producto == null) {
                throw new CoordinadorException("No ha sido posible recuperar el producto con el nombre recuperado");
            }
            return producto;
        } catch (NegocioException e) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, e);
            throw new CoordinadorException("Ha ocurrido un error al obtener el producto y sus detalles");
        }
    }

    /**
     * Verifica si un nombre de producto es válido y no está duplicado en el
     * sistema.
     *
     * @param nombre Nombre del producto a validar
     * @return true si el nombre es válido y único, false si ya existe o es
     * inválido
     * @throws CoordinadorException Si ocurre un error al verificar la
     * existencia del producto
     */
    public boolean validarNombreProducto(String nombre) throws CoordinadorException {
        if (nombre == null || nombre.trim().isEmpty() || nombre.length() > 100) {
            return false;
        }
        try {
            return productoBO.obtenerProductoDetallesPorNombre(nombre) == null;
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al validar la existencia de otro producto con el mismo nombre");
        }
    }

    /**
     * Registra un nuevo producto en el sistema después de validar sus datos.
     *
     * @param producto DTO con los datos del nuevo producto
     * @return true si el registro fue exitoso
     * @throws CoordinadorException Si los datos son inválidos o ocurre un error
     * en el registro
     */
    public boolean agregarProducto(ProductoDetalleDTO producto) throws CoordinadorException {
        if (validarDatosProducto(producto)) {
            try {
                return productoBO.agregarProducto(producto);
            } catch (NegocioException ex) {
                Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
                throw new CoordinadorException("Ha ocurrido un error al intentar agregar el producto");
            }
        }
        return false;
    }

    /**
     * Actualiza los datos de un producto existente después de validarlos.
     *
     * @param producto DTO con los datos actualizados del producto
     * @return true si la actualización fue exitosa
     * @throws CoordinadorException Si los datos son inválidos o ocurre un error
     * en la actualización
     */
    public boolean actualizarProducto(ProductoDetalleDTO producto) throws CoordinadorException {
        if (validarDatosProducto(producto)) {
            try {
                return productoBO.actualizarProducto(producto);
            } catch (NegocioException ex) {
                Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
                throw new CoordinadorException("Ha ocurrido un error al intentar actualizar el producto");
            }
        }
        return false;
    }

    /**
     * Valida los datos básicos de un producto antes de su registro o
     * actualización.
     *
     * @param producto DTO con los datos del producto a validar
     * @return true si todos los datos son válidos
     * @throws CoordinadorException Si algún dato requerido es inválido o
     * faltante
     */
    private boolean validarDatosProducto(ProductoDetalleDTO producto) throws CoordinadorException {
        if (producto == null) {
            throw new CoordinadorException("El producto a agregar no puede ser nulo");
        }
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new CoordinadorException("El nombre del producto es nulo o esta vacio");
        }
        if (producto.getTipo() == null) {
            throw new CoordinadorException("El producto no tiene una categoria asignada");
        }
        if (producto.getPrecio() <= 0) {
            throw new CoordinadorException("El producto tiene un precio negativo");
        }
        if (producto.getIngredientes().isEmpty() || producto.getIngredientes() == null) {
            throw new CoordinadorException("El producto no tiene ingredientes asociados");
        }
        return true;
    }

    /**
     * Actualiza el estado de habilitado de un producto (activo/inactivo).
     *
     * @param nombre Nombre exacto del producto cuyo estado se desea cambiar
     * @return true si la operación fue exitosa, false en caso contrario
     * @throws CoordinadorException Si ocurre un error al actualizar el estado
     */
    public boolean actualizarEstadoProducto(String nombre) throws CoordinadorException {
        try {
            return productoBO.cambiarEstadoProducto(nombre);
        } catch (NegocioException e) {
            throw new CoordinadorException("Ha ocurrido un problema al actualizar el estado del producto");
        }
    }

    public IngredienteDTO agregarIngrediente(IngredienteDTO ingrediente) throws CoordinadorException {
        if (ingrediente == null) {
            throw new CoordinadorException("El producto a agregar no puede ser nulo");
        }
        if (ingrediente.getNombre() == null) {
            throw new CoordinadorException("El nombre no puede ser nulo");
        }
        if (ingrediente.getUnidadMedida() == null) {
            throw new CoordinadorException("El ingrediente no tiene una Unidad de medida asignada");
        } else {
            try {
                ingredienteBO.agregarIngrediente(ingrediente);
            } catch (NegocioException ex) {
                Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
                throw new CoordinadorException(ex.getMessage());
            }
        }
        return ingrediente;
    }

    public boolean eliminarIngrediente(IngredienteDTO ingrediente) throws CoordinadorException {
        try {
            ingredienteBO.eliminarIngrediente(ingrediente.getId());
            return true;
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("No se pudo eliminar el ingrediente");
        }

    }

    /**
     * Muestra todos los ingredientes
     *
     * @return lista de ingredientesDTO
     * @throws CoordinadorException
     */
    public List<IngredienteDTO> mostrarIngredientes() throws CoordinadorException {
        try {
            return ingredienteBO.obtenerIngredientes();
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al obtener los ingredientes");
        }
    }

    /**
     * llama al metodo para buscar ingredientes por unidad
     *
     * @param unidad de medida
     * @return Lista de ingredientes
     * @throws CoordinadorException
     */
    public List<IngredienteDTO> buscarIngredientePorUniad(String unidad) throws CoordinadorException {
        try {
            // Validar que la unidad no sea nula o vacía
            if (unidad == null || unidad.isBlank()) {
                throw new CoordinadorException("La unidad seleccionada no puede estar vacía.");
            }

            // Llamar al método del BO para buscar ingredientes
            List<IngredienteDTO> ingredientes = ingredienteBO.buscarPorUnidad(unidad);

            // Verificar si la lista está vacía y manejar esto
            if (ingredientes == null || ingredientes.isEmpty()) {
                System.out.println("No se encontraron ingredientes para la unidad: " + unidad);
                return Collections.emptyList(); // Retornar una lista vacía
            }

            // Retornar los ingredientes obtenidos
            return ingredientes;

        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, "Error en buscarPorUnidad", ex);
            throw new CoordinadorException("Ha ocurrido un error al buscar los ingredientes: " + ex.getMessage());
        } catch (CoordinadorException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, "Excepción inesperada en buscarPorUnidad", ex);
            throw new CoordinadorException("Error inesperado: " + ex.getMessage());
        }
    }

    public List<IngredienteDTO> mostrarIngredientesSinProducto() throws CoordinadorException {
        try {
            return ingredienteBO.obtenerIngredientesSinProducto();
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al obtener los Ingredientes");
        }
    }

    public IngredienteDTO modificarStock(Long id, int stock) throws CoordinadorException {
        try {
            return ingredienteBO.actualizarStock(id, stock);
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al actualizar el stock");
        }
    }

    public List<IngredienteDTO> buscarPorNombreYUnidad(String nombre, String unidad) throws CoordinadorException {
        try {
            return ingredienteBO.buscarPorNombreYUnidad(nombre, unidad);

        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al buscar el ingrediente");
        }
    }

    public List<IngredienteDTO> buscarPorNombre(String nombre) throws CoordinadorException {
        try {
            return ingredienteBO.obtenerIngredientesPorNombre(nombre);
        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al buscar el ingrediente");
        }
    }

    public IngredienteDTO buscarPorNombreYUnidad1(String nombre, String unidad) throws CoordinadorException {
        try {
            return ingredienteBO.buscarPorNombreYUnidad1(nombre, unidad);

        } catch (NegocioException ex) {
            Logger.getLogger(CoordinadorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Ha ocurrido un error al buscar el ingrediente");
        }
    }

    public ClienteFrecuenteDTO registrarNuevoClienteFrecuente(ClienteFrecuenteDTO clienteFrecuente) throws CoordinadorException {
        try {
            validarCliente(clienteFrecuente);
            List<ClienteFrecuenteDTO> clientes = obtenerClientesFrecuentes();
            boolean telefonoDuplicado = clientes.stream()
                    .anyMatch(c -> c.getTelefono().equals(clienteFrecuente.getTelefono()));
            if (telefonoDuplicado) {
                throw new CoordinadorException("Este número de teléfono ya está registrado.");
            }

            return clienteFrecuenteBO.registrarNuevoClienteFrecuente(clienteFrecuente);
        } catch (NegocioException e) {
            throw new CoordinadorException("No se pudo registrar el cliente.", e);
        }
    }

    private void validarCliente(ClienteFrecuenteDTO clienteFrecuente) throws CoordinadorException {
        if (clienteFrecuente == null) {
            throw new CoordinadorException("El cliente no puede ser nulo.");
        }
        if (clienteFrecuente.getNombre() == null || clienteFrecuente.getNombre().trim().isEmpty()) {
            throw new CoordinadorException("El nombre del cliente es obligatorio.");
        }
        if (clienteFrecuente.getTelefono() == null || clienteFrecuente.getTelefono().trim().isEmpty()) {
            throw new CoordinadorException("El teléfono es obligatorio.");
        }
        if (!clienteFrecuente.getTelefono().matches("\\d{10,15}")) {
            throw new CoordinadorException("El teléfono no es valido.");
        }
        if (!clienteFrecuente.getCorreoElectronico().isEmpty()) {
            if (!clienteFrecuente.getCorreoElectronico().matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                throw new CoordinadorException("El formato del correo no es valido.");
            }
        }
    }

    public List<ClienteFrecuenteDTO> obtenerClientesFrecuentes() throws CoordinadorException {
        try {
            return clienteFrecuenteBO.obtenerClientesFrecuentes();
        } catch (NegocioException e) {
            throw new CoordinadorException("Ha ocurrido un error al consultar los clientes.");
        }
    }

    public List<ClienteFrecuenteDTO> obtenerClientesPorNombre(String nombre) throws CoordinadorException {
        try {
            return clienteFrecuenteBO.obtenerClientesPorNombre(nombre);
        } catch (NegocioException e) {
            throw new CoordinadorException("Ha ocurrido un error al consultar los clientes por su nombre.");
        }
    }

    public List<ClienteFrecuenteDTO> obtenerClientesPorTelefono(String telefono) throws CoordinadorException {
        try {
            return clienteFrecuenteBO.obtenerClientesPorTelefono(telefono);
        } catch (NegocioException e) {
            throw new CoordinadorException("Ha ocurrido un error al consultar los clientes por su teléfono.");
        }
    }

    public List<ClienteFrecuenteDTO> obtenerClientesPorCorreo(String correo) throws CoordinadorException {
        try {
            return clienteFrecuenteBO.obtenerClientesPorCorreo(correo);
        } catch (NegocioException e) {
            throw new CoordinadorException("Ha ocurrido un error al consultar los clientes por su correo.");
        }
    }
}
