/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import entidades.DetalleComanda;
import entidades.DetalleProductoIngrediente;
import entidades.Ingrediente;
import entidades.Producto;
import enumeradores.Estado;
import exception.PersistenciaException;
import interfaces.IComandaDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *Clase que implementa las operaciones de acceso a datos para la entidad
 * Comanda, utilizando JPA para persistencia.
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
     * Metodo privado para descontar el stock de los ingredientes cuando se marca la comanda como entregada
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




    

}
