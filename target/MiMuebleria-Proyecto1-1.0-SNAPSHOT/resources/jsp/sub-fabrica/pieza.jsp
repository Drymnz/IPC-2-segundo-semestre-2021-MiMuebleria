<%-- 
    Document   : pieza
    Created on : 26/08/2021, 13:19:41
    Author     : drymnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <div class="menu-sub-finaza">
            <jsp:include page="../../includes/menu-fabrica.jsp" flush="true"/>
        </div>
        <div class="col-8 col-sm-6">
            <form method="POST" class="mb-3 row" action="${pageContext.request.contextPath}/resources/jsp/CrearObjetosP?accion=pieza">
                <h2>Crear pieza</h2>
                <label for="Cantidad">Cantidad</label>
                <input type="number" name="cantidad" min="1"/>
                <label for="Tipo">Tipo</label>
                <input name="tipo" type="text" class="form-control"  >
                <label for="Precio">Precio</label>
                <input name="precio" type="text" class="form-control">
                <input type="submit" id="boton-enviar"  class="btn btn-primary" value="crear">
            </form> 
        </div>
    </body>
    <script>
        function activar() {
            let valor = document.getElementsByName('Cantidad');
            document.getElementById('boton-enviar').disabled = valor > 0;
        }
    </script>
</html>
