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
<div class="scroll-personal-div">
    <div class="container bd-example" >
        <h2 id="texto">Listado de ${nombreListado}</h2>
        <p class="lead">
        <input class="form-control col-md-3 light-table-filter" data-table="order-table" type="text" placeholder="filtrado busqueda..">
        <hr>
        <table class="table table-striped table-bordered table-bordered order-table">
            <thead class="table-light ">
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
                            <th scope="col">Cantidad</th>
                            <th scope="col">Modificacion</th>
                            </c:when>
                            <c:when test="${nombreListado == 'mueble'}">
                            <th scope="col">Nombre</th>
                            <th scope="col">Precio</th>
                            </c:when>
                            <c:when test="${nombreListado == 'ensable pieza'}">
                            <th scope="col">Pieza</th>
                            <th scope="col">Mueble</th>
                            <th scope="col">Cantidad</th>
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
                    </td>
                    <td><a href="${pageContext.request.contextPath}/Modificar?accion=eliminar-pieza&modificar=<%=imprimir.getId()%>&donde=ConexionJSP?accion=listadoPiezaYlistado-resumen&donde=/resources/jsp/sub-fabrica/listado-piezas.jsp" 
                           class="btn btn-lg btn-block btn-outline-primary">
                            eliminar
                        </a>
                    </td>
                    <% } else {%>
                    <td ><%=imprimir.getTipo()%></td>
                    <td ><%=imprimir.getCosto()%></td>
                    <td cope="row"><a href="${pageContext.request.contextPath}/Modificar?accion=ventana-all&modificar=<%=imprimir.getTipo()%>&all=true&donde=resources/jsp/sub-fabrica/modificar-pieza.jsp" 
                                      class="btn btn-lg btn-block btn-outline-primary">
                            Editar
                        </a>
                    </td>
                    <%}%>
                    <%}%>
                    <%if (object instanceof Mueble) {
                            Mueble imprimir = (Mueble) object;%>
                    <td cope="row"><%=imprimir.getNombre()%></td>
                    <td ><%=imprimir.getPrecio()%></td>
                    <%}%>
                    <%if (object instanceof EnsablePiezas) {
                            EnsablePiezas imprimir = (EnsablePiezas) object;
                            Pieza imprimierPieza = (Pieza) imprimir.getPieza();
                            Mueble imprimierMeuble = (Mueble) imprimir.getMueble();
                    %>
                    <td cope="row"><%=imprimierPieza.getTipo()%></td>
                    <td ><%=imprimierMeuble.getNombre()%></td>
                    <td ><%=imprimir.getCantidadPiezas()%></td>
                    <%}%>
                </tr>
                <%}
                    }%>

                </tr>
            </tbody>
        </table>
        <c:if test="${!editar}">
            <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js" type="text/javascript"></script> 
            <script src="${pageContext.request.contextPath}/resources/js/ordenar-tabla.js" type="text/javascript"></script>
        </c:if>
    </div>
</div>

