/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var id_equipo;
var nombre;
var myform;

window.onload = function () {
    myform = document.forms['MyForm'];
    id_equipo = myform['id_equipo'];
    nombre = myform['nombre'];

    myform.onsubmit = EquipoValidator;
    id_equipo.onchange = validaElem;
    nombre.onchange = validaElem;
    id_equipo.onkeyup = validaElem;
    nombre.onkeyup = validaElem;
};

function validaElem (){	
    valida (this);
}

function valida (elem){
    var camp;

    if (elem.name) {
       camp = elem.name;
    }
    
    switch (camp){
        case "id_equipo":
            return esId(elem,getIdMsg(elem));
            break;
        case "nombre":
            return esNombre(elem,getIdMsg(elem));
            break;
    }	
}

function EquipoValidator(){
    var error = null;
	
        if (!valida(nombre)){
		error = nombre;
	};
        if (!valida(id_equipo)){
		error = id_equipo;
	};
	
	if (error !== null){
            error.focus();	
            return false;
	}
        
	return true;
}

function esId(elem, idError){
    return tractarError(validaId(elem.value),elem,idError);	
}

function esNombre(elem, idError){
    return tractarError(validaNombre(elem.value),elem,idError);
}
/////////////////////////////////
function validaId(id){
    var idRegexp = /^[A-Z]{2}[0-9]{4}$/;
    return id.match(idRegexp);
}

function validaNombre(nombre){
    var nombreRegexp = /^[A-Za-z]{1,10}[0-9]{0,2}$/;
    return nombre.match(nombreRegexp);
}

function getIdMsg(elem){
	var ele = elem.getAttribute("name");
	ele += "_error";
	return ele;
}

function tractarError(noError, elem, idError){
    if(noError){
        ocultaError(idError);
        return true;
    }else{
        mostraError(idError);
        //elem.focus();
        return false;
    }
}

function mostraError(idElem) {
    document.getElementById(idElem).style.display = "inline";
}

function ocultaError(idElem) {
    document.getElementById(idElem).style.display = "none";
}
