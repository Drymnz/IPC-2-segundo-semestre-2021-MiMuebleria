<%-- 
    Document   : menu-finaciera-administracion
    Created on : 25/08/2021, 11:58:50
    Author     : drymnz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="icon" type="imagen/x-icon" href="${pageContext.request.contextPath}/resources/picture/logoIcon.icon">
<main>
    <h1 class="visually-hidden">Mi Muebleria</h1>
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
        <a href="${pageContext.request.contextPath}/resources/jsp/sub-fabrica/pieza.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
            <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
            <span class="fs-4">Mi Muebleria</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <!--<!-- elementos de listado de menu -->
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/resources/jsp/sub-fabrica/pieza.jsp" class="nav-link active" aria-current="page">
                    Crear
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/ConexionJSP?accion=listadoPiezaYlistado-resumen&donde=/resources/jsp/sub-fabrica/listado-piezas.jsp" class="nav-link active" aria-current="page">
                    Listado de piezas
                </a>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                &#128100;
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/index.jsp">Sign out</a></li>
            </ul>
        </div>
    </div>
</main>