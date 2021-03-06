/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function prepareForm(selector, url) {
    var action = $(selector).attr("action")
    $(selector).attr("action", action + "/" + url)
}

function getBasePath() {
    var str = window.location.pathname;
    return "/" + str.split("/")[1] + "/";

}

function dataTablesDevuelveValues(array) {
    var res = [];
    var result;
    var aux;
    var arrayaux = [];
    for (var i = 0; i < array.length; i++) {
        aux = array[i];
        arrayaux = [];
        for (var prop in aux) {
            if (typeof aux[prop] == "object") {
                if (aux[prop] == null) {
                    result = "No definido";
                } else {
                    result = returnFirstProperty(aux[prop]);
                }
            } else {
                result = aux[prop];
            }
            arrayaux.push(result);
        }
        res.push(arrayaux);
    }
    return res;
}

function returnFirstProperty(obj) {
    if (typeof obj[Object.keys(obj)[0]] == "object") {
        return obj.length;
    } else {
        return obj[Object.keys(obj)[0]];
    }
}
function dataTablesDevuelveProps(array) {
    var res = [];
    var aux = array[0];
    for (var prop in aux) {
        var obj = {title: prop};
        res.push(obj);
    }
    return res;
}

function dataTablesDevuelveValuesBoton(array) {
    var res = [];
    var result;
    var aux;
    var arrayaux = [];
    for (var i = 0; i < array.length; i++) {
        aux = array[i];
        arrayaux = [];
        for (var prop in aux) {
            if (typeof aux[prop] == "object") {
                if (aux[prop] == null) {
                    result = "No definido";
                } else {
                    result = returnFirstProperty(aux[prop]);
                }
            } else {
                result = aux[prop];
            }
            arrayaux.push(result);
        }

        arrayaux.push('<input name="bEscoger" type="button" class="assignar btn btn-arduino" value="Escoger orden" onclick="setHiddenValue(this);"/>');
        res.push(arrayaux);
    }
    return res;
}

function dataTablesDevuelvePropsBoton(array) {
    var res = [];
    var aux = array[0];
    for (var prop in aux) {
        var obj = {title: prop};
        res.push(obj);
    }
    res.push({title: "Assignar"});
    return res;
}

function dataTablesDevuelvePropsBoton2(array) {
    var res = [];
    var aux = array[0];
    for (var prop in aux) {
        var obj = {title: prop};
        res.push(obj);
    }
    res.push({title: "Ejecutar"});
    res.push({title: "Marcar Realizada"});
    res.push({title: "Cancelar"});
    return res;
}

function dataTablesDevuelveValuesBoton2(array) {
    var res = [];
    var result;
    var aux;
    var arrayaux = [];
    for (var i = 0; i < array.length; i++) {

        aux = array[i];
        arrayaux = [];
        for (var prop in aux) {

            if (typeof aux[prop] == "object") {
                if (aux[prop] == null) {
                    result = "No definido";
                } else {
                    result = returnFirstProperty(aux[prop]);
                }
            } else {
                result = aux[prop];
            }
            arrayaux.push(result);
        }
        if (aux["estado"] === "PENDIENTE") {
            arrayaux.push('<input name="bEjecutar" type="button" class="assignar btn btn-arduino" value="Ejecutar orden" onclick="setHiddenValueE(this);"/>');
        } else {
            arrayaux.push('<input name="bEjecutar" type="button" class="assignar btn btn-arduino" value="Ejecutar orden" onclick="setHiddenValueE(this);" disabled/>');
        }
        if (aux["estado"] === "REALIZADA") {
            arrayaux.push('<input name="bEjecutar" type="button" class="assignar btn btn-arduino" value="Marcar Realizada" onclick="setHiddenValueR(this);" disabled/>');
        } else {
            arrayaux.push('<input name="bEjecutar" type="button" class="assignar btn btn-arduino" value="Marcar Realizada" onclick="setHiddenValueR(this);"/>');
        }
        if (aux["estado"] === "CANCELADA" || aux["estado"] === "REALIZADA" || aux["estado"] === "NO_REALIZADA") {
            arrayaux.push('<input name="bCancelar" type="button" class="assignar btn btn-arduino" value="Cancelar orden" onclick="setHiddenValueC(this);" disabled/>');
        } else {
            arrayaux.push('<input name="bCancelar" type="button" class="assignar btn btn-arduino" value="Cancelar orden" onclick="setHiddenValueC(this);"/>');
        }
        res.push(arrayaux);
    }
    return res;
}