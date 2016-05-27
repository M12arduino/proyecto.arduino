package m12.arduino.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.EstadoOrden;
import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.domain.Robot;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceOrdenFabricacion;
import m12.arduino.service.ServiceProceso;
import m12.arduino.service.ServiceRobot;
import m12.arduino.service.ServiceTrabajador;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
@Controller
@RequestMapping("/stats")
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
        result += "{\"label\": \"Indefinido\", \"y\": " + sIndef + "},";
        result += "{\"label\": \"Libre\", \"y\": " + sLibre + "},";
        result += "{\"label\": \"Ocupado\", \"y\": " + sOcup + "},";
        result += "{\"label\": \"Desconectado\", \"y\": " + sDesc + "},";
        result += "{\"label\": \"Local\", \"y\": " + sLocal + "}";
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
            resultado += "{ \"y\": " + realizadas + ", \"legendText\": \"" + equipo.getNombre() + " - " + realizadas + " Ordenes realizadas\", \"indexLabel\": \"" + equipo.getNombre() + "\"},";
            resultado += "{ \"y\": " + noRealizadas + ", \"legendText\": \"" + equipo.getNombre() + " - " + noRealizadas + " Ordenes no realizadas\", \"indexLabel\": \"" + equipo.getNombre() + "\"},";
        }
        return resultado.substring(0, resultado.length() - 1);
    }

    @RequestMapping("/getStatsPeriodo")
    public Map intervaloTemporal(int mesA, int mesB, int anoA, int anoB) {
        Map container = new HashMap();
        List<OrdenFabricacion> elements = new ArrayList();
        String result = "";
        int sIndef = 0;
        int sPend = 0;
        int sIni = 0;
        int sReal = 0;
        int sNreal = 0;
        int sCanc = 0;
        for (OrdenFabricacion orden : sO.listarOrdenes()) {
            if (orden.getFechaFormat().get(Calendar.MONTH) >= mesA && orden.getFechaFormat().get(Calendar.MONTH) <= mesB
                    && orden.getFechaFormat().get(Calendar.YEAR) >= anoA && orden.getFechaFormat().get(Calendar.YEAR) <= anoB) {
                elements.add(orden);
                switch (orden.getEstado()) {
                    case INDEFINIDO:
                        sIndef++;
                        break;
                    case PENDIENTE:
                        sPend++;
                        break;
                    case INICIADA:
                        sIni++;
                        break;
                    case REALIZADA:
                        sReal++;
                        break;
                    case NO_REALIZADA:
                        sNreal++;
                        break;
                    case CANCELADA:
                        sCanc++;
                        break;
                }
            }
        }
        result += "{\"label\": \"Indefinido\", \"y\": " + sIndef + "},";
        result += "{\"label\": \"Pendiente\", \"y\": " + sPend + "},";
        result += "{\"label\": \"Iniciada\", \"y\": " + sIni + "},";
        result += "{\"label\": \"Realizada\", \"y\": " + sReal + "},";
        result += "{\"label\": \"No Realizada\", \"y\": " + sNreal + "},";
        result += "{\"label\": \"Cancelada\", \"y\": " + sCanc + "}";

        container.put("lista", elements);
        container.put("string", result);
        return container;
    }

    @RequestMapping(value = "/ajaxDiagramaA", method = RequestMethod.POST)
    public @ResponseBody
    String filtroAjaxJson(@RequestParam int mesA, @RequestParam int mesB, @RequestParam int anoA, @RequestParam int anoB) {
        return (String) intervaloTemporal(mesA, mesB, anoA, anoB).get("string");
    }

    @RequestMapping(value = "/ajaxListA", method = RequestMethod.POST)
    public @ResponseBody
    String filtroAjaxList(@RequestParam int mesA, @RequestParam int mesB, @RequestParam int anoA, @RequestParam int anoB) {
        String response = "";
        List<OrdenFabricacion> ordenF = (List<OrdenFabricacion>) intervaloTemporal(mesA, mesB, anoA, anoB).get("lista");
        try {
            ObjectMapper mapperObj = new ObjectMapper();
            response = mapperObj.writeValueAsString(ordenF);
        } catch (IOException ex) {
            response = ex.getMessage();
        }
        return response;
    }

}

