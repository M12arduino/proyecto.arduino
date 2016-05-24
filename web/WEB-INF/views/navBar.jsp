<%-- 
    Document   : login
    Created on : 12-may-2016, 15:38:59
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
            <ul class="nav navbar-nav navbar-left h1">HopeTech Industries</ul>
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
                <li>
                    <a href="${base}/j_spring_security_logout" class="btn" role="button">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</div>
