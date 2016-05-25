/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var table;
$(document).ready(function () {


    $("#search").on("click", refrescaTabla);
    //$("#editar").on("click", function () {

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
                cache: false,
                processData: false,
                success: function (response) {
                    refrescaTabla();
                    cleanCrudTrabajador();
                    $("#results_info").html(response);
                    $(".edit_box .waiting_wrapper").hide();
                },
                beforeSend: function () {
                    $(".edit_box .waiting_wrapper").show();
                }
            });
        }
    });
});

function gestionaResultadoAjax(response) {
    $("#results").html("Haz click sobre un resultado de la lista para administrarlo");
    $(".datatable-form .waiting_wrapper").hide();
    var array = JSON.parse(response);
    if (array.length > 0) {
        $("#errorTable").hide();
        var titles = dataTablesDevuelveProps(array);
        var dataSet = dataTablesDevuelveValues(array);
        table = $("#datatable_block").DataTable({
            data: dataSet,
            columns: titles,
            destroy: true
        });
        prepareCrudTrabajador();
    } else {
        if (table)
            table.destroy();
        $("#datatable_block").html("");
        $("#errorTable").show();
    }
}

function prepareCrudTrabajador() {
    $("#datatable_block tr").not(":first").on("click", function () {
        $(".form_edit").show();
        $("#id_trab").val($(this).find("td:nth-child(1)").html());
        $("#nif").val($(this).find("td:nth-child(2)").html());
        $("#nombre").val($(this).find("td:nth-child(3)").html());
        $("#movil").val($(this).find("td:nth-child(4)").html());
        $("#password").val($(this).find("td:nth-child(5)").html());
        $("#categoria").val($(this).find("td:nth-child(6)").html());
        $("#results").hide();
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
    
function editaTrabajador(){
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
        cache: false,
        processData: false,
        success: function (response) {
            refrescaTabla();
            $("#results_info").html(response);
            $(".edit_box .waiting_wrapper").hide();
        },
        beforeSend: function () {
            $(".edit_box .waiting_wrapper").show();
        }
    });
}

function refrescaTabla() {
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
        cache: false,
        processData: false,
        success: gestionaResultadoAjax,
        error: function (xhr) {
            var err = eval("(" + xhr.responseText + ")");
            alert(err.Message + "error");
        }, 
        beforeSend: function () {
            $(".datatable-form .waiting_wrapper").show();
        }
    });
}
