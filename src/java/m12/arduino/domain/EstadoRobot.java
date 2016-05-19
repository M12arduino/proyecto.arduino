/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.domain;

/**
 *
 * @author Jordi
 */
public enum EstadoRobot {
    
    // LIST
    INDEFINIDO(0,"Indefinido"),
    LIBRE(1, "Libre"),
    OCUPADO(2, "Ocupado"),
    DESCONECTADO(3, "Desconectado"),
    LOCAL(4, "Local");
    
    // ATTR
    private final int code;
    private final String name;

    // CONST
    private EstadoRobot(int code, String name) {
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
