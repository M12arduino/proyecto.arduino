/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var codigo;
var descripcion;
var acciones;
//var pinzas;
var mandar;
var myform;

//window.onload = function () {
//    asignaManejadores();
//};

function asignaManejadores(){
    myform = document.forms['MyForm'];
    
    codigo = myform['codigo'];
    descripcion = myform['descripcion'];
    acciones = myform['pos'];
    //pinzas = myform['pin'];
    mandar = myform['editar'];

    mandar.onclick = ProcesoValidator;
    
    codigo.onchange = validaElem;
    descripcion.onchange = validaElem;
    codigo.onkeyup = validaElem;
    descripcion.onkeyup = validaElem;
    
    
    for (var i = 0; i < acciones.length; i++) {
        acciones[i].onchange = validaElem;
        acciones[i].onkeyup = validaElem;
    }
    
//    if (pinzas.length > 1) {
//        for (var i = 0; i < pinzas.length; i++) {
//            pinzas[i].onchange = validaElem;
//            pinzas[i].onkeyup = validaElem;
//        }
//    }else{
//        pinzas.onchange = validaElem;
//        pinzas.onkeyup = validaElem;
//    }
}

function validaElem (){	
    valida (this);
}

function valida (elem){
    var camp;
    
    if (elem instanceof NodeList){
        camp = elem[0].name;
        alert(elem+":"+camp);
    }else{
        if (elem.name) {
            camp = elem.name;
         }
    }
    
    switch (camp){
        case "codigo":
            return esCodigo(elem,getIdMsg(elem));
            break;
        case "descripcion":
            return esDescripcion(elem,getIdMsg(elem));
            break;
        case "pos":
            return esPos(elem,getIdMsg(elem));
            break;
//        case "pin":
//            return esPinza(elem,getIdMsg(elem));
//            break;
    }	
}

function ProcesoValidator(){
    var error = null;
	
//        if (!valida(pinzas)){
//		error = pinzas;
//	};
        if (!valida(acciones)){
		error = acciones;
	};
        if (!valida(descripcion)){
		error = descripcion;
	};
        if (!valida(codigo)){
		error = codigo;
	};
	
	if (error !== null){
            error.focus();	
            return false;
	}
        
        editarProceso();
	return true;
}

function esCodigo(elem, idError){
    return tractarError(validaCodigo(elem.value),elem,idError);	
}

function esDescripcion(elem, idError){
    return tractarError(validaDescripcion(elem.value),elem,idError);
}

function esPos(elem, idError){
    return tractarError(validaPos(elem[0].value),elem,idError);
}

//function esPinza(elem, idError){
//    return tractarError(validaPinza(elem.value),elem,idError);
//}
/////////////////////////////////
function validaCodigo(cod){
    var codRegexp = /^[A-Z]{1}[0-9]{3}$/;
    return cod.match(codRegexp);
}

function validaDescripcion(desc){
    var descRegexp = /^[A-Za-zñÑáÁéÉíÍóÓúÚ]+\s?[A-Za-zñÑáÁéÉíÍóÓúÚ0-9\s]{0,99}$/;
    return desc.match(descRegexp);
}

function validaPos(pos){
    alert(pos);
    var posRegexp = /^[1-9]{1}[0-9]{0,3}$/;
    return pos.match(posRegexp);
}

//function validaPinza(pinza){
//    var pinzaRegexp = /^[0-1]{1}$/;
//    return pinza.match(pinzaRegexp);
//}
/////////////////////////////////////
function getIdMsg(elem){
    var ele = "";
    
    if (elem instanceof NodeList){
        ele = elem[0].getAttribute("name");
	ele += "_error";
    }else{
        ele = elem.getAttribute("name");
	ele += "_error";
    }
	
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
