<%-- 
    Document   : listado-piezas
    Created on : 28/08/2021, 21:33:29
    Author     : drymnz
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Object> listado = (List<Object>) request.getAttribute("listado");%>
<% List<Object> listadoresumen = (List<Object>) request.getAttribute("listado-resumen");
    request.setAttribute("editar", true);%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <jsp:include page="../../includes/menu-fabrica.jsp" flush="true"/>
        </header>
        <section>
            <%request.setAttribute("listado", listadoresumen);
                request.setAttribute("nombreListado", "resumen pieza");
                request.setAttribute("editar", false);%>
            <jsp:include flush="true" page="../../includes/tabla.jsp"/>
            <%request.setAttribute("listado", listado);
                request.setAttribute("nombreListado", "pieza");
                request.setAttribute("editar", true);%>
            <jsp:include flush="true" page="../../includes/tabla.jsp"/>
        </section>
    </body>
</html>
