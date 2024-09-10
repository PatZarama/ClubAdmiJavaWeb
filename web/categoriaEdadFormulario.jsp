<%@page import="clases.CategoriaPorEdad"%>
<%
String accion = request.getParameter("accion");
String id = "Sin generar";
String nombre = "";
int edadInicial = 0;  // Cambiado a int
int edadLimite = 0;   // Cambiado a int

if ("Modificar".equals(accion)) {
    id = request.getParameter("id");
    CategoriaPorEdad categoriaPorEdad = new CategoriaPorEdad(id);
    nombre = categoriaPorEdad.getNombre();
    edadInicial = categoriaPorEdad.getEdadInicial();  // Cambiado a int
    edadLimite = categoriaPorEdad.getEdadLimite();    // Cambiado a int
}
%>
<div id="banner">
<h3><%=accion.toUpperCase()%> CATEGORIA</h3>
<form name="formulario" method="post" action="principal.jsp?CONTENIDO=categoriaEdadActualizar.jsp">
    <table border="0">
        <tr><th>Id</th><td><%=id%></td></tr>
        <tr><th>Nombre</th><td><input type="text" name="nombre" value="<%=nombre%>" size="50" maxlength="50" required></td></tr>
        <tr><th>Edad inicial</th><td><input type="number" name="edadInicial" value="<%=edadInicial%>" min="0" max="120" required></td></tr>
        <tr><th>Edad límite</th><td><input type="number" name="edadLimite" value="<%=edadLimite%>" min="0" max="120" required></td></tr>
    </table>
    <input type="hidden" name="id" value="<%=id%>">
    <input type="submit" name="accion" value="<%=accion%>">
</form>
</div>
