/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#search").click(function () {
        $.ajax({
            url: "http://localhost:8080/A_Spring_Inicial/trabajador/buscar.htm",
            data:"nif="+$("#nifSearch").val(),
            success: function(response) {
                var obj = JSON.parse(response);
                $("#nombre").val(obj["nombre"]);
                $("#movil").val(obj["movil"]);
                $("#nif").val(obj["nif"]);
                $("#password").val(obj["password"]);
                $("#form").show();
            },
            error: function (xhr) {
                alert("what?");
                var err = eval("(" + xhr.responseText + ")");
                alert(err.Message);
            }
        });
    })


});