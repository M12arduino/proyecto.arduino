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

public enum CategoriaTrabajador { 
    
    // LIST
    INDEFINIDO(0,"Indefinido"),
    JUNIOR(1,"Junior"),
    ADMINISTRADOR(2, "Administrador");
    
    // ATTR
    private final int code;
    private final String name;
    
    // CONST
    private CategoriaTrabajador(int code, String name) {
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
