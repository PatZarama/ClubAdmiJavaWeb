/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Johan Guaquez
 */
public class CategoriaDeJuego {

    private String id;
    private String nombreCategoria;
    private String numeroJugadores;
    private String tipoCancha;

    public CategoriaDeJuego() {
    }
    
    public CategoriaDeJuego(String id) {
        String cadenaSQL="select nombreCategoria, numeroJugadores, tipoCancha from CategoriaDeJuego where id="+id;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()){
                this.id=id;
                nombreCategoria=resultado.getString("nombreCategoria");
                numeroJugadores=resultado.getString("numeroJugadores");
                tipoCancha=resultado.getString("tipoCancha");
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoriaPorEdad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(String numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public String getTipoCancha() {
        return tipoCancha;
    }

    public void setTipoCancha(String tipoCancha) {
        this.tipoCancha = tipoCancha;
    }
    
    public boolean grabar (){
        String cadenaSQL = "insert into CategoriaDeJuego (nombreCategoria, numeroJugadores, tipoCancha) values ('"+nombreCategoria+"','"+numeroJugadores+"','"+tipoCancha+"')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
     public boolean modificar (){
        String cadenaSQL = "update CategoriaDeJuego set nombreCategoria = '"+nombreCategoria+"', numeroJugador ='"+numeroJugadores+"', tipoCancha ='"+tipoCancha+"' where id="+ id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
     public boolean eliminar(){
        String cadeaSQL = "delete from CategoriaDeJuego where id="+id;
        return ConectorBD.ejecutarQuery(cadeaSQL);
    }
     public static ResultSet getlista(String filtro, String orden) {
        if (filtro!=null && filtro !="") filtro= " where "+ filtro;
        else filtro="";
        if (orden!= null && orden!="") orden=" order by "+ orden;
        else orden="";
        String cadenaSQL="select id, nombreCategoria, numeroJugadores, tipoCancha from CategoriaPorEdad"+filtro+orden;
        return ConectorBD.consultar(cadenaSQL);
    }
     public static List<CategoriaDeJuego> getListaEnObjetos(String filtro, String orden){
      List<CategoriaDeJuego> lista=new ArrayList<>();
      ResultSet datos=CategoriaDeJuego.getlista(filtro, orden);
      if(datos!=null){
          try {
              while(datos.next()){
                  CategoriaDeJuego categoriaDeJuego=new CategoriaDeJuego();
                  categoriaDeJuego.setId(datos.getString("id"));
                  categoriaDeJuego.setNombreCategoria(datos.getString("nombreCategoria"));
                  categoriaDeJuego.setNumeroJugadores(datos.getString("numeroJugadores"));
                  categoriaDeJuego.setTipoCancha(datos.getString("tipoCancha"));
                  lista.add(categoriaDeJuego);
              }
          } catch (SQLException ex) {
              Logger.getLogger(CategoriaPorEdad.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      return lista;
    }
}

    

