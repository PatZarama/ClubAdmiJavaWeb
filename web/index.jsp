<%-- 
    Document   : index
    Created on : 5/09/2024, 07:17:17 AM
    Author     : Johan Guaquez
--%>

<%-- 
    Document   : categoriasFormulario
    Created on : 30/04/2024, 11:05:30 AM
    Author     : Johan guaquez
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensaje = "";
    if (request.getParameter("error") != null) {
        switch (request.getParameter("error")) {
            case "1":
                mensaje = "Usuario o contraseña incorrecto";
                break;
            case "2":
                mensaje = "Acceso denegado";
                break;
            default:
                mensaje = "Error desconocido";
        }
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Software de ventas para gestión de inventario y ventas.">
    <title>Bienvenido a ClubAdmi</title>
    <link rel="stylesheet" href="Login.css">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
    <header>
        <h1>Bienvenido a ClubAdmi</h1>
    </header>
    <main>
        <div class="wrapper">
            <h2>Ingrese sus datos</h2>
            <p id="error" aria-live="polite"><%= mensaje %></p>
            <form name="formulario" method="post" action="validar.jsp" aria-labelledby="formulario-title">
                <fieldset>
                    <legend id="formulario-title">Formulario de inicio de sesión</legend>
                    <div class="form-group">
                        <label for="identificacion">Usuario</label>
                        <input type="text" name="identificacion" id="identificacion" required aria-required="true" placeholder="Ingrese su usuario">
                    </div>
                    <div class="form-group">
                        <label for="clave">Contraseña</label>
                        <input type="password" name="clave" id="clave" required aria-required="true" placeholder="Ingrese su contraseña">
                    </div>
                    <div class="form-group">
                        <button type="submit">Iniciar</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </main>
    <footer>
        <p>&copy; 2024 ClubAdmi.</p>
         <p>&copy; @JohanGuaquez.Desarrollador_</p>
    </footer>
</body>
</html>


