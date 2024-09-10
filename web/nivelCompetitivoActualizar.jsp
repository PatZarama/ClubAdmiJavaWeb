<%-- 
    Document   : nivelCompetitivoActualizar
    Created on : 9/09/2024, 06:55:36 PM
    Author     : Johan Guaquez
--%>

<%-- 
    Document   : nivelConpetitivoActualizar
    Created on : 9/09/2024, 05:29:29 PM
    Author     : Jhonny Rojas
--%>

<%@page import="clases.NivelCompetitivo"%>
<%
    String accion = request.getParameter("accion");
    String id = request.getParameter("id");
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    NivelCompetitivo nivelCompetitivo = new NivelCompetitivo();

    if ("Modificar".equals(accion)) {
        nivelCompetitivo.setId(id);
        nivelCompetitivo.setNombre(nombre);
        nivelCompetitivo.setDescripcion(descripcion);
        nivelCompetitivo.modificar();
    } else if ("Adicionar".equals(accion)) {
        nivelCompetitivo.setNombre(nombre);
        nivelCompetitivo.setDescripcion(descripcion);
        nivelCompetitivo.grabar();
    } else if ("Eliminar".equals(accion)) {
        nivelCompetitivo.setId(id);
        nivelCompetitivo.eliminar();
    }
%>
<script type="text/javascript">
    document.location = "principal.jsp?CONTENIDO=Categorias/nivelCompetitivo.jsp";
</script>
