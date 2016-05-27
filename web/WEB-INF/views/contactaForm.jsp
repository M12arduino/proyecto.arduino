<%-- 
    Document   : contactaForm
    Created on : 27-may-2016, 3:01:29
    Author     : couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<%
    String userloginName = "Admin";
    String userloginNif = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
    m12.arduino.service.ServiceTrabajador sT = new m12.arduino.service.ServiceTrabajador();
    userloginName = sT.buscarTrabajador(userloginNif).getNombre();
%>
<c:set var="userLoggedName" value="<%=userloginName%>"></c:set>
<c:set var="userLoggedNif" value="<%=userloginNif%>"></c:set>
    <div class="container">
        <br /><br />
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Contacta con el administrador</h3>
                </div>
                <div class="panel-body">
                <form:form name="MyForm" action="${base}/contacta/enviarCorreo.htm" method="POST" role="form" >
                    <div class="form-group">
                        <label>Nombre: </label>
                        <input name="nombre" class="form-control" type="text" disabled value="${userLoggedName}" /> 
                        <form:input name="nombre" path="nombre" type="hidden" value="${userLoggedName}" /> 
                    </div> 
                    <div class="form-group">
                        <label>Email: </label>
                        <form:input name="email" path="email" type="email" class="form-control" placeholder="${userLoggedName}@ejemplo.com" /> 
                    </div> 
                    <div class="dropdown">
                        <label>Motivo del contacto: </label>
                        <form:select class="form-control" path="motivo">          
                            <form:options items="${motivos}" />
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label>Mensaje: </label>
                        <form:textarea name="mensaje" path="mensaje" class="form-control" cols="40" rows="6" /> 
                    </div> 
                    <input type="submit" class="btn btn-arduino btn-block" value="Enviar"/>
                </form:form>
            </div>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>
<jsp:include page="footer.jsp"></jsp:include>