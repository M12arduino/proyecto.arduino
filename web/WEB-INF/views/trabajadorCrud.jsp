<%-- 
    Document   : trabajadorCrud
    Created on : 17-may-2016, 20:50:38
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="${base}/resources/styles/CrudGeneral.css"/>
<script type="text/javascript" src="${base}/resources/js/crudTrabajador.js"></script>
<script type="text/javascript" src="${base}/resources/js/validaCrudTrabajador.js"></script>
<!DOCTYPE html>


<form:form name="MyForm" action="${base}/trabajador" method="POST" id="form" >
    <body>
        <div class="container">
            <div class="row search-form">
                <div class="col-md-4">
                    <h4 class="colorLabel">Criterios de búsqueda:</h4>
                </div>
                <div class="col-md-8">
                    <div class="form_search form-inline" role="form">
                        <div class="form-group">
                            <label for="nifSearchVal" class="colorLabel">Nif:</label>
                            <input type="text" class="form-control" placeholder="nif" id="nifSearchVal"/>
                        </div>
                        <div class="form-group">
                            <label for="nombreSearchVal" class="colorLabel">Nombre:</label>
                            <input type="text" class="form-control" placeholder="nif" id="nombreSearchVal"/>
                        </div>
                        <form:select path="categoriaSearch" id="categoriaSearchVal" class="form-control">
                            <form:options items="${categorias}" itemLabel="name"/>
                        </form:select>
                        <input type="button" value="buscar" id="search" class="btn btn-arduino"/>
                    </div>
                </div>
            </div>
            <div class="row edit_box">
                <div class="waiting_wrapper">
                    <img src="${base}/resources/img/wait.gif" class="waiting"/>
                </div>
                <div class="form_edit_box">
                    <p id="results" class="alert alert-info"> Busca Trabajadores que administrar con el formulario superior para empezar </p>
                    <div class="form_edit">
                        <div class="row">
                            <div class="col-md-12">
                                <h4>
                                    Formulario de Administración:
                                </h4>
                            </div>
                        </div>
                        <form:input path="id_trab" type="hidden" id="id_trab"/>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="nif">Nif:</label>
                            <div class="col-sm-10">
                                <form:input name="nif" path="nif" id="nif" placeholder="nif" class="form-control"/>
                                <span class="alert-danger" id="nif_error">Nif erroneo.</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="nif">Nombre:</label>
                            <div class="col-sm-10">
                                <form:input name="nombre" path="nombre" id="nombre" placeholder="nombre" class="form-control"/>
                                <span class="alert-danger" id="nombre_error">Nombre erroneo (solo letras).</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="movil">Movil:</label>
                            <div class="col-sm-10">
                                <form:input name="movil" path="movil" id="movil" placeholder="movil" class="form-control"/>
                                <span class="alert-danger" id="movil_error">Movil erroneo.</span>
                            </div>
                        </div>  
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="password">Password:</label>
                            <div class="col-sm-10">
                                <form:input name="password" path="password" id="password" placeholder="password" class="form-control"/>
                                <span class="alert-danger" id="password_error">Password erroneo.</span>
                            </div>
                        </div>   
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="categoria">Categoria:</label>
                            <div class="col-sm-10">
                                <form:select path="categoria" id="categoria" class="form-control">
                                    <form:options items="${categorias}" />
                                </form:select>
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
            <div class="waiting_wrapper">

                <img src="${base}/resources/img/wait.gif" class="waiting"/>
            </div>
            <div class="col-md-12">
                <p id="errorTable" class="error"> No hay registros para los criterios seleccionados </p>
                <table id="datatable_block" class="table table-bordered table-striped">

                </table>
            </div>
        </div>
    </div>
</body>
</html>

