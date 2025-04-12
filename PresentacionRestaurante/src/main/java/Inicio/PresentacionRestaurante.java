package Inicio;

import control.CoordinadorAplicacion;

/**
 * Clase que inicia el flujo de la aplicación
 *
 * @author Alici
 */
public class PresentacionRestaurante {

    private static CoordinadorAplicacion coordinador = new CoordinadorAplicacion();

    /**
     * Clase main que inicia el flujo
     *
     * @param args
     */
    public static void main(String[] args) {
        coordinador.PantallaInicio();

    }
}
