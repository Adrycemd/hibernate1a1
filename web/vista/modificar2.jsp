<%-- 
    Document   : modificar2
    Created on : 23-feb-2016, 9:39:40
    Author     : José E. Díaz Romero
--%>

<%@page import="pojo.Persona"%>
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
            <h1>Modificar Persona</h1>
            <%
                HttpSession sesion = request.getSession();
                Persona persona = (Persona) sesion.getAttribute("persona");
            %>
            <form class="pure-form pure-form-aligned" method="post" action="../dispatcher">
                <fieldset>
                    <legend>Datos de la Persona (el DNI no se puede modificar)</legend>
                    <div class="pure-control-group">
                        <label for="dni">DNI</label>
                        <input id="dni" name="dni" type="text" maxlength="9" value="<% out.print(persona.getDni()); %>" disabled />
                    </div>
                    <div class="pure-control-group">
                        <label for="nombre">Nombre</label>
                        <input id="nombre" name="nombre" type="text" value="<% out.print(persona.getNombre()); %>" />
                    </div>
                    <div class="pure-control-group">
                        <label for="apellidos">Apellidos</label>
                        <input id="apellidos" name="apellidos" type="text" value="<% out.print(persona.getApellidos()); %>" />
                    </div>
                    <div class="pure-control-group">
                        <label for="telefono">Teléfono</label>
                        <input id="telefono" name="telefono" type="text" maxlength="11" value="<% out.print(persona.getTelefono()); %>" />
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Datos de la Dirección</legend>
                    <div class="pure-control-group">
                        <label for="calle">Calle</label>
                        <input id="calle" name="calle" type="text" value="<% out.print(persona.getDireccion().getCalle()); %>" />
                    </div>
                    <div class="pure-control-group">
                        <label for="numero">Numero</label>
                        <input id="numero" name="numero" type="number" value="<% out.print(persona.getDireccion().getNumero()); %>" />
                    </div>
                    <div class="pure-control-group">
                        <label for="piso">Piso</label>
                        <input id="piso" name="piso" type="number" value="<% out.print(persona.getDireccion().getPiso()); %>" />
                    </div>
                    <div class="pure-control-group">
                        <label for="letra">Letra</label>
                        <input id="letra" name="letra" type="text" maxlength="1" value="<% out.print(persona.getDireccion().getLetra()); %>" />
                    </div>
                </fieldset>
                <input class="pure-button pure-button-primary" type="submit" id="boton" name="boton" value="Actualizar datos" />
            </form>
        </div>
    </body>
</html>
