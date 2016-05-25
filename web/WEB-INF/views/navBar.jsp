<%-- 
    Document   : login
    Created on : 12-may-2016, 15:38:59
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="userLogged" value="<%=org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName()%>"></c:set>

<div class="navbar navbar-default" role="navigation">
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
            <ul class="nav navbar-nav navbar-left h1"><a href="${base}/main.htm">HopeTech Industries</a></ul>
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <img class="logos img-responsive" src="${base}/resources/img/spring.png">

                </li>
                <li>
                    <img class="logos img-responsive" src="${base}/resources/img/java.png">

                </li>
                <li>
                    <img class="logos img-responsive" src="${base}/resources/img/hibernate.png">
                </li>
                <li>
                    <img class="logos img-responsive" src="${base}/resources/img/arduino.png">
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="${base}/main.htm" class="btn" role="button">Home</a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">${userLogged}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="">Mi Perfil</a></li>
                        <li><a href="${base}/ordenFabricacion/ordenesEquipo.htm">Tareas equipo</a></li>
                        <li><a href="${base}/j_spring_security_logout">Cerrar sesión</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
