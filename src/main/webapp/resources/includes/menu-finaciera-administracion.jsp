<%-- 
    Document   : menu-finaciera-administracion
    Created on : 25/08/2021, 11:58:50
    Author     : drymnz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h1 class="visually-hidden">Mi Muebleria</h1>
<div  class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
        <span class="fs-4">Mi Muebleria</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <!--<!-- elementos de listado de menu -->
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/ConexionJSP?accion=listado-una-columna-menu-crear-finaciero&donde=resources/jsp/sub-finaciera-administracion/crear.jsp" class="nav-link active" aria-current="page">
                Crear
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/ConexionJSP?accion=listadoUsuario&donde=resources/jsp/sub-finaciera-administracion/listado-usuarios.jsp" class="nav-link active" aria-current="page">
                Listado Usuario
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/ConexionJSP?accion=listadoMueble&donde=resources/jsp/sub-finaciera-administracion/listado-mueble.jsp" class="nav-link active" aria-current="page">
                Listado mueble
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/ConexionJSP?accion=listadoEnsablePieza&donde=resources/jsp/sub-finaciera-administracion/listado-ensable-pieza.jsp" class="nav-link active" aria-current="page">
                Listado ensable pieza
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/resources/jsp/sub-finaciera-administracion/cargar-archivo.jsp" class="nav-link active">
                Cargar Archivo
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
