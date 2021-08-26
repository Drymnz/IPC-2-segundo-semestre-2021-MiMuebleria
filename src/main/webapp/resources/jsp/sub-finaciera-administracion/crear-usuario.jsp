<%-- 
    Document   : crear-usuario
    Created on : 23/08/2021, 14:18:14
    Author     : drymnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Usuario</title>
        <link rel="icon" type="imagen/x-icon" href="../../picture/logoIcon.icon">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <!-- hojas de estilo -->
        <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/sidebars.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/menus/crear-usuario.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-9">
                    <jsp:include page="../../includes/menu-finaciera-administracion.jsp" flush="true"/>
                </div>
                <div class="col-sm-9">
                    <div class="row">
                        <div class="col-8 col-sm-6">
                            <form method="POST" class="mb-3 row" action="../CrearObjetosP">
                                <h2>Crear usuario</h2>
                                <label for="Usuario">Usuario</label>
                                <input name="nombre" type="text" class="form-control"  placeholder="&#128100" >
                                <label for="Contraseña">Contraseña</label>
                                <input name="password" type="text" class="form-control"  required minlength="6" maxlength="6" placeholder="&#128272;">
                                <label for="tipo">tipo</label>
                                <select name="tipo" class="custom-select d-block w-100" id="operation" required>
                                    <option value="Fabrica">Fabrica</option>
                                    <option value="Venta">Punto de venta</option>
                                    <option value="Finaciero">Finaciero</option>
                                </select>
                                <input type="submit"  class="btn btn-primary" value="crear">
                            </form> 
                            <iframe src="../../../ConexionJSP?accion=listadoUsuario"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="../../js/sidebars.js" type="text/javascript"></script>
        <script src="../../js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>