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
        <title>Index</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession(true);
            
            response.sendRedirect("vista/inicio.jsp");
        %>
    </body>
</html>