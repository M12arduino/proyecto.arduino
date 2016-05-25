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

<div class="col-md-10 col-md-push-2">
    <p>Estadísticas Parciales</p>
</div>
<div class="col-md-10 col-md-push-2">
    Mes:
    <select id="dropMesA">
        <option value="blank">Entre</option>
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
    <select id="dropMesB">
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
    Año: 
    Desde
    <input type="number" value="2015" id="dropAnoA" />
    Hasta
    <input type="number" value="2017" id="dropAnoB" />
    <button id="search" onclick="searchStatistics();">Buscar</button>
</div>
<div class="col-md-4 col-md-push-2">
    <div id="chartContainerA" style="height: 300px; width: 100%;"></div>
</div>
<div class="col-md-5 col-md-push-2">

</div>
<div class="col-md-10 col-md-push-2">
    <p>Estadísticas Globales</p>
</div>
<div class="col-md-4 col-md-push-2">
    <div id="chartContainer1" style="height: 300px; width: 100%;"></div>
</div>
<div class="col-md-5 col-md-push-2">
    <div id="chartContainer2" style="height: 300px; width: 100%;"></div>
</div>

<script type="text/javascript" src="${base}/resources/libs/canvasJS/canvasjs.min.js"></script>
<script type="text/javascript">
        window.onload = initJS;
        function initJS() {
            var chart1 = new CanvasJS.Chart("chartContainer1", {
                theme: "theme1", //theme1
                title: {
                    text: "Estado de los Robots"
                },
                animationEnabled: true, // change to true
                data: [
                    {
                        type: "column",
                        dataPoints: [<%= ControllerStatistics.getStatusRobots()%>]
                    }
                ]
            });
            var chart2 = new CanvasJS.Chart("chartContainer2", {
                theme: "theme1", //theme1
                title: {
                    text: "Histórico de ordenes realizadas"
                },
                animationEnabled: true, // change to true
                data: [
                    {
                        indexLabelFontSize: 20,
                        indexLabelFontFamily: "Garamond",
                        indexLabelFontColor: "darkgrey",
                        indexLabelLineColor: "darkgrey",
                        indexLabelPlacement: "outside",
                        type: "doughnut",
                        showInLegend: true,
                        dataPoints: [<%= ControllerStatistics.getHistorialEquipos()%>]
                    }
                ]
            });
            chart1.render();
            chart2.render();
        }
        function searchStatistics() {
            var dataInfo = "hi";
            var dropMesA = document.getElementById("dropMesA").value;
            var dropMesB = document.getElementById("dropMesB").value;
            var dropAnoA = document.getElementById("dropAnoA").value;
            var dropAnoB = document.getElementById("dropAnoB").value;
            if (dropMesA !== "blank") {
                if (dropMesB !== "blank") {
                    if (dropMesA < dropMesB) {
                        mA = dropMesA;
                        mB = dropMesB;
                    } else {
                        mB = dropMesA;
                        mA = dropMesB;
                    }
                } else {
                    mA = dropMesA;
                    mB = dropMesA;
                }
            } else {
                if (dropMesB !== "blank") {
                    mA = dropMesB;
                    mB = dropMesB;
                } else {
                    mA = 0;
                    mB = 11;
                }
            }

            if (dropAnoA !== "blank") {
                if (dropAnoB !== "blank") {
                    if (dropAnoA < dropAnoB) {
                        aA = dropAnoA;
                        aB = dropAnoB;
                    } else {
                        aB = dropAnoA;
                        aA = dropAnoB;
                    }
                } else {
                    aA = dropAnoA;
                    aB = dropAnoA;
                }
            } else {
                if (dropAnoB !== "blank") {
                    aA = dropAnoB;
                    aB = dropAnoB;
                } else {
                    aA = 0;
                    aB = 3000;
                }
            }

            $.ajax({
                type: "POST",
                url: "/A_Spring_Inicial/stats/ajaxDiagramaA.htm",
                data: {
                    'mesA': mA,
                    'mesB': mB,
                    'anoA': aA,
                    'anoB': aB
                },
                success: function (mydata) {
                    var chart3 = new CanvasJS.Chart("chartContainerA", {
                        theme: "theme1", //theme1
                        title: {
                            text: "Ordenes segun priodo"
                        },
                        animationEnabled: true, // change to true
                        data: [
                            {
                                type: "column",
                                dataPoints: mydata
                            }
                        ]
                    });
                    //$("#chartContainer3").fadeIn("slow");
                    chart3.render();
                }
            });


        }
</script>
</body>
<html>
