
import clasesGenericas.ConectorBD;

public class Padre extends Persona {
    private String parentesco;
    private String identificacionPadre;

    // Constructores, getters y setters

    // Métodos CRUD (adaptando los de Persona)

    public boolean grabar() {
        String cadenaSQL = "INSERT INTO padre (identificacion, nombres, apellidos, fechaDeNacimiento, direccion, telefono, email, parentesco, identificacionPadre) " +
                "VALUES ('" + identificacion + "', '" + nombres + "', '" + apellidos + "', '" + fechaDeNacimiento + "', '" + direccion + "', '" + telefono + "', '" + email + "', '" + parentesco + "', '" + identificacionPadre + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "UPDATE padre SET nombres='" + nombres + "', apellidos='" + apellidos + "', fechaDeNacimiento='" + fechaDeNacimiento + "', " +
                "direccion='" + direccion + "', telefono='" + telefono + "', email='" + email + "', parentesco='" + parentesco + "', identificacionPadre='" + identificacionPadre + "' WHERE identificacion='" + identificacion + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    // ... otros métodos CRUD, getLista y getListaEnObjetos ...
}
