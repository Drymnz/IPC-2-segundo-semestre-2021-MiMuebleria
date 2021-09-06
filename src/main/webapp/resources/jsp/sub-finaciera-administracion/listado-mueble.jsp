<%-- 
    Document   : listado-mueble
    Created on : 31/08/2021, 22:42:52
    Author     : drymnz
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Object> listado = (List<Object>) request.getAttribute("listado");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado muble</title>
        <jsp:include flush="true" page="../../../resources/includes/recursos-bootstrap.jsp" />
    </head>
    <body>
        <main>
            <jsp:include page="../../includes/menu-finaciera-administracion.jsp" flush="true"/>
            <div class="b-example-divider"></div> 
            <section>
                <%request.setAttribute("listado", listado);
                    request.setAttribute("nombreListado", "mueble");
                    request.setAttribute("editar", false);%>
                <jsp:include flush="true" page="../../includes/tabla.jsp"/>
                <h5>Reporte del mueble más vendido, incluyendo el detalle de las ventas, en un intervalo X de tiempo
                    Reporte del mueble menos vendido, incluyendo el detalle de las ventas, en un intervalo X de tiempo.
                </h5>
            </section>
        </main>
    </body>
    <jsp:include flush="true" page="../../../resources/includes/recursos-js.jsp" />
</html>
