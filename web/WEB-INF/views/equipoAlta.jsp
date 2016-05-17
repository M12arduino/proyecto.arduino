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

       <form:form action="${base}/equipo/insertar.htm" method="GET">
            ID_EQUIPO: <form:input path="id_equipo" />
            Nombre: <form:input path="nombre" />
            <span icon="chorribootrstap icon">
            <form:checkboxes items="${listaTrabajadores}"  itemValue="nif" path="nifs" itemLabel="nombre"/>
            <input type="submit" value="Send"/>
        </form:form>

    </body>
</html>
