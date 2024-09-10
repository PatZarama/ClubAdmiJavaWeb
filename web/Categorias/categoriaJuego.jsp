<%-- 
    Document   : categoriaJuego
    Created on : 6/09/2024, 04:06:29 PM
    Author     : Johan Guaquez
--%>

<%@page import="clases.CategoriaDeJuego"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String lista = "";
    List<CategoriaDeJuego> datos = CategoriaDeJuego.getListaEnObjetos(null, null);
    for (CategoriaDeJuego categoriaDeJuego : datos) {
        lista += "<tr>";
        lista += "<td>" + categoriaDeJuego.getId() + "</td>";
        lista += "<td>" + categoriaDeJuego.getNombreCategoria() + "</td>";
        lista += "<td>" + categoriaDeJuego.getNumeroJugadores() + "</td>";
        lista += "<td>" + categoriaDeJuego.getIdTipoCancha()+ "</td>";
        lista += "<td>";
        lista += "<a href='principal.jsp?CONTENIDO=categoriaJuegoFormulario.jsp&accion=Modificar&id=" + categoriaDeJuego.getId() + 
                 "' title='Modificar'> <img src='presentacion/imagenes/modificar.png'></a>";
        lista += "<img src='presentacion/imagenes/eliminar.png' title='Eliminar' onClick='eliminar(" + categoriaDeJuego.getId() + ")'>";
        lista += "</td>";
        lista += "</tr>";
    }
%>
<div id="banner">
<h3>CATEGORIAS DE JUEGO</h3>
<table border="1">
    <tr>
        <th>ID</th><th>Nombre categoria</th><th>Numero Jugadores</th><th>Tipo cancha</th>
        <th><a href="principal.jsp?CONTENIDO=categoriaJuegoFormulario.jsp&accion=Adicionar" title="Adicionar">
                <img src="presentacion/imagenes/agregar.png"></a></th>
    </tr>
    <%= lista %>
</table>
</div>
<script>
    function eliminar(id) {
        let resultado = confirm("¿Realmente desea eliminar esta categoría de edades " + id + " del sistema?");
        if (resultado) {
            document.location = "principal.jsp?CONTENIDO=categoriaJuegoActualizar.jsp&accion=Eliminar&id=" + id;
        }          
    }
</script>
