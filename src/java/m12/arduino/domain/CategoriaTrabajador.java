/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.domain;

/**
 * Clase CategoriaTrabajador
 * @author Enric, Pablo, Jordi y Oscar
 */
public enum CategoriaTrabajador { 
    
    // LIST
    INDEFINIDO(0,"Indefinido"),
    JUNIOR(1,"Junior"),
    ADMINISTRADOR(2, "Administrador");
    
    // ATTR
    /**
     * Codigo de la categoria
     */
    private final int code;
    
    /**
     * Nombre de la categoria
     */
    private final String name;
    
    // CONST
    /**
     * Constructor de la categoria
     * @param code codigo de la categoria
     * @param name nombre de la categoria
     */
    private CategoriaTrabajador(int code, String name) {
        this.code = code;
        this.name = name;
    }
    
    // GESETS
    /**
     * Getter de codigo de categoria
     * @return codigo de la categoria
     */
    public int getCode() {
        return code;
    }

    /**
     * Getter de nombre de categoria
     * @return nombre de la categoria
     */
    public String getName() {
        return name;
    }
}
