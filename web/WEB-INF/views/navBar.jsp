<%-- 
    Document   : login
    Created on : 12-may-2016, 15:38:59
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
        String userloginName = "Admin";
        String userloginNif = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
        m12.arduino.service.ServiceTrabajador sT = new m12.arduino.service.ServiceTrabajador();
        if (!userloginNif.equals("admin")){
            userloginName = sT.buscarTrabajador(userloginNif).getNombre();
        }
%>
<c:set var="userLoggedName" value="<%=userloginName%>"></c:set>
<c:set var="userLoggedNif" value="<%=userloginNif%>"></c:set>

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
                <ul class="nav navbar-nav navb  ar-left h1"><a href="${base}/main.htm">HopeTech Industries</a></ul>
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <img class="logos img-responsive" src="${base}/resources/img/spring.png" onClick="location.href = 'https://spring.io/'">
                </li>
                <li>
                    <img class="logos img-responsive" src="${base}/resources/img/java.png" onClick="location.href = 'https://www.java.com/es/'">

                </li>
                <li>
                    <img class="logos img-responsive" src="${base}/resources/img/hibernate.png" onClick="location.href = 'http://hibernate.org/'">
                </li>
                <li>
                    <img class="logos img-responsive" src="${base}/resources/img/arduino.png" onClick="location.href = 'https://www.arduino.cc/'">
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="<%=!userloginNif.equals("admin")%>">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span><img src="${base}/resources/img/user.png"></span>Bienvenido, ${userLoggedName}<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${base}/trabajador/miPerfil.htm">Mi Perfil</a></li>
                                <li><a href="${base}/ordenFabricacion/ordenesEquipo.htm">Tareas equipo</a></li>
                                <li><a href="${base}/j_spring_security_logout">Cerrar sesión</a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                       <li><a href="${base}/j_spring_security_logout">Cerrar sesión</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</div>
