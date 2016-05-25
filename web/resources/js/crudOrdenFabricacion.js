/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var table;
$(document).ready(function () {
   
    $("#search").on("click", refrescaTabla);
    
    //$("#editar").on("click", editarOrdenFabricacion);

    $("#eliminar").on("click", function () {
        if (confirm("¿Estás seguro que deseas eliminar esta orden de fabricación?")) {
            var data = {};
            data.id = $("#id").val();
            var jsonStr = JSON.stringify(data);
            $.ajax({
                url: getBasePath() + "ordenFabricacion/eliminar.htm",
                type: "POST",
                data: jsonStr,
                contentType: "application/json; charset=utf-8",
                async: false,
                cache: false,
                processData: false,
                success: function (response) {
                    refrescaTabla();
                    cleanCrudOrdenFabricacion();
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

function prepareCrudOrdenFabricacion() {
    $("#datatable tr").not(":first").on("click", function () {
        $(".form_edit").show();
        $("#id").val($(this).find("td:nth-child(1)").html());
        $("#codigo").val($(this).find("td:nth-child(2)").html());
        $("#descripcion").val($(this).find("td:nth-child(3)").html());
        $("#prioridad").val($(this).find("td:nth-child(4)").html());
        $("#codigo_proceso").val($(this).find("td:nth-child(6)").html());
        $("#cantidad").val($(this).find("td:nth-child(7)").html());
        $("#id_robot").val($(this).find("td:nth-child(8)").html());
        $("#results").hide();
    });
}

function cleanCrudOrdenFabricacion() {
    $("#id").val(null);
    $("#codigo").val(null);
    $("#descripcion").val(null);
    $("#prioridad").val(null);
    $("#codigo_proceso").val(null);
    $("#cantidad").val(null);
    $("#id_robot").val(null);
}

function editarOrdenFabricacion() {
    var data = {};
    data.id = $("#id").val();
    data.codigo = $("#codigo").val();
    data.descripcion = $("#descripcion").val();
    data.prioridad = $("#prioridad").val();
    data.codigo_proceso = $("#codigo_proceso").val();
    data.cantidad = $("#cantidad").val();
    data.id_robot = $("#id_robot").val();
    var jsonStr = JSON.stringify(data);
    $.ajax({
        url: getBasePath() + "ordenFabricacion/actualizar.htm",
        type: "POST",
        data: jsonStr,
        contentType: "application/json; charset=utf-8",
        async: false,
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

function gestionaResultadoAjax(response) {
    $("#results").html("Haz click sobre un resultado de la lista para administrarlo");
    $(".datatable-form .waiting_wrapper").hide();
    var array = JSON.parse(response);
    ;
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
        prepareCrudOrdenFabricacion();
    } else {
        if (table)
            table.destroy();
        $("#datatable").html("");
        $("#errorTable").show();
    }
}

function refrescaTabla() {
    var data = {};
    data.codigo = $("#codigoSearchVal").val();
    data.descripcion = $("#descripcionSearchVal").val();
    data.prioridad = $("#prioridadSearchVal").val();
    data.codigo_proceso = $("#codigo_procesoSearchVal").val();
    data.equipo_id = $("#equipo_idSearchVal").val();
    data.id_robot = $("#id_robotSearchVal").val();
    var jsonStr = JSON.stringify(data);
    $.ajax({
        url: getBasePath() + "ordenFabricacion/buscar.htm",
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
        },
        beforeSend: function () {
            $(".datatable-form .waiting_wrapper").show();
        }
    });
}
