/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import GUIs.ClienteFrecuente;
import GUIs.EliminarIngrediente;
import GUIs.Ingredientes;
import GUIs.MenuPrincipal;
import GUIs.PantallaTomaComanda;
import GUIs.RegistrarClienteNuevo;
import GUIs.frmAgregarIngrediente;
import javax.swing.JFrame;

/**
 *
 * @author erika
 */
public class CoordinadorAplicacion {
    
    public void PantallaPrinicipal(JFrame frame){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        frame.dispose();
    }
    
    public void PantallaComandas (JFrame frame){
        
    }
    
    public void PantallaIngredientes(JFrame frame){
        Ingredientes pantallaIngredientes = new Ingredientes();
        pantallaIngredientes.setVisible(true);
        frame.dispose();
    }
    
    public void PantallaAgregarIngrediente(JFrame frame){
        frmAgregarIngrediente pantallaAgregar = new frmAgregarIngrediente();
        pantallaAgregar.setVisible(true);
        frame.dispose();
    }
    
    public void PantallaEliminarIngrediente(JFrame frame){
        EliminarIngrediente pantallaEliminar = new EliminarIngrediente();
        pantallaEliminar.setVisible(true);
        frame.dispose();
    }
    
    public void PantallaClienteFrecuente(JFrame frame){
        ClienteFrecuente pantallaCliente = new ClienteFrecuente();
        pantallaCliente.setVisible(true);
        frame.dispose();
    }
    
    public void PantallaTomaComanda(JFrame frame){
        PantallaTomaComanda pantallaComanda = new PantallaTomaComanda();
        pantallaComanda.setVisible(true);
        frame.dispose();
    }
    
    public void PantallaRegistrarCliente(JFrame frame){
        RegistrarClienteNuevo PantallaRegistrarCliente = new RegistrarClienteNuevo();
        PantallaRegistrarCliente.setVisible(true);
        frame.dispose();
    }
}
