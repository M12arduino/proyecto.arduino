<%-- 
    Document   : ordenFabricacionAlta
    Created on : 19-may-2016, 14:27:23
    Author     : Jordi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<script src="${base}/resources/js/validaOrdenFabricacion.js" type="text/javascript"></script>
<link href="/A_Spring_Inicial/resources/styles/altaGeneral.css" rel="stylesheet">
    <div class="container">
        <br /><br />
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Añadir orden de fabricación</h3>
                </div>
                <div class="panel-body">
                <form:form name="MyForm" action="${base}/ordenFabricacion/insertar.htm" method="POST" role="form" >
                    <div class="form-group">
                        <label for="codigoOrden">Codigo: </label>
                        <form:input name="codigo" path="codigo" class="form-control" id="codigoOrden" />
                        <span class="alert-danger" id="codigo_error">Código erroneo. ejemplo: OF001</span>
                    </div>
                    <div class="form-group">
                        <label for="descripcionOrden">Descripción: </label>
                        <form:input name="descripcion" path="descripcion" class="form-control" id="descripcionOrden" />
                        <span class="alert-danger" id="descripcion_error">La descripción debe contener solo letras.</span>
                    </div>
                    <div class="dropdown">
                        <label for="prioridadOrden">Prioridad: </label>
                        <form:select class="form-control" path="prioridad">
                            <form:options  items="${prioridades}" id="prioridadOrden" />
                        </form:select>
                    </div>
                    <div class="dropdown">
                        <label for="procesoOrden">Proceso: </label>
                        <form:select class="form-control" path="codigo_proceso">
                            <form:options itemLabel="codigo" itemValue="codigo" items="${procesos}" id="procesoOrden" />
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label for="cantidadOrden">Cantidad: </label>
                        <form:input name="cantidad" path="cantidad" class="form-control" id="cantidadOrden" />
                        <span class="alert-danger" id="cantidad_error">La cantidad debe contener solo números.</span>
                    </div>
                    <div class="dropdown">
                        <label for="robotOrden">Robot: </label>
                        <form:select class="form-control" path="id_robot">
                            <form:options itemLabel="nombre" itemValue="id_robot" items="${robots}" id="robotOrden" />
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

</body>
</html>
