<%-- 
    Document   : usuario
    Created on : 25/08/2021, 12:35:19
    Author     : drymnz
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% List<Object> listado = (List<Object>) request.getAttribute("listado");%>
<% boolean editar = (boolean) request.getAttribute("editar");%>
<!DOCTYPE html>
<div class="tablaUsuario">
    <h2 id="texto">Listado de ${nombreListado}</h2>
    <table class="table">
        <thead>
            <tr>
                <c:choose>
                    <c:when test="${nombreListado == 'usuario'}">
                        <th scope="col">Nombre</th>
                        <th scope="col">Password</th>
                        <th scope="col">Tipo</th>
                        </c:when>
                        <c:when test="${nombreListado == 'pieza'}">
                        <th scope="col">Id</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Costo</th>
                        <th scope="col">Modificacion</th>
                        <th scope="col">Eliminar</th>
                        </c:when>
                        <c:when test="${nombreListado == 'resumen pieza'}">
                        <th scope="col">Tipo</th>
                        </c:when>
                        <c:when test="${nombreListado == 'mueble'}">
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        </c:when>
                    </c:choose>
            </tr>
        </thead>
        <tbody> 
            <tr>
                <%if (listado
                            != null) {
                        for (Object object : listado) {%>
            <tr>
                <%if (object instanceof Usuario) {
                        Usuario imprimir = (Usuario) object;%>
                <td cope="row"><%=imprimir.getNombre()%></td>
                <td ><%=imprimir.getPassword()%></td>
                <td ><%=imprimir.getTipo()%></td>
                <%}%>
                <%if (object instanceof Pieza) {
                        Pieza imprimir = (Pieza) object;%>
                <%if (editar) {%>
                <td ><%=imprimir.getId()%></td>
                <td ><%=imprimir.getTipo()%></td>
                <td ><%=imprimir.getCosto()%></td>
                <td cope="row"><a href="${pageContext.request.contextPath}/Modificar?accion=ventana&modificar=<%=imprimir.getId()%>&donde=resources/jsp/sub-fabrica/modificar-pieza.jsp" 
                                  class="btn btn-lg btn-block btn-outline-primary">
                        Editar
                    </a>
                <td><a href="${pageContext.request.contextPath}/Modificar?accion=eliminar-pieza&modificar=<%=imprimir.getId()%>&donde=ConexionJSP?accion=listadoPiezaYlistado-resumen&donde=/resources/jsp/sub-fabrica/listado-piezas.jsp" 
                       class="btn btn-lg btn-block btn-outline-primary">
                        eliminar
                    </a>
                </td>
                <% } else {%>
                <td ><%=imprimir.getTipo()%></td>
                <%}%>
                <%}%>
                <%if (object instanceof Mueble) {
                        Mueble imprimir = (Mueble) object;%>
                <td cope="row"><%=imprimir.getNombre()%></td>
                <td ><%=imprimir.getPrecio()%></td>
                <%}%>
            </tr>
            <%}
                }%>

            </tr>
        </tbody>
    </table>
</div>
