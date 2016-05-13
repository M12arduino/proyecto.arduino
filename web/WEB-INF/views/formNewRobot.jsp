<%-- 
    Document   : formNewRobot
    Created on : 12-may-2016, 20:46:56
    Author     : Couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Form robot</h2>
    <form:form method="POST" modelAttribute="robotForm" action="formNewRobot.htm">
        <table>
            <tr>
                <td>
                    <label>Nombre</label>
                    <form:input path="nombre" type="text"/>
                </td>
                <td>
                    <label>lugar</label>
                    <form:input path="lugar" type="text"/>
                </td>
                <td>
                    <label>Coor X</label>
                    <form:input path="coorX" type="text"/>
                </td>
                <td>
                    <label>Coor Y</label>
                    <form:input path="coorY" type="text"/>
                </td>
                <td>
                    <label>Estado</label>
                    <form:input path="estado" type="text"/>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>  
    </form:form>
</body>
</html>
