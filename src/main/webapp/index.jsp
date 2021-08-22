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
        <link href="resources/css/Style-login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <div id="logotipo">
            </div>
        </header>
        <main id="cuerpo">
            <div class="izquierdaFormulario">
                <form id="formulario" >
                    <h2>Login</h2>
                    <label for="Usuario">Usuario</label>
                    <input type="text" id="nombre" placeholder="&#128100">
                    <label for="Contraseña">Contraseña</label>
                    <input type="password" required minlength="6" maxlength="6" id="Contraseña" placeholder="&#128272;">
                    <input type="submit" value="Ingresar">
                </form>   
            </div>
            <div id="imagenDerecha"></div>
        </main>
    </body>
    <footer>
        <div id="footer-separador"></div>
        <div id="footer-content">
            <p>Mi muebleria - derechos reservados</p>
        </div> 
    </footer>
</html>
