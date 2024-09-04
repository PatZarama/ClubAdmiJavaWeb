package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona {

    private String identificacion;
    private String nombres;
    private String apellidos;
    private String fechaDeNacimiento;
    private String direccion;
    private String telefono;
    private String email;

    public Persona() {
    }

    public Persona(String identificacion) {
        String cadenaSQL = "select nombres, apellidos, fechaDeNacimiento, direccion, telefono, email "
                + "from persona where identificacion=" + identificacion;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                this.identificacion = identificacion;
                nombres = resultado.getString("nombres");
                apellidos = resultado.getString("apellidos");
                fechaDeNacimiento = resultado.getString("fechaDeNacimiento");
                direccion = resultado.getString("direccion");
                telefono = resultado.getString("telefono");
                email = resultado.getString("email");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la identificacion" + ex.getMessage());
        }

    }

    public String getIdentificacion() {
        String resultado = identificacion;
        if (identificacion == null) {
            resultado = "";
        }
        return resultado;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        String resultado = nombres;
        if (nombres == null) {
            resultado = "";
        }
        return resultado;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        String resultado = apellidos;
        if (apellidos == null) {
            resultado = "";
        }
        return resultado;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaDeNacimiento() {
        String resultado = fechaDeNacimiento;
        if (apellidos == null) {
            resultado = "";
        }
        return resultado;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getDireccion() {
        String resultado = direccion;
        if (direccion == null) {
            resultado = "";
        }
        return resultado;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        String resultado = telefono;
        if (telefono == null) {
            resultado = "";
        }
        return resultado;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        String resultado = email;
        if (email == null) {
            resultado = "";
        }
        return resultado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String datos = "";
        if (identificacion != null) {
            datos = identificacion + " - " + nombres + " " + apellidos;
        }
        return datos;
    }

    public boolean grabar() {
        String cadenaSQL = "INSERT INTO persona (nombres, apellidos, fechaDeNacimiento, direccion, telefono, email) "
                + "VALUES ('" 
                + nombres + "', '" 
                + apellidos + "', '" 
                + fechaDeNacimiento + "', '" 
                + direccion + "', '" 
                + telefono + "', '" 
                + email + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar(String identificacionAnterior) {
        String cadenaSQL = "UPDATE persona SET nombres='" + nombres 
                + "', apellidos='" + apellidos 
                + "', fechaDeNacimiento='" + fechaDeNacimiento 
                + "', direccion='" + direccion 
                + "', telefono='" + telefono 
                + "', email='" + email 
                + "' WHERE identificacion=" + identificacionAnterior;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean eliminar() {
        String cadenaSQL = "DELETE FROM persona WHERE identificacion='" + identificacion + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getLista(String filtro, String orden) {
        if(filtro!=null && filtro !="") filtro= " where " + filtro;
        else filtro=" ";
        if(orden!=null && orden!="") orden=" order by  "+ orden;
        else orden=" ";
        String cadenaSQL="SELECT identificacion, nombres, apellidos, fechaDeNacimiento, direccion, telefono, email "
                + "FROM persona "+ filtro + orden;
 
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<Persona> getListaEnObjetos(String filtro, String orden) {
        List<Persona> lista = new ArrayList<>();
        ResultSet datos = Persona.getLista(filtro, orden);
        if(datos!=null){
            try {
                while(datos.next()){
                Persona persona = new Persona();
                persona.setIdentificacion(datos.getString("identificacion"));
                persona.setNombres(datos.getString("nombres"));
                persona.setApellidos(datos.getString("apellidos"));
                persona.setFechaDeNacimiento(datos.getString("fechaDeNacimiento"));
                persona.setDireccion(datos.getString("direccion"));
                persona.setTelefono(datos.getString("telefono"));
                persona.setEmail(datos.getString("email"));
                lista.add(persona);
                }
             } catch (SQLException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
