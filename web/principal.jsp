<%-- 
    Document   : principal
    Created on : 27/08/2024, 08:13:29 PM
    Author     : Johan Guaquez
--%>
<%@page import="clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
HttpSession sesion = request.getSession();
Usuario USUARIO = null;
if (sesion.getAttribute("usuariot")== null) response.sendRedirect("index.jsp?error=2");
  else USUARIO = (Usuario) sesion.getAttribute("usuariot");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema ClubAmi</title>
        <link rel="stylesheet" href="recursos/jquery-ui-1.13.3.custom/jquery-ui.css">
        <script src="recursos/jquery-3.7.1.min.js"></script>
        <script src="recursos/jquery-ui-1.13.3.custom/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap">
        <script src="recursos/amcharts5/index.js"></script>
        <script src="recursos/amcharts5/xy.js"></script>
        <script src="recursos/amcharts5/themes/Animated.js"></script>      
    </head>
    <body>
        <div class="menu-container">
            <div id="menu"><%=USUARIO.getTipoEnObjeto().getMenu()%></div>
            <div id="contenido"></div>
    </div>
            <jsp:include page='<%=request.getParameter("CONTENIDO")%>' flush="true" />
    </body>
</html>

