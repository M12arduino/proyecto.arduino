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
       <div class="container">
            <br /><br />
            <div class="panel panel-primary">
                <p class="text-uppercase panel-heading text-center"><strong>Dar de alta un nuevo trabajador</strong></p>
                <form:form method="post" modelAttribute="trabajadorForm" action="darAltaTrabajador.htm">
                    <div class="form-group">NIF: <input type="text" maxlength="9" path="nif" /></div>
                    <div class="form-group">Nombre: <input type="text" path="nombre" /></div>
                    <div class="form-group">Movil: <input type="text" path="movil" /></div>
                    <div class="form-group">Categoria: <input type="text" path="categoria" /></div>
                    <input type="submit" class="btn btn-default" name="Submit" value="Send"/>
                </form:form>
                <br>
            </div>
        </div>
    </body>
</html>
