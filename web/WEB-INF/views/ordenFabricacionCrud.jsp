<%-- 
    Document   : ordenFabricacionCrud
    Created on : 21-may-2016, 21:32:31
    Author     : OscarMorenoGonzalez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<link rel="stylesheet" href="${base}/resources/styles/ordenFabricacionCrud.css"/>
<script type="text/javascript" src="${base}/resources/js/crudOrdenFabricacion.js"></script>
<script type="text/javascript" src="${base}/resources/js/validaCrudOrdenFabricacion.js"></script>
<link href="/A_Spring_Inicial/resources/styles/altaGeneral.css" rel="stylesheet">

<div class="tableResults">
    <form:form name="MyForm" action="${base}/ordenFabricacion" method="POST" id="form">
        <div class="form_search">
            <input type="text" placeholder="codigo" id="codigoSearchVal"/>
            <input type="text" placeholder="descripcion" id="descripcionSearchVal"/>
            <form:select path="prioridad" id="prioridadSearchVal">
                <form:options  items="${prioridades}" />
            </form:select>
            <form:select path="codigo_proceso" id="codigo_procesoSearchVal">
                <form:options itemLabel="codigo" itemValue="codigo" items="${procesos}" />
            </form:select>
            <form:input path="cantidad" id="cantidadSearchVal"/>
            <form:select path="id_robot" id="id_robotSearchVal">
                <form:options itemLabel="nombre" itemValue="id_robot" items="${robots}" />
            </form:select>
            
            <input type="button" value="buscar" id="search"/>
            <p id="results"> Busca una Orden de Fabricación </p>
        </div>
        <div class="form_edit">
            <form:input path="id" type="hidden" id="id"/>
            Codigo: <form:input name="codigo" path="codigo" />
            <span class="alert-danger" id="codigo_error">Código erroneo. ejemplo: OF001</span>
            Descripcion: <form:input name="descripcion" path="descripcion" />
            <span class="alert-danger" id="descripcion_error">La descripción debe contener solo letras.</span>
            Prioridad: 
            <form:select path="prioridad">
                <form:options  items="${prioridades}" />
            </form:select>
            Proceso: 
            <form:select path="codigo_proceso">
                <form:options itemLabel="codigo" itemValue="codigo" items="${procesos}" />
            </form:select>
            Cantidad: <form:input name="cantidadOrden" path="cantidad" />
            <span class="alert-danger" id="cantidadOrden_error">La cantidad debe contener solo números.</span>
            Id_Robot:
            <form:select path="id_robot">
                <form:options itemLabel="nombre" itemValue="id_robot" items="${robots}" />
            </form:select>
            
            <input name="editar" type="button" value="Editar" id="editar"/>
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
