/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ClienteFrecuenteDTO;
import DTOs.ComandaDTO;
import DTOs.DetalleComandaDTO;
import DTOs.DetalleReporteComandaDTO;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import entidades.DetalleComanda;
import entidades.Mesa;
import entidades.Producto;
import enumeradores.Estado;
import exception.NegocioException;
import exception.PersistenciaException;
import extras.Periodo;
import interfaces.IComandaBO;
import interfaces.IComandaDAO;
import interfaces.IMesaDAO;
import interfaces.IProductoDAO;
import interfaces.IClienteFrecuenteDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.ClienteMapper;
import mappers.ComandaMapper;

/**
 * Clase que implementa la lógica de negocio para operaciones relacionadas con
 * comandas
 *
 * @author erika
 */
public class ComandaBO implements IComandaBO {

    private IComandaDAO comandaDAO;
    private IProductoDAO productoDAO;
    private IMesaDAO mesaDAO;
    private IClienteFrecuenteDAO clienteFrecuenteDAO;

    /**
     * Constructor que inicializa las dependencias DAO necesarias
     *
     * @param comandaDAO Implementación de IComandaDAO para acceso a datos de
     * Comanda
     * @param productoDAO Implementación de IProductoDAO para acceso a datos de
     * Producto
     * @param mesaDAO Implementación de IMesaDAO para acceso a datos de Mesa
     * @param clienteFrecuenteDAO Implementación de IClienteFrecuenteDAO para
     * acceso a datos de Cliente Frecuente
     */
    public ComandaBO(IComandaDAO comandaDAO, IProductoDAO productoDAO, IMesaDAO mesaDAO, IClienteFrecuenteDAO clienteFrecuenteDAO) {
        this.comandaDAO = comandaDAO;
        this.productoDAO = productoDAO;
        this.clienteFrecuenteDAO = clienteFrecuenteDAO;
        this.mesaDAO = mesaDAO;

    }

    /**
     * Metodo para obtener todas las comandas guardadas en la base de datos
     *
     * @return Lista de comandas
     * @throws NegocioException
     */
    @Override
    public List<ComandaDTO> obtenerComandas() throws NegocioException {
        try {
            List<Comanda> comandas = comandaDAO.obtenerComandas();
            return ComandaMapper.toDtoList(comandas);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener las comandas");
        }
    }

    /**
     * Regresa la comandas activas
     *
     * @return Lista de comandas
     * @throws NegocioException
     */
    @Override
    public List<ComandaDTO> obtenerComandasActivas() throws NegocioException {
        try {
            List<Comanda> comandas = comandaDAO.obtenerComandasActivas();
            return ComandaMapper.toDtoList(comandas);
        } catch (PersistenciaException e) {
            throw new NegocioException("Ocurrió un error al obtener las comandas Activas");
        }
    }

    /**
     * Metodo para actualizar una comanda
     *
     * @param comandaActualizar Comanda a actualizar
     * @return True si se actualizo la comanda
     * @throws NegocioException Si ocurre algun error al actualizar
     */
    @Override
    public boolean actualizarComanda(ComandaDTO comandaActualizar) throws NegocioException {
        if (comandaActualizar == null) {
            throw new NegocioException("La comanda a actualizar es nula");
        }
        if (comandaActualizar.getNumeroMesa() == null) {
            throw new NegocioException("El número de mesa de la comanda a actualizar es nula");
        }
        try {
            Mesa mesa = mesaDAO.obtenerMesaPorNumero(Long.valueOf(comandaActualizar.getNumeroMesa()));
            ClienteFrecuente cliente = null;
            if (comandaActualizar.getIdCliente() != null) {
//                cliente = clienteFrecuenteDAO.obtenerClientePorId(comandaActualizar.getIdCliente());
            }
            Comanda comanda = ComandaMapper.toEntity(comandaActualizar, cliente, mesa);
            List<DetalleComanda> detallesComanda = new ArrayList<>();
            for (DetalleComandaDTO detalleComandaDTO : comandaActualizar.getDetallesComanda()) {
                Producto producto = productoDAO.obtenerProductoPorNombre(detalleComandaDTO.getNombreProducto());
                detallesComanda.add(
                        new DetalleComanda(
                                detalleComandaDTO.getPrecioUnitario(),
                                detalleComandaDTO.getCantidad(),
                                detalleComandaDTO.getImporteTotal(),
                                detalleComandaDTO.getNotas(),
                                producto,
                                comanda)
                );
            }
            comanda.setDetallesComanda(detallesComanda);
            return comandaDAO.actualizarComanda(comanda);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComandaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ocurrió un error al actualizar la comanda");
        }
    }

