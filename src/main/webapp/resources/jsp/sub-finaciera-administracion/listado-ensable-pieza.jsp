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
        <title>JSP Page</title>
    </head>
    <header>
        <div class="col-sm-9">
            <jsp:include page="../../includes/menu-finaciera-administracion.jsp" flush="true"/>
        </div>
    </header>
    <body>
        <section>
            <%request.setAttribute("listado", listado);
                request.setAttribute("nombreListado", "ensable pieza");
                request.setAttribute("editar", false);%>
            <jsp:include flush="true" page="../../includes/tabla.jsp"/>
        </section>
    </body>
</html>
