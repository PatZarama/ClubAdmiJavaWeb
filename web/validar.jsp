<%-- 
    Document   : validar
    Created on : 27/08/2024, 08:13:03 PM
    Author     : Johan Guaquez
--%>

<%@page import="clases.Usuario"%>

<%
String identificacion=request.getParameter("identificacion");
String clave=request.getParameter("clave");
Usuario usuariot=Usuario.validar(identificacion, clave);
if (usuariot!=null){
    HttpSession sesion=request.getSession();
    sesion.setAttribute("usuariot", usuariot);
    response.sendRedirect("principal.jsp?CONTENIDO=inicio.jsp");
} else {
    response.sendRedirect("index.jsp?error=1");
}
%>



