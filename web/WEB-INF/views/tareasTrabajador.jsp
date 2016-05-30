<%-- 
    Document   : tareasTrabajador
    Created on : 26-may-2016, 13:39:50
    Author     : Jordi
--%>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navBar.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
    var ordenes = JSON.parse('${ordenes}');
</script>
<script type="text/javascript" src="${base}/resources/js/tareasTrabajador.js"></script>
<!DOCTYPE html>

<body>
    <div class="row datatable-form">
        <div class="col-md-12">
            <p id="errorTable" class="error">No tienes ordenes assignadas, ¡día festivo!</p>
            <table id="datatable_tareas" class="table table-bordered table-striped">
            </table>
        </div>
    </div>
    <form:form name="MyForm" action="${base}/ordenFabricacion/modificarEstado.htm" method="POST" id="form">
        <form:input type="hidden" path="codigo_eje" id="codigoE" value="undefined"/>
        <form:input type="hidden" path="codigo_can" id="codigoC" value="undefined"/>
        <form:input type="hidden" path="codigo_rea" id="codigoR" value="undefined"/>
    </form:form>
</body>
</html>
