package m12.arduino.controller;

import m12.arduino.domain.Accion;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.EstadoRobot;
import m12.arduino.domain.Proceso;
import m12.arduino.domain.Robot;
import m12.arduino.domain.Trabajador;
import m12.arduino.domain.Ubicacion;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceProceso;
import m12.arduino.service.ServiceRobot;
import m12.arduino.service.ServiceTrabajador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
@Controller
@RequestMapping("/populate")
public class ControllerPopulate {

    @RequestMapping("/populate")
    public ModelAndView populate() {
        ModelAndView mV = new ModelAndView("main");

        ServiceRobot sR = new ServiceRobot();
        ServiceTrabajador sT = new ServiceTrabajador();
        ServiceEquipo sE = new ServiceEquipo();
        ServiceProceso sP = new ServiceProceso();

        ////////////////////////////////////////////////////////////////////////
        Equipo equ0 = new Equipo();
        equ0.setNombre("Equipo0");

        Equipo equ1 = new Equipo();
        equ1.setNombre("Equipo1");

        sE.insertarEquipo(equ0);
        sE.insertarEquipo(equ1);

        ////////////////////////////////////////////////////////////////////////
        Trabajador tr0 = new Trabajador();
        tr0.setNif("00000000A");
        tr0.setNombre("Trabajador0");
        tr0.setMovil("60000000");
        tr0.setCategoria(CategoriaTrabajador.LEADER);
        tr0.setPassword("pass0");

        Trabajador tr1 = new Trabajador();
        tr1.setNif("11111111A");
        tr1.setNombre("Trabajador1");
        tr1.setMovil("61111111");
        tr1.setCategoria(CategoriaTrabajador.JUNIOR);
        tr1.setPassword("pass1");

        Trabajador tr2 = new Trabajador();
        tr2.setNif("22222222A");
        tr2.setNombre("Trabajador2");
        tr2.setMovil("62222222");
        tr2.setCategoria(CategoriaTrabajador.SENIOR);
        tr2.setPassword("pass2");

        sT.insertarTrabajador(tr0);
        sT.insertarTrabajador(tr1);
        sT.insertarTrabajador(tr2);

        ////////////////////////////////////////////////////////////////////////
        equ0.addTrabajador(sT.buscarTrabajador("00000000A"));
        equ0.addTrabajador(sT.buscarTrabajador("11111111A"));
        equ1.addTrabajador(sT.buscarTrabajador("22222222A"));

        sT.actualizarTrabajador(tr0);
        sT.actualizarTrabajador(tr1);
        sT.actualizarTrabajador(tr2);

        ////////////////////////////////////////////////////////////////////////
        Robot ro0 = new Robot();
        ro0.setNombre("Robot0");
        ro0.setEstado(EstadoRobot.LIBRE);
        Ubicacion ub0 = new Ubicacion();
        ub0.setCoorX(50);
        ub0.setCoorY(20);
        ub0.setLugar("Granollers");
        ro0.setUbicacion(ub0);

        Robot ro1 = new Robot();
        ro1.setNombre("Robot1");
        ro1.setEstado(EstadoRobot.OCUPADO);
        Ubicacion ub1 = new Ubicacion();
        ub1.setCoorX(80);
        ub1.setCoorY(90);
        ub1.setLugar("Barcelona");
        ro1.setUbicacion(ub1);

        Robot ro2 = new Robot();
        ro2.setNombre("Robot2");
        ro2.setEstado(EstadoRobot.DESCONECTADO);
        Ubicacion ub2 = new Ubicacion();
        ub2.setCoorX(10);
        ub2.setCoorY(15);
        ub2.setLugar("Berlin");
        ro2.setUbicacion(ub2);

        sR.insertarRobot(ro0);
        sR.insertarRobot(ro1);
        sR.insertarRobot(ro2);

        ////////////////////////////////////////////////////////////////////////
        Proceso pr0 = new Proceso();
        pr0.setCodigo("P001");
        pr0.setDescripcion("Descripcion proceso 1");
        Accion ac01 = new Accion();
        ac01.setId_accion(1);
        ac01.setPosX(101);
        ac01.setPosY(201);
        ac01.setPosZ(301);
        ac01.setAbrirPinza(true);
        Accion ac02 = new Accion();
        ac02.setId_accion(2);
        ac02.setPosX(102);
        ac02.setPosY(202);
        ac02.setPosZ(302);
        ac02.setAbrirPinza(false);
        pr0.getAcciones().add(ac01);
        pr0.getAcciones().add(ac02);

        Proceso pr1 = new Proceso();
        pr1.setCodigo("P002");
        pr1.setDescripcion("Descripcion proceso 2");
        Accion ac11 = new Accion();
        ac11.setId_accion(1);
        ac11.setPosX(103);
        ac11.setPosY(203);
        ac11.setPosZ(303);
        ac11.setAbrirPinza(true);
        Accion ac12 = new Accion();
        ac12.setId_accion(2);
        ac12.setPosX(104);
        ac12.setPosY(204);
        ac12.setPosZ(304);
        ac12.setAbrirPinza(false);
        pr1.getAcciones().add(ac11);
        pr1.getAcciones().add(ac12);

        sP.insertarProceso(pr0);
        sP.insertarProceso(pr1);

        return mV;
    }
}
