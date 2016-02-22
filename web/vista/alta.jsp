<%-- 
    Document   : alta
    Created on : 15-feb-2016, 13:17:57
    Author     : Sara Aamoraga
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
            <h1>Dar de alta a Persona</h1>
            <form class="pure-form pure-form-aligned" method="post" action="../dispatcher">
                <fieldset>
                    <legend>Datos de la Persona</legend>
                    <div class="pure-control-group">
                        <label for="dni">DNI</label>
                        <input id="dni" name="dni" type="text" maxlength="9" />
                    </div>
                    <div class="pure-control-group">
                        <label for="nombre">Nombre</label>
                        <input id="nombre" name="nombre" type="text" />
                    </div>
                    <div class="pure-control-group">
                        <label for="apellidos">Apellidos</label>
                        <input id="apellidos" name="apellidos" type="text" />
                    </div>
                    <div class="pure-control-group">
                        <label for="telefono">Teléfono</label>
                        <input id="telefono" name="telefono" type="text" maxlength="11" />
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Datos de la Dirección</legend>
                    <div class="pure-control-group">
                        <label for="calle">Calle</label>
                        <input id="calle" name="calle" type="text" />
                    </div>
                    <div class="pure-control-group">
                        <label for="numero">Numero</label>
                        <input id="numero" name="numero" type="number" />
                    </div>
                    <div class="pure-control-group">
                        <label for="piso">Piso</label>
                        <input id="piso" name="piso" type="number" />
                    </div>
                    <div class="pure-control-group">
                        <label for="letra">Letra</label>
                        <input id="letra" name="letra" type="text" maxlength="1" />
                    </div>
                </fieldset>
                <input class="pure-button pure-button-primary" type="submit" id="boton" name="boton" value="AltaPersona" />
            </form>
        </div>
    </body>
</html>
