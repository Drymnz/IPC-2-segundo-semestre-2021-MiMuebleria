<%-- 
    Document   : listado-piezas
    Created on : 28/08/2021, 21:33:29
    Author     : drymnz
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Object> listado = (List<Object>) request.getAttribute("listado");
    List<Object> listadoresumen = (List<Object>) request.getAttribute("listado-resumen");
    request.setAttribute("editar", true);
%>
<!DOCTYPE html>
<html  lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado pieza</title>
        <jsp:include flush="true" page="../../../resources/includes/recursos-bootstrap.jsp" />
    </head>
    <body>
        <main>
            <jsp:include page="../../includes/menu-fabrica.jsp" flush="true"/>
            <%request.setAttribute("listado", listadoresumen);
                request.setAttribute("nombreListado", "resumen pieza");
                request.setAttribute("editar", false);%>
            <jsp:include flush="true" page="../../includes/tabla.jsp"/>
            <%request.setAttribute("listado", listado);
                request.setAttribute("editar", true);
                request.setAttribute("nombreListado", "pieza");%>
            <jsp:include flush="true" page="../../includes/tabla.jsp"/>
        </main>
        <jsp:include flush="true" page="../../../resources/includes/recursos-js.jsp" />
    </body>
</html>
