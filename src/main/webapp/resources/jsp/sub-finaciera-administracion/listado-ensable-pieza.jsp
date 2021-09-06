<%-- 
    Document   : listado-ensable-pieza
    Created on : 31/08/2021, 23:25:59
    Author     : drymnz
--%>



<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Object> listado = (List<Object>) request.getAttribute("listado");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado ensable piezas</title>
        <jsp:include flush="true" page="../../../resources/includes/recursos-bootstrap.jsp" />
    </head>
    <body>
        <main>
            <jsp:include page="../../includes/menu-finaciera-administracion.jsp" flush="true"/>
            <div class="b-example-divider"></div> 
            <section>
                <%request.setAttribute("listado", listado);
                    request.setAttribute("nombreListado", "ensable pieza");
                    request.setAttribute("editar", false);%>
                <jsp:include flush="true" page="../../includes/tabla.jsp"/>
            </section>

        </main>
    </body>
    <jsp:include flush="true" page="../../../resources/includes/recursos-js.jsp" />
</html>
