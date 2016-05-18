/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    $("#search").on("click", function () {
        $.ajax({
            url: getBasePath() + "trabajador/buscar.htm",
            success: function (response) {
                var array = JSON.parse(response);
                var titles = dataTablesDevuelveProps(array);
                var dataSet = dataTablesDevuelveValues(array);
                $("#datatable").DataTable({
                    data: dataSet,
                    columns: titles
                });
                prepareCrudTrabajador();
            },
            error: function (xhr) {
                var err = eval("(" + xhr.responseText + ")");
                alert(err.Message);

            }
        });
    })
    $("#editar").on("click", function () {
        prepareForm("#form", "actualizar.htm")
        $("#form").submit();
    })

    $("#eliminar").on("click", function () {
        prepareForm("#form", "eliminar.htm");
        $("#form").submit();
    })
})

 function prepareCrudTrabajador() {
        $("#datatable tr").not(":first").on("click", function () {
            $(".form_edit").show();
            $("#id_trab").val($(this).find("td:nth-child(1)").html());
            $("#nif").val($(this).find("td:nth-child(2)").html());
            $("#nombre").val($(this).find("td:nth-child(3)").html());
            $("#movil").val($(this).find("td:nth-child(4)").html());
            $("#password").val($(this).find("td:nth-child(5)").html());
            $("#categoria").val($(this).find("td:nth-child(6)").html());

        })
//          


    }




