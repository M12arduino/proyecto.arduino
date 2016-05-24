/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function () {
    var table;
    /*$("#search").on("click", function () {
     var data = {};
     data.id_robot = $("#id_robotSearchVal").val();
     data.nombre = $("#nombreSearchVal").val();
     data.lugar = $("#lugarSearchVal").val();
     data.estado = $("#estadoSearchVal").val();
     var jsonStr = JSON.stringify(data);
     $.ajax({
     url: getBasePath() + "robot/buscarRobot.htm",
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
     })*/

    $("#search").on("click", refrescaTabla);

    //$("#editar").on("click", function () {

    $("#eliminar").on("click", function () {
        if (confirm("¿Estás seguro que deseas eliminar este robot?")) {
            var data = {};
            data.id = $("#id").val();
            data.id_robot = $("#id_robot").val();
            data.nombre = $("#nombre").val();
            data.lugar = $("#lugar").val();
            data.estado = $("#estado").val();
            data.coorX = $("#coorX").val();
            data.coorY = $("#coorY").val();
            var jsonStr = JSON.stringify(data);
            $.ajax({
                url: getBasePath() + "robot/eliminar.htm",
                type: "POST",
                data: jsonStr,
                contentType: "application/json; charset=utf-8",
                cache: false,
                processData: false,
                success: function (response) {
                    refrescaTabla();
                    cleanCrudRobot();
                    $("#results").html(response);
                    $(".edit_box .waiting_wrapper").hide();
                },
                beforeSend: function () {
                    $(".edit_box .waiting_wrapper").show();
                },
            });
        }
    });
});

function editaRobot(){
    var data = {};
    data.id = $("#id").val();
    data.id_robot = $("#id_robot").val();
    data.nombre = $("#nombre").val();
    data.lugar = $("#lugar").val();
    data.estado = $("#estado").val();
    data.coorX = $("#coorX").val();
    data.coorY = $("#coorY").val();
    var jsonStr = JSON.stringify(data);
    $.ajax({
        url: getBasePath() + "robot/actualizar.htm",
        type: "POST",
        data: jsonStr,
        contentType: "application/json; charset=utf-8",
        cache: false,
        processData: false,
        success: function (response) {
            refrescaTabla();
            $("#results").html(response);
            $(".edit_box .waiting_wrapper").hide();
        },
        beforeSend: function () {
            $(".edit_box .waiting_wrapper").show();
        },
    });
}

function gestionaResultadoAjax(response) {
    $("#results").html("Haz click sobre un resultado de la lista para administrarlo");
    $(".datatable-form .waiting_wrapper").hide();
    var array = JSON.parse(response);
    if (array.length > 0) {
        $("#errorTable").hide();
        var titles = dataTablesDevuelveProps(array);
        var dataSet = dataTablesDevuelveValues(array);

        table = $("#datatable").DataTable({
            data: dataSet,
            columns: titles,
            destroy: true
        });
        prepareCrudRobot();
    } else {
        if (table)
            table.destroy();
        $("#datatable").html("");
        $("#errorTable").show();
    }
}

function refrescaTabla() {
    var data = {};
    data.id_robot = $("#id_robotSearchVal").val();
    data.nombre = $("#nombreSearchVal").val();
    data.lugar = $("#lugarSearchVal").val();
    data.estado = $("#estadoSearchVal").val();
    var jsonStr = JSON.stringify(data);
    $.ajax({
        url: getBasePath() + "robot/buscarRobot.htm",
        type: "POST",
        data: jsonStr,
        contentType: "application/json; charset=utf-8",
        cache: false,
        processData: false,
        success: gestionaResultadoAjax,
        error: function (xhr) {
            var err = eval("(" + xhr.responseText + ")");
            alert(err.Message + "error");

        },
        beforeSend: function () {
            $(".datatable-form .waiting_wrapper").show();
        },
    });
}

function prepareCrudRobot() {
    $("#datatable tr").not(":first").on("click", function () {
        $(".form_edit").show();
        $("#id").val($(this).find("td:nth-child(1)").html());
        $("#id_robot").val($(this).find("td:nth-child(2)").html());
        $("#nombre").val($(this).find("td:nth-child(3)").html());
        $("#lugar").val($(this).find("td:nth-child(4)").html());
        $("#estado").val($(this).find("td:nth-child(5)").html());
        $("#coorX").val($(this).find("td:nth-child(6)").html());
        $("#coorY").val($(this).find("td:nth-child(7)").html());
        $("#results").hide();
    });
}

function cleanCrudRobot() {
    $("#id").val(null);
    $("#id_robot").val(null);
    $("#nombre").val(null);
    $("#lugar").val(null);
    $("#estado").val(null);
    $("#coorX").val(null);
    $("#coorY").val(null);
}
