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
public class Notificaciones {
    private String id;
    private String fecha;
    private String titulo;
    private String descripcion;
    private String vista;
    private String identificacionUsuario;
    
    public Notificaciones() {
    }

    public Notificaciones(String id) {
    String cadenaSQL = "select id, fecha, titulo, descripcion, vista, identificacionUsuario from Notificaciones where id=" + id;
    ResultSet resultado = ConectorBD.consultar(cadenaSQL);
    
    try {
        if (resultado.next()) {
            this.id = id;
            fecha = resultado.getString("fecha");
            titulo = resultado.getString("titulo");
            descripcion = resultado.getString("descripcion");
            vista = resultado.getString("vista");
            identificacionUsuario = resultado.getString("identificacionUsuario");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public boolean grabar() {
        String cadenaSQL = "insert into Notificaciones (id, fecha, titulo, descripcion, vista, identificacionUsuario) values ('" 
                            + id + "','" + fecha + "','" + titulo + "','" + descripcion + "','" + vista + "','" + identificacionUsuario + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "update Notificaciones set fecha='" + fecha + "', titulo='" + titulo + "', descripcion='" + descripcion 
                            + "', vista='" + vista + "', identificacionUsuario='" + identificacionUsuario + "' where id=" + id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean eliminar() {
        String cadenaSQL = "delete from Notificaciones where id=" + id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getLista(String filtro, String orden) {
        if (filtro != null && filtro != "") filtro = " where " + filtro;
        else filtro = "";
        if (orden != null && orden != "") orden = " order by " + orden;
        else orden = "";
        String cadenaSQL = "select id, fecha, titulo, descripcion, vista, identificacionUsuario from Notificaciones" + filtro + orden;
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<Notificaciones> getListaEnObjetos(String filtro, String orden) {
        List<Notificaciones> lista = new ArrayList<>();
        ResultSet datos = Notificaciones.getLista(filtro, orden);
        if (datos != null) {
            try {
                while (datos.next()) {
                    Notificaciones notificacion = new Notificaciones();
                    notificacion.setId(datos.getString("id"));
                    notificacion.setFecha(datos.getString("fecha"));
                    notificacion.setTitulo(datos.getString("titulo"));
                    notificacion.setDescripcion(datos.getString("descripcion"));
                    notificacion.setVista(datos.getString("vista"));
                    notificacion.setIdentificacionUsuario(datos.getString("identificacionUsuario"));
                    lista.add(notificacion);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
