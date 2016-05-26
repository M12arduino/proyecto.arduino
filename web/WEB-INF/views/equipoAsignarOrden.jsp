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
    <div class="container">
        <br /><br />
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Asignar orden</h3>
                </div>
                <div class="panel-body">
                <form:form action="${base}/equipo/altaOrden.htm" method="POST" role="form">
                    <div class="dropdown">
                        <label for="equipoOrden">Equipo: </label>
                        <form:select path="id_equipo" class="form-control" id="equipoOrden">
                            <form:options itemLabel="nombre" itemValue="id_equipo" items="${equipos}" />
                        </form:select>
                    </div>
                    <div class="dropdown">
                        <label for="ordenAsignada">Orden: </label>
                    <form:select class="form-control" path="codigo_orden">
                        <form:options itemLabel="codigo" itemValue="codigo" items="${ordenes}" id="ordenAsignada" />
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