<%-- 
    Document   : formNewRobot
    Created on : 12-may-2016, 20:46:56
    Author     : Couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<script src="${base}/resources/js/validaRobot.js" type="text/javascript"></script>
<link href="${base}/resources/styles/altaGeneral.css" rel="stylesheet">
<div class="container">
    <div class="page-header">
        <h1>Administración de Robots</h1>
    </div>
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Añadir robot</h3>
            </div>
            <div class="panel-body">
                <form:form name="MyForm" action="${base}/robot/insertar.htm" method="POST" role="form" >
                    <div class="form-group">
                        <label for="idRobot">ID Robot: </label>
                        <form:input name="id_robot" path="id_robot" class="form-control" id="idRobot" />
                        <span class="alert-danger" id="id_robot_error">ID erroneo.</span>
                    </div>
                    <div class="form-group">
                        <label for="nombreRobot">Nombre: </label>
                        <form:input name="nombre" path="nombre" class="form-control" id="nombreRobot" />
                        <span class="alert-danger" id="nombre_error">Nombre erroneo.</span>
                    </div>
                    <div class="form-group">
                        <label for="nombreRobot">Lugar: </label>
                        <form:input name="lugar" path="lugar" class="form-control" id="nombreRobot" />
                        <span class="alert-danger" id="lugar_error">Lugar erroneo.</span>
                    </div>
                    <div class="form-group">
                        <label for="coorxRobot">Coor X: </label>
                        <form:input name="coorX" path="coorX" class="form-control" id="coorxRobot" />
                        <span class="alert-danger" id="coorX_error">Coor X erronea.</span>
                    </div>
                    <div class="form-group">
                        <label for="cooryRobot">Coor Y: </label>
                        <form:input name="coorY" path="coorY" class="form-control" id="cooryRobot" />
                        <span class="alert-danger" id="coorY_error">Coor Y erronea.</span>
                    </div>
                    <div class="dropdown">
                        <label for="estadoRobot">Estado: </label>
                        <form:select class="form-control" path="estado">
                            <form:options items="${estados}" id="estadoRobot" />
                        </form:select>
                    </div>
                    <br /><br />
                    <input type="submit" class="btn btn-arduino btn-block" value="Enviar"/>
                </form:form>
            </div>
        </div>
    </div>
    <div class="col-md-3"></div>
</div>
<jsp:include page="footer.jsp"></jsp:include>