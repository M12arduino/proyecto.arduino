<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
    <title>Arduino Central Web</title>
</head>
<body>
<div class="container">
    <br /><br />
    <div class="col-md-3"></div>
    <div class="col-md-6">
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
            <input type="submit" class="btn btn-default btn-block" value="Iniciar sesión"/>
        </form>
    </div>
    <div class="col-md-3"></div>
</div>
</body>
</html>
