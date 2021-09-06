<%-- 
    Document   : menu-finaciera-administracion
    Created on : 25/08/2021, 11:58:50
    Author     : drymnz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
    <a href="${pageContext.request.contextPath}/resources/jsp/sub-fabrica/pieza.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
        <span class="fs-4">Mi Muebleria</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <!--<!-- elementos de listado de menu -->
        <li class="nav-item">
            <svg class="bi me-2" width="16" height="16"></svg>
            <a href="${pageContext.request.contextPath}/resources/jsp/sub-fabrica/pieza.jsp" class="nav-link active" aria-current="page">
                Crear
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/ConexionJSP?accion=listadoPiezaYlistado-resumen&donde=/resources/jsp/sub-fabrica/listado-piezas.jsp" class="nav-link active" aria-current="page">
                Listado de piezas
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/ConexionJSP?accion=listadoDisponiblesEnsablarMueble&donde=/resources/jsp/sub-fabrica/ensable-mueble.jsp" class="nav-link active" aria-current="page">
                Ensablar mueble
            </a>
        </li>
    </ul>
    <hr>
    <div class="dropdown">
        <a href="${pageContext.request.contextPath}/index.jsp" class="d-flex text-white text-decoration-none " id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            &#128100; Sign out
        </a>
    </div>
</div>
