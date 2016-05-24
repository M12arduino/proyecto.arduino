/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var nif;
var nombre;
var movil;
var password;
var myform;

window.onload = function () {
    myform = document.forms['MyForm'];
    nif = myform['nif'];
    nombre = myform['nombre'];
    movil = myform['movil'];
    password = myform['password'];
    editar = myform['editar'];

    editar.onclick = OFValidator;
    nif.onchange = validaElem;
    nombre.onchange = validaElem;
    movil.onchange = validaElem;
    password.onchange = validaElem;
    nif.onkeyup = validaElem;
    nombre.onkeyup = validaElem;
    movil.onkeyup = validaElem;
    password.onkeyup = validaElem;
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
        case "nif":
            return esNif(elem,getIdMsg(elem));
            break;
        case "nombre":
            return esNombre(elem,getIdMsg(elem));
            break;
        case "movil":
            return esMovil(elem,getIdMsg(elem));
            break;
        case "password":
            return esPassword(elem,getIdMsg(elem));
            break;
    }	
}

function OFValidator(){
    var error = null;
	
        if (!valida(password)){
		error = password;
	};
        if (!valida(movil)){
		error = movil;
	};
        if (!valida(nombre)){
		error = nombre;
	};
        if (!valida(nif)){
		error = nif;
	};
	
	if (error !== null){
            error.focus();	
            return false;
	}
        
        editaTrabajador();
	return true;
}

function esNif(elem, idError){
    return tractarError(validaNif(elem.value),elem,idError);	
}

function esNombre(elem, idError){
    return tractarError(validaNombre(elem.value),elem,idError);
}

function esMovil(elem, idError){
    return tractarError(validaMovil(elem.value),elem,idError);
}

function esPassword(elem, idError){
    return tractarError(validaPassword(elem.value),elem,idError);
}
/////////////////////////////////
function validaNif(nif){
    var nifRegexp = /^[0-9]{8}[A-Z]{1}$/;
    return nif.match(nifRegexp);
}

function validaNombre(nombre){
    var nombreRegexp = /^[A-Za-zñÑáÁéÉíÍóÓúÚ]{1,50}$/;
    return nombre.match(nombreRegexp);
}

function validaMovil(movil){
    var movilRegexp = /^6[0-9]{8}$/;
    return movil.match(movilRegexp);
}

function validaPassword(pass){
    var passRegexp = /^[A-Za-z0-9]{1,25}$/;
    return pass.match(passRegexp);
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
