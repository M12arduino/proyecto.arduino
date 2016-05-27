<%-- 
    Document   : objectDetail
    Created on : 20-may-2016, 17:41:42
    Author     : enric
--%>
<%@page import="m12.arduino.service.ServiceTrabajador"%>
<%@page import="m12.arduino.domain.Equipo"%>
<%@page import="m12.arduino.domain.CategoriaTrabajador"%>
<%@page import="m12.arduino.domain.Trabajador"%>
<%@page import="m12.arduino.domain.Maketable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
    <div class="alert alert-success"> Su Petición se ha realizado con éxito</div>
    <div class="container">
        <br /><br />
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Datos de ${objeto.getFullName()}</h3>
            </div>
            <div class="panel-body">
                <div class="lead">${objeto.getClass().getSimpleName()}</div>
                <c:forEach var="i" items="${objeto.getFields()}" varStatus="status">

                    <div class="text-left col-md-2">${i}</div>
                    <c:choose>
                        <c:when test="'xRobotEquipoTrabajadorProcesoOrdenFabricacion'.indexOf(${i})">
                            <div class="text-right col-md-10">${objeto.getInfo()[status.index]}</div>
                        </c:when>
                        <c:otherwise>
                            <div class="text-right col-md-10">${objeto.getInfo()[status.index]}</div>
                        </c:otherwise>
                    </c:choose>
                    <br />
                </c:forEach>
                <br /><br />
            </div>
            <a class="btn btn-arduino btn-block" href="" >Generar PDF</a>
            <a class="btn btn-arduino btn-block" href="${base}/${fn:toLowerCase(objeto['class'].simpleName)}/alta.htm" >Siguiente alta</a>

        </div>
        <div class="col-md-3"></div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>