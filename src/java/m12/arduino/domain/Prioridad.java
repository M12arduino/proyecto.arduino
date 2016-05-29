package m12.arduino.domain;
/**
 * Clase Prioridad
 * @author Enric, Pablo, Jordi y Oscar
 */
public enum Prioridad {

    // LIST
    INDEFINIDO(0,"Indefinido"),
    BAJA(1, "Baja"),
    MEDIA(2, "Media"),
    ALTA(3, "Alta");

    // ATTR
    /**
     * Codigo de la prioridad
     */
    private final int code;
    
    /**
     * Nombre de la prioridad
     */
    private final String name;

    // CONST
    /**
     * Constructor de prioridad
     * @param code codigo de la prioridad
     * @param name nombre de la prioridad
     */
    private Prioridad(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // GESETS
    /**
     * Getter del codigo de la prioridad
     * @return codigo de la prioridad
     */
    public int getCode() {
        return code;
    }

    /**
     * Getter del nombre de la prioridad
     * @return nombre de la prioridad
     */
    public String getName() {
        return name;
    }
}
