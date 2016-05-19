package m12.arduino.domain;
/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016
 pendent, iniciada, realitzada, no realitzada,
 cancel·lada)
 @author Jordi
 */

public enum EstadoOrden {

    // LIST
    INDEFINIDO(0,"Indefinido"),
    PENDIENTE(1, "Pendiente"),
    INICIADA(2, "Iniciada"),
    REALIZADA(3, "Realizada"),
    NO_REALIZADA(4, "No Realizada"),
    CANCELADA(5, "Cancelada");

    // ATTR
    private final int code;
    private final String name;

    // CONST
    private EstadoOrden(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // GESETS
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
