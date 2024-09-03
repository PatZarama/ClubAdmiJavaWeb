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
public class Horario {
    
    private String id;
    private String dia;
    private String horaInicio;
    private String horaFinal;
    private String idCategoriaPorEdad;
    private String idCategoriaJuego;
    private String idTipoCancha;
    private String idEntrenador;

    public Horario() {
    }
    public Horario(String id) {
        String cadenaSQL="select dia, horaIncio, horaFinal, idCategoriaPorEdad, idCategoriaJuego, idTipoCancha, idEntrenador from Horario where id="+id;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()){
                this.id=id;
                dia=resultado.getString("dia");
                horaInicio=resultado.getString("horaFinal");
                idCategoriaPorEdad=resultado.getString("idCategoriaPorEdad");
                idCategoriaJuego=resultado.getString("idCategoriaJuego");
                idTipoCancha=resultado.getString("idTipoCancha");
                idEntrenador=resultado.getString("idEntrenador");
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getIdCategoriaPorEdad() {
        return idCategoriaPorEdad;
    }

    public void setIdCategoriaPorEdad(String idCategoriaPorEdad) {
        this.idCategoriaPorEdad = idCategoriaPorEdad;
    }

    public String getIdCategoriaJuego() {
        return idCategoriaJuego;
    }

    public void setIdCategoriaJuego(String idCategoriaJuego) {
        this.idCategoriaJuego = idCategoriaJuego;
    }

    public String getIdTipoCancha() {
        return idTipoCancha;
    }

    public void setIdTipoCancha(String idTipoCancha) {
        this.idTipoCancha = idTipoCancha;
    }

    public String getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }
    
    public boolean grabar (){
        String cadenaSQL = "insert into Horario (dia, horaFinal, idCategoriaPorEdad, idCategoriaJuego, idTipoCancha, idEntrenador) values ('"+dia+"','"+horaFinal+"','"+idCategoriaPorEdad+"','"+idCategoriaJuego+"','"+idTipoCancha+"','"+idEntrenador+"')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
     public boolean modificar (){
        String cadenaSQL = "update Horario set dia = '"+dia+"', horaFinal ='"+horaFinal+"', idCategoriaPorEdad ='"+idCategoriaPorEdad+"',idCategoriaJuego = '"+idCategoriaJuego+"', idTipoCancha ='"+idTipoCancha+"', idEntrenador ='"+idEntrenador+"' where id="+ id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
     public boolean eliminar(){
        String cadeaSQL = "delete from Horario where id="+id;
        return ConectorBD.ejecutarQuery(cadeaSQL);
    }
     public static ResultSet getlista(String filtro, String orden) {
        if (filtro!=null && filtro !="") filtro= " where "+ filtro;
        else filtro="";
        if (orden!= null && orden!="") orden=" order by "+ orden;
        else orden="";
        String cadenaSQL="select id, dia, horaFinal, idCategoriaPorEdad, idCategoriaJuego, idTipoCancha, idEntrenador from Horario"+filtro+orden;
        return ConectorBD.consultar(cadenaSQL);
    }
     public static List<Horario> getListaEnObjetos(String filtro, String orden){
      List<Horario> lista=new ArrayList<>();
      ResultSet datos=Horario.getlista(filtro, orden);
      if(datos!=null){
          try {
              while(datos.next()){
                  Horario horario=new Horario();
                  horario.setId(datos.getString("id"));
                  horario.setNombreCategoria(datos.getString("nombreCategoria"));
                  horario.setNumeroJugadores(datos.getString("numeroJugadores"));
                  horario.setTipoCancha(datos.getString("tipoCancha"));
                  lista.add(horario);
              }
          } catch (SQLException ex) {
              Logger.getLogger(CategoriaPorEdad.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      return lista;
    }
}

    


    
    
}
