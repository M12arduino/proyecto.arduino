/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var id_robot;
var nombre;
var lugar;
var coorX;
var coorY;
var myform;
var edita;

window.onload = function () {
    myform = document.forms['MyForm'];
    id_robot = myform['id_robot'];
    nombre = myform['nombre'];
    lugar = myform['lugar'];
    coorX = myform['coorX'];
    coorY = myform['coorY'];
    edita = myform['editar']

    edita.onclick = RobotValidator;
    id_robot.onchange = validaElem;
    nombre.onchange = validaElem;
    lugar.onchange = validaElem;
    coorX.onchange = validaElem;
    coorY.onchange = validaElem;
    id_robot.onkeyup = validaElem;
    nombre.onkeyup = validaElem;
    lugar.onkeyup = validaElem;
    coorX.onkeyup = validaElem;
    coorY.onkeyup = validaElem;
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
        case "id_robot":
            return esID(elem,getIdMsg(elem));
            break;
        case "nombre":
            return esNombre(elem,getIdMsg(elem));
            break;
        case "lugar":
            return esLugar(elem,getIdMsg(elem));
            break;
        case "coorX":
            return esCoor(elem,getIdMsg(elem));
            break;
        case "coorY":
            return esCoor(elem,getIdMsg(elem));
            break;
    }	
}

function RobotValidator(){
    var error = null;
	
        if (!valida(coorY)){
		error = coorY;
	};
        if (!valida(coorX)){
		error = coorX;
	};
        if (!valida(lugar)){
		error = lugar;
	};
        if (!valida(nombre)){
		error = nombre;
	};
        if (!valida(id_robot)){
		error = id_robot;
	};
	
	if (error !== null){
            error.focus();	
            return false;
	}
        
        editaRobot();
	return true;
}

function esID(elem, idError){
    return tractarError(validaId(elem.value),elem,idError);	
}

function esNombre(elem, idError){
    return tractarError(validaNombre(elem.value),elem,idError);
}

function esLugar(elem, idError){
    return tractarError(validaLugar(elem.value),elem,idError);
}

function esCoor(elem, idError){
    return tractarError(validaCoor(elem.value),elem,idError);
}
/////////////////////////////////
function validaId(id){
    var idRegexp = /^[A-Za-z0-9]+$/;
    return id.match(idRegexp);
}

function validaNombre(nombre){
    var nombreRegexp = /^[A-Za-zñÑáÁéÉíÍóÓúÚ]+[A-Za-zñÑáÁéÉíÍóÓúÚ\s]{0,49}$/;
    return nombre.match(nombreRegexp);
}

function validaLugar(movil){
    var lugarRegexp = /^[A-Za-zñÑáÁéÉíÍóÓúÚ]+[A-Za-zñÑáÁéÉíÍóÓúÚ\s]{0,49}$/;
    return movil.match(lugarRegexp);
}

function validaCoor(pass){
    var coorRegexp = /^[0-9]{1,4}\.?[0-9]{0,2}$/;
    return pass.match(coorRegexp);
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
