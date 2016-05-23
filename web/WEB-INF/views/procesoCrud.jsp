<%-- 
    Document   : procesoCrud
    Created on : 21-may-2016, 19:33:25
    Author     : OscarMorenoGonzalez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<div class="tableResults">
    <form:form action="${base}/proceso" method="POST" id="form">
        <div class="form_search">
            <input type="text" placeholder="id_proceso" id="id_procesoSearchVal"/>
            <input type="text" placeholder="codigo" id="codigoSearchVal"/>
            <input type="text" placeholder="descripcion" id="descripcionSearchVal"/>
            <input type="button" value="buscar" id="search"/>
            <p id="results"> Busca un Proceso </p>
        </div>
        <div class="form_edit">
            <form:input path="id" type="hidden" id="id"/>
            Código de proceso: <form:input path="codigo"/>
            Descripción: <form:input path="descripcion" />
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
</div>
</body>
</html>
