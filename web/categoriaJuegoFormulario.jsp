<%-- 
    Document   : categoriaJuegoFormulario
    Created on : 6/09/2024, 04:17:46 PM
    Author     : Johan Guaquez
--%>
<%@page import="clases.TipoCancha"%>
<%@page import="clases.CategoriaDeJuego"%>
<%
String accion = request.getParameter("accion");
String id = request.getParameter("id");
CategoriaDeJuego categoriaDeJuego = new CategoriaDeJuego();

if (accion.equals("Modificar") && id != null) {
    categoriaDeJuego = new CategoriaDeJuego(id);   
} else {
    categoriaDeJuego.setId("Sin generar");
}
%>
<div id="banner">
    <h3><%=accion.toUpperCase()%> CATEGORIA DE JUEGO</h3>
    <form name="formulario" method="post" action="categoriaJuegoProcesar.jsp">
        <table border="0">
            <tr><th>ID</th><td><%=categoriaDeJuego.getId()%></td></tr>

            <tr><th>NOMBRE CATEGORIA</th><td><input type="text" name="nombre" value="<%=categoriaDeJuego.getNombreCategoria()%>" maxlength="50" size="50" required></td></tr>

            <tr><th>NUMERO DE JUGADORES</th><td><input type="number" name="numeroJugadores" value="<%=categoriaDeJuego.getNumeroJugadores()%>" required></td></tr>

            <tr><th>TIPO DE CANCHA</th><td><select name="idTipoCancha"><%=TipoCancha.getListaEnOptions(categoriaDeJuego.getIdTipoCancha())%></select></td></tr>
        </table>

        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="accion" value="<%=accion%>">
        <input type="submit" value="<%=accion%>">
    </form>
</div>
