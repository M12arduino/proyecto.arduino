package m12.arduino.domain;

/**
 * Clase EstadoOrden
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
public enum EstadoOrden {

    // LIST
    INDEFINIDO(0, "Indefinido"),
    PENDIENTE(1, "Pendiente"),
    INICIADA(2, "Iniciada"),
    REALIZADA(3, "Realizada"),
    NO_REALIZADA(4, "No Realizada"),
    CANCELADA(5, "Cancelada");

    // ATTR
    /**
     * Codigo del estado de la orden
     */
    private final int code;

    /**
     * Nombre del estado de la orden
     */
    private final String name;

    // CONST
    /**
     * Constructor del estado de la orden
     *
     * @param code codigo del estado de la orden
     * @param name nombre del estado de la orden
     */
    private EstadoOrden(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // GESETS
    /**
     * Getter del codigo del estado de la orden
     *
     * @return codigo del estado de la orden
     */
    public int getCode() {
        return code;
    }

    /**
     * Getter del nombre del estado de la orden
     *
     * @return nombre del estado de la orden
     */
    public String getName() {
        return name;
    }
}
