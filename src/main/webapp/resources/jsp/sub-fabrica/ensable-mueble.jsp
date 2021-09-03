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
    List<Object> listado = (List<Object>) request.getAttribute("listado");
    List<String> listadoMuebles = new ArrayList<String>();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <jsp:include page="../../includes/menu-fabrica.jsp" flush="true"/>
        </header>
        <h2><%= usuario.getNombre()%></h2>
        <header>
            <form method="POST" class="mb-3 row" action="${pageContext.request.contextPath}/resources/jsp/CrearObjetosP?ensamble=pieza">
                <h2>Crear ensable mueble</h2>
                <label for="nombre">¿Que mueble desea ensamblar?</label>
                <label for="nombre">post: solo sale los que se pueden por la cantidad de piezas</label>
                <select name="tipo-pieza" class="custom-select d-block w-100" id="operation" required >
                    <% if (listado != null) {
                            for (Object object : listado) {
                                EnsablePiezas informacion = (EnsablePiezas) object;
                                if (listadoMuebles.isEmpty()) {
                                    listadoMuebles.add(informacion.getMueble().getNombre());
                                    out.println("<option value=\"" + informacion.getMueble().getNombre() + "\">" + informacion.getMueble().getNombre() + "</option>");
                                } else {
                                    String añadirString = "";
                                    boolean añadir = false;
                                    for (String listadoMueble : listadoMuebles) {
                                        añadir = ((listadoMueble.equalsIgnoreCase(informacion.getMueble().getNombre()))) ? false : true;
                                        añadirString = (añadir) ? (informacion.getMueble().getNombre()) : "";
                                    }
                                    if (!añadirString.isEmpty()) {
                                        listadoMuebles.add(añadirString);
                                        out.println("<option value=\"" + añadirString + "\">" + añadirString + "</option>");
                                    }
                                }
                            }
                        }
                    %>
                </select>
                <%if (true) {
                    
                    }
                %>
                <input type="submit"  class="btn btn-primary" value="crear">
            </form> 
        </header>
    </body>
</html>
