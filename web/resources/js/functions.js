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
    return  obj[Object.keys(obj)[0]]
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