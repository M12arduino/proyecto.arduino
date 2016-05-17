<%-- 
    Document   : welcome
    Created on : 12-may-2016, 20:04:13
    Author     : enric
--%>

<%@page import="m12.arduino.domain.CategoriaTrabajador"%>
<%@page import="m12.arduino.domain.Trabajador"%>
<%@page import="m12.arduino.domain.Equipo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="tableMaker.jsp"></jsp:include>
    </body>
</html>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
INSERT OK

