/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m12.arduino.domain.EstadoOrden;
import m12.arduino.domain.EstadoRobot;
import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.domain.Robot;
import m12.arduino.service.OrdenFabricacionArduino;
import m12.arduino.service.ServiceOrdenFabricacion;
import m12.arduino.service.ServiceRobot;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author enric
 */
@RestController
public class WebService {

    private static final ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();
    private static final ServiceRobot sR = new ServiceRobot();
    private static List<Robot> myRobots;

    @RequestMapping("/ordenFinalizada")
    public String ordenFinalizada(@RequestParam(value = "codigoOrden") String codigoOrden, @RequestParam(value = "codigoRobot") String codigoRobot) {
        OrdenFabricacion ordenRecivida = sO.buscarOrden(codigoOrden);
        Robot robotRecivido = sR.buscarRobot(codigoRobot);

        ordenRecivida.setEstado(EstadoOrden.REALIZADA);
        robotRecivido.setEstado(EstadoRobot.LIBRE);

        OrdenFabricacion ordenToSend = new OrdenFabricacion();

        for (OrdenFabricacion or : robotRecivido.getOrdenes()) {
            if (or.getEstado() == EstadoOrden.INICIADA) {
                if (or.getFechaFormat().getTimeInMillis() < ordenToSend.getFechaFormat().getTimeInMillis()) {
                    ordenToSend = or;
                }
            }
        }

        if (ordenToSend.getId() != 0) {
            String response;
            try {
                ObjectMapper mapperObj = new ObjectMapper();
                response = mapperObj.writeValueAsString(ordenRecivida);
            } catch (IOException ex) {
                response = ex.getMessage();
            }
            return response;
        }
        return "No more";
    }

    ////////////////////////////////////////////////////////////////////////////
    public static void webServiceUp() {
        while (true) {
            renewListRobots();
            for (int i = 0; i < 5; i++) {
                checkStatusRobots();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static void renewListRobots() {
        myRobots = sR.listarRobots();
    }

    private static void checkStatusRobots() {
        for (Robot myRobot : myRobots) {
            getHTML("sda");
        }
    }
    
    public static String getHTML(String urlToRead){
//      StringBuilder result = new StringBuilder();
//      URL url = new URL(urlToRead);
//      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//      conn.setRequestMethod("GET");
//      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//      String line;
//      while ((line = rd.readLine()) != null) {
//         result.append(line);
//      }
//      rd.close();
//      return result.toString();
        return "hi";
   }

}
