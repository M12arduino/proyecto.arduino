<%-- 
    Document   : contactaForm
    Created on : 27-may-2016, 3:01:29
    Author     : couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Contacta con el administrador</h3>
                    </div>
                    <div class="panel-body">
                        <form:form name="MyForm" action="${path}/contacta/enviarCorreoAnonimo.htm" method="POST" role="form" >
                            <div class="form-group">
                                <label>Nombre: </label>
                                <input name="nombre" class="form-control" type="text" disabled value="Anonimo" /> 
                                <form:input name="nombre" path="nombre" type="hidden" value="Anonimo" /> 
                            </div> 
                            <div class="form-group">
                                <label>Email: </label>
                                <form:input name="email" path="email" type="email" class="form-control" placeholder="Anonimo@ejemplo.com" /> 
                            </div> 
                            <div class="dropdown">
                                <label>Motivo del contacto: </label>
                                <form:select class="form-control" path="motivo">          
                                    <form:options items="${motivos}" />
                                </form:select>
                            </div>
                            <div class="form-group">
                                <label>Mensaje: </label>
                                <form:textarea name="mensaje" path="mensaje" class="form-control" cols="40" rows="6" /> 
                            </div> 
                            <input type="submit" class="btn btn-arduino btn-block" value="Enviar" />
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
    </body>
</html>