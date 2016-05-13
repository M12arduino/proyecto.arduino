<%-- 
    Document   : login
    Created on : 12-may-2016, 15:38:59
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Spring MVC Form Handling</title>
    </head>
    <body>

        <h2>Student Information</h2>
        <form:form method="POST" modelAttribute="trabajadorForm" action="login.htm">
            <table>
                <tr>
                    <td>
                        <label> Nombre</label>
                        <form:input path="nombre" type="text"/>
                    </td>
                    <td>
                        <label> Password</label>
                        <form:input path="password" type="password"/>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table>  
        </form:form>
    </body>
</html>