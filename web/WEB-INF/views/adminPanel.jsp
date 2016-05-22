<%-- 
    Document   : adminPanel
    Created on : 18-may-2016, 14:14:23
    Author     : Couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="nav-side-menu col-xs-2">
    <div id="panel-title" class="panel-title">Panel de administrador</div>
    <div class="menu-list">
        <ul id="menu-content" class="menu-content collapse">
            <li  data-toggle="collapse" data-target="#trabajadores" class="collapsed">
                <div>
                <a href="#">Gestionar trabajadores</a>
                <span><img src="${base}/resources/img/worker.ico"></span>
            </li>
            <ul class="sub-menu collapse" id="trabajadores">
                <li><a href="${base}/trabajador/tabla.htm">Mostrar Trabajadores</a></li>
                <li><a href="${base}/trabajador/alta.htm">Añadir Trabajador</a></li>
                <li><a href="${base}/trabajador/administrar.htm">Administrar Trabajadores</a></li>
            </ul>

            <li data-toggle="collapse" data-target="#robots" class="collapsed">
                <a href="#">Gestionar robots</a>
                <span><img src="${base}/resources/img/robot.png"></span>
            </li>  
            <ul class="sub-menu collapse" id="robots">
                <li><a href="${base}/robot/tabla.htm">Mostrar Robots</a></li>
                <li><a href="${base}/robot/alta.htm">Añadir Robot</a></li>
                <li><a href="${base}/robot/administrar.htm">Administrar Robots</a></li>
            </ul>

            <li data-toggle="collapse" data-target="#equipos" class="collapsed">
                <a href="#">Gestionar equipos</a>
                <span><img src="${base}/resources/img/team.png"></span>
            </li>
            <ul class="sub-menu collapse" id="equipos">
                <li><a href="${base}/equipo/tabla.htm">Mostrar Equipos</a></li>
                <li><a href="${base}/equipo/alta.htm">Añadir Equipo</a></li>
                <li><a href="${base}/equipo/administrar.htm">Administrar Equipos</a></li>
            </ul>
            
            <li data-toggle="collapse" data-target="#procesos" class="collapsed">
                <a href="#">Gestionar Procesos</a>
                <span><img src="${base}/resources/img/process.png"></span>
            </li>
            <ul class="sub-menu collapse" id="procesos">
                <li><a href="${base}/proceso/tabla.htm">Mostrar Procesos</a></li>
                <li><a href="${base}/proceso/alta.htm">Añadir Proceso</a></li>
                <li><a href="${base}/proceso/administrar.htm">Administrar Procesos</a></li>
            </ul>
            
            <li data-toggle="collapse" data-target="#ordenes" class="collapsed">
                <a href="#">Gestionar Ordenes</a>
                <span><img src="${base}/resources/img/ordenFabri.png"></span>
            </li>
            <ul class="sub-menu collapse" id="ordenes">
                <li><a href="${base}/ordenFabricacion/tabla.htm">Mostrar Ordenes</a></li>
                <li><a href="${base}/ordenFabricacion/alta.htm">Añadir Ordenes</a></li>
                <li><a href="${base}/ordenFabricacion/administrar.htm">Administrar Ordenes</a></li>
            </ul>
            
            <a href="${base}/populate/populate.htm">Populate</a>
        </ul>
    </div>
</div>
