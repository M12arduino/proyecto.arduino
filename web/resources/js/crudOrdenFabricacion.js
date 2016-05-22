/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var table = null;

    function gestionaResultadoAjax(response) {
        alert(response);
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
            prepareCrudOrdenFabricacion();
        } else {
            if(table)table.destroy();
            $("#datatable").html("");
            $("#errorTable").show();
        }
    }
    
    function refrescaTabla(){
        var data = {};
        data.codigo = $("#codigoSearchVal").val();
        data.descripcion = $("#descripcionSearchVal").val();
        data.prioridad = $("#prioridadSearchVal").val();
        data.codigo_proceso = $("#codigo_procesoSearchVal").val();
        data.cantidad = $("#cantidadSearchVal").val();
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
            }
        });
    }
    
    $("#search").on("click", refrescaTabla);
    
    $("#editar").on("click", function () {
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
            success: function(response){
                alert(response);
                refrescaTabla();
            }
        });
    });

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
                success: function(response){
                    alert(response);
                    refrescaTabla();
                    cleanCrudOrdenFabricacion();
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
        $("#codigo_proceso").val($(this).find("td:nth-child(5)").html());
        $("#cantidad").val($(this).find("td:nth-child(6)").html());
        $("#id_robot").val($(this).find("td:nth-child(7)").html());

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
