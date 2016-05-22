<%-- 
    Document   : formTrabajadorAlta
    Created on : 12-may-2016, 17:19:44
    Author     : Jordi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
    <div class="container">
        <br /><br />
        <div class="col-md-3"></div>
        <div class="col-md-6">
        <form:form action="${base}/trabajador/insertar.htm" method="POST" role="form" >
            <div class="form-group">
                <label for="nifTrabajador">NIF: </label>
                <form:input path="nif" class="form-control" id="nifTrabajador"/>
            </div>
            <div class="form-group">
                <label for="nombreTrabajador">Nombre: </label>
                <form:input path="nombre" class="form-control" id="nombreTrabajador" />
            </div>
            <div class="form-group">
                <label for="movilTrabajador">Movil: </label>
                <form:input path="movil" class="form-control" id="movilTrabajador" />
            </div>
            <div class="form-group">
                <label for="passTrabajador">Password: </label>
                <form:input path="password" class="form-control" id="passTrabajador" />
            </div>
            <div class="dropdown">
                <label for="categoriaTrabajador">Categoria: </label>
                <form:select class="form-control" path="categoria">      
                    <form:options items="${categorias}" id="categoriaTrabajador" />
                </form:select>
            </div>
            <br /><br />
            <input type="submit" class="btn btn-default btn-block" value="Send"/>
        </form:form>
    </div>
    <div class="col-md-3"></div>
</div>
</body>
</html>