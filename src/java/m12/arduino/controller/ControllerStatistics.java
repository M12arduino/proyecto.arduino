package m12.arduino.controller;

import m12.arduino.domain.Equipo;
import m12.arduino.domain.EstadoOrden;
import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.domain.Robot;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceOrdenFabricacion;
import m12.arduino.service.ServiceProceso;
import m12.arduino.service.ServiceRobot;
import m12.arduino.service.ServiceTrabajador;

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
public class ControllerStatistics {

    private final static ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();
    private final static ServiceProceso sP = new ServiceProceso();
    private final static ServiceRobot sR = new ServiceRobot();
    private final static ServiceTrabajador sT = new ServiceTrabajador();
    private final static ServiceEquipo sE = new ServiceEquipo();

    public static String getStatusRobots() {
        int sIndef = 0;
        int sLibre = 0;
        int sOcup = 0;
        int sDesc = 0;
        int sLocal = 0;
        String result = "";
        for (Robot robot : sR.listarRobots()) {
            switch (robot.getEstado()) {
                case INDEFINIDO:
                    sIndef++;
                    break;
                case LIBRE:
                    sLibre++;
                    break;
                case OCUPADO:
                    sOcup++;
                    break;
                case DESCONECTADO:
                    sDesc++;
                    break;
                case LOCAL:
                    sLocal++;
                    break;
            }
        }
        result += "{label: \"Indefinido\", y: " + sIndef + "},";
        result += "{label: \"Libre\", y: " + sLibre + "},";
        result += "{label: \"Ocupado\", y: " + sOcup + "},";
        result += "{label: \"Desconectado\", y: " + sDesc + "},";
        result += "{label: \"Local\", y: " + sLocal + "}";
        return result;
    }
    
    public static String getHistorialEquipos() {
        //"{ y: " . $row[1] . ", legendText: \"" . $row[0] . " - " . $row[1] . " Tasks\", indexLabel: \"" . $row[0] . "\" },"
        int realizadas;
        int noRealizadas;
        String resultado = " ";
        for (Equipo equipo : sE.listarEquipos()) {
            realizadas = 0;
            noRealizadas = 0;
            for (OrdenFabricacion orden : equipo.getOrdenes()) {
                if (orden.getEstado() == EstadoOrden.REALIZADA) {
                    realizadas++;
                } else {
                    noRealizadas++;
                }
            }
            resultado += "{ y: " + realizadas + ", legendText: \"" + equipo.getNombre() + " - " + realizadas + " Ordenes realizadas\", indexLabel: \"" + equipo.getNombre() + "\"},";
            resultado += "{ y: " + noRealizadas + ", legendText: \"" + equipo.getNombre() + " - " + noRealizadas + " Ordenes no realizadas\", indexLabel: \"" + equipo.getNombre() + "\"},";
        }
        return resultado.substring(0, resultado.length()-1);
    }
}
