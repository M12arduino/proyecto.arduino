/*
Jordi Puig Puig
DAW 2
Curs 2015-2016
*/
var table;

$(document).ready(function () {
    rellenaDataTable(ordenes);
});

function rellenaDataTable(array) {
    if (array.length > 0) {
        var titles = dataTablesDevuelvePropsBoton2(array);
        var dataSet = dataTablesDevuelveValuesBoton2(array);

        table = $("#datatable_tareas").DataTable({
            data: dataSet,
            columns: titles,
            destroy: true
        });
    } else {
        document.getElementById("errorTable").style.display = "inline";
    }    
}

function setHiddenValueE(elem) {
    var codigo = elem.parentNode.parentNode.firstChild.innerHTML;
    document.getElementById("codigoE").value = codigo;
    document.getElementById("form").submit();
}
function setHiddenValueC(elem) {
    var codigo = elem.parentNode.parentNode.firstChild.innerHTML;
    document.getElementById("codigoC").value = codigo;
    document.getElementById("form").submit();
}