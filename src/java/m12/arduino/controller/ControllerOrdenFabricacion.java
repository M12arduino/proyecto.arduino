package m12.arduino.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.EstadoOrden;
import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.domain.Prioridad;
import m12.arduino.domain.Trabajador;
import m12.arduino.service.OrdenFabricacionForm;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceOrdenFabricacion;
import m12.arduino.service.ServiceProceso;
import m12.arduino.service.ServiceRobot;
import m12.arduino.service.ServiceTrabajador;
import m12.arduino.service.TareasEquipoForm;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
@Controller
@RequestMapping("/ordenFabricacion")
public class ControllerOrdenFabricacion {

    private ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();
    private ServiceProceso sP = new ServiceProceso();
    private ServiceRobot sR = new ServiceRobot();
    private ServiceEquipo sE = new ServiceEquipo();
    private ServiceTrabajador sT = new ServiceTrabajador();

    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("ordenFabricacionAlta", "command", new OrdenFabricacionForm());
        mV.addObject("prioridades", Prioridad.values());
        mV.addObject("procesos", sP.listarProcesos());
        mV.addObject("robots", sR.listarRobots());
        return mV;
    }

    @RequestMapping(value = "/insertar")
    public ModelAndView addOrden(OrdenFabricacionForm ofF) {
        OrdenFabricacion oF = new OrdenFabricacion();
        oF.setCodigo(ofF.getCodigo());
        oF.setDescripcion(ofF.getDescripcion());
        oF.setProridad(ofF.getPrioridad());
        oF.setProceso(sP.buscarProceso(ofF.getCodigo_proceso()));
        oF.setCantidad(ofF.getCantidad());
        oF.setRobot(sR.buscarRobot(ofF.getId_robot()));
        
        OrdenFabricacion orden = sO.insertarOrden(oF);
        System.err.println(orden.toString());
        ModelAndView mV = new ModelAndView("detalleObjeto");
        mV.addObject("objeto", orden);
        return mV;
    }

    @RequestMapping(value = "/actualizar", headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody
    String actualizarOrdenFabricacion(@RequestBody OrdenFabricacionForm ofF) {
        String msg = "";
        try {
            OrdenFabricacion of = sO.buscarOrden("id", ofF.getId());
            of.setCodigo(ofF.getCodigo());
            of.setDescripcion(ofF.getDescripcion());
            of.setCantidad(ofF.getCantidad());
            System.out.println("CODIGOPROCESO:" + ofF.getCodigo_proceso() + "CODIGROGOOT" + ofF.getId_robot() + "###############");
            of.setProceso(sP.buscarProceso("id", ofF.getCodigo_proceso()));
            of.setProridad(ofF.getPrioridad());
            of.setRobot(sR.buscarRobot("id", ofF.getId_robot()));
            sO.actualizarOrden(of);
            msg = "<div class=\"alert alert-success\">La orden de fabricacion se ha actualizado correctamente</div>";
        } catch (HibernateException e) {
            msg = "<div class=\"alert alert-error\">Error al actualizar la orden de fabricacion</div>";
        }
        return msg;
    }

    @RequestMapping(value = "/eliminar", headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody
    String eliminarOrdenFabricacion(@RequestBody OrdenFabricacionForm ofF) {
        String msg = "";
        try {
            OrdenFabricacion of = new OrdenFabricacion();
            of.setId(ofF.getId());
            sO.eliminarOrden(of);
            msg = "<div class=\"alert alert-success\">La orden de fabricación se ha eliminado correctamente</div>";
        } catch (Exception e) {
            msg = "<div class=\"alert alert-error\">error al actualizar la orden de fabricacion</div>";;
        }
        return msg;
    }

    @RequestMapping(value = "/administrar")
    public ModelAndView administrarOrdenFabricacion() {
        ModelAndView mV = new ModelAndView("ordenFabricacionCrud", "command", new OrdenFabricacionForm());
        mV.addObject("prioridades", Prioridad.values());
        mV.addObject("procesos", sP.listarProcesos());
        mV.addObject("robots", sR.listarRobots());
        mV.addObject("equipos", sE.listarEquipos());
        return mV;
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public @ResponseBody
    String buscaOrdenFabricacionAjax(@RequestBody OrdenFabricacionForm ofF) {
        String codigo = ofF.getCodigo();
        String descripcion = ofF.getDescripcion();
        Long proceso_id = sP.buscarProceso(ofF.getCodigo_proceso()).getId();
        Long equipo_id = ofF.getEquipo_id();
        Prioridad prioridad = ofF.getPrioridad();
        Long robot_id = sR.buscarRobot(ofF.getId_robot()).getId();
        if (equipo_id == 0) {
            equipo_id = null;
        }
        if (proceso_id == 0) {
            proceso_id = null;
        }
        if (robot_id == 0) {
            robot_id = null;
        }
        if (prioridad == Prioridad.INDEFINIDO) {
            prioridad = null;
        }
        String response = null;
        List<OrdenFabricacion> OF = sO.listarOrdenes("codigo", codigo, "descripcion", descripcion, "equipo_id", equipo_id, "proceso_id", proceso_id, "robot_id", robot_id, "prioridad", prioridad);
        // List<OrdenFabricacion> OF = sO.listarOrdenes();
        if (OF != null) {
            try {
                ObjectMapper mapperObj = new ObjectMapper();
                response = mapperObj.writeValueAsString(OF);
            } catch (IOException ex) {
                response = ex.getMessage();
            }
        } else {
            response = null;
        }

        return response;
    }

    @RequestMapping("/ejecutarOrden")
    public ModelAndView ejecutarOrden(String codigo_orden) {
        ModelAndView mV = new ModelAndView("main");
        OrdenFabricacion oF = sO.buscarOrden(codigo_orden);
        if (oF.getEstado() == EstadoOrden.PENDIENTE) {
            // CRIDA AL ARDUINO PER INICIAR LA ORDRE
            oF.setEstado(EstadoOrden.INICIADA);
            sO.actualizarOrden(oF);

        } else {
            String message = "Para iniciar una orden ésta debe encontrarse en estado 'Pendiente'";
        }

        return new ModelAndView("main");
    }

    @RequestMapping("/ordenesEquipo")
    public ModelAndView tareasEquipo() {
        String nif = SecurityContextHolder.getContext().getAuthentication().getName();
        Trabajador trab = sT.buscarTrabajador(nif);
        Equipo eq = trab.getEquipo();
        List<OrdenFabricacion> ordenes = sO.listarOrdenes("equipo_id", eq.getId());
        List<TareasEquipoForm> tareas = new ArrayList<TareasEquipoForm>();
        TareasEquipoForm aux;
        for (OrdenFabricacion orden : ordenes) {
            if (orden.getTrabajador() == null) {
                aux = new TareasEquipoForm();
                aux.setCodigo(orden.getCodigo());
                aux.setDescripcion(orden.getDescripcion());
                aux.setEquipo(orden.getEquipo().getId_equipo());
                aux.setEstado(orden.getEstado());
                aux.setPrioridad(orden.getProridad());
                aux.setProceso(orden.getProceso().getCodigo());
                aux.setRobot(orden.getRobot().getId_robot());
                tareas.add(aux);
            }
        }
        String ordenesJson;
        ModelAndView mV = new ModelAndView("tareasEquipo");
        try {
            ObjectMapper mapperObj = new ObjectMapper();
            ordenesJson = mapperObj.writeValueAsString(tareas);
        } catch (IOException ex) {
            ordenesJson = ex.getMessage() + "something";
        }
        mV.addObject("objeto", eq);
        mV.addObject("ordenes", ordenesJson);
        return mV;
    }

    @RequestMapping("/cancelarOrden")
    public ModelAndView cancelarOrden(String codigo_orden) {
        ModelAndView mV = new ModelAndView("main");
        OrdenFabricacion oF = sO.buscarOrden(codigo_orden);
        if (oF.getEstado() != EstadoOrden.CANCELADA) {
            // CRIDA AL ARDUINO PER Cancelar LA ORDRE?????
            oF.setEstado(EstadoOrden.CANCELADA);
            sO.actualizarOrden(oF);

        } else {
            String message = "Ésta orden ya se encuentra en estado 'Cancelada'";
        }

        return new ModelAndView("main");
    }

    @RequestMapping("/tabla")
    public ModelAndView makeTable() {
        ModelAndView mV = new ModelAndView("tableMaker");
        mV.addObject("listado", sO.listarOrdenes());
        return mV;
    }
}
