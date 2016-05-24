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
<div class="col-md-4 col-md-push-2">
    <div id="chartContainer1" style="height: 300px; width: 100%;"></div>
</div>
<div class="col-md-5 col-md-push-2">
    <div id="chartContainer2" style="height: 300px; width: 100%;"></div>
</div>
    <script type="text/javascript">
        window.onload = function () {
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
                        // { y: 53.37, legendText:"Android 53%", indexLabel: "Android 53%" },
                        dataPoints: [<%= ControllerStatistics.getHistorialEquipos()%>]
                    }
                ]
            });
            chart1.render();
            chart2.render();
        }; // TANCA ONLOAD

    </script>
</body>
<html>
