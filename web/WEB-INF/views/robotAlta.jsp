<%-- 
    Document   : formNewRobot
    Created on : 12-may-2016, 20:46:56
    Author     : Couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>

       <form:form action="${base}/robot/insertar.htm" method="POST">
            Nombre: <form:input path="nombre" />
            Lugar: <form:input path="lugar" />
            Coor X: <form:input path="coorX" />
            Coor Y: <form:input path="coorY" />
            Estado 
            <form:select path="estado">
                <form:options items="${estados}" />
            </form:select>
            <input type="submit" value="Send"/>
        </form:form>

    </body>
</html>