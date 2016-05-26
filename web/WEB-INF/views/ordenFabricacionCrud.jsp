<%-- 
    Document   : ordenFabricacionCrud
    Created on : 21-may-2016, 21:32:31
    Author     : OscarMorenoGonzalez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<link rel="stylesheet" href="${base}/resources/styles/CrudGeneral.css"/>
<script type="text/javascript" src="${base}/resources/js/crudOrdenFabricacion.js"></script>
<script type="text/javascript" src="${base}/resources/js/validaCrudOrdenFabricacion.js"></script>
<link href="/A_Spring_Inicial/resources/styles/altaGeneral.css" rel="stylesheet">

<body>
    <div class="container">
        <div class="page-header">
            <h1>Administración de Ordenes de fabricación</h1>
        </div>
        <form:form name="MyForm" action="${base}/ordenFabricacion" method="POST" id="form">
            <div class="row search-form">
                <div class="col-md-3">
                    <h4 class="colorLabel">Criterios de búsqueda:</h4>
                </div>
                <div class="col-md-9">
                    <div class="form_search form-inline" role="form">
                        <div class="form-group">
                            <label for="codigoSearchVal" class="colorLabel">Codigo Orden:</label>
                            <input type="text" class="form-control" placeholder="codigo" id="codigoSearchVal"/>
                        </div>
                        <div class="form-group">
                            <label for="descripcionSearchVal" class="colorLabel">Descripción:</label>
                            <input type="text" class="form-control" placeholder="descripción" id="descripcionSearchVal"/>
                        </div>
                        <div class="form-group">
                            <label for="prioridadSearchVal" class="colorLabel">Prioridad:</label>
                            <form:select path="prioridad" class="form-control" id="prioridadSearchVal">
                                <form:options   items="${prioridades}" />
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="codigo_procesoSearchVal" class="colorLabel">Codigo Prceso: </label>
                            <form:select path="codigo_proceso" class="form-control" id="codigo_procesoSearchVal">
                                <form:option value="0">Procesos</form:option>
                                <form:options itemLabel="codigo" itemValue="id" items="${procesos}" />
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="equipo_idSearchVal" class="colorLabel">Equipo: </label>
                            <form:select path="equipo_id" class="form-control" id="equipo_idSearchVal">
                                <form:option value="0">Equipos</form:option>
                                <form:options itemValue="id" itemLabel="nombre" items="${equipos}" />
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="cantidadSearchVal" class="colorLabel">Id Robot:</label>
                            <form:select path="id_robot" class="form-control" id="id_robotSearchVal">
                                <form:option value="0">Robots</form:option>
                                <form:options itemLabel="nombre" itemValue="id" items="${robots}" />
                            </form:select>
                        </div>

                        <div class="form-group">
                            <input type="button" class="form-control btn btn-arduino" value="buscar" id="search"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form_edit_box">
                <p id="results" class="alert alert-info"> Busca equipos que administrar con el formulario superior para empezar </p>
                <div class="form_edit">
                    <div class="row">
                        <div class="col-md-12">
                            <h4>
                                Formulario de Administración:
                            </h4>
                        </div>
                    </div>
                    <form:input path="id" type="hidden" id="id"/>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="codigo">Codigo:</label>
                        <div class="col-sm-10">
                            <form:input name="codigo" path="codigo" class="form-control" id="codigo"/>
                            <span class="alert-danger" id="codigo_error">Código erroneo. ejemplo: OF001</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="descripcion">Descripcion:</label>
                        <div class="col-sm-10">
                            <form:input name="descripcion" path="descripcion" id="descripcion" class="form-control" />
                            <span class="alert-danger" id="descripcion_error">La descripción debe contener solo letras y números.</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="codigo">Prioridad:</label>
                        <div class="col-sm-10">
                            <form:select path="prioridad" class="form-control" id="prioridad">
                                <form:options  items="${prioridades}" />
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="codigo_proceso">Codigo Proceso:</label>
                        <div class="col-sm-10">
                            <form:select path="codigo_proceso" class="form-control" id="codigo_proceso">
                                <form:options itemValue="id" itemLabel="codigo" items="${procesos}" />
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="cantidad">Cantidad:</label>
                        <div class="col-sm-10">
                            <form:input name="cantidad" path="cantidad" id="cantidad" class="form-control" />
                            <span class="alert-danger" id="cantidad_error">La cantidad debe contener solo números.</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="id_robot">ID Robot:</label>
                        <div class="col-sm-10">
                            <form:select path="id_robot" class="form-control" id="id_robot">
                                <form:options itemValue="id" itemLabel="nombre" items="${robots}" />
                            </form:select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="button" class="btn btn-arduino" value="Editar" id="editar"/>
                            <input type="button" class="btn btn-arduino" value="Eliminar" id="eliminar"/>
                        </div>
                    </div>
                    <div id="results_info">

                    </div>
                </div>
            </div>
        </form:form>
        <div class="row datatable-form">
            <div class="col-md-12">
                <p id="errorTable" class="error"> No hay registros para los criterios seleccionados </p>
                <table id="datatable" class="table table-bordered table-striped">

                </table>
            </div>
        </div>
    </div>
</body>
</html>
