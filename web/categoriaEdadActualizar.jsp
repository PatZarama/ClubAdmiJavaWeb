<%-- 
    Document   : categoriaEdadActualizar
    Created on : 5/09/2024, 02:10:06 PM
    Author     : Johan Guaquez
--%>

<%@page import="clases.CategoriaPorEdad"%>
<%
    String accion = request.getParameter("accion");
    String nombre = request.getParameter("nombre");
    int edadInicial = Integer.parseInt(request.getParameter("edadInicial"));  // Cambiado a int
    int edadLimite = Integer.parseInt(request.getParameter("edadLimite"));    // Cambiado a int
    CategoriaPorEdad categoriaPorEdad = new CategoriaPorEdad();
    categoriaPorEdad.setNombre(nombre);
    categoriaPorEdad.setEdadInicial(edadInicial);  // Cambiado a int
    categoriaPorEdad.setEdadLimite(edadLimite);    // Cambiado a int
    switch (accion) {
        case "Adicionar":
            categoriaPorEdad.grabar();
            break;
        case "Modificar":
            categoriaPorEdad.setId(request.getParameter("id"));
            categoriaPorEdad.modificar();
            break;
        case "Eliminar":
            categoriaPorEdad.setId(request.getParameter("id"));
            categoriaPorEdad.eliminar();
            break;
    }
%>
<script type="text/javascript">
    document.location="principal.jsp?CONTENIDO=Categorias/categoriaEdad.jsp";
</script>
