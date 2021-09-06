<%-- 
    Document   : resultado-mueble-ensablado
    Created on : 5/09/2021, 16:19:47
    Author     : drymnz
--%>

<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Pieza"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Mueble"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Mueble mueble = (Mueble) request.getAttribute("mueble");
    List<Pieza> piezasUsadaslistadoresumen = (List<Pieza>) request.getAttribute("listado");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado mueble ensablado</title>
        <jsp:include flush="true" page="../../../resources/includes/recursos-bootstrap.jsp" />
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
     <jsp:include flush="true" page="../../../resources/includes/recursos-js.jsp" />
</html>
