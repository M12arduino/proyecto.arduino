package m12.arduino.domain;

import java.util.List;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016
 codi, descripció, relació de moviments del robot i accions a
realitzar (obrir-tancar pinça)
@author Jordi
*/
public class Proceso {

    // ATTR
    private long id_proc;
    private String descripcion;
    private List<Accion> acciones;
}
