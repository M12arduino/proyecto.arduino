<%-- 
    Document   : formTrabajadorAlta
    Created on : 12-may-2016, 17:19:44
    Author     : Jordi
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

        <form:form action="darAltaTrabajador.htm" method="POST">
            NIF: <form:input path="nif" />
            Nombre: <form:input path="nombre" />
            Movil: <form:input path="movil" />
            Password: <form:input path="password" />
            Categoria: 
            <form:select path="categoria">
                <form:options items="${categorias}" itemValue="code" itemLabel="name" />
            </form:select>
            <input type="submit" value="Send"/>
        </form:form>

    </body>
</html>
