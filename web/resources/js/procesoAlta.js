
function añadirAccion() {
    var num = document.getElementById("numAcciones").value;
    num++;
    document.getElementById("numAcciones").value = num;

    var newInput = "<div class='accion'>";
    newInput += "<div class='col-md-3'>Pos X: <input type='number' class='form-control' id='posX" + num + "' /></div>";
    newInput += "<div class='col-md-3'>Pos Y: <input type='number' class='form-control' id='posY" + num + "' /></div>";
    newInput += "<div class='col-md-3'>Pos Z: <input type='number' class='form-control' id='posZ" + num + "' /></div>";
    newInput += "<div class='col-md-3'>Pinza: <input type='number' class='form-control' id='pinza" + num + "' /></div>";
    newInput += "</div><br /><br /><br /><br />";

    $("#buto").before(newInput);

}

function prepare() {
    var json = "[";
    var posX;
    var posY;
    var posZ;
    var pinza;
    for (var i = 1; i <= document.getElementById("numAcciones").value; i++) {
        posX = document.getElementById("posX" + i).value;
        posY = document.getElementById("posY" + i).value;
        posZ = document.getElementById("posZ" + i).value;
        pinza = document.getElementById("pinza" + i).value;
        if (pinza === "0") {
            pinza = false;
        } else {
            pinza = true;
        }
        json += "{\"posX\": " + posX + ", \"posY\": " + posY + ", \"posZ\": " + posZ + ", \"abrirPinza\": " + pinza + "},";
    }
    json = json.substring(0,json.length-1);
    json += "]";
    document.getElementById("accionesJSON").value = json;
    document.getElementById("myForm").submit();
}