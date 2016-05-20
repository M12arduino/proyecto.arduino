<%-- 
    Document   : objectDetail
    Created on : 20-may-2016, 17:41:42
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
            <c:forEach var="field" items="${objeto.getFields()}">
                <td>${field}</td>
            </c:forEach>
        </tr>
        <tr>
        <c:forEach var="field" items="${objeto.getInfo()}">
            <td>${field}</td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
