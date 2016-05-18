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
            Acciones:
            <div class="accion">
                 Pos X: <form:input path="acciones[0]" itemValue="" class="inpu"/>
                 Pos Y: <input type="number" value=""/>
                 Pos Z: <input type="number" value=""/>
                 Pinza: <input type="number" value=""/>
            </div>
            <button type="button" onclick="añadirAccion()">Añadir accion</button><br />
            <div class="acciones"></div>
            <input type="submit" value="Send" />
        </form:form>

</body>
</html>
