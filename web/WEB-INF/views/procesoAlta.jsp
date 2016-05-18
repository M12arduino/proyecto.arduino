<%-- 
    Document   : procesoAlta
    Created on : 17-may-2016, 16:44:54
    Author     : Couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>

<form:form action="${base}/proceso/insertar.htm" method="POST">
    Descripcion: <form:input path="descripcion" />
    <div class="accion">
        Acciones:
        <form:input path="acciones[0]" itemValue="" class="inpu"/>
        <input type="number" value=""/>
        <input type="number" value=""/>
        <input type="number" value=""/>
        <button type="button" onclick="añadirAccion()">Añadir accion</button>
    </div><br />
    <div class="acciones"></div>
    <input type="submit" value="Send" />
</form:form>

</body>
</html>