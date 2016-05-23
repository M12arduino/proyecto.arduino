<%-- 
    Document   : TableMaker
    Created on : 17-may-2016, 14:40:45
    Author     : Jordi
--%>

<%@page import="m12.arduino.domain.Equipo"%>
<%@page import="m12.arduino.domain.CategoriaTrabajador"%>
<%@page import="m12.arduino.domain.Trabajador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
    <table border="1">
        <thead>
            <tr>
            <c:forEach var="field" items="${listado.get(0).getFields()}">
                <td>${field}</td>
            </c:forEach>
        </tr>
    </thead>
    <tbody>     
        <c:forEach var="object" items="${listado}">
            <tr>
                <c:forEach var="item" items="${object.getInfo()}">
                    <td>${item}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </tbody>
</table>
