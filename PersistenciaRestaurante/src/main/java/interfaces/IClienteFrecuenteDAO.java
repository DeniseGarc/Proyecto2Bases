/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.ClienteFrecuente;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Maryr
 */
public interface IClienteFrecuenteDAO {

    public ClienteFrecuente registrarNuevoClienteFrecuente (ClienteFrecuente clienteFrecuente) throws PersistenciaException;
    public List<ClienteFrecuente> obtenerClientesFrecuentes() throws PersistenciaException;
    public List<ClienteFrecuente> obtenerClientesPorNombre(String nombre) throws PersistenciaException;
    public List<ClienteFrecuente> obtenerClientesPorTelefono(String telefono) throws PersistenciaException;
    public List<ClienteFrecuente> obtenerClientesPorCorreo(String correo) throws PersistenciaException;
}
