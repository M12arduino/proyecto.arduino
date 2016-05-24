<%-- 
    Document   : equipoAlta
    Created on : 13-may-2016, 20:28:41
    Author     : enric
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<sec:authorize access="hasRole('rol_admin')">
    <jsp:include page="adminPanel.jsp"></jsp:include>
</sec:authorize>
    <div class="container">
        <br /><br />
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Añadir equipo</h3>
                </div>
                <div class="panel-body">
                <form:form action="${base}/equipo/insertar.htm" method="GET" role="form" >
                    <div class="form-group">
                        <label for="idEquipo">ID_EQUIPO: </label>
                        <form:input path="id_equipo" class="form-control" id="idEquipo" />
                    </div>
                    <div class="form-group">
                        <label for="nombreEquipo">Nombre: </label>
                        <form:input path="nombre" class="form-control" id="nombreEquipo" />
                    </div>
                    <div class="checkbox">
                        <label class="checkbox-inline">
                            <form:checkboxes items="${listaTrabajadores}"  itemValue="nif" path="nifs" itemLabel="nombre"/>
                        </label>
                    </div>
                    <br /><br />
                    <input type="submit" class="btn btn-arduino btn-block" value="Send"/>
                </form:form>
            </div>
        </div>
    </div>
    <div class="col-md-3"></div>
</div>
</body>
</html>
