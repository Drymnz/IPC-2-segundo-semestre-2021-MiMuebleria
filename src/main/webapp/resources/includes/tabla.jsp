<%-- 
    Document   : usuario
    Created on : 25/08/2021, 12:35:19
    Author     : drymnz
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*"%>
<%@page import="com.mycompany.mimuebleria.proyecto1.Objetos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Object> listado = (List<Object>) request.getAttribute("listado");%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <div class="tablaUsuario">
            <h2 id="texto">Listado de ${nombreListado}</h2>
            <table class="table">
                <thead>
                    <tr>
                <script >
                    var data = document.getElementById("texto");
                    switch (data.innerHTML) {
                        case "Listado de usuario":
                            document.writeln("<th scope=\"col\">");
                            document.writeln("nombre</th> ");
                            document.writeln("<th scope=\"col\">");
                            document.writeln("password</th> ");
                            document.writeln("<th scope=\"col\">");
                            document.writeln("tipo</th> ");
                            break;
                        case "Listado de pieza":
                            document.writeln("<th scope=\"col\">");
                            document.writeln("tipo</th> ");
                            document.writeln("<th scope=\"col\">");
                            document.writeln("costo</th> ");
                            break;
                        case "Listado de mueble":
                            document.writeln("<th scope=\"col\">");
                            document.writeln("nombre</th> ");
                            document.writeln("<th scope=\"col\">");
                            document.writeln("precio</th> ");
                            break;
                    }
                </script>
                </tr>
                </thead>
                <tbody> 
                    <tr>
                        <%if (listado != null) {
                                for (Object object : listado) {%>
                    <tr>
                        <%if (object instanceof Usuario) {
                                Usuario imprimir = (Usuario) object;%>
                        <td ><%=imprimir.getNombre()%></td>
                        <td ><%=imprimir.getPassword()%></td>
                        <td ><%=imprimir.getTipo()%></td>
                        <%}%>
                        <%if (object instanceof Pieza) {
                                Pieza imprimir = (Pieza) object;%>
                        <td ><%=imprimir.getTipo()%></td>
                        <td ><%=imprimir.getCosto()%></td>
                        <<td><a href="modificar.jsp?ajustar=${imprimir}">Ajustes</a></td>>
                        <%}%>
                        <%if (object instanceof Mueble) {
                                Mueble imprimir = (Mueble) object;%>
                        <td ><%=imprimir.getNombre()%></td>
                        <td ><%=imprimir.getPrecio()%></td>
                        <%}%>
                    </tr>
                    <%}
                        }%>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>

