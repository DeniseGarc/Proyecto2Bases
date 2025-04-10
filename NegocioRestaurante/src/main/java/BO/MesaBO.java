/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IMesaBO;
import interfaces.IMesaDAO;

/**
 *
 * @author Maryr
 */
public class MesaBO implements IMesaBO {

    private IMesaDAO mesaDAO;

    public MesaBO() {
    }

    public MesaBO(IMesaDAO mesaDAO) {
        this.mesaDAO = mesaDAO;
    }

    /**
     * Método para insertar las mesas en la base de datos. Llama al DAO para
     * insertar las mesas.
     *
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public void insertarMesas() throws NegocioException {
        try {
            mesaDAO.insertarMesas();
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudieron insertar las mesas: ", e);
        }
    }

    /**
     * Método para verificar si las mesas ya estan insertadas.
     *
     * @return true si las mesas ya están insertadas, false si no.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public boolean consultarMesas() throws NegocioException {
        try {
            return mesaDAO.consultarMesas();
        } catch (PersistenciaException e) {
            throw new NegocioException("Hubo un error al consultar las mesas: ", e);
        }
    }
}
