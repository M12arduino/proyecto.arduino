/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    
   $("#nifSearch").on("click",function () {
        $.ajax({
            url: getBasePath()+"trabajador/buscar.htm",
            data:"nif="+$("#nifSearchVal").val(),
            success: function(response) {
                var obj = JSON.parse(response);
                $("#nombre").val(obj["nombre"]);
                $("#movil").val(obj["movil"]);
                $("#nif").val(obj["nif"]);
                $("#password").val(obj["password"]);
                $("#categoria").val(obj["categoria"]);
                $("#id_trab").val(obj["id_trab"]);
                $("#form").show();
                $("#tableResults").find("p").hide();
            },
            error: function (xhr) {
                var err = eval("(" + xhr.responseText + ")");
                alert(err.Message);
            }
        });
    })
    
    $("#editar").on("click",function(){
        prepareForm("#form","actualizar.htm")
        $("#form").submit();
    })
    
    $("#eliminar").on("click",function(){
        prepareForm("#form","eliminar.htm");
        $("#form").submit();
    })
})
    

    
  

