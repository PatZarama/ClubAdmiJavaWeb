
package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario extends Persona {

    private String rol;
    private String claves;

    public Usuario() {
    }

    public Usuario(String identificacion) {
        String cadenaSQL = "select rol, claves from usuario where identificacion=" + identificacion;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                rol = resultado.getString("rol");
                claves = resultado.getString("claves");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la identificacion" + ex.getMessage());
        }

    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getClaves() {
        String resultado=claves;
        if(claves==null) resultado="";
        return resultado;
    }

    public void setClaves(String claves) {
        this.claves = claves;
    }

    @Override
    public String toString() {
        return "Usuario{" + "rol=" + rol + ", claves=" + claves + '}';
    }
    
    public boolean grabar() {
        String cadenaSQL = "INSERT INTO usuario (rol, claves) "
                + "VALUES ('" 
                + rol + "', '" 
                + claves + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public boolean modificar(String identificacionAnterior) {
        String cadenaSQL = "UPDATE usuario SET rol='"+rol
                + "' ,claves='" + claves  
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
        String cadenaSQL="SELECT rol, claves FROM usuario "+ filtro + orden;
 
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<Usuario> getListaEnObjetos() {
        List<Usuario> lista = new ArrayList<>();
        ResultSet datos = Usuario.getLista(null,null);
        if(datos!=null){
            try {
                while(datos.next()){
                Usuario usuario = new Usuario();
                usuario.setRol(datos.getString("rol"));
                usuario.setClaves(datos.getString("claves"));
                lista.add(usuario);
                }
             } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    
}

