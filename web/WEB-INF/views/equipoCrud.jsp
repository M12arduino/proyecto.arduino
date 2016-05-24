<%-- 
    Document   : equipoCrud
    Created on : 21-may-2016, 20:46:51
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<link rel="stylesheet" href="${base}/resources/styles/CrudGeneral.css"/>
<script type="text/javascript" src="${base}/resources/js/crudEquipo.js"></script>
<script type="text/javascript" src="${base}/resources/js/validaCrudEquipo.js"></script>

    <div class="container">
    <form:form name="MyForm" action="${base}/equipo" method="POST" id="form">
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
                        <label for="nif_equipoSearchVal" class="colorLabel">Id Equipo:</label>
                        <input type="text" class="form-control" placeholder="id_equipo" id="id_equipoSearchVal"/>
                    </div>
                    <div class="form-group">
                        <label for="nombreSearchVal" class="colorLabel">Nombre:</label>
                        <input type="text" class="form-control" placeholder="nombre" id="nombreSearchVal"/>
                    </div>
                    <div class="form-group">
                        <input type="button" class="form-control btn btn-arduino" value="buscar" id="search"/>
                    </div>
                </div>
            </div>
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
                        <button type="button" class="btn btn-arduino" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-arduino" id="guardaModal">Guardar cambios</button>
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
                    <form:input path="id" type="hidden" id="id" class="form-horizontal" role="form"/>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="id_equipo">Id Equipo:</label>
                        <div class="col-sm-10">
                            <form:input name="id_equipo" path="id_equipo" id="id_equipo" placeholder="id_equipo" class="form-control"/>
                            <span class="alert-danger" id="id_equipo_error">ID erroneo.</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="nombre">Nombre:</label>
                        <div class="col-sm-10">
                            <form:input name="nombre" path="nombre" id="nombre" placeholder="nombre" class="form-control"/>
                            <span class="alert-danger" id="nombre_error">Nombre erroneo.</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label " for="nombre">Trabajadores:</label>
                            <div id="addTrabajador" data-toggle="modal" data-target="#modal">
                                <span class="addText">
                                    Añadir Trabajadores
                                </span>
                                <span class="fa fa-plus-circle" >
                                </span>
                            </div>
                        </div>
                        <div class="col-sm-10">
                            <ul id="trabajadores">
                            </ul>
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
        <div class="row">
            <div class="waiting_wrapper">

                <img src="${base}/resources/img/wait.gif" class="waiting"/>
            </div>
            <div id="results_info">

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
