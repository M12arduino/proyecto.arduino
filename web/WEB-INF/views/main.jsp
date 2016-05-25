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
<sec:authorize access="hasRole('LEADER')">
    <jsp:include page="adminPanel.jsp"></jsp:include>
</sec:authorize>
<sec:authorize access="hasRole('SENIOR')">
    <jsp:include page="workerPanel.jsp"></jsp:include>
</sec:authorize>
<div class="main_wrapper">
    <div class="row">
        <div class="col-md-12">
            <div class="form-inline" role="form">
                <div class="col-md-2">
                    <h4 class="colorLabel">Estadísticas Parciales:</h4>
                </div>
                <div class="form-group">
                    <label for="dropMesA" class="colorLabel">Mes:</label>
                    <select id="dropMesA" class="form-control">
                        <option value="blank">Desde</option>
                        <option value="0">Enero</option>
                        <option value="1">Febrero</option>
                        <option value="2">Marzo</option>
                        <option value="3">Abril</option>
                        <option value="4">Mayo</option>
                        <option value="4">Junio</option>
                        <option value="5">Julio</option>
                        <option value="6">Agosto</option>
                        <option value="7">Setiembre</option>
                        <option value="8">Octubre</option>
                        <option value="9">Noviembre</option>
                        <option value="11">Diciembre</option>        
                    </select>
                    <select id="dropMesB" class="form-control">
                        <option value="blank">Hasta</option>
                        <option value="0">Enero</option>
                        <option value="1">Febrero</option>
                        <option value="2">Marzo</option>
                        <option value="3">Abril</option>
                        <option value="4">Mayo</option>
                        <option value="4">Junio</option>
                        <option value="5">Julio</option>
                        <option value="6">Agosto</option>
                        <option value="7">Setiembre</option>
                        <option value="8">Octubre</option>
                        <option value="9">Noviembre</option>
                        <option value="11">Diciembre</option>        
                    </select>
                </div>
                <div class="form-group">
                    <label for="dropAnoA" class="colorLabel">Año:</label>
                    <input type="number" class="form-control" value="2015" id="dropAnoA" />
                    <input type="number" class="form-control" value="2017" id="dropAnoB" />
                </div>
                <div class="form-group">
                    <button id="search" class="btn btn-arduino" onclick="searchStatistics();">Buscar</button>
                </div>               
                <div class="col-md-12">
                    <div id="chartContainerA" class="stats_ajax"></div>
                </div>
                <div class="col-md-12">
                    <table id="datatable_block" class="table table-bordered table-striped">

                    </table>
                </div>
                <div class="col-md-12">
                    <p>Estadísticas Globales</p>
                </div>
                <div class="col-md-12">
                <div class="col-md-6">
                    <div id="chartContainer1"></div>
                </div>
                <div class="col-md-6">
                    <div id="chartContainer2"></div>
                </div>
                </div>
            </div>
            <script type="text/javascript" src="${base}/resources/libs/canvasJS/canvasjs.min.js"></script>
            <script type="text/javascript">
                        var chart1Statistics = JSON.parse('[' + '<%= ControllerStatistics.getStatusRobots()%>' + ']');
                        var chart2Statistics = JSON.parse('[' + '<%= ControllerStatistics.getHistorialEquipos()%>' + ']');
            </script>
            <script type="text/javascript" src="${base}/resources/js/statistics.js"></script>
            </body>
            <html>
