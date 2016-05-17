<%-- 
    Document   : cssLoader
    Created on : 12-may-2016, 19:39:41
    Author     : Couto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- GENERALES -->
<!DOCTYPE HTML>
<html>
    <head>
        <!-- Base para redirecciones, -->
        <c:set var="base" value="<%=request.getContextPath()%>" scope="session" />
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arduino Central Web</title>
        <link rel="stylesheet" href="${base}/resources/libs/bootstrap.min.css"/>
        <script type="text/javascript" src="${base}/resources/libs/jquery-2.2.3.js"></script>
        <script type="text/javascript" src="${base}/resources/libs/bootstrap.min.js"/>


        <!-- CSS PARTICULARES -->
        <link rel="stylesheet" href="${base}/resources/styles/login.css"/>

        <!-- JS PARTICULARES -->
        <script type="text/javascript" src="${base}/resources/js/login.js"></script>


        <!-- MOVER!! CSS SIEMPRE ANTES QUE JS-->
        
    </head>
