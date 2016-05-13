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

                <form:form method="post" modelAttribute="trabajadorForm" action="darAltaTrabajador.htm">
                    NIF: <input type="text" path="nif" />
                    Nombre: <input type="text" path="nombre" />
                    Movil: <input type="text" path="movil" />
                    Categoria: <input type="text" path="categoria" />
                    <input type="submit" class="btn btn-default" name="Submit" value="Send"/>
                </form:form>

    </body>
</html>
