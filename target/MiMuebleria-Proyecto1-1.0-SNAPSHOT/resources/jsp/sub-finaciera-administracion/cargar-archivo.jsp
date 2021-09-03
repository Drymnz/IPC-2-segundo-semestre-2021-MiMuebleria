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
        <link rel="icon" type="imagen/x-icon" href="../../picture/logoIcon.icon">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <!-- hojas de estilo -->
    </head>
    <body>
        <jsp:include page="../../includes/menu-finaciera-administracion.jsp"/>
        <div class="contenido">
            <form method="POST" action="../../../ManejadorArchivo" enctype="multipart/form-data">
                <label for="datafile">Seleccione un archivo</label>
                <input type="file" name="datafile">
                <br>
                <button type="submit">Subir</button>
            </form>
        </div>
        <script src="../../js/sidebars.js" type="text/javascript"></script>
        <script src="../../js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
