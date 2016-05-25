<%-- 
    Document   : error
    Created on : 13-may-2016, 18:18:36
    Author     : Jordi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                    <h3 class="panel-title">Mi Perfil</h3>
                </div>
                <div class="panel-body">
                    <form:form name="MyForm" action="${base}/trabajador/actualizarPerfil.htm" method="POST" role="form" >
                    <div class="form-group">
                        <label for="idTrabajador">ID: </label>
                        <input class="form-control" id="idTrabajador" value="${myTrab.getId_trab()}" disabled/>
                    </div>
                    <div class="form-group">
                        <label for="categoriaTrabajador">Categoria: </label>
                        <input class="form-control" id="categoriaTrabajador" value="${myTrab.getCategoria()}" disabled/>
                    </div>
                    <div class="form-group">
                        <label for="equipoTrabajador">Equipo: </label>
                        <input class="form-control" id="equipoTrabajador" value="${myTrab.getEquipo().getId_equipo()}" disabled/>
                    </div>
                    <div class="form-group">
                        <label for="nifTrabajador">NIF: </label>
                        <input class="form-control" id="nifTrabajador" value="${myTrab.getNif()}" disabled/>
                    </div>
                    <div class="form-group">
                        <label for="nombreTrabajador">Nombre: </label>
                        <form:input name="nombre" path="nombre" class="form-control" id="nombreTrabajador" value="${myTrab.getNombre()}"/>
                        <span class="alert-danger" id="nombre_error">Nombre erroneo (solo letras).</span>
                    </div>
                    <div class="form-group">
                        <label for="movilTrabajador">Movil: </label>
                        <form:input name="movil" path="movil" class="form-control" id="movilTrabajador" value="${myTrab.getMovil()}"/>
                        <span class="alert-danger" id="movil_error">Movil erroneo.</span>
                    </div>
                    <div class="form-group">
                        <label for="passTrabajador">Password: </label>
                        <form:input name="password" path="password" class="form-control" id="passTrabajador" placeholder="********"/>
                        <span class="alert-danger" id="password_error">Password erroneo.</span>
                    </div>
                    <br /><br />
                    <form:input type="hidden" name="id_trab" path="id_trab" value="${myTrab.getId_trab()}"/>
                    <form:input type="hidden" name="categoria" path="categoria" value="${myTrab.getCategoria()}"/>
                    <form:input type="hidden" name="equipo" path="id_equipo" value="${myTrab.getEquipo().getId_equipo()}"/>
                    <form:input type="hidden" name="nif" path="nif" value="${myTrab.getNif()}"/>
                    <input type="submit" class="btn btn-arduino btn-block" value="Send"/>
                </form:form>
            </div>
        </div>
    </div>
    <div class="col-md-3"></div>
</div>
</body>
</html>
