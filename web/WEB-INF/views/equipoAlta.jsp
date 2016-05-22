<%-- 
    Document   : equipoAlta
    Created on : 13-may-2016, 20:28:41
    Author     : enric
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
    <div class="container">
        <br /><br />
        <div class="col-md-3"></div>
        <div class="col-md-6">
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
                <form:checkboxes items="${listaTrabajadores}"  itemValue="nif" path="nifs" itemLabel="nombre"/>
            </div>
            <input type="submit" class="btn btn-default btn-block" value="Send"/>
        </form:form>
    </div>
    <div class="col-md-3"></div>
</div>
</body>
</html>
