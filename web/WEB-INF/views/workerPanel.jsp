<%-- 
    Document   : adminPanel
    Created on : 18-may-2016, 14:14:23
    Author     : Couto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="nav-side-menu col-xs-2">
    <div id="panel-title" class="panel-title">Panel de Trabajador</div>
    <div class="menu-list">
        <ul id="menu-content" class="menu-content collapse">
            <li data-toggle="collapse" data-target="#orden" class="collapsed">
                <a href="#">Gestionar Ordenes</a>
                <span><img src="${base}/resources/img/ordenFabri.png"></span>
            </li>
            <ul class="sub-menu collapse" id="orden">
                <li><a href="${base}/ordenFabricacion/tabla.htm">Mostrar Ordenes</a></li>
                <li><a href="${base}/ordenFabricacion/alta.htm">Añadir Ordenes</a></li>
                <li><a href="${base}/ordenFabricacion/administrar.htm">Administrar Ordenes</a></li>
            </ul>
            
            <a href="${base}/populate/populate.htm">Populate</a>
        </ul>
    </div>
</div>
