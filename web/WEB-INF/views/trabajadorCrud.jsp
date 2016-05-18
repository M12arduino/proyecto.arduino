<%-- 
    Document   : trabajadorCrud
    Created on : 17-may-2016, 20:50:38
    Author     : enric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="${base}/resources/styles/trabajadorCrud.css"/>
 <script type="text/javascript" src="${base}/resources/js/crudTrabajador.js"></script>
<!DOCTYPE html>

<label for="nif">NIF</label>

    
    <form:form action="${base}/trabajador" method="POST" id="form">
        <div class="form_search">
            <input type="text" placeholder="nif" id="nifSearchVal"/>
            <input type="text" placeholder="nombre" id="nombreSearchVal"/>
            <form:select path="categoriaSearch" id="categoriaSearch">
                <form:options items="${categorias}" />
            </form:select>
            <input type="button" value="buscar" id="search"/>
        <p id="results"> Busca algun resultado </p>
        </div>
        <div class="form_edit">
          <form:input path="id_trab" type="hidden" id="id_trab"/>
            NIF: <form:input path="nif" id="nif"/>
            Nombre: <form:input path="nombre" id="nombre"/>
            Movil: <form:input path="movil" id="movil" />
            Password: <form:input path="password" id="password"/>
            Categoria: 
            <form:select path="categoria" id="categoria">
                <form:options items="${categorias}" />
            </form:select>
            <input type="button" value="Editar" id="editar"/>
            <input type="button" value="Eliminar" id="eliminar"/>
        </div>
        </form:form>
<div class="col-md-2"></div>
<div class="col-md-8">
<table id="datatable">
    
</table>
</div>
</html>
