
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Johan Guaquez
 */
public class TipoPersona {
    
    private String identificacion;

    public TipoPersona(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
   
    public String getNombre(){
        String nombre= null;
        switch (identificacion){
            case "A" : nombre ="Administrador"; break;
            case "E" : nombre ="Entrenador"; break;
            default : nombre ="Desconocido"; break;
        }
        return nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }
   
    public String getMenu() {
    String menu = "<ul class='menu'>";
    menu += "<li><a href='principal.jsp?CONTENIDO=inicio.jsp'>Inicio</a></li>";
    
    switch(this.identificacion) {
        case "A":
            menu += "<li class='submenu'><a href='#'>Categorias</a>";
            menu += "<ul>";
            menu += "<li><a href='principal.jsp?CONTENIDO=Categorias/categoriaJuego.jsp'>Categoría de juego</a></li>";               
            menu += "<li><a href='principal.jsp?CONTENIDO=Categorias/tipoCancha.jsp'>Tipos de canchas</a></li>";              
            menu += "<li><a href='principal.jsp?CONTENIDO=Categorias/tipoPrueba.jsp'>Tipos de pruebas</a></li>";               
            menu += "<li><a href='principal.jsp?CONTENIDO=Categorias/nivelCompetitivo.jsp'>Nivel competitivo</a></li>"; 
            menu += "</ul></li>";
            menu += "<li class='submenu'><a href='#'>Usuarios</a>";
            menu += "<ul>";
            menu += "<li><a href='principal.jsp?CONTENIDO=Usuarios/entrenadores.jsp'>Entrenadores</a></li>";
            menu += "<li><a href='principal.jsp?CONTENIDO=Usuarios/alumnos.jsp'>Alumnos</a></li>";
            menu += "<li><a href='principal.jsp?CONTENIDO=Usuarios/padres.jsp'>Padres</a></li>";
            menu += "</ul></li>";
            menu += "<li><a href='principal.jsp?CONTENIDO=asistencias.jsp'>Asistencias</a></li>"; 
            menu += "<li><a href='principal.jsp?CONTENIDO=pagos.jsp'>Pagos</a></li>";
            menu += "<li class='submenu'><a href='#'>Indicadores</a>";
            menu += "<ul>";
            menu += "<li><a href='principal.jsp?CONTENIDO=indicadores/ventas.jsp'>Ventas</a></li>";
            
            menu += "</ul></li>";            
            break;          
        case "V":
            menu += "<li><a href='principal.jsp?CONTENIDO=clientes.jsp'>Clientes</a></li>";
            menu += "<li><a href='principal.jsp?CONTENIDO=ventas.jsp'>Ventas</a></li>";
            break;
    }
    
    menu += "<li><a href='index.jsp'>Salir</a></li>";
    menu += "</ul>";
    
    return menu;
}


   
    public String getListaEnOptions() {
    String lista = "";
    if (identificacion == null) identificacion = "";
    switch (identificacion) {
        case "A":
            lista = "<option value='A' selected>Administrador</option><option value='V'>Vendedor</option><option value='C'>Cliente</option>";
            break;
        case "V":
            lista = "<option value='A'>Administrador</option><option value='V' selected>Vendedor</option><option value='C'>Cliente</option>";
            break;
        default:
            lista = "<option value='A'>Administrador</option><option value='V'>Vendedor</option><option value='C'>Cliente</option>";
            break;
    }
    return lista;
}
 
}