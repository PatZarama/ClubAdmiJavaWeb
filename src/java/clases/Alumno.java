
package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alumno extends Persona {
    private String genero;
    private String seguroMedico;
    private String nivel;
    private String categoria;

    public Alumno() {
    }
    
    
    public Alumno(String identificacion) {
        String cadenaSQL = "select genero, seguroMedico, nivel, categoria from alumno where identificacion=" + identificacion;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                genero = resultado.getString("genero");
                seguroMedico = resultado.getString("seguroMedico");
                nivel = resultado.getString("nivel");
                categoria = resultado.getString("categoria");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la identificacion" + ex.getMessage());
        }

    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
        
    public String getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(String seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Alumno{" + '}';
    }
    
    public boolean grabar() {
        String cadenaSQL = "INSERT INTO alumno (genero, seguroMedico, nivel, categoria) "
                + "VALUES ('" 
                + genero + "', '" 
                + seguroMedico + "', '"
                + nivel + "', '"
                + categoria + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public boolean modificar(String identificacionAnterior) {
        String cadenaSQL = "UPDATE alumno SET genero='"+genero
                + "' ,seguroMedico='" + seguroMedico 
                + "' ,nivel='" + nivel
                + "' ,categoria='" + categoria
                + "' WHERE identificacion=" + identificacionAnterior;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
/*
    public boolean eliminar() {
        //String cadenaSQL = "DELETE FROM persona WHERE identificacion='" + identificacion + "'";
        //return ConectorBD.ejecutarQuery(cadenaSQL);
    }
*/
        public static ResultSet getLista(String filtro, String orden) {
        if(filtro !=null && filtro !="") filtro= " where " + filtro;
        else filtro=" ";
        if(orden!=null && orden!="") orden=" order by  "+ orden;
        else orden=" ";
        String cadenaSQL="SELECT genero, seguroMedico, nivel, categoria FROM alumno "+ filtro + orden;
 
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<Alumno> getListaEnObjetos() {
        List<Alumno> lista = new ArrayList<>();
        ResultSet datos = Alumno.getLista(null,null);
        if(datos!=null){
            try {
                while(datos.next()){
                Alumno alumno = new Alumno();
                alumno.setGenero(datos.getString("genero"));
                alumno.setSeguroMedico(datos.getString("seguroMedico"));
                lista.add(alumno);
                }
             } catch (SQLException ex) {
                Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}

