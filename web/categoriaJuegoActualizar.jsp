<%-- 
    Document   : categoriaJuegoActualizar
    Created on : 6/09/2024, 04:16:14 PM
    Author     : Johan Guaquez
--%>
<%@page import="clases.CategoriaDeJuego"%>


<%
    String accion = request.getParameter("accion");
    String nombreCategoria = request.getParameter("nombreCategoria");  // Cambiado a int// Cambiado a int
    String numeroJugadores = request.getParameter("numeroJugadores"); 
    String idTipoCancha= request.getParameter("idTipoCancha");
    CategoriaDeJuego categoriaDeJuego = new CategoriaDeJuego();
    categoriaDeJuego.setNombreCategoria(nombreCategoria);
    categoriaDeJuego.setNumeroJugadores(numeroJugadores);  // Cambiado a int
    categoriaDeJuego.setIdTipoCancha(idTipoCancha);    // Cambiado a int
    switch (accion) {
        case "Adicionar":
            categoriaDeJuego.grabar();
            break;
        case "Modificar":
            categoriaDeJuego.setId(request.getParameter("id"));
            categoriaDeJuego.modificar();
            break;
        case "Eliminar":
            categoriaDeJuego.setId(request.getParameter("id"));
            categoriaDeJuego.eliminar();
            break;
    }
%>
<script type="text/javascript">
    document.location="principal.jsp?CONTENIDO=Categorias/categoriaJuego.jsp";
</script>
