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
        if (array.length > 0) {
            $("#errorTable").hide();
            var titles = dataTablesDevuelveProps(array);
            var dataSet = dataTablesDevuelveValues(array);

            table = $("#datatable").DataTable({
                data: dataSet,
                columns: titles,
                destroy: true
            });
            prepareCrud();
        } else {
            if (table)
                table.destroy();
            $("#datatable").html("");
            $("#errorTable").show();
        }
    }
    $("#guardaModal").on("click", function () {
        var str = "[";
        $("#trabajadoresModal li").each(function(){
            if($(this).find(".modalcheck").is(":checked")){
               var json = $(this).find(".hiddendata").html();
               str = str+ ","+json;
            }
        })
        str = str+"]";
        str = str.replace(",","");
        var array = JSON.parse(str);
        populateTrabajadores(array);
        $("#modal").modal("toggle");
    })
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
            async: false,
            cache: false,
            processData: false,
            success: gestionaResultadoAjax,
            error: function (xhr) {
                var err = eval("(" + xhr.responseText + ")");
            }
        });
    }

    $("#search").on("click", refrescaTabla);

    $("#editar").on("click", function () {
        var trabajadores = [];
        $("#trabajadores li").each(function(){
            var json = $(this).find(".hiddendata").html();
            var obj = JSON.parse(json);
            trabajadores.push(obj);
        })
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
            async: false,
            cache: false,
            processData: false,
            success: function (response) {
                alert(response);
                refrescaTabla();
            }
        });
    });
    $("#addTrabajador").on("click", function () {
        $.ajax({
            url: getBasePath() + "trabajador/trabajadores.htm",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            async: false,
            cache: false,
            processData: false,
            success: function (response) {
                var array = JSON.parse(response);
                var actual = [];
                $("#trabajadores li").each(function(){
                    actual.push($(this).find("p").html());
                })
                $("#trabajadoresModal").children().remove();
                for (var i = 0; i < array.length; i++) {
                    var json = JSON.stringify(array[i]);
                    var fullName = array[i]['id_trab'] + ' - ' + array[i]['nombre'];
                    if (actual.indexOf(fullName)== -1){
                        $("#trabajadoresModal").append('<li class="itemModal"><input type="checkbox" class="modalcheck">' + fullName + '<span class="hiddendata">' + json + '</span></li>');
                    }
                }
            },
            error: function (xhr) {
                var err = eval("(" + xhr.responseText + ")");
                console.log(err.Message + "error");
            }
        });
    })
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
                async: false,
                cache: false,
                processData: false,
                success: function (response) {
                    alert(response);
                    refrescaTabla();
                    cleanCrud();
                }
            });
        }
    });
});

function prepareCrud() {
    $("#datatable tr").not(":first").on("click", function () {
        $(".form_edit").show();
        $("#id").val($(this).find("td:nth-child(1)").html());
        $("#id_equipo").val($(this).find("td:nth-child(2)").html());
        $("#nombre").val($(this).find("td:nth-child(3)").html());
        buscaTrabajadores($(this).find("td:nth-child(2)").html());


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
        async: false,
        cache: false,
        processData: false,
        success: function (response) {
            var array = JSON.parse(response);
            $("#trabajadores").html(" ");
            populateTrabajadores(array);
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
        $("#trabajadores li").each(function(){
            var str =$(this).find("p").html();
            if (str == fullName) check = false;
        });
        if (check)$("#trabajadores").append('<li><span class="hiddendata" >' + JSON.stringify(array[i]) + '</span><p>'+fullName  + '</p><span class="glyphicon glyphicon-remove-sign deletebutton"></span></li>');
        $(".deletebutton").on("click",function(){
        if (confirm("¿Eliminar este usuario del equipo?"))$(this).parent().remove();
    })
    }
}
function cleanCrudT() {
    $("#id_equipo").val(null);
    $("#nif").val(null);
    $("#nombre").val(null);
    $("#movil").val(null);
    $("#password").val(null);
    $("#categoria").val(null);
}
