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
public class Institucion {

    private int id;
    private String nombre;
    private String direccion;
    private int diaLimitePago;
    private int pension;

    public Institucion() {
    }

    public Institucion(int id) {
        String cadenaSQL = "select nombre, direccion, diaLimitePago, pension from institucion where id=" + id;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                this.id = id;
                nombre = resultado.getString("nombre");
                direccion = resultado.getString("direccion");
                diaLimitePago = resultado.getInt("diaLimitePago");
                pension = resultado.getInt("pension");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Institucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDiaLimitePago() {
        return diaLimitePago;
    }

    public void setDiaLimitePago(int diaLimitePago) {
        this.diaLimitePago = diaLimitePago;
    }

    public int getPension() {
        return pension;
    }

    public void setPension(int pension) {
        this.pension = pension;
    }

    public boolean grabar() {
        String cadenaSQL = "insert into institucion (nombre, direccion, diaLimitePago, pension) values ('"
                + nombre + "', '" + direccion + "', " + diaLimitePago + ", " + pension + ")";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "update institucion set nombre = '" + nombre + "', direccion = '"
                + direccion + "', diaLimitePago = " + diaLimitePago + ", pension = " + pension
                + " where id = " + id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean eliminar() {
        String cadenaSQL = "delete from institucion where id = " + id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getlista(String filtro, String orden) {
        if (filtro != null && !filtro.isEmpty()) filtro = " where " + filtro;
        else filtro = "";
        if (orden != null && !orden.isEmpty()) orden = " order by " + orden;
        else orden = "";
        String cadenaSQL = "select id, nombre, direccion, diaLimitePago, pension from institucion" + filtro + orden;
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<Institucion> getListaEnObjetos(String filtro, String orden) {
        List<Institucion> lista = new ArrayList<>();
        ResultSet datos = Institucion.getlista(filtro, orden);
        if (datos != null) {
            try {
                while (datos.next()) {
                    Institucion institucion = new Institucion();
                    institucion.setId(datos.getInt("id"));
                    institucion.setNombre(datos.getString("nombre"));
                    institucion.setDireccion(datos.getString("direccion"));
                    institucion.setDiaLimitePago(datos.getInt("diaLimitePago"));
                    institucion.setPension(datos.getInt("pension"));
                    lista.add(institucion);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Institucion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
