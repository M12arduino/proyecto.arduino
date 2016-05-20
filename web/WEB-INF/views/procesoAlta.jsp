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

<form:form id="myForm" action="${base}/proceso/insertar.htm" method="POST">
    Descripcion: <form:input path="descripcion" />
    Acciones:
    <div class="accion">
        Pos X: <input type="number" id="posX1" />
        Pos Y: <input type="number" id="posY1" />
        Pos Z: <input type="number" id="posZ1" />
        Pinza: <input type="number" id="pinza1" />
    </div>
    <button id="buto"  type="button" onclick="añadirAccion()">Añadir accion</button><br />
    <form:input type="hidden" id="accionesJSON" path="accionesJSON" value="" />
    <input type="hidden" id="numAcciones" value="1" />
    <input type="button" value="Send" onclick="prepare();"/>
</form:form>

</body>
</html>
