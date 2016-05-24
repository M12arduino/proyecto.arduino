/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var codigo;
var descripcion;
var cantidad;
var myform;

window.onload = function () {
    myform = document.forms['MyForm'];
    codigo = myform['codigo'];
    descripcion = myform['descripcion'];
    
    //este no coge el valor.
    cantidad = myform['cantidadOrden'];
    
    editar = myform['editar'];
    
    editar.onclick = OFValidator;
    codigo.onchange = validaElem;
    descripcion.onchange = validaElem;
    cantidad.onchange = validaElem;
    codigo.onkeyup = validaElem;
    descripcion.onkeyup = validaElem;
    //cantidad.onkeyup = validaElem;
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
        case "codigo":
            return esCodigo(elem,getIdMsg(elem));
            break;
        case "descripcion":
            return esDescripcion(elem,getIdMsg(elem));
            break;
        case "cantidad":
            return esCantidad(elem,getIdMsg(elem));
            break;
    }	
}

function OFValidator(){
    var error = null;
	if (!valida(codigo)){
		error = codigo;
	};

	if (!valida(descripcion)){
		error = descripcion;
	};
//	if (!valida(cantidad)){
//		error = cantidad;
//	};
	
	if (error !== null){
            error.focus();	
            return false;
	}
        editarOrdenFabricacion();
	return true;
}

function esCodigo(elem, idError){
    alert(elem.value);
    return tractarError(validaCodigo(elem.value),elem,idError);	
}

function esDescripcion(elem, idError){
    return tractarError(validaDescripcion(elem.value),elem,idError);
}

function esCantidad(elem, idError){
    alert(elem.value);
    return tractarError(validaCantidad(elem.value),elem,idError);
}

function validaCodigo(codigo){
    var coreRegexp = /^[A-Z]{2}[0-9]{3}$/;
    return codigo.match(coreRegexp);
}

function validaDescripcion(descripcion){
    var descRegexp = /^[\w\,ñÑáÁéÉíÍóÓúÚ\s]{1,50}$/;
    return descripcion.match(descRegexp);
}

function validaCantidad(cantidad){
    var cantRegexp = /^[0-9]{1,4}$/;
    return cantidad.match(cantRegexp);
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
