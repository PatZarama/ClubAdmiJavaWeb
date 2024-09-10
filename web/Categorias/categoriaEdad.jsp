<%@page import="clases.CategoriaPorEdad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String lista = "";
    List<CategoriaPorEdad> datos = CategoriaPorEdad.getListaEnObjetos(null, null);
    for (CategoriaPorEdad categoriaPorEdad : datos) {
        lista += "<tr>";
        lista += "<td>" + categoriaPorEdad.getId() + "</td>";
        lista += "<td>" + categoriaPorEdad.getNombre() + "</td>";
        lista += "<td>" + categoriaPorEdad.getEdadInicial() + "</td>";
        lista += "<td>" + categoriaPorEdad.getEdadLimite() + "</td>";
        lista += "<td>";
        lista += "<a href='principal.jsp?CONTENIDO=categoriaEdadFormulario.jsp&accion=Modificar&id=" + categoriaPorEdad.getId() + 
                 "' title='Modificar'> <img src='presentacion/imagenes/modificar.png'></a>";
        lista += "<img src='presentacion/imagenes/eliminar.png' title='Eliminar' onClick='eliminar(" + categoriaPorEdad.getId() + ")'>";
        lista += "</td>";
        lista += "</tr>";
    }
%>
<div id="banner">
<h3>CATEGORIAS POR EDAD</h3>
<table border="1">
    <tr>
        <th>ID</th><th>Nombre</th><th>Edad inicial</th><th>Edad límite</th>
        <th><a href="principal.jsp?CONTENIDO=categoriaEdadFormulario.jsp&accion=Adicionar" title="Adicionar">
                <img src="presentacion/imagenes/agregar.png"></a></th>
    </tr>
    <%= lista %>
</table>
</div>
<script>
    function eliminar(id) {
        let resultado = confirm("¿Realmente desea eliminar esta categoría de edades " + id + " del sistema?");
        if (resultado) {
            document.location = "principal.jsp?CONTENIDO=categoriaEdadActualizar.jsp&accion=Eliminar&id=" + id;
        }          
    }
</script>
