/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var table;

$(document).ready(function () {
    alert(ordenes);
    rellenaDataTable(ordenes);
})

function rellenaDataTable(array) {
    if (array.length > 0) {;
        var titles = dataTablesDevuelvePropsBoton(array);
        var dataSet = dataTablesDevuelveValuesBoton(array);

        table = $("#datatable_tareas").DataTable({
            data: dataSet,
            columns: titles,
            destroy: true
        });
    } 
}
