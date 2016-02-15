<%-- 
    Document   : inicio
    Created on : 11-feb-2016, 14:06:07
    Author     : José E. Díaz Romero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas Hibernate 1a1</title>
        <link rel="stylesheet" href="../css/pure-min.css">
        <link rel="stylesheet" href="../css/css.css">
        <script type="text/javascript" src="../js/js.js"></script>
    </head>
    <body>
        <div id="formulario">
            <h1>Administración personas 1 a 1</h1>
            <form class="pure-form pure-form-aligned" method="post" action="../dispatcher">
                <div class="pure-control-group">
                    <label for="nif">N.I.F:</label>
                    <input type="text" id ="nif" name="nif" oninput="comprobar()" required  />
                </div>
                <div class="pure-control-group">
                    <label for="clave">Contraseña:</label>
                    <input type="password" id="clave" name="clave" oninput="comprobar()" required />
                </div>
                <br />
                <div class="pure-controls">
                    <input type="hidden" id="boton" name="boton" />
                    <input class="pure-button" type="submit" id="alta" name="alta" value="Alta" disabled="disabled" onclick="valorBoton(this.value)" />
                    <input class="pure-button" type="submit" id="enviar" name="enviar" value="Baja" disabled="disabled" onclick="valorBoton(this.value)" />
                    <input class="pure-button pure-button-primary" type="submit" id="votar" name="votar" value="Votar" disabled="disabled" onclick="valorBoton(this.value)" />
                </div>
                <div class="pure-controls">
                    <input class="pure-button" type="button" id="cerrar" name="cerrar" value="Cerrar escrutinio" onclick="cerrarEscrutinio()" />
                    <input class="pure-button pure-button-primary" type="submit" id="resultados" name="resultados" value="Resultados" disabled="disabled" onclick="valorBoton(this.value)" />
                </div>
            </form>
        </div>
    </body>
</html>

