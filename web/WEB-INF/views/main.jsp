<%-- 
    Document   : main.jsp
    Created on : 13-may-2016, 19:41:38
    Author     : enric
--%>
<%@page import="m12.arduino.controller.ControllerStatistics"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<sec:authorize access="hasRole('rol_admin')">
    <jsp:include page="adminPanel.jsp"></jsp:include>
</sec:authorize>
<div class="col-md-10 col-md-push-2">
    <div class="panel panel-primary">
        <p class="text-uppercase text- panel-heading text-center"><strong></strong></p>
        <div id="chartContainer1" style="height: 300px; width: 100%;"></div>
    </div>
    
</div>
</body>
<html>