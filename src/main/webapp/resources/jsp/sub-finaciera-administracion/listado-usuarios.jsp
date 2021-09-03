<%-- 
    Document   : listado-usuarios
    Created on : 31/08/2021, 22:17:13
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
    <body>
        <header>
            <div class="col-sm-9">
                <jsp:include page="../../includes/menu-finaciera-administracion.jsp" flush="true"/>
            </div>
        </header>
        <section>
            <%request.setAttribute("listado", listado);
                request.setAttribute("nombreListado", "usuario");
                request.setAttribute("editar", false);%>
            <jsp:include flush="true" page="../../includes/tabla.jsp"/>
            <h4>Reporte del usuario que registra más ventas en un intervalo X de tiempo: por cada venta se muestran los productos vendidos junto con su precio unitario.
                Reporte del usuario que registra más ganancias en un intervalo X de tiempo: Mostrar el total de la ganancia en ese intervalo de tiempo e incluir un listado con todos los productos vendidos incluyendo la ganancia de ese producto.
            </h4>
        </section>
    </body>
</html>
