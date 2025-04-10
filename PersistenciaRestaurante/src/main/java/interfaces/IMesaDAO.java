
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Mesa;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Maryr
 */
public interface IMesaDAO {
    public void insertarMesas() throws PersistenciaException;
    public boolean consultarMesas() throws PersistenciaException;
    public List<Mesa> obtenerMesas() throws PersistenciaException;
    public Mesa obtenerMesaPorNumero(Long numero) throws PersistenciaException;
}
