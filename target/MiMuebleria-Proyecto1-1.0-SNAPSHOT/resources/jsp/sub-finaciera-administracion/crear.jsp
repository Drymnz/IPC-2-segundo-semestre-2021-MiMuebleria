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
        <jsp:include flush="true" page="../../../resources/includes/recursos-bootstrap.jsp" />
    </head>
    <body>
        <main>
            <jsp:include page="../../includes/menu-finaciera-administracion.jsp" flush="true"/>
            <div class="b-example-divider"></div> 
            <div class="row  justify-content-center scroll-personal-div">
                <div class="mb-3">
                    <form method="POST" class="mb-3 row" action="${pageContext.request.contextPath}/resources/jsp/CrearObjetosP?accion=usuario">
                        <h2>Crear usuario</h2>
                        <div class="mb-3">
                            <label for="Usuario">Usuario</label>
                            <input name="nombre" type="text" class="form-control"  placeholder="&#128100" >
                        </div>
                        <div class="mb-3">
                            <label for="Contraseña">Contraseña</label>
                            <input name="password" type="text" class="form-control"  required minlength="6" maxlength="6" placeholder="&#128272;">
                        </div>
                        <div class="mb-3">
                            <label for="tipo">tipo</label>
                            <select name="tipo" class="custom-select d-block w-100" id="operation" required>
                                <option value="Fabrica">Fabrica</option>
                                <option value="Venta">Punto de venta</option>
                                <option value="Finaciero">Finaciero</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <input type="submit"  class="btn btn-primary" value="crear">
                        </div>
                    </form>  
                </div>
                <div class="mb-3">
                    <form method="POST" class="mb-3 row" action="${pageContext.request.contextPath}/resources/jsp/CrearObjetosP?accion=mueble">
                        <div class="mb-3">
                            <h2>Crear mueble</h2>
                            <label for="nombre">nombre</label>
                            <input name="mueble" type="text" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="precio">precio</label>
                            <input name="precio" type="text" class="form-control" ">
                        </div>
                        <div class="mb-3">
                            <input type="submit"  class="btn btn-primary" value="crear">
                        </div>
                    </form> 
                </div>
                <div class="mb-3">
                    <form method="POST" class="mb-3" action="${pageContext.request.contextPath}/CrearEnsable?ensamble=pieza">
                        <h2>Crear ensable piezas</h2>
                        <label for="nombre">mueble</label>
                        <select name="tipo-mueble" class="custom-select d-block w-100" id="operation" required>
                            <% if (listado != null) {
                                    for (String string : listado) {
                                        out.println("<option value=\"" + string + "\">" + string + "</option>");
                                    }
                                }
                            %>
                        </select>
                        <label for="nombre">pieza</label>
                        <select name="tipo-pieza" class="custom-select d-block w-100" id="operation" required>
                            <% if (listadoresumen != null) {
                                    for (String string : listadoresumen) {
                                        out.println("<option value=\"" + string + "\">" + string + "</option>");
                                    }
                                }
                            %>
                        </select>
                        <label for="precio">cantidad</label>
                        <input name="cantidad-piezas" type="number" min="1"  class="form-control" ">
                        <input type="submit"  class="btn btn-primary" value="crear">
                    </form> 
                </div>
            </div>
        </main>
    </body>
    <jsp:include flush="true" page="../../../resources/includes/recursos-js.jsp" />
</html>