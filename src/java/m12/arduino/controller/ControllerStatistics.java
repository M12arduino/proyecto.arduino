package m12.arduino.controller;

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
    
    private final ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();
    private final ServiceProceso sP = new ServiceProceso();
    private final static ServiceRobot sR = new ServiceRobot();
    private final ServiceTrabajador sT = new ServiceTrabajador();
    private final ServiceEquipo sE = new ServiceEquipo();
    
    public static String getStatusRobots() {
        int sIndef = 0;
        int sLibre = 0;
        int sOcup = 0;
        int sDesc = 0;
        int sLocal = 0;
        int sDefault = 0;
        String result = "";
        for (Robot robot : sR.listarRobots()) {
            switch(robot.getEstado()) {
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
                default:
                    sDefault++;
            }
            result += "{label: \"Indefinido\", y: " + sIndef + "},";
            result += "{label: \"Libre\", y: " + sLibre + "},";
            result += "{label: \"Ocupado\", y: " + sOcup + "},";
            result += "{label: \"Desconectado\", y: " + sDesc + "},";
            result += "{label: \"Local\", y: " + sLocal + "},";
            result += "{label: \"Desconocido\", y: " + sDefault + "}";
        }
        return result;
    }
}
