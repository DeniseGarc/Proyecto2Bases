package manejadorBO;

import BO.ClienteFrecuenteBO;
import BO.ComandaBO;
import BO.IngredienteBO;
import BO.MesaBO;
import BO.ProductoBO;
import DAO.ClienteFrecuenteDAO;
import DAO.ComandaDAO;
import DAO.IngredienteDAO;
import DAO.MesaDAO;
import DAO.ProductoDAO;
import interfaces.IClienteFrecuenteDAO;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;
import interfaces.IClienteFrecuenteBO;
import interfaces.IComandaBO;
import interfaces.IComandaDAO;
import interfaces.IMesaBO;
import interfaces.IMesaDAO;

/**
 * Clase que funciona como fábrica de objetos negocio.
 *
 * @author Alici
 */
public class ManejadorBO {

    /**
     * Método que crea y regresa la instancia de ProductoBO.
     *
     * @return clase ProductoBO que implementa la interfaz IProductoBO.
     */
    public static IProductoBO crearProductoBO() {
        IProductoDAO productoDAO = ProductoDAO.getInstanciaDAO();
        IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstanceDAO();
        IProductoBO productoBO = new ProductoBO(productoDAO, ingredienteDAO);
        return productoBO;
    }

    /**
     * Metodo que crea y regresa la instancia de IngredienteBO
     *
     * @return IngredienteBO que implementa la interfaz IIngredienteBO
     */
    public static IIngredienteBO crearIngredienteBO() {
        IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstanceDAO();
        IIngredienteBO ingredienteBO = new IngredienteBO(ingredienteDAO);
        return ingredienteBO;
    }

    /**
     * Metodo que crea y regresa la instancia de IClienteFrecuenteBO
     *
     * @return ClienteFrecuenteBO que implementa la interfaz IClienteFrecuenteBO
     */
    public static IClienteFrecuenteBO crearClienteFrecuenteBO() {
        IClienteFrecuenteDAO clienteFrecuenteDAO = ClienteFrecuenteDAO.getInstanciaDAO();
        IClienteFrecuenteBO clienteFrecuenteBO = new ClienteFrecuenteBO(clienteFrecuenteDAO);
        return clienteFrecuenteBO;
    }

    /**
     * Metodo que crea y regresa la instancia de IComandaBO
     *
     * @return ComandaBO que implementa la interfaz IComandaBO
     */
    public static IComandaBO crearComandaBo() {
        IComandaDAO comandaDAO = ComandaDAO.getInstanciaDAO();
        IProductoDAO productoDAO = ProductoDAO.getInstanciaDAO();
        IMesaDAO mesaDAO = MesaDAO.getInstanciaDAO();
        IClienteFrecuenteDAO clienteFrecuenteDAO = ClienteFrecuenteDAO.getInstanciaDAO();
        IComandaBO comandaBO = new ComandaBO(comandaDAO, productoDAO, mesaDAO, clienteFrecuenteDAO);
        return comandaBO;
    }

    /**
     * Metodo que crea y regresa la instancia de IMesaBO
     *
     * @return MesaBO que implementa la interfaz IMesaBO
     */
    public static IMesaBO crearMesaBO() {
        IMesaDAO mesaDAO = MesaDAO.getInstanciaDAO();
        IMesaBO mesaBO = new MesaBO(mesaDAO);
        return mesaBO;
    }
}
