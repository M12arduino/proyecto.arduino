<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="<%=request.getContextPath()%>" scope="session" />
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${path}/resources/libs/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${path}/resources/styles/paneles.css"/>
        <title>Arduino Central Web</title>
    </head>
    <body>
        <div class="container">
            <br /><br />
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Inicia sesion en HopeTech Industries</h3>
                    </div>
                    <div class="panel-body">
                        <form action="j_spring_security_check" method="POST" role="form" >
                            <div class="form-group">
                                <label for="username">Usuario: </label>
                                <input id="username" class="form-control" name="j_username" type="text" />
                            </div>
                            <div class="form-group">
                                <label for="password">Contraseña: </label>
                                <input id="password" class="form-control" name="j_password" type="password" />
                            </div>      
                            <br /><br />
                            <input type="submit" class="btn btn-arduino btn-block" value="Iniciar sesión"/>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
    </body>
</html>
