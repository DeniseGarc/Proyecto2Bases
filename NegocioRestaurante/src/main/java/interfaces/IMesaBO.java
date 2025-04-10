/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.MesaDTO;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author Maryr
 */
public interface IMesaBO {
    public void insertarMesas() throws NegocioException;
    public boolean consultarMesas() throws NegocioException;
    public List<MesaDTO> obtenerMesas() throws NegocioException;
}
