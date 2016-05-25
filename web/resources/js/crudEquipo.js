/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    
    $("#guardaModal").on("click", function () {
        var str = "[";
        $("#trabajadoresModal li").each(function () {
            if ($(this).find(".modalcheck").is(":checked")) {
                var json = $(this).find(".hiddendata").html();
                str = str + "," + json;
            }
        });
        str = str + "]";
        str = str.replace(",", "");
        var array = JSON.parse(str);
        populateTrabajadores(array);
        $("#modal").modal("toggle");
    });

    $("#search").on("click", refrescaTabla);
    //$("#editar").on("click", function () {

    $("#addTrabajador").on("click", function () {
        $.ajax({
            url: getBasePath() + "trabajador/trabajadores.htm",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            cache: false,
            processData: false,
            success: function (response) {
                var array = JSON.parse(response);
                var actual = [];
                $("#trabajadores li").each(function () {
                    actual.push($(this).find("p").html());
                });
                $("#trabajadoresModal").children().remove();
                for (var i = 0; i < array.length; i++) {
                    var json = JSON.stringify(array[i]);
                    var fullName = array[i]['id_trab'] + ' - ' + array[i]['nombre'];
                    if (actual.indexOf(fullName) === -1) {
                        $("#trabajadoresModal").append('<li class="itemModal" onclick="checkThis(this)"><input type="checkbox" class="modalcheck">' + fullName + '<span class="hiddendata">' + json + '</span></li>');
                    }
                }
            },
            error: function (xhr) {
                var err = eval("(" + xhr.responseText + ")");
                console.log(err.Message + "error");
            }
        });

    });
    $("#eliminar").on("click", function () {
        if (confirm("¿Estás seguro que deseas eliminar este equipo?, los trabajadores que contenga quedaràn sin equipo")) {
            var data = {};
            data.id = $("#id").val();
            data.id_equipo = $("#id_equipo").val();
            data.nombre = $("#nombre").val();
            var jsonStr = JSON.stringify(data);
            $.ajax({
                url: getBasePath() + "equipo/eliminar.htm",
                type: "POST",
                data: jsonStr,
                contentType: "application/json; charset=utf-8",
                cache: false,
                processData: false,
                success: function (response) {
                    refrescaTabla();
                    $("#results_info").html(response);
                    $(".edit_box .waiting_wrapper").hide();
                    cleanCrud();
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
    var array = JSON.parse(response);
    if (array.length > 0) {
        $("#errorTable").hide();
        var titles = dataTablesDevuelveProps(array);
        var dataSet = dataTablesDevuelveValues(array);
        table = $("#datatable").DataTable({
            data: dataSet,
            columns: titles,
            destroy: true,
            language: {
                lengthMenu: "Muestra _MENU_ registros por página",
                info: "Mostrando _START_ hasta _END_ de un total de _TOTAL_ entradas",
                search: "Búsqueda",
                paginate: {
                    first: "Primero",
                    last: "Último",
                    next: "Siguiente",
                    previous: "Previo"
                }
            }
        });
        $("#datatable_wrapper").first(".row").find(".col-sm-6").addClass("col-md-6");
        prepareCrud();
    } else {
        if (table)
            table.destroy();
        $("#datatable").html("");
        $("#errorTable").show();
    }
}
var table;
function refrescaTabla() {
    var data = {};
    data.id_equipo = $("#id_equipoSearchVal").val();
    data.nombre = $("#nombreSearchVal").val();
    var jsonStr = JSON.stringify(data);
    $.ajax({
        url: getBasePath() + "equipo/buscar.htm",
        type: "POST",
        data: jsonStr,
        contentType: "application/json; charset=utf-8",
        cache: false,
        processData: false,
        success: gestionaResultadoAjax,
        error: function (xhr) {
            var err = eval("(" + xhr.responseText + ")");
        }
    });
}
function checkThis(obj,e) {
    var actual =obj.getElementsByTagName("input")[0].checked;
    if (actual){
        obj.getElementsByTagName("input")[0].checked = false;
    }else{
        obj.getElementsByTagName("input")[0].checked = true;
        obj.classname="checked_modal"
    }
}
function prepareCrud() {
    $("#datatable tr").not(":first").on("click", function () {
        $(".form_edit").show();
        $("#id").val($(this).find("td:nth-child(1)").html());
        $("#id_equipo").val($(this).find("td:nth-child(2)").html());
        $("#nombre").val($(this).find("td:nth-child(3)").html());
        buscaTrabajadores($(this).find("td:nth-child(2)").html());
        $("#results").hide();
    });
}

function buscaTrabajadores(idequipo) {
    var data = {};
    data.id_equipo = idequipo;
    var jsonStr = JSON.stringify(data);
    $.ajax({
        url: getBasePath() + "equipo/trabajadores.htm",
        type: "POST",
        data: jsonStr,
        contentType: "application/json; charset=utf-8",
        cache: false,
        processData: false,
        success: function (response) {
            var array = JSON.parse(response);
            $("#trabajadores").html(" ");
            populateTrabajadores(array);
            $(".datatable-form .waiting_wrapper").hide();
        },
        beforeSend: function () {
            $(".datatable-form .waiting_wrapper").show();
        },
        error: function (xhr) {
            var err = eval("(" + xhr.responseText + ")");
            alert(err.Message + "error");
        }
    });
}

function populateTrabajadores(array) {
    for (var i = 0; i < array.length; i++) {
        var fullName = array[i]['id_trab'] + ' - ' + array[i]['nombre'];
        var check = true;
        $("#trabajadores li").each(function () {
            var str = $(this).find("p").html();
            if (str === fullName) {
                check = false;
            }
        });
        if (check)
            $("#trabajadores").append('<li class="col-md-3 col-xs-12 col-sm-6"><span class="hiddendata" >' + JSON.stringify(array[i]) + '</span><p>' + fullName + '</p><span class="glyphicon glyphicon-remove-sign deletebutton"></span></li>');
    }

    $(".deletebutton").on("click", function () {
        if (confirm("¿Eliminar este usuario del equipo?"))
            $(this).parent().remove();
    });
}
function cleanCrudT() {
    $("#id_equipo").val(null);
    $("#nif").val(null);
    $("#nombre").val(null);
    $("#movil").val(null);
    $("#password").val(null);
    $("#categoria").val(null);
}

function editaEquipo() {
    var trabajadores = [];
    $("#trabajadores li").each(function () {
        var json = $(this).find(".hiddendata").html();
        var obj = JSON.parse(json);
        trabajadores.push(obj);
    });
    var data = {};
    data.id = $("#id").val();
    data.id_equipo = $("#id_equipo").val();
    data.nombre = $("#nombre").val();
    data.trabajadores = trabajadores;
    var jsonStr = JSON.stringify(data);
    $.ajax({
        url: getBasePath() + "equipo/actualizar.htm",
        type: "POST",
        data: jsonStr,
        contentType: "application/json; charset=utf-8",
        cache: false,
        processData: false,
        success: function (response) {
            $("#results_info").html(response);
            refrescaTabla();
        }
    });
}