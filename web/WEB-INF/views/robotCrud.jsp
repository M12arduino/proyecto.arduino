<%-- 
    Document   : robotCrud
    Created on : 18-may-2016, 20:31:06
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<link rel="stylesheet" href="${base}/resources/styles/CrudGeneral.css"/>
<script type="text/javascript" src="${base}/resources/js/crudRobot.js"></script>
    <div class="container">
        <form:form action="${base}/robot" method="POST" id="form">
            <div class="row search-form">
                <div class="col-md-4">
                    <h4 class="colorLabel">Criterios de búsqueda:</h4>
                </div>
                <div class="col-md-8">
                    <div class="form_search form-inline" role="form">
                        <div class="form-group">
                            <label for="id_robotSearchVal" class="colorLabel">Id Robot:</label>
                            <input type="text" class="form-control" placeholder="id_robot" id="id_robotSearchVal"/>
                        </div>
                        <div class="form-group">
                            <label for="nombreSearchVal" class="colorLabel">Nombre:</label>
                            <input type="text" class="form-control" placeholder="nombre" id="nombreSearchVal"/>
                        </div>
                        <div class="form-group">
                            <label for="lugarSearchVal" class="colorLabel">Lugar:</label>
                            <input type="text" class="form-control" placeholder="lugar" id="lugarSearchVal"/>
                        </div>
                        <div class="form-group">
                            <label for="estadoSearchVal" class="colorLabel">Estado:</label>
                            <form:select path="estadoSearch" class="form-control" id="estadoSearchVal">
                                <form:options items="${estados}" itemLabel="name"/>
                            </form:select>
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
                            <label class="control-label col-sm-2" for="id_robot">Id Equipo:</label>
                            <div class="col-sm-10">
                                <form:input path="id_robot" id="id_robot" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="nombre">Nombre:</label>
                            <div class="col-sm-10">
                                <form:input path="nombre" id="nombre" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="lugar">Lugar:</label>
                            <div class="col-sm-10">
                                <form:input path="lugar" class="form-control" id="lugar"/>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="coorX">CoorX:</label>
                            <div class="col-sm-10">
                                <form:input path="coorX" class="form-control" id="coorX"/>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="coorY">CoorY:</label>
                            <div class="col-sm-10">
                                <form:input path="coorY" class="form-control" id="coorY"/>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="estado">Estado:</label>
                            <div class="col-sm-10">
                                <form:select path="estado" id="estado" class="form-control">
                                    <form:options items="${estados}" />
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
