/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function () {
    var table = null;
//    $("#search").on("click", function () {
//        var data = {};
//        data.nif = $("#nifSearchVal").val();
//        data.nombre = $("#nombreSearchVal").val();
//        data.categoria = $("#categoriaSearchVal").val();
//        var jsonStr = JSON.stringify(data);
//        $.ajax({
//            url: getBasePath() + "trabajador/buscar.htm",
//            type: "POST",
//            data: jsonStr,
//            contentType: "application/json; charset=utf-8",
//            async: false,
//            cache: false,
//            processData: false,
//            success: gestionaResultadoAjax,
//            error: function (xhr) {
//                var err = eval("(" + xhr.responseText + ")");
//                alert(err.Message + "error");
//
//            }
//        });
//    });

    function gestionaResultadoAjax(response) {
        var array = JSON.parse(response);
        if (array !== "") {
            $("#errorTable").hide();
            var titles = dataTablesDevuelveProps(array);
            var dataSet = dataTablesDevuelveValues(array);

            table = $("#datatable").DataTable({
                data: dataSet,
                columns: titles,
                destroy: true
            });
            prepareCrudTrabajador();
        } else {
            if(table)table.destroy();
            $("#datatable").html("");
            $("#errorTable").show();
        }
    }
    
    function refrescaTabla(){
        var data = {};
        data.nif = $("#nifSearchVal").val();
        data.nombre = $("#nombreSearchVal").val();
        data.categoria = $("#categoriaSearchVal").val();
        var jsonStr = JSON.stringify(data);
        $.ajax({
            url: getBasePath() + "trabajador/buscar.htm",
            type: "POST",
            data: jsonStr,
            contentType: "application/json; charset=utf-8",
            async: false,
            cache: false,
            processData: false,
            success: gestionaResultadoAjax,
            error: function (xhr) {
                var err = eval("(" + xhr.responseText + ")");
                alert(err.Message + "error");
            }
        });
    }
    
    $("#search").on("click", refrescaTabla);
    
    $("#editar").on("click", function () {
        var data = {};
        data.id_trab = $("#id_trab").val();
        data.nif = $("#nif").val();
        data.nombre = $("#nombre").val();
        data.movil = $("#movil").val();
        data.password = $("#password").val();
        data.categoria = $("#categoria").val();
        var jsonStr = JSON.stringify(data);
        $.ajax({
            url: getBasePath() + "trabajador/actualizar.htm",
            type: "POST",
            data: jsonStr,
            contentType: "application/json; charset=utf-8",
            async: false,
            cache: false,
            processData: false,
            success: function(response){
                alert(response);
                refrescaTabla();
            }
        });
    });

    $("#eliminar").on("click", function () {
        if (confirm("¿Estás seguro que deseas eliminar este usuario?")) {
            var data = {};
            data.id_trab = $("#id_trab").val();
            data.nif = $("#nif").val();
            data.nombre = $("#nombre").val();
            data.movil = $("#movil").val();
            data.password = $("#password").val();
            data.categoria = $("#categoria").val();
            var jsonStr = JSON.stringify(data);
            $.ajax({
                url: getBasePath() + "trabajador/eliminar.htm",
                type: "POST",
                data: jsonStr,
                contentType: "application/json; charset=utf-8",
                async: false,
                cache: false,
                processData: false,
                success: function(response){
                    alert(response);
                    refrescaTabla();
                    cleanCrudTrabajador();
                }
            }); 
        }
    });
});

function prepareCrudTrabajador() {
    $("#datatable tr").not(":first").on("click", function () {
        $(".form_edit").show();
        $("#id_trab").val($(this).find("td:nth-child(1)").html());
        $("#nif").val($(this).find("td:nth-child(2)").html());
        $("#nombre").val($(this).find("td:nth-child(3)").html());
        $("#movil").val($(this).find("td:nth-child(4)").html());
        $("#password").val($(this).find("td:nth-child(5)").html());
        $("#categoria").val($(this).find("td:nth-child(6)").html());

    });
}

function cleanCrudTrabajador() {
    $("#id_trab").val(null);
    $("#nif").val(null);
    $("#nombre").val(null);
    $("#movil").val(null);
    $("#password").val(null);
    $("#categoria").val(null);
}




