<%-- 
    Document   : modificar
    Created on : 27/08/2021, 10:29:20
    Author     : drymnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.*"%>
<% Object ajustar = (Object) request.getAttribute("modificar");%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <h1>Modificar</h1>
        <%if (ajustar instanceof Pieza) {
                Pieza modificar = (Pieza) ajustar;%>
        <form method="POST" action="${pageContext.request.contextPath}/Modificar">
            <label>tipo >> <%=modificar.getTipo()%></label>
            <input type="text" name="tipo" />
            <label>tipo >> <%=modificar.getCosto()%></label>
            <input type="number" name="costo"  />
            <input type="hidden" name="ajustar" value="<%=modificar.getId()%>">
            <input type="submit" name="accion" value="modificar-pieza">
        </form>
        <label>NOTA: si deja un espacio en blanco sera colocado de esa manera en modificar</label>
        <%}%>
    </body>
</html>
