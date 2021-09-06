<%-- 
    Document   : modificar-pieza
    Created on : 29/08/2021, 12:37:28
    Author     : drymnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Object ajustar = (Object) request.getAttribute("modificar");%>
<% boolean activar = (boolean) request.getAttribute("all");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar pieza</title>
        <jsp:include flush="true" page="../../../resources/includes/recursos-bootstrap.jsp" />
    </head>
    <body>
        <main>
            <jsp:include page="../../includes/menu-fabrica.jsp" flush="true"/>
            <div class="b-example-divider"></div> 
            <section>
                <jsp:include page="../../includes/modificar.jsp" flush="true"/>
            </section>
        </main>
        <jsp:include flush="true" page="../../../resources/includes/recursos-js.jsp" />
    </body>
</html>
