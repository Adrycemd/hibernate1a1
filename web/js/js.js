function cerrarEscrutinio() {
    document.getElementById("cerrar").disabled = true;
    document.getElementById("resultados").disabled = false;
    document.getElementById("alta").disabled = true;
    document.getElementById("enviar").disabled = true;
    document.getElementById("votar").disabled = true;
    document.getElementById("nif").disabled = true;
    document.getElementById("nif").required = false;
    document.getElementById("clave").disabled = true;
    document.getElementById("clave").required = false;
}

function comprobar() {
    if (document.getElementById("nif").value != "" && document.getElementById("clave").value != "") {
        document.getElementById("alta").disabled = false;
        document.getElementById("enviar").disabled = false;
        document.getElementById("votar").disabled = false;
    } else {
        document.getElementById("alta").disabled = true;
        document.getElementById("enviar").disabled = true;
        document.getElementById("votar").disabled = true;
    }
}

function valorBoton(valor) {
    document.getElementById("boton").value = valor;
}