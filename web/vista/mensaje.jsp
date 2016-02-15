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
        <title>Mensaje</title>
        <link rel="stylesheet" href="../css/pure-min.css">
        <link rel="stylesheet" href="../css/css.css">
        <script type="text/javascript" src="../js/js.js"></script>
    </head>
    <body>
        <div id="formulario">
            <h1>
            <%
                HttpSession sesion = request.getSession();

                out.println((String) sesion.getAttribute("mensaje"));
                sesion.setAttribute("mensaje", "Por favor, vuelva al inicio.");
            %>
        </h1>
            <form class="pure-form pure-form-aligned" method="post" action="inicio.jsp">
                <input class="pure-button pure-button-primary" type="submit" name="resultados" value="Volver" />
            </form>
        </div>
    </body>
</html>
