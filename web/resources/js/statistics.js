/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = initJS;
function initJS() {
    document.getElementById("datatable_block").style.display = "none";
    document.getElementById("chartContainerA").style.display = "none";
    var chart1 = new CanvasJS.Chart("chartContainer1", {
        theme: "theme1", //theme1
        title: {
            text: "Estado de los Robots"
        },
        animationEnabled: true, // change to true
        data: [
            {
                type: "column",
                dataPoints: chart1Statistics
            }
        ]
    });
    var chart2 = new CanvasJS.Chart("chartContainer2", {
        theme: "theme1", //theme1
        title: {
            text: "Histórico de ordenes realizadas"
        },
        animationEnabled: true, // change to true
        data: [
            {
                indexLabelFontSize: 20,
                indexLabelFontFamily: "Garamond",
                indexLabelFontColor: "darkgrey",
                indexLabelLineColor: "darkgrey",
                indexLabelPlacement: "outside",
                type: "doughnut",
                showInLegend: true,
                dataPoints: chart2Statistics
            }
        ]
    });
    chart1.render();
    chart2.render();
}
function searchStatistics() {
    document.getElementById("datatable_block").style.display = "block";
    document.getElementById("chartContainerA").style.display = "block";
    var dropMesA = document.getElementById("dropMesA").value;
    var dropMesB = document.getElementById("dropMesB").value;
    var dropAnoA = document.getElementById("dropAnoA").value;
    var dropAnoB = document.getElementById("dropAnoB").value;
    if (dropMesA !== "blank") {
        if (dropMesB !== "blank") {
            if (dropMesA < dropMesB) {
                mA = dropMesA;
                mB = dropMesB;
            } else {
                mB = dropMesA;
                mA = dropMesB;
            }
        } else {
            mA = dropMesA;
            mB = dropMesA;
        }
    } else {
        if (dropMesB !== "blank") {
            mA = dropMesB;
            mB = dropMesB;
        } else {
            mA = 0;
            mB = 11;
        }
    }

    if (dropAnoA !== "blank") {
        if (dropAnoB !== "blank") {
            if (dropAnoA < dropAnoB) {
                aA = dropAnoA;
                aB = dropAnoB;
            } else {
                aB = dropAnoA;
                aA = dropAnoB;
            }
        } else {
            aA = dropAnoA;
            aB = dropAnoA;
        }
    } else {
        if (dropAnoB !== "blank") {
            aA = dropAnoB;
            aB = dropAnoB;
        } else {
            aA = 0;
            aB = 3000;
        }
    }

    $.ajax({
        type: "POST",
        async: false,
        url: "/A_Spring_Inicial/stats/ajaxDiagramaA.htm",
        data: {
            'mesA': mA,
            'mesB': mB,
            'anoA': aA,
            'anoB': aB
        },
        success: function (mydata) {
            var proba = JSON.parse("[" + mydata + "]");
            var chart3 = new CanvasJS.Chart("chartContainerA", {
                theme: "theme1", //theme1
                title: {
                    text: "Ordenes segun periodo"
                },
                animationEnabled: true, // change to true
                data: [
                    {
                        type: "column",
                        dataPoints: proba
                    }
                ]
            });
            $("#chartContainer3").fadeIn("slow");
            chart3.render();
        }
    });
    $.ajax({
        type: "POST",
        url: "/A_Spring_Inicial/stats/ajaxListA.htm",
        data: {
            'mesA': mA,
            'mesB': mB,
            'anoA': aA,
            'anoB': aB
        },
        success: function (mydata) {
            var array = JSON.parse(mydata);
            var titles = dataTablesDevuelveProps(array);
            var dataSet = dataTablesDevuelveValues(array);
            var dataTable = $("#datatable_block").DataTable({
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
        }
    });


}