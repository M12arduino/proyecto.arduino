<%-- 
    Document   : ordenFabricacionAlta
    Created on : 19-may-2016, 14:27:23
    Author     : Jordi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<form:form action="${base}/equipo/altaOrden.htm" method="POST">
    Equipo: 
    <form:select path="id_equipo">
        <form:options itemLabel="nombre" itemValue="id_equipo" items="${equipos}" />
    </form:select>
    Orden:
    <form:select path="codigo_orden">
        <form:options itemLabel="codigo" itemValue="codigo" items="${ordenes}" />
    </form:select>
    <input type="submit" value="Send"/>
</form:form>

</body>
</html>
