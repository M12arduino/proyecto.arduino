
function añadirAccion(){
    var accion="";
    $(".accion").find('input').each(function() {
         var elemento= this;
         accion += elemento.value + "/";
    });
    alert($(".inpu").attr("name"));
    $(".acciones").append(accion + "<br />");
}