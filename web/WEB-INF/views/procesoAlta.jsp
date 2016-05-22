<%-- 
    Document   : procesoAlta
    Created on : 17-may-2016, 16:44:54
    Author     : Couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<script type="text/javascript" src="${base}/resources/js/procesoAlta.js"></script>
<div class="container">
    <br /><br />
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <form:form id="myForm" action="${base}/proceso/insertar.htm" method="POST" role="form" >
            <div class="form-group">
                <label for="procesoDesc">Descripcion: </label>
                <form:input path="descripcion" class="form-control" id="procesoDesc" />
            </div>
            <div class="form-group">
                <label>Acciones: </label>
                <div class="accion">
                    <div class="col-md-3">Pos X: <input type="number" class="form-control" id="posX1" /></div>
                    <div class="col-md-3">Pos Y: <input type="number" class="form-control" id="posY1" /></div>
                    <div class="col-md-3">Pos Z: <input type="number" class="form-control" id="posZ1" /></div>
                    <div class="col-md-3">Pinza: <input type="number" class="form-control" id="pinza1" /></div>
                </div>
                <br /><br /><br /><br />
                <button id="buto"  type="button" class="btn btn-default" onclick="añadirAccion()">Añadir accion</button><br />
            </div>
            <form:input type="hidden" id="accionesJSON" path="accionesJSON" value="" />
            <input type="hidden" id="numAcciones" value="1" />
            <input type="button" value="Send" class="btn btn-default btn-block" onclick="prepare();"/>
        </form:form>
    </div>
    <div class="col-md-3"></div>
</div>
</body>
</html>
