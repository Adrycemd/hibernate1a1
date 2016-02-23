<%-- 
    Document   : modificar
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
            <h1>Modificar los datos de una Persona</h1>
            <form class="pure-form pure-form-aligned" method="post" action="../dispatcher">
                <div class="pure-control-group">
                    <label for="dni">DNI</label>
                    <input id="dni" name="dni" type="text" maxlength="9" />
                </div>
                <br>
                <input class="pure-button pure-button-primary" type="submit" id="boton" name="boton" value="Modificar Persona" />
            </form>
        </div>
    </body>
</html>