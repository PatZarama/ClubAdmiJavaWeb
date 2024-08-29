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
public class Usuarios {
    
    private String identificacion;

    public Usuarios(String identificacion) {
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
            menu += "<li><a href='principal.jsp?CONTENIDO=categorias.jsp'>Categoría</a></li>";               
            menu += "<li><a href='principal.jsp?CONTENIDO=medioDePago.jsp'>Medios de pago</a></li>";              
            menu += "<li><a href='principal.jsp?CONTENIDO=usuarios.jsp'>Usuarios</a></li>";               
            menu += "<li><a href='principal.jsp?CONTENIDO=clientes.jsp'>Clientes</a></li>";               
            menu += "<li><a href='principal.jsp?CONTENIDO=productos.jsp'>Producto</a></li>";                
            menu += "<li><a href='principal.jsp?CONTENIDO=ventas.jsp'>Ventas</a></li>";
            menu += "<li class='submenu'><a href='#'>Reportes</a>";
            menu += "<ul>";
            menu += "<li><a href='principal.jsp?CONTENIDO=reportes/productosMasVendidos.jsp'>Productos más vendidos</a></li>";
            menu += "<li><a href='principal.jsp?CONTENIDO=reportes/productosMenosVendidos.jsp'>Productos menos vendidos</a></li>";
            menu += "</ul></li>";
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

    
           



