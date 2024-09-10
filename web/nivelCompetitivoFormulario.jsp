<%-- 
    Document   : nivelCompetitivoFormulario
    Created on : 9/09/2024, 06:54:16 PM
    Author     : Johan Guaquez
--%>

<%-- 
    Document   : nivelConpetitivoFormulario
    Created on : 9/09/2024, 05:29:59 PM
    Author     : Jhonny Rojas
--%>

<%@page import="clases.NivelCompetitivo"%>
<%
    String accion = request.getParameter("accion");
    String id = "Sin generar";
    String nombre = "";
    String descripcion = "";
    if ("Modificar".equals(accion)) {
        id = request.getParameter("id");
        NivelCompetitivo nivelCompetitivo = new NivelCompetitivo(id);
        nombre = nivelCompetitivo.getNombre();
        descripcion = nivelCompetitivo.getDescripcion();
    }
%>
<div id="banner">
<h3><%= accion.toUpperCase() %> NIVEL COMPETITIVO</h3>
<form name="formulario" method="post" action="principal.jsp?CONTENIDO=nivelCompetitivoActualizar.jsp">
    <table border="0">
        <tr><th>ID</th><td><%= id %></td></tr>
        <tr><th>Nombre</th><td><input type="text" name="nombre" value="<%= nombre %>" size="50" maxlength="50" required></td></tr>
        <tr><th>Descripción</th><td><textarea name="descripcion" cols="50" rows="5"><%= descripcion %></textarea></td></tr>
    </table>
    <input type="hidden" name="id" value="<%= id %>">
    <input type="submit" name="accion" value="<%= accion %>">
</form>
</div>
