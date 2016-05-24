/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    var table;

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
            beforeSend: function(){
                $(".datatable-form .waiting_wrapper").hide();
            }
        });
    }

    $("#search").on("click", refrescaTabla);

    $("#editar").on("click", function () {
        var data = {};
        data.id = $("#id").val();
        data.codigo = $("#codigo").val();
        data.descripcion = $("#descripcion").val();
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
                $(".edit_box .waiting_wrapper").hide();
            },
            beforeSend: function () {
                $(".edit_box .waiting_wrapper").show();
            },
        });
    });

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
                    alert(response);
                    refrescaTabla();
                    cleanCrudProceso();
                    $(".edit_box .waiting_wrapper").hide();
                },
                beforeSend: function () {
                    $(".edit_box .waiting_wrapper").show();
                },
            });
        }
    });
});

function prepareCrudProceso() {
    $("#datatable tr").not(":first").on("click", function () {
        $(".form_edit").show();
        $("#id").val($(this).find("td:nth-child(1)").html());
        $("#codigo").val($(this).find("td:nth-child(2)").html());
        $("#descripcion").val($(this).find("td:nth-child(3)").html());
        $("#results").hide();
    });
}

function cleanCrudProceso() {
    $("#id").val(null);
    $("#codigo").val(null);
    $("#descripcion").val(null);
}
