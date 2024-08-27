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
    private String rol;
    private String claves;
    private String genero;
    private String seguroMedico;
    private String nivel;
    private String categoria;

        public Persona(String identificacion){
        String cadenaSQL= "select nombres, apellidos, fechaDeNacimiento, direccion, telefono, email from persona "
                + "where identificacion ="+identificacion+"";
        ResultSet resultado=ConectorBD.consultar(cadenaSQL);
        
        try {
            if (resultado.next()) {
                this.identificacion=identificacion;
                nombres=resultado.getString("nombres");
                apellidos=resultado.getString("apellidos");
                fechaDeNacimiento=resultado.getString("fechaDeNacimiento");
                direccion=resultado.getString("direccion");
                telefono=resultado.getString("telefono");
                email=resultado.getString("email");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    public boolean grabar() {
        String cadenaSQL = "INSERT INTO persona (identificacion, nombres, apellidos, fechaDeNacimiento, direccion, telefono, email) " +
                "VALUES ('" + identificacion + "', '" + nombres + "', '" + apellidos + "', '" + fechaDeNacimiento + "', '" + direccion + "', '" + telefono + "', '" + email + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "UPDATE persona SET nombres='" + nombres + "', apellidos='" + apellidos + "', fechaDeNacimiento='" + fechaDeNacimiento + "', " +
                "direccion='" + direccion + "', telefono='" + telefono + "', email='" + email + "' WHERE identificacion='" + identificacion + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean eliminar() {
        String cadenaSQL = "DELETE FROM persona WHERE identificacion='" + identificacion + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getLista(String filtro, String orden) {
        // ... lógica similar a la del ejemplo para construir la consulta ...
    }

    public static List<Persona> getListaEnObjetos(String filtro, String orden) {
        List<Persona> lista = new ArrayList<>();
        ResultSet datos = Persona.getLista(filtro, orden);
        // ... lógica similar a la del ejemplo para llenar la lista de objetos Persona ...
    }
}