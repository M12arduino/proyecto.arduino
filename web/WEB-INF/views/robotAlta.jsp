<%-- 
    Document   : formNewRobot
    Created on : 12-may-2016, 20:46:56
    Author     : Couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<sec:authorize access="hasRole('rol_admin')">
    <jsp:include page="adminPanel.jsp"></jsp:include>
</sec:authorize>
    <div class="container">
        <br /><br />
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Añadir robot</h3>
                </div>
                <div class="panel-body">
                <form:form action="${base}/robot/insertar.htm" method="POST" role="form" >
                    <div class="form-group">
                        <label for="idRobot">ID Robot: </label>
                        <form:input path="id_robot" class="form-control" id="idRobot" />
                    </div>
                    <div class="form-group">
                        <label for="nombreRobot">Nombre: </label>
                        <form:input path="nombre" class="form-control" id="nombreRobot" />
                    </div>
                    <div class="form-group">
                        <label for="nombreRobot">Lugar: </label>
                        <form:input path="lugar" class="form-control" id="nombreRobot" />
                    </div>
                    <div class="form-group">
                        <label for="coorxRobot">Coor X: </label>
                        <form:input path="coorX" class="form-control" id="coorxRobot" />
                    </div>
                    <div class="form-group">
                        <label for="cooryRobot">Coor Y: </label>
                        <form:input path="coorY" class="form-control" id="cooryRobot" />
                    </div>
                    <div class="dropdown">
                        <label for="estadoRobot">Estado: </label>
                        <form:select class="form-control" path="estado">
                            <form:options items="${estados}" id="estadoRobot" />
                        </form:select>
                    </div>
                    <br /><br />
                    <input type="submit" class="btn btn-arduino btn-block" value="Send"/>
                </form:form>
            </div>
        </div>
    </div>
    <div class="col-md-3"></div>
</body>
</html>