<%-- 
    Document   : equipoCrud
    Created on : 21-may-2016, 20:46:51
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="${base}/resources/styles/trabajadorCrud.css"/>
<script type="text/javascript" src="${base}/resources/js/crudEquipo.js"></script>
<!DOCTYPE html>

<label for="nif">NIF</label>


<form:form action="${base}/equipo" method="POST" id="form">
    <div class="form_search">
        <input type="text" placeholder="id_equipo" id="nif_equipoSearchVal"/>
        <input type="text" placeholder="nombre" id="nombreSearchVal"/>
        <input type="button" value="buscar" id="search"/>

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
    <form:input path="id" type="hidden" id="id"/>
    ID EQUIPO: <form:input path="id_equipo" id="id_equipo"/>
    Nombre: <form:input path="nombre" id="nombre"/>
    <ul id="trabajadores">
    </ul>
    <div id="addTrabajador" data-toggle="modal" data-target="#modal">
        <span>
            Añadir Trabajador
        </span>
    <span class="fa fa-plus-circle" >
    </span>
    </div>
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
</html>
