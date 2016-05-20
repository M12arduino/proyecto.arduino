<%-- 
    Document   : ordenFabricacionAlta
    Created on : 19-may-2016, 14:27:23
    Author     : Jordi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<script type="text/javascript" src="${base}/resources/js/procesoAlta.js"></script>
<form:form action="${base}/trabajador/insertar.htm" method="POST">
    Codigo: <form:input path="codigo" />
    Descripcion: <form:input path="descripcion" />
    Prioridad: 
    <form:select path="prioridad">
        <form:options  items="${prioridades}" />
    </form:select>
    Proceso: 
    <form:select path="codigo_proceso">
        <form:options items="${procesos}" />
    </form:select>
    Cantidad: <form:input path="cantidad" />
    Robot: 
    <form:select path="nombre_robot">
        <form:options itemLabel="fullName" items="${robots}" />
    </form:select>
    <input type="submit" value="Send"/>
</form:form>


</body>
</html>
