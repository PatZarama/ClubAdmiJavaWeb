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
 * @author 
 */
public class PrestamoMateriales {

    private int id;
    private String fecha;
    private String identificacionEntrenador;

    public PrestamoMateriales() {
    }

    public PrestamoMateriales(int id) {
        String cadenaSQL = "select fecha, identificacionEntrenador from PrestamoMateriales where id=" + id;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                this.id = id;
                fecha = resultado.getString("fecha");
                identificacionEntrenador = resultado.getString("identificacionEntrenador");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoMateriales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdentificacionEntrenador() {
        return identificacionEntrenador;
    }

    public void setIdentificacionEntrenador(String identificacionEntrenador) {
        this.identificacionEntrenador = identificacionEntrenador;
    }

    public boolean grabar() {
        String cadenaSQL = "insert into PrestamoMateriales (fecha, identificacionEntrenador) values ('"
                + fecha + "', '" + identificacionEntrenador + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "update PrestamoMateriales set fecha = '" + fecha + "', identificacionEntrenador = '"
                + identificacionEntrenador + "' where id = " + id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean eliminar() {
        String cadenaSQL = "delete from PrestamoMateriales where id = " + id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getlista(String filtro, String orden) {
        if (filtro != null && !filtro.isEmpty()) filtro = " where " + filtro;
        else filtro = "";
        if (orden != null && !orden.isEmpty()) orden = " order by " + orden;
        else orden = "";
        String cadenaSQL = "select id, fecha, identificacionEntrenador from PrestamoMateriales" + filtro + orden;
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<PrestamoMateriales> getListaEnObjetos(String filtro, String orden) {
        List<PrestamoMateriales> lista = new ArrayList<>();
        ResultSet datos = PrestamoMateriales.getlista(filtro, orden);
        if (datos != null) {
            try {
                while (datos.next()) {
                    PrestamoMateriales prestamo = new PrestamoMateriales();
                    prestamo.setId(datos.getInt("id"));
                    prestamo.setFecha(datos.getString("fecha"));
                    prestamo.setIdentificacionEntrenador(datos.getString("identificacionEntrenador"));
                    lista.add(prestamo);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PrestamoMateriales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}

