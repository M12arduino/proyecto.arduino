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
<input type="text" placeholder="nifSearch" id="nif"/>
<input type="button" value="buscar" id="search"/>
<div id="tableResults">
    <p> Busca algun resultado </p>
    <form:form action="${base}/trabajador/actualizar.htm" method="POST" id="form">
            NIF: <form:input path="nif" id="nif"/>
            Nombre: <form:input path="nombre" id="nombre"/>
            Movil: <form:input path="movil" id="movil" />
            Password: <form:input path="password" id="password"/>
            Categoria: 
            <form:select path="categoria" id="categoria">
                <form:options items="${categorias}" />
            </form:select>
            <input type="submit" value="Send"/>
        </form:form>

</div>
</html>
