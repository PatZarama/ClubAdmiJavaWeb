/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
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
        String cadenaSQL = "update CategoriaPorEdad set nombre = '"+nombre+"', edadInicial ='"+edadInicial+"', edadLimite ='"+edadLimite+"' where id="+ id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
     public boolean eliminar(){
        String cadeaSQL = "delete from CategoriaPorEdad where id="+id;
        return ConectorBD.ejecutarQuery(cadeaSQL);
    }
    
    
}
