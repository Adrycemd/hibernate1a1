<%-- 
    Document   : inicio
    Created on : 15-feb-2016, 14:06:07
    Author     : Sara Amoraga
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
            <form class="pure-form" method="post" action="../dispatcher">
                <div class="pure-controls">
                    <input type="hidden" id="boton" name="boton" />
                    <input class="pure-button pure-button-primary" type="submit" id="alta" name="alta" value="Alta" onclick="valorBoton(this.value)" />
                    <input class="pure-button pure-button-primary" type="submit" id="baja" name="baja" value="Baja" onclick="valorBoton(this.value)" />
                    <input class="pure-button pure-button-primary" type="submit" id="modificar" name="modificar" value="Modificar" onclick="valorBoton(this.value)" />
                    <input class="pure-button pure-button-primary" type="submit" id="eliminar" name="eliminar" value="Eliminar" onclick="valorBoton(this.value)" />
                </div>
            </form>
        </div>
    </body>
</html>