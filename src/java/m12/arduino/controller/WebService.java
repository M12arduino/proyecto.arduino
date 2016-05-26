/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import java.io.IOException;
import java.util.List;
import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.service.OrdenFabricacionArduino;
import m12.arduino.service.ServiceOrdenFabricacion;
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
    private ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();

    @RequestMapping("/greeting")
    public String ordenEnJson(@RequestParam(value="codigo", defaultValue ="OF001") String codigo) {
        OrdenFabricacionArduino ordenFab = new OrdenFabricacionArduino();
        OrdenFabricacion buscaOrd = sO.buscarOrden(codigo);
        ordenFab.setAcciones(buscaOrd.getProceso().getAcciones());
        ordenFab.setCodigo(buscaOrd.getCodigo());
        ordenFab.setProridad(buscaOrd.getProridad());
        ordenFab.setId(buscaOrd.getId());
        ordenFab.setDescripcion(buscaOrd.getDescripcion());
        String response = "No hay nada";
            try {
                ObjectMapper mapperObj = new ObjectMapper();
                response = mapperObj.writeValueAsString(ordenFab);
            } catch (IOException ex) {
                response = ex.getMessage();
            }
        
        
        
        return response;
    }
}

