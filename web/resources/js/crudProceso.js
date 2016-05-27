/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var actions = null;
$(document).ready(function () {

    var table;
    $("#accionesButton").on("click", añadirAccion);

    $("#search").on("click", refrescaTabla);

    //$("#editar").on("click", editarProceso);

    $("#eliminar").on("click", function () {
        if (confirm("¿Estás seguro que deseas eliminar este proceso?")) {
            var data = {};
            data.id = $("#id").val();
            data.codigo = $("#codigo").val();
            data.descripcion = $("#descripcion").val();
            var jsonStr = JSON.stringify(data);
            $.ajax({
                url: getBasePath() + "proceso/eliminar.htm",
                type: "POST",
                data: jsonStr,
                contentType: "application/json; charset=utf-8",
                cache: false,
                processData: false,
                success: function (response) {
                    var str = response;
                    refrescaTabla();
                    cleanCrudProceso();
                    $("#results_info").html(str);
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
        actions = array;
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
            prepareCrudProceso();
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
        var jsonStr = JSON.stringify(data);
        $.ajax({
            url: getBasePath() + "proceso/buscarProceso.htm",
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
                $(".datatable-form .waiting_wrapper").hide();
            }
        });
    }

function prepareCrudProceso() {
    $("#datatable tr").not(":first").on("click", function () {
        var auxactions;
        $(".form_edit").show();
        $("#id").val($(this).find("td:nth-child(1)").html());
        $("#codigo").val($(this).find("td:nth-child(2)").html());
        $("#descripcion").val($(this).find("td:nth-child(3)").html());
        $("#results").hide();
        var id = $(this).find("td:nth-child(1)").html();
        for (var i = 0; i < actions.length; i++) {
            if (actions[i].id == id) {
                auxactions = actions[i].acciones;
            }
        }
        $("#acciones_wrapper").children(".accion").remove();
        añadirAccionesPre(auxactions);
    });
}

function añadirAccionesPre(arrayAcciones) {
    for (var i = 0; i < arrayAcciones.length; i++) {
        var ab = "";
        var ce = "";
        if (arrayAcciones[i].abrirPinza === true)
            ab = "selected";
        else
            ce = "selected";
        str = "<div class='accion'><div class='col-md-3'>Pos X: <input name='pos' type='number' class='form-control posX' value='" + arrayAcciones[i].posX + "'/></div>";
        str += "<div class='col-md-3'>Pos Y: <input name='pos' type='number' class='form-control posY' value='" + arrayAcciones[i].posY + "'/></div>";
        str += "<div class='col-md-3'>Pos Z: <input name='pos' type='number' class='form-control posZ' value='" + arrayAcciones[i].posZ + "'/></div>";
        str += "<div class='col-md-3'>Pinza: <select class='form-control abP'>\n\
        <option value='1' " + ab + ">Abierta</option><option value='0' " + ce + ">Cerrada</option></select></div>";
        str += "</div>";
        $("#pos_error").before(str);
        asignaManejadores();
    }
}

function añadirAccion() {
    var newInput = "<div class='accion'>";
    newInput += "<div class='col-md-3'>Pos X: <input name='pos' type='number' class='form-control posX' /></div>";
    newInput += "<div class='col-md-3'>Pos Y: <input name='pos' type='number' class='form-control posY' /></div>";
    newInput += "<div class='col-md-3'>Pos Z: <input name='pos' type='number' class='form-control posZ' /></div>";
    newInput += "<div class='col-md-3'>Pinza:<select class='form-control abP'>\n\
        <option value='1' >Abierta</option><option value='0' selected>Cerrada</option></select></div>";

    $("#pos_error").before(newInput);
    
    asignaManejadores();
}

function recuperaAcciones() {
    var arrayObj = [];
    var obj;
    $(".accion").each(function () {
        obj = {};
        var x = $(this).find(".posX").val();
        var y = $(this).find(".posY").val();
        var z = $(this).find(".posZ").val();
        var ab = $(this).find(".abP").val();
        obj.posX = x;
        obj.posY = y;
        obj.posZ = z;
        obj.abrirPinza = ab;
        arrayObj.push(obj);
    });
    return arrayObj;
}

function cleanCrudProceso() {
    $("#id").val(null);
    $("#codigo").val(null);
    $("#descripcion").val(null);
}

function editarProceso() {
    var data = {};
    data.codigo = $("#codigo").val();
    data.descripcion = $("#descripcion").val();
    data.acciones = recuperaAcciones();
    var jsonStr = JSON.stringify(data);
    $.ajax({
        url: getBasePath() + "proceso/actualizar.htm",
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
