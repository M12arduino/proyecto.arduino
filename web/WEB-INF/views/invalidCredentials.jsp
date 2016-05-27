<%-- 
    Document   : welcome
    Created on : 12-may-2016, 20:04:13
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="<%=request.getContextPath()%>" scope="session" />
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${path}/resources/libs/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${path}/resources/styles/paneles.css"/>
        <title>Arduino Central Web</title>
    </head>
    <body>
        <div class="container">
            <br /><br />
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Credenciales invalidas</h3>
                    </div>
                    <div class="panel-body">
                        Las credenciales introducidas no son correctas.
                        <br /><br />
                        <a class="btn btn-arduino btn-block" href="${path}/contacta/formularioAnonimo.htm" >Contacte con el administrador</a>
                        <a class="btn btn-arduino btn-block" href="${path}/main.htm" >Login</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
    </body>
</html>
