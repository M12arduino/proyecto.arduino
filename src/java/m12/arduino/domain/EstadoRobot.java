/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.domain;

/**
 * Clase EstadoRobot
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
public enum EstadoRobot {

    // LIST
    INDEFINIDO(0, "Indefinido"),
    LIBRE(1, "Libre"),
    OCUPADO(2, "Ocupado"),
    DESCONECTADO(3, "Desconectado"),
    LOCAL(4, "Local");

    // ATTR
    /**
     * Codigo del estado del robot
     */
    private final int code;

    /**
     * Nombre del estado del robot
     */
    private final String name;

    // CONST
    /**
     * Constructor del estado del robot
     *
     * @param code codigo del estado del robot
     * @param name nombre del estado del robot
     */
    private EstadoRobot(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // GESETS
    /**
     * Getter del codigo del robot
     *
     * @return codigo del robot
     */
    public int getCode() {
        return code;
    }

    /**
     * Getter del nombre del robot
     *
     * @return nombre del robot
     */
    public String getName() {
        return name;
    }

}
