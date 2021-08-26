<%-- 
    Document   : usuario
    Created on : 25/08/2021, 12:35:19
    Author     : drymnz
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Usuario"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Usuario> listado = (List<Usuario>) request.getAttribute("listadoUsuario"); %>
<link href="../../css/bootstrap.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<div class="tablaUsuario">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">nombre</th>
                <th scope="col">contraseña</th>
                <th scope="col">tipo</th>
            </tr>
        </thead>
        <tbody>
            <%if (listado != null) {
                    for (Usuario usuario : listado) {
                        usuario.getNombre();%>
            <tr>
                <td ><%=usuario.getNombre()%></td>
                <td ><%=usuario.getPassword()%></td>
                <td ><%=usuario.getTipo()%></td>
            </tr>
            <%}
            }%>
        </tbody>
    </table>
</div>
