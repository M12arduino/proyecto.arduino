<%-- 
    Document   : main.jsp
    Created on : 13-may-2016, 19:41:38
    Author     : enric
--%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<sec:authorize access="hasRole('rol_admin')">
    <jsp:include page="adminPanel.jsp"></jsp:include>
</sec:authorize>

<body>
<html>