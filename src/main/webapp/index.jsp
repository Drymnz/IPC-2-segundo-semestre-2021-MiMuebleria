<%-- 
    Document   : index
    Created on : 18/08/2021, 08:17:36
    Author     : drymnz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link rel="icon" type="imagen/x-icon" href="resources/picture/logoIcon.icon">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <!-- hojas de estilo -->
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/Style-login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <div id="logotipo">
            </div>
        </header>
        <main id="cuerpo">
            <div class="izquierdaFormulario">
                <form method="POST" id="formulario" action="resources/jsp/ConexionJSP">
                    <h2>Login</h2>
                    <label for="Usuario">Usuario</label>
                    <input type="text"  placeholder="&#128100" name="usuario">
                    <label for="Contraseña">Contraseña</label>
                    <input type="password" name="password" required minlength="6" maxlength="6" placeholder="&#128272;">
                    <input type="submit">
                </form>   
            </div>
            <div id="imagenDerecha"></div>
        </main>
        <jsp:include page="resources/includes/footer.jsp" />
    </body>
</html>