    /**
     * Metodo para agregar una comanda nueva
     *
     * @param comandaNueva Comanda a agregar
     * @return True si se agrego la comanda
     * @throws NegocioException Si ocurre algun error al agregar la comanda
     */
    @Override
    public boolean agregarComanda(ComandaDTO comandaNueva) throws NegocioException {
        if (comandaNueva == null) {
            throw new NegocioException("La comanda a registrar es nula");
        }
        if (comandaNueva.getNumeroMesa() == null) {
            throw new NegocioException("El número de mesa de la comanda a actualizar es nula");
        }
        try {
            Mesa mesa = mesaDAO.obtenerMesaPorNumero(Long.valueOf(comandaNueva.getNumeroMesa()));
            ClienteFrecuente cliente = null;
            if (comandaNueva.getIdCliente() != null) {
                cliente = clienteFrecuenteDAO.obtenerClientePorId(comandaNueva.getIdCliente());
            }
            Comanda comanda = ComandaMapper.toEntity(comandaNueva, cliente, mesa);
            List<DetalleComanda> detallesComanda = new ArrayList<>();
            for (DetalleComandaDTO detalleComandaDTO : comandaNueva.getDetallesComanda()) {
                Producto producto = productoDAO.obtenerProductoPorNombre(detalleComandaDTO.getNombreProducto());
                detallesComanda.add(
                        new DetalleComanda(
                                detalleComandaDTO.getPrecioUnitario(),
                                detalleComandaDTO.getCantidad(),
                                detalleComandaDTO.getImporteTotal(),
                                detalleComandaDTO.getNotas(),
                                producto,
                                comanda)
                );
            }
            comanda.setDetallesComanda(detallesComanda);
            return comandaDAO.registrarComanda(comanda);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComandaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ocurrió un error al registrar la comanda");
        }
    }

    /**
     * Metodo para actualizar el estado de las comandas
     *
     * @param comanda Comanda a actualizar
     * @param nuevoEstado Esrado al que se va a actualizar la comanda
     * @return True si la comanda se actualizo correctamente
     * @throws NegocioException
     */
    @Override
    public boolean actualizarEstadoComanda(ComandaDTO comanda, Estado nuevoEstado) throws NegocioException {
        try {
            if (comanda == null) {
                throw new NegocioException("La comandaDTO no puede ser nula");
            }
            if (nuevoEstado == null) {
                throw new NegocioException("El nuevo estado no puede ser nulo");
            }
            if (comanda.getId() == null) {
                throw new NegocioException("El ID de la comandaDTO no está establecido");
            }

            // Convertir el DTO a entidad Comanda utilizando el Mapper
            Comanda comandaEntidad = ComandaMapper.toEntity(comanda, null, null);

            // Llamar al DAO para actualizar el estado
            return comandaDAO.actualizarEstadoComanda(comandaEntidad, nuevoEstado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el estado de la comanda: " + e.getMessage(), e);
        }
    }

    @Override
    public List<DetalleReporteComandaDTO> obtenerDetallesReporteComanda(Periodo periodo) throws NegocioException {
        try {
            if (periodo == null) {
                Calendar fechaInicio = comandaDAO.obtenerFechaPrimerComanda();
                Calendar fechaFin = comandaDAO.obtenerFechaUltimaComanda();
                periodo = new Periodo(fechaInicio, fechaFin);
            }
            List<DetalleReporteComandaDTO> detallesReporteComandaConFolio = comandaDAO.generarReporteComandas(periodo);
            for (DetalleReporteComandaDTO detalleReporteComandaDTO : detallesReporteComandaConFolio) {
                String folio = generarFolio(detalleReporteComandaDTO);
                detalleReporteComandaDTO.setFolio(folio);
            }
            return detallesReporteComandaConFolio;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComandaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Ha ocurrido un error al intentar consultar los detalles del reporte de comandas: " + ex.getMessage(), ex);
        }
    }

    private String generarFolio(DetalleReporteComandaDTO detalleReporte) {
        String fecha = new SimpleDateFormat("yyyyMMdd").format(detalleReporte.getFechaHora().getTime());
        return "OB-" + fecha + "-" + String.format("%03d", Long.valueOf(detalleReporte.getFolio()));
    }

    /**
     * Obtiene la fecha de la ultima comanda hecha por el cliente dado
     *
     * @param clienteF cliente del cual se requiere la fecha
     * @return la fecha de la ultima comanda del cliente
     * @throws NegocioException
     */
    @Override
    public Calendar obtenerFechaUltimaComandaCliente(ClienteFrecuenteDTO clienteF) throws NegocioException {
        try {
            return comandaDAO.obtenerFechaUltimaComandaCliente(ClienteMapper.toEntity(clienteF));
        } catch (PersistenciaException e) {
            throw new NegocioException("Hubo un error al recuperar la fecha de la ultima comanda del cliente: ", e);
        }
    }

}
