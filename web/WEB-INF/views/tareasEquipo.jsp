<%-- 
    Document   : tareasEquipo
    Created on : 25-may-2016, 4:35:55
    Author     : enric
--%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
    var ordenes = JSON.parse('${ordenes}');
</script>
<script type="text/javascript" src="${base}/resources/js/tareasEquipo.js"></script>
<!DOCTYPE html>

<body>
    <div class="row datatable-form">
        <div class="col-md-12">
            <p id="errorTable" class="error"> El equipo no tiene ordenes assignadas, ¡día festivo!</p>
            <table id="datatable_tareas" class="table table-bordered table-striped">
            </table>
        </div>
    </div>
    <form:form name="MyForm" action="${base}/ordenFabricacion/asignarTrabajador.htm" method="POST" id="form">
        <form:input type="hidden" path="codigo" id="codigo" value=""/>
    </form:form>
</body>
</html>
