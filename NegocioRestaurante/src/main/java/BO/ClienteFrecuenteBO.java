/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import interfaces.IClienteFrecuenteBO;
import interfaces.IClienteFrecuenteDAO;

/**
 *
 * @author Maryr
 */
public class ClienteFrecuenteBO implements IClienteFrecuenteBO {

    private IClienteFrecuenteDAO clienteFrecuenteDAO;

    public ClienteFrecuenteBO(IClienteFrecuenteDAO clienteFrecuenteDAO) {
        this.clienteFrecuenteDAO  = clienteFrecuenteDAO;
    }

}
