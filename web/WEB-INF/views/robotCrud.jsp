<%-- 
    Document   : robotCrud
    Created on : 18-may-2016, 20:31:06
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<link rel="stylesheet" href="${base}/resources/styles/robotCrud.css"/>
<script type="text/javascript" src="${base}/resources/js/crudRobot.js"></script>


<div class="tableResults">
    <form:form action="${base}/robot" method="POST" id="form">
        <div class="form_search">
            <input type="text" placeholder="id_robot" id="id_robotSearchVal"/>
            <input type="text" placeholder="nombre" id="nombreSearchVal"/>
            <input type="text" placeholder="lugar" id="lugarSearchVal"/>
            <form:select path="estadoSearch" id="estadoSearchVal">
                <form:options items="${estados}" itemLabel="name"/>
            </form:select>
            <input type="button" value="buscar" id="search"/>
            <p id="results"> Busca un Robot </p>
        </div>
        <div class="form_edit">
            <form:input path="id" type="hidden" id="id"/>
            ID Robot: <form:input path="id_robot"/>
            Nombre: <form:input path="nombre" />
            Lugar: <form:input path="lugar" />
            Coor X: <form:input path="coorX" />
            Coor Y: <form:input path="coorY" />
            Estado 
            <form:select path="estado">
                <form:options items="${estados}" />
            </form:select>
            <input type="button" value="Editar" id="editar"/>
            <input type="button" value="Eliminar" id="eliminar"/>
        </div>
    </form:form>
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <p id="errorTable" class="error"> No hay registros para los criterios seleccionados </p>
        <table id="datatable">

        </table>
    </div>
</div>
</body>
</html>