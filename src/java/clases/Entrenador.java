package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import clasesGenericas.ConectorBD;

public class Entrenador extends Persona {

    private String fechaIngreso;
    private String fechaRetiro;

    public Entrenador() {
    }

    public Entrenador(String identificacion) {
        String cadenaSQL = "select fechaIngreso, fechaRetiro from entrenador where identificacion=" + identificacion;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                fechaIngreso = resultado.getString("fechaIngreso");
                fechaRetiro = resultado.getString("fechaRetiro");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la identificacion" + ex.getMessage());
        }

    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    @Override
    public String toString() {
        return "Entrenador{" + "fechaIngreso=" + fechaIngreso + ", fechaRetiro=" + fechaRetiro + '}';
    }
    
        public boolean grabar() {
        String cadenaSQL = "INSERT INTO entrenador (fechaIngreso, fechaRetiro) "
                + "VALUES ('" 
                + fechaIngreso + "', '" 
                + fechaRetiro + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public boolean modificar(String identificacionAnterior) {
        String cadenaSQL = "UPDATE entrenador SET fechaIngreso='"+fechaIngreso
                + "' ,fechaRetiro='" + fechaRetiro  
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
        String cadenaSQL="SELECT rol, claves FROM entrenador "+ filtro + orden;
 
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<Entrenador> getListaEnObjetos() {
        List<Entrenador> lista = new ArrayList<>();
        ResultSet datos = Entrenador.getLista(null,null);
        if(datos!=null){
            try {
                while(datos.next()){
                Entrenador entrenador = new Entrenador();
                entrenador.setFechaIngreso(datos.getString("FechaIngreso"));
                entrenador.setFechaRetiro(datos.getString("FechaRetiro"));
                lista.add(entrenador);
                }
             } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
