<%-- 
    Document   : ensable-mueble
    Created on : 1/09/2021, 20:36:41
    Author     : drymnz
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.EnsablePiezas"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Mueble"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario usuario = (Usuario) request.getAttribute("usuario");
    List<String> listado = (List<String>) request.getAttribute("listado");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ensable mueble</title>
        <jsp:include flush="true" page="../../../resources/includes/recursos-bootstrap.jsp" />
    </head>
    <body>
        <main>
            <jsp:include page="../../includes/menu-fabrica.jsp" flush="true"/>
            <div class="b-example-divider"></div> 
            <div class="d-flex row col-md-8 themed-grid-col">
                <div class="mb-3">
                    <c:if test="${usuario!=null}">
                        <h2> Usuario logiado : <%= usuario.getNombre()%></h2>
                        <label for="nombre">¿Que mueble desea ensamblar?</label>
                        <header>
                            <c:if test="${listado != null}">
                                <%
                                    for (String string : listado) {%>
                                <div>
                                    <form method="POST" class="mb-3 row" action="${pageContext.request.contextPath}/CrearEnsable?ensamble=mueble">
                                        <div class="mb-3">
                                            <%
                                                String[] enviar = string.split("\\)");
                                            %>
                                            <p> <%=enviar[1]%></p>
                                        </div>
                                        <div class="mb-3">
                                            <input type="hidden" name="tipo-mueble" value="<%=enviar[0]%>"/>
                                            <input type="hidden" name="usuario" value="${usuario.getNombre()}"/>
                                            <input type="submit"  class="btn btn-primary" value="crear">
                                        </div>
                                    </form> 
                                </div>     
                                <%}%>
                            </c:if>
                        </c:if>
                    </header>   
                </div>
            </div>
        </main>
        <jsp:include flush="true" page="../../../resources/includes/recursos-js.jsp" />
    </body>
</html>
