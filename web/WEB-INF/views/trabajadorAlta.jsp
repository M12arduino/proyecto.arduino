<%-- 
    Document   : formTrabajadorAlta
    Created on : 12-may-2016, 17:19:44
    Author     : Jordi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<script src="${base}/resources/js/validaTrabajador.js" type="text/javascript"></script>
<link href="${base}/resources/styles/altaGeneral.css" rel="stylesheet">
    <div class="container">
        <br /><br />
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Añadir trabajador</h3>
                </div>
                <div class="panel-body">
                <form:form name="MyForm" action="${base}/trabajador/actualizar.htm" method="POST" role="form" >
                    <div class="form-group">
                        <label for="nifTrabajador">NIF: </label>
                        <form:input name="nif" path="nif" class="form-control" id="nifTrabajador"/>
                        <span class="alert-danger" id="nif_error">Nif erroneo.</span>
                    </div>
                    <div class="form-group">
                        <label for="nombreTrabajador">Nombre: </label>
                        <form:input name="nombre" path="nombre" class="form-control" id="nombreTrabajador" />
                        <span class="alert-danger" id="nombre_error">Nombre erroneo (solo letras).</span>
                    </div>
                    <div class="form-group">
                        <label for="movilTrabajador">Movil: </label>
                        <form:input name="movil" path="movil" class="form-control" id="movilTrabajador" />
                        <span class="alert-danger" id="movil_error">Movil erroneo.</span>
                    </div>
                    <div class="form-group">
                        <label for="passTrabajador">Password: </label>
                        <form:input name="password" path="password" class="form-control" id="passTrabajador" />
                        <span class="alert-danger" id="password_error">Password erroneo.</span>
                    </div>
                    <div class="dropdown">
                        <label for="categoriaTrabajador">Categoria: </label>
                        <form:select class="form-control" path="categoria">      
                            <form:options items="${categorias}" id="categoriaTrabajador" />
                        </form:select>
                    </div>
                    <br /><br />
                    <input type="submit" class="btn btn-arduino btn-block" value="Enviar"/>
                </form:form>
            </div>
        </div>
    </div>
    <div class="col-md-3"></div>
</div>
<jsp:include page="footer.jsp"></jsp:include>