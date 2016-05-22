<%-- 
    Document   : equipoCrud
    Created on : 21-may-2016, 20:46:51
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="${base}/resources/styles/trabajadorCrud.css"/>
<script type="text/javascript" src="${base}/resources/js/crudEquipo.js"></script>
<!DOCTYPE html>

<label for="nif">NIF</label>


<form:form action="${base}/equipo" method="POST" id="form">
    <div class="form_search form-inline" role"form">
         <div class="form-group">
            <label for="nif_equipoSearchVal">Id Equipo:</label>
            <input type="text" class="form-control" placeholder="id_equipo" id="nif_equipoSearchVal"/>
        </div>
        <div class="form-group">
            <label for="nombreSearchVal">Nombre:</label>
            <input type="text" class="form-control" placeholder="nombre" id="nombreSearchVal"/>
        </div>
        <div class="form-group">
            <input type="button" class="form-control btn btn-default" value="buscar" id="search"/>
        </div>


        <div id="modal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Añadir Trabajadores</h4>
                    </div>
                    <div class="modal-body">
                        <ul id="trabajadoresModal">

                        </ul>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="guardaModal">Save changes</button>
                    </div>
                </div>
            </div>

        </div>
    </div>


    <p id="results"> Busca algun resultado </p>
</div>


<div class="form_edit">
    <form:input path="id" type="hidden" id="id" class="form-horizontal" role="form"/>
    <div class="form-group">
        <label class="control-label col-sm-2" for="id_equipo">Id Equipo:</label>
        <div class="col-sm-10">
            <form:input path="id_equipo" id="id_equipo" placeholder="id_equipo" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="nombre">Nombre:</label>
        <div class="col-sm-10">
            <form:input path="nombre" id="nombre" placeholder="nombre" class="form-control"/>
        </div>
    </div>
    <ul id="trabajadores">
    </ul>
    <div id="addTrabajador" data-toggle="modal" data-target="#modal">
        <span>
            Añadir Trabajador
        </span>
        <span class="fa fa-plus-circle" >
        </span>
    </div>
    <div class="col-sm-offset-2 col-sm-10">
        <input type="button" class="btn btn-default" value="Editar" id="editar"/>
    </div>
    <div class="col-sm-offset-2 col-sm-10">
       <input type="button" class="btn btn-default" value="Eliminar" id="eliminar"/>
    </div>
    
</div>
</form:form>
<div class="col-md-2"></div>
<div class="col-md-8">
    <p id="errorTable" class="error"> No hay registros para los criterios seleccionados </p>
    <table id="datatable">

    </table>
</div>
</html>
