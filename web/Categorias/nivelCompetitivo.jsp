<%-- 
    Document   : nivelCompetitivo
    Created on : 9/09/2024, 06:53:22 PM
    Author     : Johan Guaquez
--%>

<%-- 
    Document   : nivelConpetitivo
    Created on : 9/09/2024, 05:28:26 PM
    Author     : Jhonny Rojas
--%>

<%@page import="java.util.List"%>
<%@page import="clases.NivelCompetitivo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String lista = "";
    List<NivelCompetitivo> datos = NivelCompetitivo.getListaEnObjetos(null, null);
    for (NivelCompetitivo nivelCompetitivo : datos) {
        lista += "<tr>";
        lista += "<td>" + nivelCompetitivo.getId() + "</td>";
        lista += "<td>" + nivelCompetitivo.getNombre() + "</td>";
        lista += "<td>" + nivelCompetitivo.getDescripcion() + "</td>";
        lista += "<td>";
        lista += "<a href='principal.jsp?CONTENIDO=nivelCompetitivoFormulario.jsp&accion=Modificar&id=" + nivelCompetitivo.getId() + 
                "' title='Modificar'> <img src='presentacion/imagenes/modificar.png' alt='Modificar'></a>";
        lista += "<img src='presentacion/imagenes/eliminar.png' title='Eliminar' onClick='eliminar(" + nivelCompetitivo.getId() + ")' alt='Eliminar'>";
        lista += "</td>";
        lista += "</tr>";
    }
%>
<div id="banner">
<h3>LISTA DE NIVELES COMPETITIVOS</h3>
<table border="1">
    <tr>
        <th>ID</th><th>Nombre</th><th>Descripción</th>
        <th><a href="principal.jsp?CONTENIDO=nivelCompetitivoFormulario.jsp&accion=Adicionar" title="Adicionar">
                <img src="presentacion/imagenes/agregar.png" alt="Adicionar"></a></th>
    </tr>
    <%= lista %>
</table>
</div>
<script>
    function eliminar(id) {
        if (confirm("¿Realmente desea eliminar este nivel competitivo " + id + " del sistema?")) {
            document.location = "principal.jsp?CONTENIDO=nivelCompetitivoActualizar.jsp&accion=Eliminar&id=" + id;
        }
    }
</script>
