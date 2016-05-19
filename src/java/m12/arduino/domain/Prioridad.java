package m12.arduino.domain;
/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */

public enum Prioridad {

    // LIST
    INDEFINIDO(0,"Indefinido"),
    BAJA(1, "Baja"),
    MEDIA(2, "Media"),
    ALTA(3, "Alta");

    // ATTR
    private final int code;
    private final String name;

    // CONST
    private Prioridad(int code, String name) {
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
