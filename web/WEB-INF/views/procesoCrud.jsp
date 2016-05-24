<%-- 
    Document   : procesoCrud
    Created on : 21-may-2016, 19:33:25
    Author     : OscarMorenoGonzalez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<link rel="stylesheet" href="${base}/resources/styles/CrudGeneral.css"/>
<script type="text/javascript" src="${base}/resources/js/crudProceso.js"></script>
<!DOCTYPE html>
<body>
    <div class="container">
        <form:form action="${base}/proceso" method="POST" id="form">
            <div class="page-header">
                <h1>Administración de Equipos</h1>
            </div>
            <div class="row search-form">
                <div class="col-md-4">
                    <h4 class="colorLabel">Criterios de búsqueda:</h4>
                </div>
                <div class="col-md-8">
                    <div class="form_search form-inline" role="form">
                        <div class="form-group">
                            <label for="codigoSearchVal" class="colorLabel">Codigo Proceso:</label>
                            <input type="text" class="form-control" placeholder="codigo" id="codigoSearchVal"/>
                        </div>
                        <div class="form-group">
                            <label for="descripcionSearchVal" class="colorLabel">Descripcion:</label>
                            <input type="text" class="form-control" placeholder="descripción" id="descripcionSearchVal"/>
                        </div>
                        <div class="form-group">
                            <input type="button" class="form-control btn btn-arduino" value="buscar" id="search"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row edit_box">                        
                <div class="waiting_wrapper">
                    <img src="${base}/resources/img/wait.gif" class="waiting"/>
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
                            <label class="control-label col-sm-2" for="codigo">Codigo Proceso:</label>
                            <div class="col-sm-10">
                                <form:input path="codigo" id="codigo" placeholder="codigo" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="descripcion">Descripcion:</label>
                            <div class="col-sm-10">
                                <form:input path="descripcion" id="descripcion" placeholder="descripcion" class="form-control"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="button" class="btn btn-arduino" value="Editar" id="editar"/>
                                <input type="button" class="btn btn-arduino" value="Eliminar" id="eliminar"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
        <div class="row datatable-form">
            <div class="waiting_wrapper">

                <img src="${base}/resources/img/wait.gif" class="waiting"/>
            </div>
            <div class="col-md-12">
                <p id="errorTable" class="error"> No hay registros para los criterios seleccionados </p>
                <table id="datatable" class="table table-bordered table-striped">

                </table>
            </div>
        </div>
    </div>
</body>
</html>