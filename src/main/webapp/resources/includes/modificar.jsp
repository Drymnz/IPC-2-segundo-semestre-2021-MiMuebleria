<%-- 
    Document   : modificar
    Created on : 27/08/2021, 10:29:20
    Author     : drymnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.*"%>
<% Object ajustar = request.getAttribute("ajustar");%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <%if (ajustar instanceof Pieza) {%>
        <form method="POST" action="">
            
        </form>
        <%}%>
    </body>
</html>
