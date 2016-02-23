<%-- 
    Document   : listar
    Created on : 15-feb-2016, 13:17:57
    Author     : Sara Aamoraga
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
        <%
            HttpSession sesion = request.getSession();
            ArrayList<Persona> personas = (ArrayList<Persona>) sesion.getAttribute("personas");
            Iterator<Persona> iterador = personas.iterator();
        %>
        <div id="formulario">
            <h1>Listar Personas</h1>
            <table class="tabla">
                <tr>
                    <td>DNI</td>
                    <td>Nombre</td>
                    <td>Apellidos</td>
                    <td>Teléfono</td>
                    <td>Calle</td>
                    <td>Numero</td>
                    <td>Piso</td>
                    <td>Letra</td>
                </tr>
                <% while (iterador.hasNext()) {
                    Persona persona = iterador.next(); %>
                        
                    <tr>
                        <td><% out.print(persona.getDni()); %></td>
                        <td><% out.print(persona.getNombre()); %></td>
                        <td><% out.print(persona.getApellidos()); %></td>
                        <td><% out.print(persona.getTelefono()); %></td>
                        <td><% out.print(persona.getDireccion().getCalle()); %></td>
                        <td><% out.print(persona.getDireccion().getNumero()); %></td>
                        <td><% out.print(persona.getDireccion().getPiso()); %></td>
                        <td><% out.print(persona.getDireccion().getLetra()); %></td>
                    </tr>
                <% } %>
            </table>
            <form class="pure-form pure-form-aligned" method="post" action="inicio.jsp">
                <input class="pure-button pure-button-primary" type="submit" name="resultados" value="Volver" />
            </form>
        </div>
    </body>
</html>
