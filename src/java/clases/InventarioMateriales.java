
package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventarioMateriales {

    private String id;
    private String idInventario;
    private String idEntregaMateriales;
    private String cantidad;
    private String reintegrado;
    private String observacionesPrestamo;
    private String observacionesReintegro;

    public InventarioMateriales() {
    }

    public InventarioMateriales(String id) {
        String cadenaSQL = "select idInventario, idEntregaMateriales, cantidad, reintegrado, observacionesPrestamo, observacionesReintegro from InventarioMateriales where id=" + id;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                this.id = id;
                idInventario = resultado.getString("idInventario");
                idEntregaMateriales = resultado.getString("idEntregaMateriales");
                cantidad = resultado.getString("cantidad");
                reintegrado = resultado.getString("reintegrado");
                observacionesPrestamo = resultado.getString("observacionesPrestamo");
                observacionesReintegro = resultado.getString("observacionesReintegro");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consulta el id " + ex.getMessage());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(String idInventario) {
        this.idInventario = idInventario;
    }

    public String getIdEntregaMateriales() {
        return idEntregaMateriales;
    }

    public void setIdEntregaMateriales(String idEntregaMateriales) {
        this.idEntregaMateriales = idEntregaMateriales;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getReintegrado() {
        return reintegrado;
    }

    public void setReintegrado(String reintegrado) {
        this.reintegrado = reintegrado;
    }

    public String getObservacionesPrestamo() {
        return observacionesPrestamo;
    }

    public void setObservacionesPrestamo(String observacionesPrestamo) {
        this.observacionesPrestamo = observacionesPrestamo;
    }

    public String getObservacionesReintegro() {
        return observacionesReintegro;
    }

    public void setObservacionesReintegro(String observacionesReintegro) {
        this.observacionesReintegro = observacionesReintegro;
    }

    @Override
    public String toString() {
        return "InventarioMateriales{" + '}';
    }
    
    
    public boolean grabar() {
        String cadenaSQL = "insert into InventarioMateriales (idInventario, idEntregaMateriales, "
                + "cantidad, reintegrado, observacionesPrestamo, observacionesReintegro) values ('"
                + idInventario + "','"
                + idEntregaMateriales + "','"
                + cantidad + "','"
                + reintegrado + "','"
                + observacionesPrestamo + "','"
                + observacionesReintegro + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "update InventarioMateriales set idInventario='" + idInventario
                + "', idEntregaMateriales='" + idEntregaMateriales                
                + "', cantidad='" + cantidad
                + "', reintegrado='" + reintegrado
                + "', observacionesPrestamo='" + observacionesPrestamo
                + "', observacionesReintegro='" + observacionesReintegro
                + "' where id=" + id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean eliminar() {
        String cadenaSQL = "delete from InventarioMateriales where id=" + id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getLista(String filtro, String orden) {
        if (filtro != null && filtro != " ") {
            filtro = " where " + filtro;
        } else {
            filtro = " ";
        }
        if (orden != null && orden != " ") {
            orden = " order by  " + orden;
        } else {
            orden = " ";
        }
        String cadenaSQL = "select idInventario, idEntregaMateriales, cantidad, reintegrado, observacionesPrestamo, observacionesReintegro from InventarioMateriales " + filtro + orden;
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<InventarioMateriales> getListaEnObjetos(String filtro, String orden) {
        List<InventarioMateriales> lista = new ArrayList<>();//inicializacion de esta coleccion de datos
        ResultSet datos = InventarioMateriales.getLista(filtro, orden);
        if (datos != null) {
            try {
                while (datos.next()) {
                    InventarioMateriales invent = new InventarioMateriales();
                    invent.setId(datos.getString("id"));
                    invent.setIdInventario(datos.getString("idInventario"));
                    invent.setIdEntregaMateriales(datos.getString("cantidad"));
                    invent.setCantidad(datos.getString("estado"));
                    invent.setReintegrado(datos.getString("estado"));
                    invent.setObservacionesPrestamo(datos.getString("estado"));
                    invent.setObservacionesReintegro(datos.getString("estado"));
                    lista.add(invent);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InventarioMateriales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

}
