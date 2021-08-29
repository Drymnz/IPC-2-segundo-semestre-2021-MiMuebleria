<%-- 
    Document   : modificar-pieza
    Created on : 29/08/2021, 12:37:28
    Author     : drymnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Object ajustar = (Object) request.getAttribute("modificar");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar pieza</title>
    </head>
    <body>
        <header>
            <jsp:include page="../../includes/menu-fabrica.jsp" flush="true"/>
        </header>
        <section>
            <jsp:include page="../../includes/modificar.jsp" flush="true"/>
        </section>
    </body>
</html>
