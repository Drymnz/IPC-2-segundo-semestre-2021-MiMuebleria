<%-- 
    Document   : modificar
    Created on : 27/08/2021, 10:29:20
    Author     : drymnz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.*"%>
<% Object ajustar = (Object) request.getAttribute("modificar");%>
<!DOCTYPE html>

<h1>Modificar</h1>
<%if (ajustar instanceof Pieza) {
        Pieza modificar = (Pieza) ajustar;%>
<form method="POST" action="${pageContext.request.contextPath}/Modificar">
    <input type="hidden" name="tipo-antes" value="<%=modificar.getTipo()%>"/>
    <input type="hidden" name="ajustar" value="<%=modificar.getId()%>"/>
    <label>tipo antes>(<%=modificar.getTipo()%>) despues:</label>
    <input type="text" name="tipo" />
    <c:if test="${modificar.getCosto() > 0}">
        <label>costo antes>(<%=modificar.getCosto()%>) despues :</label>
        <input type="number" name="costo"  /> 
    </c:if>
    <input type="submit" name="accion" value="modificar-pieza"/>
</form>
<label>NOTA: si deja un espacio en blanco sera colocado de esa manera en modificar</label>
<%}%>