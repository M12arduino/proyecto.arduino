<%-- 
    Document   : objectDetail
    Created on : 20-may-2016, 17:41:42
    Author     : enric
--%>
<%@page import="m12.arduino.domain.Equipo"%>
<%@page import="m12.arduino.domain.CategoriaTrabajador"%>
<%@page import="m12.arduino.domain.Trabajador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 
           prefix="fn" %> 
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<link rel="stylesheet" href="${base}/resources/styles/detalle.css"/>
<body>
    <div class="alert alert-success"> Su Petición se ha realizado con éxito
    </div>
    <c:forEach var="i" items="${objeto.getFields()}" varStatus="status">
        <p>
            <span class="field">${i}</span>
            <span class="value">${objeto.getInfo()[status.index]}</span>
        </p>
    </c:forEach>
    <a href="${base}/${fn:toLowerCase(objeto['class'].simpleName)}/alta.htm" >Siguiente alta</a>
    <a href="${base}"> Menú principal </a>
</body>
</html>
