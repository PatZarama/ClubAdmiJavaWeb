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
 * @author Jhonny Rojas
 */
public class NivelCompetitivo {
    private String id;
    private String nombre;
    private String descripcion;
    
    public NivelCompetitivo() {
    }

    public NivelCompetitivo(String id) {
    String cadenaSQL = "select id, nombre, descripcion from NivelCompetitivo where id=" + id;
    ResultSet resultado = ConectorBD.consultar(cadenaSQL);
    
    try {
        if (resultado.next()) {
            this.id = id;
            nombre = resultado.getString("nombre");
            descripcion = resultado.getString("descripcion");
        }
    } catch (SQLException ex) {
        Logger.getLogger(NivelCompetitivo.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    // Setters y Getters

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos para las operaciones CRUD
    
    public boolean grabar() {
        String cadenaSQL = "insert into NivelCompetitivo (id, nombre, descripcion) values ('" + id + "','" + nombre + "','" + descripcion + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "update NivelCompetitivo set nombre='" + nombre + "', descripcion='" + descripcion + "' where id='" + id + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean eliminar() {
        String cadenaSQL = "delete from NivelCompetitivo where id='" + id + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getLista(String filtro, String orden) {
        if (filtro != null && filtro != "") filtro = " where " + filtro;
        else filtro = "";
        if (orden != null && orden != "") orden = " order by " + orden;
        else orden = "";
        String cadenaSQL = "select id, nombre, descripcion from NivelCompetitivo" + filtro + orden;
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<NivelCompetitivo> getListaEnObjetos(String filtro, String orden) {
        List<NivelCompetitivo> lista = new ArrayList<>();
        ResultSet datos = NivelCompetitivo.getLista(filtro, orden);
        if (datos != null) {
            try {
                while (datos.next()) {
                    NivelCompetitivo nivelCompetitivo = new NivelCompetitivo();
                    nivelCompetitivo.setId(datos.getString("id"));
                    nivelCompetitivo.setNombre(datos.getString("nombre"));
                    nivelCompetitivo.setDescripcion(datos.getString("descripcion"));
                    lista.add(nivelCompetitivo);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NivelCompetitivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}




