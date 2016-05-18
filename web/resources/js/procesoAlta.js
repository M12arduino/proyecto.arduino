
function añadirAccion() {
    var accion = "";
    $(".accion").find('input').each(function () {
        var elemento = this;
        accion += elemento.value + "/";
    });
    
    $(".accion").after("Pos X: <form:input name='acciones[1]' itemValue='' class='inpu'/> Pos Y: <input type='number' value=''/> Pos Z: <input type='number' value=''/> Pinza: <input type='number' value=''/><br />");
    
    $(".acciones").append(accion + "<br />");

}