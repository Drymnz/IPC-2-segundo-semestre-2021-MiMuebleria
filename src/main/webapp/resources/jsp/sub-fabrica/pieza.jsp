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
        <title>Crear Pieza</title>
        <jsp:include flush="true" page="../../../resources/includes/recursos-bootstrap.jsp" />
    </head>
    <body>
        <main>
            <jsp:include page="../../includes/menu-fabrica.jsp" flush="true"/>
            <div class="b-example-divider"></div> 
            <div class="col-6 col-sm-4">
                <form method="POST" class="mb-3" action="${pageContext.request.contextPath}/resources/jsp/CrearObjetosP?accion=pieza">
                    <h2>Crear pieza</h2>
                    <div class="mb-3">
                        <label for="Cantidad">Cantidad : </label>
                        <input type="number" name="cantidad" min="1"/>
                    </div>
                    <div class="mb-3">
                        <label for="Tipo">Tipo</label>
                        <input name="tipo" type="text" class="form-control"  >
                    </div>
                    <div class="mb-3">
                        <label for="Precio">Precio</label>
                        <input name="precio" type="text" class="form-control">
                    </div>
                    <div class="mb-3 container-xxl themed-container">
                        <input type="submit" id="boton-enviar"  class="btn btn-primary" value="crear">
                    </div>
                </form> 
            </div>
        </main>
        <jsp:include flush="true" page="../../../resources/includes/recursos-js.jsp" />
    </body>
    <script>
        function activar() {
            let valor = document.getElementsByName('Cantidad');
            document.getElementById('boton-enviar').disabled = valor > 0;
        }
    </script>
</html>
