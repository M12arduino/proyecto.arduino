<%-- 
    Document   : robotCrud
    Created on : 18-may-2016, 20:31:06
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<link rel="stylesheet" href="${base}/resources/styles/robotCrud.css"/>
 <script type="text/javascript" src="${base}/resources/js/robotTrabajador.js"></script>
 
 <input type="text" placeholder="id_robot" id="searchIdVal"/>
 <input type="button" id="searchId" value="buscar"/>
 <div class="tableResults">
     <p> Busca un robot </p>
       <form:form action="${base}/robot/insertar.htm" method="POST" id="form">
           ID Robot: <form:input path="id_robot"/>
            Nombre: <form:input path="nombre" />
            Lugar: <form:input path="lugar" />
            Coor X: <form:input path="coorX" />
            Coor Y: <form:input path="coorY" />
            Estado 
            <form:select path="estado">
                <form:options items="${estados}" />
            </form:select>
            <input type="button" value="Editar" id="editar"/>
            <input type="button" value="Eliminar" id="eliminar"/>
        </form:form>
 </div>
    </body>
</html>