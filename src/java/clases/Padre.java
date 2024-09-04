

package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Padre extends Persona {
    private String parentesco;
    private String identificacionPadre;

    public Padre() {
    }

    public Padre(String identificacion) {
        String cadenaSQL = "select parentesco, identificacionPadre from padre where identificacion=" + identificacion;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                parentesco = resultado.getString("parentesco");
                identificacionPadre = resultado.getString("identificacionPadre");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la identificacion" + ex.getMessage());
        }
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getIdentificacionPadre() {
        return identificacionPadre;
    }

    public void setIdentificacionPadre(String identificacionPadre) {
        this.identificacionPadre = identificacionPadre;
    }

    @Override
    public String toString() {
        return "Padre{" + "parentesco=" + parentesco + '}';
    }
    
    public boolean grabar() {
        String cadenaSQL = "INSERT INTO padre (parentesco, identificacionPadreos) "
                + "VALUES ('" 
                + parentesco + "', '"  
                + identificacionPadre + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar(String identificacionAnterior) {
        String cadenaSQL = "UPDATE padre SET parentesco='"+parentesco
                + "', identificacionPadre='" + identificacionPadre 
                + "' WHERE identificacion=" + identificacionAnterior;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
/*
    public boolean eliminar() {
        String cadenaSQL = "DELETE FROM padre WHERE identificacion='" + identificacion + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
*/
    public static ResultSet getLista(String filtro, String orden) {
        if(filtro!=null && filtro !="") filtro= " where " + filtro;
        else filtro=" ";
        if(orden!=null && orden!="") orden=" order by  "+ orden;
        else orden=" ";
        String cadenaSQL="SELECT parentesco, identificacionPadre from padre FROM persona "+ filtro + orden;
 
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<Padre> getListaEnObjetos() {
        List<Padre> lista = new ArrayList<>();
        ResultSet datos = Padre.getLista(null, null);
        if(datos!=null){
            try {
                while(datos.next()){
                Padre padre = new Padre();
                padre.setParentesco(datos.getString("parentesco"));
                padre.setIdentificacionPadre(datos.getString("identificacionPadre"));
                lista.add(padre);
                }
             } catch (SQLException ex) {
                Logger.getLogger(Padre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    
}

