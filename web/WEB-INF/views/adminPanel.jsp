<%-- 
    Document   : adminPanel
    Created on : 18-may-2016, 14:14:23
    Author     : Couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="nav-side-menu">
    <div class="brand">Panel de administrador</div>
    <div class="menu-list">
        <ul id="menu-content" class="menu-content collapse out">
            <li  data-toggle="collapse" data-target="#trabajadores" class="collapsed">
                <a href="#">Gestionar trabajadores</a>
                <span>pepe</span>
            </li>
            <ul class="sub-menu collapse" id="trabajadores">
                <li><a href="${base}/trabajador/tabla.htm">Mostrar Trabajadores</a></li>
                <li><a href="${base}/trabajador/alta.htm">Añadir Trabajador</a></li>
                <li><a href="${base}/trabajador/administrar.htm">Administrar Trabajadores</a></li>
            </ul>

            <li data-toggle="collapse" data-target="#robots" class="collapsed">
                <a href="#">Gestionar robots</a>
            </li>  
            <ul class="sub-menu collapse" id="robots">
                <li><a href="${base}/robot/tabla.htm">Mostrar Robots</a></li>
                <li><a href="${base}/robot/alta.htm">Añadir Robot</a></li>
                <li><a href="${base}/robot/administrar.htm">Administrar Robots</a></li>
            </ul>

            <li data-toggle="collapse" data-target="#equipos" class="collapsed">
                <a href="#">Gestionar equipos</a>
            </li>
            <ul class="sub-menu collapse" id="equipos">
                <li><a href="${base}/equipo/tabla.htm">Mostrar Equipos</a></li>
                <li><a href="${base}/equipo/alta.htm">Añadir Equipo</a></li>
                <li><a href="${base}/equipo/administrar.htm">Administrar Equipos</a></li>
            </ul>
            
            <li data-toggle="collapse" data-target="#procesos" class="collapsed">
                <a href="#">Gestionar Procesos</a>
            </li>
            <ul class="sub-menu collapse" id="procesos">
                <li><a href="${base}/proceso/tabla.htm">Mostrar Procesos</a></li>
                <li><a href="${base}/proceso/alta.htm">Añadir Proceso</a></li>
                <li><a href="${base}/proceso/administrar.htm">Administrar Procesos</a></li>
            </ul>
            
            <a href="${base}/populate/populate.htm">Populate</a>
        </ul>
    </div>
</div>