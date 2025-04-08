/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;


import DTOs.ComandaDTO;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author Maryr
 */
public interface IComandaBO {
    public List<ComandaDTO> obtenerComandas() throws NegocioException;
    public List<ComandaDTO> obtenerComandsActivas() throws NegocioException;
}
