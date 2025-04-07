package DTOs;

import enumeradores.UnidadMedida;

/**
 * DTO que representa un ingrediente asociado a un producto.
 *
 * @author Alicia Denise García Acosta 00000252402
 */
public class IngredienteProductoDTO {

    /**
     * Nombre identificador del ingrediente.
     */
    private String nombre;

    /**
     * Unidad de medida en la que se expresa la cantidad del ingrediente.
     */
    private UnidadMedida unidadMedida;

    /**
     * Cantidad requerida del ingrediente para el producto.
     */
    private int cantidad;

    /**
     * Constructor para crear un DTO completo de ingrediente-producto.
     *
     * @param nombre Nombre del ingrediente
     * @param unidadMedida Unidad de medida del ingrediente
     * @param cantidad Cantidad requerida del ingrediente
     */
    public IngredienteProductoDTO(String nombre, UnidadMedida unidadMedida, int cantidad) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el nombre del ingrediente.
     *
     * @return Nombre actual del ingrediente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del ingrediente.
     *
     * @param nombre Nuevo nombre para el ingrediente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la unidad de medida del ingrediente.
     *
     * @return UnidadMedida actual para este ingrediente
     */
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Establece la unidad de medida del ingrediente.
     *
     * @param unidadMedida Nueva unidad de medida
     */
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    /**
     * Obtiene la cantidad requerida del ingrediente.
     *
     * @return Cantidad actual expresada en la unidad de medida especificada
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad requerida del ingrediente.
     *
     * @param cantidad Nueva cantidad expresada en la unidad de medida
     * especificada
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
