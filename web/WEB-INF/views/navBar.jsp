<%-- 
    Document   : login
    Created on : 12-may-2016, 15:38:59
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <!--Capçalera de la barra -->
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!--Cos de la barra de navegació-->

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Trabajadores<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${base}/trabajador/alta.htm">Añadir trabajador</a></li>
                        <li><a href="${base}/trabajador/tabla.htm">Tabla</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Equipos<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${base}/equipo/alta.htm">Añadir Equipo</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Robots<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${base}/robot/alta.htm">Añadir Robot</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
                <li><a href="documents.html"> pascual</a></li>
                <li><a href="http://www.cfavalles.org/moodle"> esto </a></li>
                <li><a href="contacte.html"> lotoro </a></li>
            </ul>
        </div>
    </div>
</div>