package clases;


import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoriaPorEdad {
    private String id;
    private String nombre;
    private String edadInicial;
    private String edadLimite;

    public CategoriaPorEdad() {
    }

    public CategoriaPorEdad(String id) {
        String cadenaSQL="select nombre, edadIInicial, edadLimite from CategoriaPorEdad where id="+id;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()){
                this.id=id;
                nombre=resultado.getString("nombre");
                edadInicial=resultado.getString("edadInicial");
                edadLimite=resultado.getString("edadFinal");
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdadInicial() {
        return edadInicial;
    }

    public void setEdadInicial(String edadInicial) {
        this.edadInicial = edadInicial;
    }

    public String getEdadLimite() {
        return edadLimite;
    }

    public void setEdadLimite(String edadLimite) {
        this.edadLimite = edadLimite;
    }
    @Override
    public String toString(){
        return  nombre;
    }

     public boolean grabar (){
        String cadenaSQL = "insert into CategoriaPorEdad (nombre, edadInicial, edadLimite) values ('"+nombre+"','"+edadInicial+"','"+edadLimite+"')";
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
     public static ResultSet getlista(String filtro, String orden) {
        if (filtro!=null && filtro !="") filtro= " where "+ filtro;
        else filtro="";
        if (orden!= null && orden!="") orden=" order by "+ orden;
        else orden="";
        String cadenaSQL="select id, nombre, fechaInicio, fechaLimite from CategoriaPorEdad"+filtro+orden;
        return ConectorBD.consultar(cadenaSQL);
    }
     public static List<CategoriaPorEdad> getListaEnObjetos(String filtro, String orden){
      List<CategoriaPorEdad> lista=new ArrayList<>();
      ResultSet datos=CategoriaPorEdad.getlista(filtro, orden);
      if(datos!=null){
          try {
              while(datos.next()){
                  CategoriaPorEdad categoriaPorEdad=new CategoriaPorEdad();
                  categoriaPorEdad.setId(datos.getString("id"));
                  categoriaPorEdad.setNombre(datos.getString("nombre"));
                  categoriaPorEdad.setEdadInicial(datos.getString("edadInicial"));
                  categoriaPorEdad.setEdadLimite(datos.getString("edadLimite"));
                  lista.add(categoriaPorEdad);
              }
          } catch (SQLException ex) {
              Logger.getLogger(CategoriaPorEdad.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      return lista;
    }
}

