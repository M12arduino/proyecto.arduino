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
<input type="text" placeholder="nif" id="nifSearchVal"/>
<input type="button" value="buscar" id="nifSearch"/>
<div id="tableResults">
    <p> Busca algun resultado </p>
    <form:form action="${base}/trabajador" method="POST" id="form">
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
        </form:form>

</div>
</html>
