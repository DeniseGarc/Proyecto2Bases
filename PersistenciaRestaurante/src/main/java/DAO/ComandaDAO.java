/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTOs.DetalleReporteComandaDTO;
import conexion.Conexion;
import entidades.Cliente;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import entidades.DetalleComanda;
import entidades.DetalleProductoIngrediente;
import entidades.Ingrediente;
import entidades.Producto;
import entidades.Mesa;
import enumeradores.Estado;
import exception.PersistenciaException;
import extras.Periodo;
import interfaces.IComandaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad
 * Comanda, utilizando JPA para persistencia.
 *
 * @author Maryr
 */
public class ComandaDAO implements IComandaDAO {

    /**
     * Instancia única de la clase ComandaDAO
     */
    public static ComandaDAO instanciaComandaDAO;

    /**
     * Constructor privado para aplicar el patrón Singleton
     */
    public ComandaDAO() {
    }

    /**
     * Metodo que devuelve la instancia única de ComandaDAO
     *
     * @return instancia única de ComandaDAO
     */
    public static ComandaDAO getInstanciaDAO() {
        if (instanciaComandaDAO == null) {
            instanciaComandaDAO = new ComandaDAO();
        }
        return instanciaComandaDAO;
    }

    /**
     * Método para obtener una lista de comandas de un cliente especifico
     *
     * @param clienteFrecuente del cual se requieren las comandas
     * @return la lista de comandas asociadas al cliente
     * @throws PersistenciaException
     */
    @Override
    public List<Comanda> obtenerComandasPorCliente(ClienteFrecuente clienteFrecuente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Comanda c WHERE c.cliente = :cliente", Comanda.class)
                    .setParameter("cliente", clienteFrecuente)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar comandas por cliente: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene la fecha de la ultima comanda hecha por el cliente dado
     *
     * @param clienteF cliente del cual se requiere la fecha
     * @return la fecha de la ultima comanda del cliente
     * @throws PersistenciaException
     */
    @Override
    public Calendar obtenerFechaUltimaComandaCliente(ClienteFrecuente clienteF) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Comanda c WHERE c.cliente = :clienteF ORDER BY c.fechaHora DESC", Calendar.class)
                    .setParameter("clienteF", clienteF)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Hubo un error al obtener la fecha de la ultima comanda del cliente: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Método para obtener una lista de todas las comandas registradas
     *
     * @return Lista de comandas registradas
     * @throws PersistenciaException
     */
    @Override
    public List<Comanda> obtenerComandas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Comanda c ", Comanda.class)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar comandas por cliente: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene las comanda de la base de datos cuyo estado sea activa
     *
     * @return Lista de comandas con estado activas
     * @throws PersistenciaException si ocurre algun error inesperado
     */
    @Override
    public List<Comanda> obtenerComandasActivas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM Comanda c WHERE c.estado = :estado", Comanda.class)
                    .setParameter("estado", Estado.ACTIVA)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar comandas por cliente: ", e);
        } finally {
            em.close();
        }
    }

    /**
     * Registra una nueva comanda en la base de datos
     *
     * @param comandaNueva Comanda nueva a registrar
     * @return True si se inserto correctamente la comanda en la base de datos
     * @throws PersistenciaException Si ocurre algun error inesperado
     */
    @Override
    public boolean registrarComanda(Comanda comandaNueva) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(comandaNueva);
            em.getTransaction().commit();
            return comandaNueva.getId() != null;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar la comanda", e);
        } finally {
            em.close();
        }

    }

    /**
     * Metodo que actualiza una comanda
     *
     * @param comanda Comanda a actualizar
     * @return True si se actualizo correctamente la comanda
     * @throws PersistenciaException si ocurre algun error inesperado
     */
    @Override
    public boolean actualizarComanda(Comanda comanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(comanda);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar la comanda", e);
        } finally {
            em.close();
        }
    }

    /**
     * Metodo para modificar el estado de la comanda
     *
     * @param comanda Comanda a modificar
     * @param nuevoEstado Estado al que se va a cambiar
     * @return True si se pudo actualizar correctamente
     * @throws PersistenciaException
     */
    @Override
    public boolean actualizarEstadoComanda(Comanda comanda, Estado nuevoEstado) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            if (comanda == null) {
                throw new PersistenciaException("Comanda no puede ser nula");
            }

            Comanda comandaGestionada = em.find(Comanda.class, comanda.getId());

            if (comandaGestionada == null) {
                throw new PersistenciaException("La comanda no existe en la base de datos");
            }

            // Solo si se cambia a ENTREGADA, descontar stock
            if (nuevoEstado == Estado.ENTREGADA) {
                descontarStock(comandaGestionada, em);
            }

            comandaGestionada.setEstado(nuevoEstado);
            em.merge(comandaGestionada);

            em.getTransaction().commit();
            return true;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar el estado de la comanda", e);
        } finally {
            em.close();
        }
    }

    /**
     * Metodo privado para descontar el stock de los ingredientes cuando se
     * marca la comanda como entregada
     *
     * @param comanda Comanda que se actualiza
     * @param em
     */
    private void descontarStock(Comanda comanda, EntityManager em) {
        for (DetalleComanda detalle : comanda.getDetallesComanda()) {
            Producto producto = detalle.getProducto();
            int cantidadComanda = detalle.getCantidad();

            for (DetalleProductoIngrediente dpi : producto.getDetallesProducto()) {
                Ingrediente ingrediente = dpi.getIngrediente();
                int cantidadIngrediente = dpi.getCantidad() * cantidadComanda;

                int nuevoStock = ingrediente.getStock() - cantidadIngrediente;

                if (nuevoStock < 0) {
                    throw new IllegalStateException("No hay suficiente stock para el ingrediente: " + ingrediente.getNombre());
                }

                ingrediente.setStock(nuevoStock);
                em.merge(ingrediente);
            }
        }
    }

    @Override
    public List<DetalleReporteComandaDTO> generarReporteComandas(Periodo periodo) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        List<DetalleReporteComandaDTO> detallesReporteComandaDTO = new ArrayList<>();
        try {
            em.getTransaction().begin();
            List<Object[]> resultados = em.createQuery(
                    "SELECT c.id, c.fechaHora, m.numero, c.totalVenta, c.estado, cl.nombre FROM Comanda c "
                    + "LEFT JOIN c.mesa m "
                    + "LEFT JOIN c.cliente cl WHERE c.fechaHora BETWEEN :fechaInicio AND :fechaFin", Object[].class)
                    .setParameter("fechaInicio", periodo.getFechaInicio().getTime())
                    .setParameter("fechaFin", periodo.getFechaFin().getTime())
                    .getResultList();
            em.getTransaction().commit();
            for (Object[] row : resultados) {
                DetalleReporteComandaDTO detalleReporteComandaDTO = new DetalleReporteComandaDTO(
                        (Long) row[0], // id de la comanda
                        (Calendar) row[1], // fecha y hora de la comanda
                        (Long) row[2], // numero de mesa
                        (Double) row[3], // total de la comanda
                        (Estado) row[4], // estado de la comanda
                        (String) row[5]); // cliente asociado
                detallesReporteComandaDTO.add(detalleReporteComandaDTO);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al intentar consultar los detalles del reporte de comandas: " + e.getMessage());
        } finally {
            em.close();
        }
        return detallesReporteComandaDTO;
    }

    @Override
    public Calendar obtenerFechaPrimerComanda() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        List<DetalleReporteComandaDTO> detallesReporteComandaDTO = new ArrayList<>();
        try {
            try {
                return em.createQuery(
                        "SELECT c.fechaHora FROM Comanda c ORDER BY c.fechaHora ASC", Calendar.class)
                        .setMaxResults(1)
                        .getSingleResult();
            } catch (NoResultException e) {
                return null; // No hay comandas en la base de datos
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al intentar consultar la fecha de la primer comanda" + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Calendar obtenerFechaUltimaComanda() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        List<DetalleReporteComandaDTO> detallesReporteComandaDTO = new ArrayList<>();
        try {
            try {
                return em.createQuery(
                        "SELECT c.fechaHora FROM Comanda c ORDER BY c.fechaHora DESC", Calendar.class)
                        .setMaxResults(1)
                        .getSingleResult();
            } catch (NoResultException e) {
                return null; // No hay comandas en la base de datos
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al intentar consultar la fecha de la primer comanda" + e.getMessage());
        } finally {
            em.close();
        }
    }

}
