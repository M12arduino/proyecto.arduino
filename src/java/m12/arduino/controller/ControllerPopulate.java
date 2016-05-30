package m12.arduino.controller;

import m12.arduino.domain.Accion;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.EstadoOrden;
import m12.arduino.domain.EstadoRobot;
import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.domain.Prioridad;
import m12.arduino.domain.Proceso;
import m12.arduino.domain.Robot;
import m12.arduino.domain.Trabajador;
import m12.arduino.domain.Ubicacion;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceOrdenFabricacion;
import m12.arduino.service.ServiceProceso;
import m12.arduino.service.ServiceRobot;
import m12.arduino.service.ServiceTrabajador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para llenar la base de datos (populate).
 * @author Enric, Pablo, Jordi y Oscar
 */
@Controller
@RequestMapping("/populate")
public class ControllerPopulate {

    /**
     * Metodo que rellena la base de datos.
     * @return Devuelve un objeto ModelAndView "vista" (redirecciona a la home 
     * despues de rellenar la base de datos).
     */
    @RequestMapping("/populate")
    public ModelAndView populate() {
        ModelAndView mV = new ModelAndView("main");

        ServiceRobot sR = new ServiceRobot();
        ServiceTrabajador sT = new ServiceTrabajador();
        ServiceEquipo sE = new ServiceEquipo();
        ServiceProceso sP = new ServiceProceso();
        ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();

        ////////////////////////////////////////////////////////////////////////
        Equipo equ0 = new Equipo();
        equ0.setNombre("Equipo A");
        equ0.setId_equipo("CV2001");

        Equipo equ1 = new Equipo();
        equ1.setNombre("Team Rocket");
        equ1.setId_equipo("CV2002");
        
        Equipo equ2 = new Equipo();
        equ2.setNombre("External Team");
        equ2.setId_equipo("CV2003");
        
        Equipo equ3 = new Equipo();
        equ3.setNombre("Subcontrata Everis");
        equ3.setId_equipo("CV2004");

        Equipo e0 = sE.insertarEquipo(equ0);
        Equipo e1 = sE.insertarEquipo(equ1);
        Equipo e2 = sE.insertarEquipo(equ2);        
        Equipo e3 = sE.insertarEquipo(equ3);

        System.out.println(e0);
        System.out.println(e1);
        ////////////////////////////////////////////////////////////////////////
        Trabajador tr0 = new Trabajador();
        tr0.setNif("00000000A");
        tr0.setNombre("Pablo Couto");
        tr0.setMovil("600000000");
        tr0.setCategoria(CategoriaTrabajador.JUNIOR);
        tr0.setPassword("passpablo");

        Trabajador tr1 = new Trabajador();
        tr1.setNif("11111111A");
        tr1.setNombre("Enric Sayos");
        tr1.setMovil("611111111");
        tr1.setCategoria(CategoriaTrabajador.JUNIOR);
        tr1.setPassword("passenric");

        Trabajador tr2 = new Trabajador();
        tr2.setNif("22222222A");
        tr2.setNombre("Oscar Moreno");
        tr2.setMovil("622222222");
        tr2.setCategoria(CategoriaTrabajador.ADMINISTRADOR);
        tr2.setPassword("passoscar");
        
        Trabajador tr3 = new Trabajador();
        tr3.setNif("33333333A");
        tr3.setNombre("Jordi Puig");
        tr3.setMovil("633333333");
        tr3.setCategoria(CategoriaTrabajador.ADMINISTRADOR);
        tr3.setPassword("passjordi");
        
        Trabajador tr4 = new Trabajador();
        tr4.setNif("44444444A");
        tr4.setNombre("Cristian Sosa");
        tr4.setMovil("644444444");
        tr4.setCategoria(CategoriaTrabajador.ADMINISTRADOR);
        tr4.setPassword("passcristian");
        
        Trabajador tr5 = new Trabajador();
        tr5.setNif("55555555A");
        tr5.setNombre("Disabled User");
        tr5.setMovil("655555555");
        tr5.setCategoria(CategoriaTrabajador.INDEFINIDO);
        tr5.setPassword("passdisabled");

        Trabajador t0 = sT.insertarTrabajador(tr0);
        Trabajador t1 = sT.insertarTrabajador(tr1);
        Trabajador t2 = sT.insertarTrabajador(tr2);
        Trabajador t3 = sT.insertarTrabajador(tr3);
        Trabajador t4 = sT.insertarTrabajador(tr4);
        Trabajador t5 = sT.insertarTrabajador(tr5);

        ////////////////////////////////////////////////////////////////////////
        e0.addTrabajador(t0);
        e0.addTrabajador(t1);
        e1.addTrabajador(t2);
        e1.addTrabajador(t3);
        e2.addTrabajador(t4);
        e3.addTrabajador(t5);

        sT.actualizarTrabajador(t0);
        sT.actualizarTrabajador(t1);
        sT.actualizarTrabajador(t2);
        sT.actualizarTrabajador(t3);
        sT.actualizarTrabajador(t4);
        sT.actualizarTrabajador(t5);

        ////////////////////////////////////////////////////////////////////////
        Robot ro0 = new Robot();
        ro0.setId_robot("Rob00");
        ro0.setNombre("Terminator");
        ro0.setEstado(EstadoRobot.LIBRE);
        Ubicacion ub0 = new Ubicacion();
        ub0.setCoorX(50);
        ub0.setCoorY(20);
        ub0.setLugar("Granollers");
        ro0.setUbicacion(ub0);

        Robot ro1 = new Robot();
        ro1.setId_robot("Rob01");
        ro1.setNombre("RoboRabo");
        ro1.setEstado(EstadoRobot.LOCAL);
        Ubicacion ub1 = new Ubicacion();
        ub1.setCoorX(80);
        ub1.setCoorY(90);
        ub1.setLugar("Barcelona");
        ro1.setUbicacion(ub1);

        Robot ro2 = new Robot();
        ro2.setId_robot("Rob02");
        ro2.setNombre("Asimov");
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
        Accion accion;
        ////
        Proceso pr0 = new Proceso();
        pr0.setCodigo("P001");
        pr0.setDescripcion("Descripcion proceso 1");
        
        accion = new Accion();
        accion.setPosX(101);
        accion.setPosY(201);
        accion.setPosZ(301);
        accion.setAbrirPinza(true);
        pr0.addAccion(accion);
        
        accion = new Accion();
        accion.setPosX(102);
        accion.setPosY(202);
        accion.setPosZ(302);
        accion.setAbrirPinza(false);
        pr0.addAccion(accion);

        ////
        Proceso pr1 = new Proceso();
        pr1.setCodigo("P002");
        pr1.setDescripcion("Descripcion proceso 2");
        accion = new Accion();
        accion.setPosX(103);
        accion.setPosY(203);
        accion.setPosZ(303);
        accion.setAbrirPinza(true);
        pr1.addAccion(accion);
        
        accion = new Accion();
        accion.setPosX(104);
        accion.setPosY(204);
        accion.setPosZ(304);
        accion.setAbrirPinza(false);
        pr1.addAccion(accion);
        
        accion = new Accion();
        accion.setPosX(105);
        accion.setPosY(205);
        accion.setPosZ(305);
        accion.setAbrirPinza(false);
        pr1.addAccion(accion);
        
        ////
        Proceso pr2 = new Proceso();
        pr2.setCodigo("P003");
        pr2.setDescripcion("Descripcion proceso 3");
        accion = new Accion();
        accion.setPosX(106);
        accion.setPosY(206);
        accion.setPosZ(306);
        accion.setAbrirPinza(true);
        pr2.addAccion(accion);
        
        accion = new Accion();
        accion.setPosX(107);
        accion.setPosY(207);
        accion.setPosZ(307);
        accion.setAbrirPinza(false);
        pr2.addAccion(accion);
        
        accion = new Accion();
        accion.setPosX(108);
        accion.setPosY(208);
        accion.setPosZ(308);
        accion.setAbrirPinza(false);
        pr2.addAccion(accion);

        ////
        Proceso pr3 = new Proceso();
        pr3.setCodigo("P004");
        pr3.setDescripcion("Descripcion proceso 4");
        accion = new Accion();
        accion.setPosX(109);
        accion.setPosY(209);
        accion.setPosZ(309);
        accion.setAbrirPinza(true);
        pr3.addAccion(accion);
        
        sP.insertarProceso(pr0);
        sP.insertarProceso(pr1);
        sP.insertarProceso(pr2);
        sP.insertarProceso(pr3);
        
        ////////////////////////////////////////////////////////////////////////
        OrdenFabricacion of1 = new OrdenFabricacion();
        of1.setCodigo("OF001");
        of1.setDescripcion("codigo 1, prioridad baja, proceso 1, cantidad 10");
        of1.setProridad(Prioridad.BAJA);
        of1.setProceso(sP.buscarProceso("P001"));
        of1.setCantidad(10);
        of1.setRobot(sR.buscarRobot("Rob00"));
        
        OrdenFabricacion of2 = new OrdenFabricacion();
        of2.setCodigo("OF002");
        of2.setDescripcion("codigo 2, prioridad media, proceso 2, cantidad 20");
        of2.setProridad(Prioridad.MEDIA);
        of2.setProceso(sP.buscarProceso("P002"));
        of2.setCantidad(20);
        of2.setRobot(sR.buscarRobot("Rob00"));
        
        OrdenFabricacion of3 = new OrdenFabricacion();
        of3.setCodigo("OF003");
        of3.setDescripcion("codigo 3, prioridad alta, proceso 1, cantidad 30");
        of3.setProridad(Prioridad.ALTA);
        of3.setProceso(sP.buscarProceso("P001"));
        of3.setCantidad(30);
        of3.setRobot(sR.buscarRobot("Rob00"));
        
        OrdenFabricacion of4 = new OrdenFabricacion();
        of4.setCodigo("OF004");
        of4.setDescripcion("codigo 4, prioridad baja, proceso 2, cantidad 40");
        of4.setProridad(Prioridad.BAJA);
        of4.setProceso(sP.buscarProceso("P002"));
        of4.setCantidad(40);
        of4.setRobot(sR.buscarRobot("Rob00"));
        
        OrdenFabricacion of5 = new OrdenFabricacion();
        of5.setCodigo("OF005");
        of5.setDescripcion("codigo 5, prioridad media, proceso 1, cantidad 50");
        of5.setProridad(Prioridad.MEDIA);
        of5.setProceso(sP.buscarProceso("P001"));
        of5.setCantidad(50);
        of5.setRobot(sR.buscarRobot("Rob01"));
        
        OrdenFabricacion of6 = new OrdenFabricacion();
        of6.setCodigo("OF006");
        of6.setDescripcion("codigo 6, prioridad Alta, proceso 2, cantidad 60");
        of6.setProridad(Prioridad.ALTA);
        of6.setProceso(sP.buscarProceso("P002"));
        of6.setCantidad(60);
        of6.setRobot(sR.buscarRobot("Rob02"));
        
        OrdenFabricacion of7 = new OrdenFabricacion();
        of7.setCodigo("OF007");
        of7.setDescripcion("codigo 7, prioridad baja, proceso 4, cantidad 70");
        of7.setProridad(Prioridad.BAJA);
        of7.setProceso(sP.buscarProceso("P004"));
        of7.setCantidad(70);
        of7.setRobot(sR.buscarRobot("Rob02"));
        
        OrdenFabricacion of8 = new OrdenFabricacion();
        of8.setCodigo("OF008");
        of8.setDescripcion("codigo 8, prioridad media, proceso 2, cantidad 80");
        of8.setProridad(Prioridad.MEDIA);
        of8.setProceso(sP.buscarProceso("P002"));
        of8.setCantidad(80);
        of8.setRobot(sR.buscarRobot("Rob01"));
        
        OrdenFabricacion of9 = new OrdenFabricacion();
        of9.setCodigo("OF009");
        of9.setDescripcion("codigo 9, prioridad alta, proceso 4, cantidad 90");
        of9.setProridad(Prioridad.ALTA);
        of9.setProceso(sP.buscarProceso("P004"));
        of9.setCantidad(90);
        of9.setRobot(sR.buscarRobot("Rob01"));
        
        OrdenFabricacion of10 = new OrdenFabricacion();
        of10.setCodigo("OF010");
        of10.setDescripcion("codigo 10, prioridad baja, proceso 4, cantidad 100");
        of10.setProridad(Prioridad.BAJA);
        of10.setProceso(sP.buscarProceso("P004"));
        of10.setCantidad(100);
        of10.setRobot(sR.buscarRobot("Rob02"));
        
        OrdenFabricacion of11 = new OrdenFabricacion();
        of11.setCodigo("OF011");
        of11.setDescripcion("codigo 11, prioridad baja, proceso 1, cantidad 110");
        of11.setProridad(Prioridad.BAJA);
        of11.setProceso(sP.buscarProceso("P001"));
        of11.setCantidad(110);
        of11.setRobot(sR.buscarRobot("Rob00"));
        
        OrdenFabricacion of12 = new OrdenFabricacion();
        of12.setCodigo("OF012");
        of12.setDescripcion("codigo 12, prioridad media, proceso 2, cantidad 120");
        of12.setProridad(Prioridad.MEDIA);
        of12.setProceso(sP.buscarProceso("P002"));
        of12.setCantidad(120);
        of12.setRobot(sR.buscarRobot("Rob00"));
        
        OrdenFabricacion of13 = new OrdenFabricacion();
        of13.setCodigo("OF013");
        of13.setDescripcion("codigo 13, prioridad alta, proceso 1, cantidad 130");
        of13.setProridad(Prioridad.ALTA);
        of13.setProceso(sP.buscarProceso("P001"));
        of13.setCantidad(130);
        of13.setRobot(sR.buscarRobot("Rob00"));
        
        OrdenFabricacion of14 = new OrdenFabricacion();
        of14.setCodigo("OF014");
        of14.setDescripcion("codigo 14, prioridad baja, proceso 2, cantidad 140");
        of14.setProridad(Prioridad.BAJA);
        of14.setProceso(sP.buscarProceso("P002"));
        of14.setCantidad(140);
        of14.setRobot(sR.buscarRobot("Rob00"));
        
        OrdenFabricacion of15 = new OrdenFabricacion();
        of15.setCodigo("OF015");
        of15.setDescripcion("codigo 15, prioridad media, proceso 1, cantidad 150");
        of15.setProridad(Prioridad.MEDIA);
        of15.setProceso(sP.buscarProceso("P001"));
        of15.setCantidad(150);
        of15.setRobot(sR.buscarRobot("Rob01"));
        
        OrdenFabricacion of16 = new OrdenFabricacion();
        of16.setCodigo("OF016");
        of16.setDescripcion("codigo 16, prioridad Alta, proceso 2, cantidad 160");
        of16.setProridad(Prioridad.ALTA);
        of16.setProceso(sP.buscarProceso("P002"));
        of16.setCantidad(160);
        of16.setRobot(sR.buscarRobot("Rob02"));
        
        OrdenFabricacion of17 = new OrdenFabricacion();
        of17.setCodigo("OF017");
        of17.setDescripcion("codigo 17, prioridad baja, proceso 4, cantidad 170");
        of17.setProridad(Prioridad.BAJA);
        of17.setProceso(sP.buscarProceso("P004"));
        of17.setCantidad(170);
        of17.setRobot(sR.buscarRobot("Rob02"));
        
        OrdenFabricacion of18 = new OrdenFabricacion();
        of18.setCodigo("OF018");
        of18.setDescripcion("codigo 18, prioridad media, proceso 2, cantidad 180");
        of18.setProridad(Prioridad.MEDIA);
        of18.setProceso(sP.buscarProceso("P002"));
        of18.setCantidad(180);
        of18.setRobot(sR.buscarRobot("Rob01"));
        
        OrdenFabricacion of19 = new OrdenFabricacion();
        of19.setCodigo("OF019");
        of19.setDescripcion("codigo 19, prioridad alta, proceso 4, cantidad 190");
        of19.setProridad(Prioridad.ALTA);
        of19.setProceso(sP.buscarProceso("P004"));
        of19.setCantidad(190);
        of19.setRobot(sR.buscarRobot("Rob01"));
        
        OrdenFabricacion of20 = new OrdenFabricacion();
        of20.setCodigo("OF020");
        of20.setDescripcion("codigo 20, prioridad alta, proceso 4, cantidad 200");
        of20.setProridad(Prioridad.ALTA);
        of20.setProceso(sP.buscarProceso("P004"));
        of20.setCantidad(200);
        of20.setRobot(sR.buscarRobot("Rob01"));
        
        OrdenFabricacion of21 = new OrdenFabricacion();
        of21.setCodigo("OF021");
        of21.setDescripcion("codigo 21, prioridad baja, proceso 4, cantidad 210");
        of21.setProridad(Prioridad.BAJA);
        of21.setProceso(sP.buscarProceso("P001"));
        of21.setCantidad(210);
        of21.setRobot(sR.buscarRobot("Rob01"));
        
        OrdenFabricacion of22 = new OrdenFabricacion();
        of22.setCodigo("OF022");
        of22.setDescripcion("codigo 22, prioridad media, proceso 4, cantidad 220");
        of22.setProridad(Prioridad.MEDIA);
        of22.setProceso(sP.buscarProceso("P002"));
        of22.setCantidad(220);
        of22.setRobot(sR.buscarRobot("Rob00"));
        
        OrdenFabricacion of23 = new OrdenFabricacion();
        of23.setCodigo("OF023");
        of23.setDescripcion("codigo 23, prioridad alta, proceso 4, cantidad 230");
        of23.setProridad(Prioridad.ALTA);
        of23.setProceso(sP.buscarProceso("P004"));
        of23.setCantidad(230);
        of23.setRobot(sR.buscarRobot("Rob01"));
        
        sO.insertarOrden(of1);
        sO.insertarOrden(of2);
        sO.insertarOrden(of3);
        sO.insertarOrden(of4);
        sO.insertarOrden(of5);
        sO.insertarOrden(of6);
        sO.insertarOrden(of7);
        sO.insertarOrden(of8);
        sO.insertarOrden(of9);
        sO.insertarOrden(of10);
        sO.insertarOrden(of11);
        sO.insertarOrden(of12);
        sO.insertarOrden(of13);
        sO.insertarOrden(of14);
        sO.insertarOrden(of15);
        sO.insertarOrden(of16);
        sO.insertarOrden(of17);
        sO.insertarOrden(of18);
        sO.insertarOrden(of19);
        sO.insertarOrden(of20);
        sO.insertarOrden(of21);
        sO.insertarOrden(of22);
        sO.insertarOrden(of23);
        
        ////////////////////////////////////////////////////////////////////////
        Equipo e = sE.buscarEquipo("CV2001");
        OrdenFabricacion orden1 = sO.buscarOrden("OF001");
        OrdenFabricacion orden2 = sO.buscarOrden("OF002");
        OrdenFabricacion orden3 = sO.buscarOrden("OF009");
        OrdenFabricacion orden4 = sO.buscarOrden("OF010");
        e.addOrden(orden1);
        e.addOrden(orden2);
        e.addOrden(orden3);
        e.addOrden(orden4);
        orden1.setEstado(EstadoOrden.PENDIENTE);
        orden2.setEstado(EstadoOrden.PENDIENTE);
        orden3.setEstado(EstadoOrden.PENDIENTE);
        orden4.setEstado(EstadoOrden.PENDIENTE);
        sO.actualizarOrden(orden1);
        sO.actualizarOrden(orden2);
        sO.actualizarOrden(orden3);
        sO.actualizarOrden(orden4);
        
        e = sE.buscarEquipo("CV2002");
        orden1 = sO.buscarOrden("OF003");
        orden2 = sO.buscarOrden("OF004");
        orden3 = sO.buscarOrden("OF011");
        orden4 = sO.buscarOrden("OF012");
        e.addOrden(orden1);
        e.addOrden(orden2);
        e.addOrden(orden3);
        e.addOrden(orden4);
        orden1.setEstado(EstadoOrden.PENDIENTE);
        orden2.setEstado(EstadoOrden.PENDIENTE);
        orden3.setEstado(EstadoOrden.PENDIENTE);
        orden4.setEstado(EstadoOrden.PENDIENTE);
        sO.actualizarOrden(orden1);
        sO.actualizarOrden(orden2);
        sO.actualizarOrden(orden3);
        sO.actualizarOrden(orden4);
        
        e = sE.buscarEquipo("CV2003");
        orden1 = sO.buscarOrden("OF005");
        orden2 = sO.buscarOrden("OF006");
        orden3 = sO.buscarOrden("OF013");
        orden4 = sO.buscarOrden("OF014");
        e.addOrden(orden1);
        e.addOrden(orden2);
        e.addOrden(orden3);
        e.addOrden(orden4);
        orden1.setEstado(EstadoOrden.PENDIENTE);
        orden2.setEstado(EstadoOrden.PENDIENTE);
        orden3.setEstado(EstadoOrden.PENDIENTE);
        orden4.setEstado(EstadoOrden.PENDIENTE);
        sO.actualizarOrden(orden1);
        sO.actualizarOrden(orden2);
        sO.actualizarOrden(orden3);
        sO.actualizarOrden(orden4);
        
        e = sE.buscarEquipo("CV2004");
        orden1 = sO.buscarOrden("OF007");
        orden2 = sO.buscarOrden("OF008");
        orden3 = sO.buscarOrden("OF015");
        orden4 = sO.buscarOrden("OF016");
        e.addOrden(orden1);
        e.addOrden(orden2);
        e.addOrden(orden3);
        e.addOrden(orden4);
        orden1.setEstado(EstadoOrden.PENDIENTE);
        orden2.setEstado(EstadoOrden.PENDIENTE);
        orden3.setEstado(EstadoOrden.PENDIENTE);
        orden4.setEstado(EstadoOrden.PENDIENTE);
        sO.actualizarOrden(orden1);
        sO.actualizarOrden(orden2);
        sO.actualizarOrden(orden3);
        sO.actualizarOrden(orden4);
        
        return mV;
    }
}
