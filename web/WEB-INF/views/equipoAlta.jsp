<%-- 
    Document   : equipoAlta
    Created on : 13-may-2016, 20:28:41
    Author     : enric
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

       <form:form action="insertar.htm" method="POST">
            ID_EQUIPO: <form:input path="id_equipo" />
            Nombre: <form:input path="nombre" />
            <form:select path="trabajadores">
                <form:options items="${listaTrabajadfdsfdsfores}" itemValue="nif" itemLabel="nombre"/>
            </form:select>
            <input type="submit" value="Send"/>
        </form:form>

    </body>
</html>
