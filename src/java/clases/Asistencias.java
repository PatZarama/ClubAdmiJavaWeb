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
        
public class Asistencias {
    
    private String id;
    private String estado;
    private String fecha;
    private String idHorario;
    private String idAlumno;
        
    public  Asistencias (){
   }
    public Asistencias(String id) {
        String cadenaSQL = "select estado,fecha,idHorarios,idAlumno from Asistencias where id=" + id;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                this.id=id;
                estado=resultado.getString("estado");
                fecha=resultado.getString("fecha");
                idHorario=resultado.getString("idHorario");
                idAlumno=resultado.getString("idAlumno");   
            }
        } catch (SQLException ex) {
            Logger.getLogger(Asistencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public String toString() {
        return "Asistencias{" + '}';
    }
       public boolean grabar(){
    String cadenaSQL= "insert into Asistencias (estado,fecha,idHorario,idAlumno) values (' "+estado+" ',' "+fecha+" ','"+idHorario+"','" +idAlumno+"')";
    return ConectorBD.ejecutarQuery(cadenaSQL);
}
    public boolean modificar() {
    String cadenaSQL = "update Asistencias set estado='"+estado+"', fecha='"+fecha+"', idHorario='"+idHorario+ "', idAlumno='"+idAlumno+"' where id ="+id;
    return ConectorBD.ejecutarQuery(cadenaSQL);
    
}
    public boolean eliminar(){
        String cadenaSQL="delete from Asistencias where id="+id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
    public static ResultSet getLista(String filtro, String orden){
        if(filtro!=null && filtro!="")orden=" order by "+orden;
        else filtro="";
        if(orden!=null && orden!="")orden=" order by "+orden;
        else orden ="";
        String cadenaSQL="select id, estado, fecha,idHorario, idAlumno from Asistencias "+filtro+orden;
        return ConectorBD.consultar(cadenaSQL);
    }
    
    public static List<Asistencias> getListaEnObjetos(String filtro, String orden){
        List<Asistencias> lista = new ArrayList<>();
        ResultSet datos = Asistencias.getLista(filtro, orden);
        if(datos!=null){
            try{
                while(datos.next()){
                    Asistencias asistencias = new Asistencias();
                    asistencias.setId(datos.getString("id"));
                    asistencias.setEstado(datos.getString("estado"));
                    asistencias.setFecha(datos.getString("fecha"));
                     asistencias.setIdHorario(datos.getString("idHorario"));
                      asistencias.setIdAlumno(datos.getString("idAlumno"));
                    lista.add(asistencias);
                    
                }
            }catch(SQLException ex){
                Logger.getLogger(Asistencias.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        return lista;
        
    }
    
                            
}
