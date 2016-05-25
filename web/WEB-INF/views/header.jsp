<%-- 
    Document   : cssLoader
    Created on : 12-may-2016, 19:39:41
    Author     : Couto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <!-- Base para redirecciones, -->
        <c:set var="base" value="<%=request.getContextPath()%>" scope="session" />
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arduino Central Web</title>
        
        <!-- CSS -->
        <link rel="stylesheet" href="${base}/resources/libs/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${base}/resources/styles/adminPanel.css"/>
        <link rel="stylesheet" href="${base}/resources/styles/navBar.css"/>
        <link rel="stylesheet" href="${base}/resources/styles/paneles.css"/>
        <link rel="stylesheet" href="${base}/resources/styles/CrudGeneral.css"/>
        <!-- ??? -->
        <link rel="stylesheet" href="${base}/resources/styles/ordenFabricacionCrud.css"/>
        <link rel="stylesheet" href="${base}/resources/styles/procesoCrud.css"/>
        <link rel="stylesheet" href="${base}/resources/styles/robotCrud.css"/>
        <!-- -->
        <link rel="stylesheet" href="${base}/resources/libs/dataTables.bootstrap.min.css"/>
        <link rel="stylesheet" href="${base}/resources/libs/font-awesome/css/font-awesome.min.css"/>        
        <link rel="stylesheet" href="${base}/resources/styles/general.css"/>
        <!-- JS -->
        <script type="text/javascript" src="${base}/resources/libs/jquery-2.2.3.js"></script>
        <script type="text/javascript" src="${base}/resources/libs/bootstrap/js/bootstrap.min.js"/></script>
        <script type="text/javascript" src="${base}/resources/js/functions.js"></script>
        <script type="text/javascript" src="${base}/resources/js/procesoAlta.js"></script>
        <script type="text/javascript" src="${base}/resources/libs/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="${base}/resources/libs/dataTables.bootstrap.min.js"></script>
        <!-- MOVER!! CSS SIEMPRE ANTES QUE JS-->  
     </head>
     <body>
