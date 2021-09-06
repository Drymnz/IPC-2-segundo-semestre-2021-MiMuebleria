<%-- 
    Document   : cargar-archivo
    Created on : 24/08/2021, 10:16:55
    Author     : drymnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar archivo</title>
        <jsp:include flush="true" page="../../../resources/includes/recursos-bootstrap.jsp" />
    </head>
    <body>
        <main>
            <jsp:include page="../../includes/menu-finaciera-administracion.jsp"/>
            <div class="b-example-divider"></div> 
            <div class="flex-column container">
                <form method="POST" action="../../../ManejadorArchivo" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="datafile">Seleccione un archivo</label>
                        <input type="file" name="datafile">
                        <br>
                        <button type="submit">Subir</button>
                    </div>
                </form>
            </div> 
        </main>
        <jsp:include flush="true" page="../../../resources/includes/recursos-js.jsp" />
    </body>
</html>
