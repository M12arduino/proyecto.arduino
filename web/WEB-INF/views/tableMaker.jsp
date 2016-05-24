<%-- 
    Document   : TableMaker
    Created on : 17-may-2016, 14:40:45
    Author     : Jordi
--%>

<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="m12.arduino.domain.Equipo"%>
<%@page import="m12.arduino.domain.CategoriaTrabajador"%>
<%@page import="m12.arduino.domain.Trabajador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
    <div class="container">
        <br /><br />
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Tabla ${listado.get(0).getClass().getSimpleName()}</h3>
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <c:forEach var="field" items="${listado.get(0).getFields()}">
                                    <td>${field}</td>
                                </c:forEach>
                                    <td>
                                        Detalle
                                    </td>
                            </tr>
                        </thead>
                        <tbody>     
                            <c:forEach var="object" items="${listado}">
                                <tr>
                                    <c:forEach var="item" items="${object.getInfo()}">
                                        <td>${item}</td>
                                    </c:forEach>
                                        <td>
                                            <%
                                                Object obj = new Trabajador();
                                                ModelAndView mV = new ModelAndView("detalleObjeto");
                                                mV.addObject("objeto", obj);
                                            %>
                                            <button type="button" class="btn-default btn" onclick="window.location.href='<%=mV%>'">Detalle</button>
                                        </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>
</body>
</html>

