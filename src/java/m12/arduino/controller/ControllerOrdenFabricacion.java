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
import m12.arduino.domain.Proceso;
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

/**
 * Controlador para los objetos orden de fabricacion
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
@Controller
@RequestMapping(value = {"/ordenFabricacion", "/ordenfabricacion"})
public class ControllerOrdenFabricacion {

    private ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();
    private ServiceProceso sP = new ServiceProceso();
    private ServiceRobot sR = new ServiceRobot();
    private ServiceEquipo sE = new ServiceEquipo();
    private ServiceTrabajador sT = new ServiceTrabajador();

    /**
     * Metodo formulario de alta de ordenes de fabricacion
     *
     * @return Devuelve un objeto ModelAndView (formulario) llamado
     * ordenFabricacionAlta con un objeto OrdenFabricacionForm vacio y tres
     * listas (prioridades, robots y procesos.
     */
    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("ordenFabricacionAlta", "command", new OrdenFabricacionForm());
        mV.addObject("prioridades", Prioridad.values());
        mV.addObject("procesos", sP.listarProcesos());
        mV.addObject("robots", sR.listarRobots());
        return mV;
    }

    /**
     * Metodo para insertar ordenes de fabricación en la base de datos.
     *
     * @param ofF Objeto OrdenFabricacionForm con los datos de la orden de
     * fabricacion a insertar.
     * @return Devuelve un objeto ModelAndView (vista) llamado detalleObjeto con
     * los datos de la orden de fabricacion insertada.
     */
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

    /**
     * Metodo para actualizar ordenes de fabricación en la base de datos.
     *
     * @param ofF Objeto OrdenFabricacionForm con los datos de la orden de
     * fabricacion a actualizar.
     * @return Devuelve un String metido en un div con la confirmación de como
     * ha finalizado la operación.
     */
    @RequestMapping(value = "/actualizar", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarOrdenFabricacion(@RequestBody OrdenFabricacionForm ofF) {
        String msg = "";
        try {
            OrdenFabricacion of = sO.buscarOrden("id", ofF.getId());
            of.setCodigo(ofF.getCodigo());
            of.setDescripcion(ofF.getDescripcion());
            of.setEquipo(sE.buscarEquipo("id", ofF.getEquipo_id()));
            of.setCantidad(ofF.getCantidad());
            of.setProceso(sP.buscarProceso("id", ofF.getCodigo_proceso_id()));
            of.setProridad(ofF.getPrioridad());
            of.setRobot(sR.buscarRobot("id", ofF.getId_robot_id()));
            sO.actualizarOrden(of);
            msg = "<div class=\"alert alert-success\">La orden de fabricacion se ha actualizado correctamente</div>";
        } catch (HibernateException e) {
            msg = "<div class=\"alert alert-error\">Error al actualizar la orden de fabricacion</div>";
        }
        return msg;
    }

    /**
     * Metodo para eliminar ordenes de fabricacion de la base de datos.
     *
     * @param ofF Objeto OrdenFabricacionForm con los datos de la orden de
     * fabricacion a eliminar.
     * @return Devuelve un String metido en un div con la confirmación de como
     * ha finalizado la operación.
     */
    @RequestMapping(value = "/eliminar", method = RequestMethod.POST)
    public @ResponseBody
    String eliminarOrdenFabricacion(@RequestBody OrdenFabricacionForm ofF) {
        String msg = "";
        try {
            OrdenFabricacion of = new OrdenFabricacion();
            of.setId(ofF.getId());
            sO.eliminarOrden(of);
            msg = "<div class=\"alert alert-success\">La orden de fabricacion se ha eliminado correctamente</div>";
        } catch (Exception e) {
            msg = "<div class=\"alert alert-error\">error al actualizar la orden de fabricacion</div>";;
        }
        return msg;
    }

    /**
     * Metodo para mostrar el editor de ordenes de fabricacion.
     *
     * @return Devuelve un objeto ModelAndView (formulario) llamado
     * ordenFabricacionCrud con un objeto vacio OrdenFabricacionForm para
     * introducir los datos a cambiar, o elimiar de la orden de fabricacion.
     */
    @RequestMapping(value = "/administrar")
    public ModelAndView administrarOrdenFabricacion() {
        ModelAndView mV = new ModelAndView("ordenFabricacionCrud", "command", new OrdenFabricacionForm());
        mV.addObject("prioridades", Prioridad.values());
        mV.addObject("procesos", sP.listarProcesos());
        mV.addObject("robots", sR.listarRobots());
        mV.addObject("equipos", sE.listarEquipos());
        return mV;
    }

    /**
     * Metodo para buscar ordenes de fabricacion en la base de datos.
     *
     * @param ofF objeto OrdenFabricacionForm con los datos de las ordenes de
     * fabricacion a buscar.
     * @return Devuelve un String con las ordenes de fabricacion que coinciden
     * con los parámetros del formulario.
     */
    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public @ResponseBody
    String buscaOrdenFabricacionAjax(@RequestBody OrdenFabricacionForm ofF) {
        String codigo = ofF.getCodigo();
        String descripcion = ofF.getDescripcion();
        Long proceso_id = ofF.getCodigo_proceso_id();
        Long equipo_id = ofF.getEquipo_id();
        Prioridad prioridad = ofF.getPrioridad();
        Long robot_id = ofF.getId_robot_id();
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
        List<OrdenFabricacion> OF = sO.listarOrdenes("codigo", codigo, "descripcion", descripcion, "proceso_id", proceso_id, "robot_id", robot_id, "equipo_id", equipo_id, "proridad", prioridad);
        //List<OrdenFabricacion> OF = sO.listarOrdenes();
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

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Metodo para mostrar las ordenes de fabricacion asignadas por equipo.
     *
     * @return Devuelve un objeto ModelAndView (vista) llamado tareasEquipo con
     * un objeto OrdenFabricacionForm vacio y las ordenes de fabricacion
     * asignadas a cada equipo.
     */
    @RequestMapping("/ordenesEquipo")
    public ModelAndView tareasEquipo() {
        String nif = SecurityContextHolder.getContext().getAuthentication().getName();
        Trabajador trab = sT.buscarTrabajador(nif);
        Equipo eq = trab.getEquipo();
        if (eq == null) {
            eq = new Equipo();
        }
        List<OrdenFabricacion> ordenes = sO.listarOrdenes("equipo_id", eq.getId());
        List<TareasEquipoForm> tareas = new ArrayList<TareasEquipoForm>();
        TareasEquipoForm aux;
        for (OrdenFabricacion orden : ordenes) {
            if (orden.getTrabajador() == null && orden.getEstado() == EstadoOrden.PENDIENTE) {
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
        ModelAndView mV = new ModelAndView("tareasEquipo", "command", new OrdenFabricacionForm());
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

    /**
     * Metodo para asignar ordenes de fabricacion a trabajadores
     *
     * @param ofF objeto OrdenFabricacionForm con los datos de la orden de
     * fabricacion que el trabajador se quiere asignar.
     * @return Devuelve un objeto ModelAndView (redirige a la pantalla de tareas de equipo)
     */
    @RequestMapping("/asignarTrabajador")
    public ModelAndView asignarOrden(OrdenFabricacionForm ofF) {
        OrdenFabricacion orden = sO.buscarOrden(ofF.getCodigo());
        String nif = SecurityContextHolder.getContext().getAuthentication().getName();
        Trabajador trab = sT.buscarTrabajador(nif);
        trab.addOrden(orden);
        sT.actualizarTrabajador(trab);
        sO.actualizarOrden(orden);
        return tareasEquipo();
    }
/////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodo para vilualizar las odenes asignadas por trabajador.
     *
     * @return Devuelve un objeto ModelAndView (vista) con un objeto
     * OrdenFabricacionForm vacio y una lista con las ordenes de fabricacion
     * asignadas al trabajador.
     */
    @RequestMapping("/ordenesTrabajador")
    public ModelAndView tareasTrabajador() {
        String message = "inicialitzat";
        String nif = SecurityContextHolder.getContext().getAuthentication().getName();
        Trabajador trab = sT.buscarTrabajador(nif);
        List<OrdenFabricacion> ordenes = sO.listarOrdenes("trabajador_id_trab", trab.getId_trab());
        List<TareasEquipoForm> tareas = new ArrayList<TareasEquipoForm>();
        TareasEquipoForm aux;
        for (OrdenFabricacion orden : ordenes) {
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
        String ordenesJson;
        ModelAndView mV = new ModelAndView("tareasTrabajador", "command", new OrdenFabricacionForm());
        try {
            ObjectMapper mapperObj = new ObjectMapper();
            ordenesJson = mapperObj.writeValueAsString(tareas);
        } catch (IOException ex) {
            ordenesJson = ex.getMessage() + "something";
        }
        if (message != null) {
            mV.addObject("message", message);
        }
        mV.addObject("ordenes", ordenesJson);
        return mV;
    }

    ////// /////// ////// /////// ////// ////// ////// ///// ////// ////// /////
    /**
     * Metodo para modificar el estado de las ordenes de fabricacion de cada
     * trabajador
     *
     * @param ofF objeto OrdenFabricacionForm con los datos de la orden de
     * fabricacion a la que se le quiere modificar el estado.
     * @return Devuelve un objeto ModelAndView (vista) con un mensaje sobre como
     * ha transcurrido la operacion. (redirige a "tareasTrabajador")
     */
    @RequestMapping("/modificarEstado")
    public ModelAndView modifyOrden(OrdenFabricacionForm ofF) {
        OrdenFabricacion orden;
        String message = "Orden actualizada";
        if ("undefined".equals(ofF.getCodigo_can())) {
            if ("undefined".equals(ofF.getCodigo_rea())) {
                orden = sO.buscarOrden(ofF.getCodigo_eje());
                if (orden.getEstado() == EstadoOrden.PENDIENTE) {
                    orden.setEstado(EstadoOrden.INICIADA);
                    sO.actualizarOrden(orden);
                } else {
                    message = "Para ejecutar una orden ésta debe estar en 'PENDIENTE'";
                }
            } else {
                orden = sO.buscarOrden(ofF.getCodigo_rea());
                if (orden.getEstado() != EstadoOrden.REALIZADA) {
                    orden.setEstado(EstadoOrden.REALIZADA);
                    sO.actualizarOrden(orden);
                } else {
                    message = "Para ejecutar una orden ésta no debe estar 'CANCELADA' o marcada ya como 'REALIZADA'";
                }
            }
        } else {
            orden = sO.buscarOrden(ofF.getCodigo_can());
            if (orden.getEstado() != EstadoOrden.CANCELADA) {
                orden.setEstado(EstadoOrden.CANCELADA);
                sO.actualizarOrden(orden);
            } else {
                message = "Esta orden ya esta 'CANCELADA'";
            }
        }
        //return tareasTrabajador(message);

        return tareasTrabajador();
    }
//    
//    @RequestMapping("/ejecutarOrden")
//    public ModelAndView ejecutarOrden(String codigo_orden) {
//        OrdenFabricacion oF = sO.buscarOrden(codigo_orden);
//        if (oF.getEstado() == EstadoOrden.PENDIENTE) {
//            WebService.execute
//            oF.setEstado(EstadoOrden.INICIADA);
//            sO.actualizarOrden(oF);
//        } else {
//            return tareasTrabajador("Para iniciar una orden ésta debe encontrarse en estado 'Pendiente'");
//        }
//        return tareasTrabajador(null);
//    }
//    
//    @RequestMapping("/cancelarOrden")
//    public ModelAndView cancelarOrden(String codigo_orden) {
//        ModelAndView mV = new ModelAndView("main");
//        OrdenFabricacion oF = sO.buscarOrden(codigo_orden);
//        if (oF.getEstado() != EstadoOrden.CANCELADA) {
//            // CRIDA AL ARDUINO PER Cancelar LA ORDRE?????
//            oF.setEstado(EstadoOrden.CANCELADA);
//            sO.actualizarOrden(oF);
//        } else {
//            String message = "Ésta orden ya se encuentra en estado 'Cancelada'";
//        }
//        return new ModelAndView("main");
//    }
////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodo para mostrar en una tabla las ordenes de fabricacion de la base de
     * datos.
     *
     * @return Devuelve un objeto ModelAndView (vista) con las ordenes de
     * fabricacion de la base de datos.
     */
    @RequestMapping("/tabla")
    public ModelAndView makeTable() {
        ModelAndView mV = new ModelAndView("tableMaker");
        mV.addObject("listado", sO.listarOrdenes());
        return mV;
    }
}
