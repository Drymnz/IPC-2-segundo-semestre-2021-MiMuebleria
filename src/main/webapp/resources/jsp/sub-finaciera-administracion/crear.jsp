<%-- 
    Document   : crear-usuario
    Created on : 23/08/2021, 14:18:14
    Author     : drymnz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<String> listado = (List<String>) request.getAttribute("listado");%>
<% List<String> listadoresumen = (List<String>) request.getAttribute("listado-resumen");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Usuario</title>
        <link rel="icon" type="imagen/x-icon" href="../../picture/logoIcon.icon">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <!-- hojas de estilo -->
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-9">
                    <jsp:include page="../../includes/menu-finaciera-administracion.jsp" flush="true"/>
                </div>
                <div class="col-sm-9">
                    <div class="row">
                        <div class="col-8 col-sm-6">
                            <form method="POST" class="mb-3 row" action="${pageContext.request.contextPath}/resources/jsp/CrearObjetosP?accion=usuario">
                                <h2>Crear usuario</h2>
                                <label for="Usuario">Usuario</label>
                                <input name="nombre" type="text" class="form-control"  placeholder="&#128100" >
                                <label for="Contraseña">Contraseña</label>
                                <input name="password" type="text" class="form-control"  required minlength="6" maxlength="6" placeholder="&#128272;">
                                <label for="tipo">tipo</label>
                                <select name="tipo" class="custom-select d-block w-100" id="operation" required>
                                    <option value="Fabrica">Fabrica</option>
                                    <option value="Venta">Punto de venta</option>
                                    <option value="Finaciero">Finaciero</option>
                                </select>
                                <input type="submit"  class="btn btn-primary" value="crear">
                            </form> 
                        </div>
                        <div class="col-8 col-sm-6">
                            <form method="POST" class="mb-3 row" action="${pageContext.request.contextPath}/resources/jsp/CrearObjetosP?accion=mueble">
                                <h2>Crear mueble</h2>
                                <label for="nombre">nombre</label>
                                <input name="mueble" type="text" class="form-control">
                                <label for="precio">precio</label>
                                <input name="precio" type="text" class="form-control" ">
                                <input type="submit"  class="btn btn-primary" value="crear">
                            </form> 
                        </div>
                        <div class="col-8 col-sm-6">
                            <form method="POST" class="mb-3 row" action="${pageContext.request.contextPath}/resources/jsp/CrearObjetosP?ensamble=pieza">
                                <h2>Crear ensable piezas</h2>
                                <label for="nombre">mueble</label>
                                <select name="tipo-mueble" class="custom-select d-block w-100" id="operation" required>
                                    <% if (listado != null){ for (String string : listado) {
                                            out.println("<option value=\"" + string + "\">" + string + "</option>");
                                        }}
                                    %>
                                </select>
                                <label for="nombre">pieza</label>
                                <select name="tipo-pieza" class="custom-select d-block w-100" id="operation" required>
                                    <% if(listadoresumen != null){ for (String string : listadoresumen) {
                                            out.println("<option value=\"" + string + "\">" + string + "</option>");
                                    }}
                                    %>
                                </select>
                                <label for="precio">cantidad</label>
                                <input name="cantidad-piezas" type="number" min="1"  class="form-control" ">
                                <input type="submit"  class="btn btn-primary" value="crear">
                            </form> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="../../js/sidebars.js" type="text/javascript"></script>
        <script src="../../js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>