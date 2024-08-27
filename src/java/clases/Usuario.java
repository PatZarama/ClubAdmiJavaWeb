
import clasesGenericas.ConectorBD;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Usuario extends Persona {
    private String rol;
    private String claves;

    // Constructores, getters y setters

    // Métodos CRUD (adaptando los de Persona)

    public boolean grabar() {
        String cadenaSQL = "INSERT INTO usuario (identificacion, nombres, apellidos, fechaDeNacimiento, direccion, telefono, email, rol, claves) " +
                "VALUES ('" + identificacion + "', '" + nombres + "', '" + apellidos + "', '" + fechaDeNacimiento + "', '" + direccion + "', '" + telefono + "', '" + email + "', '" + rol + "', '" + claves + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "UPDATE usuario SET nombres='" + nombres + "', apellidos='" + apellidos + "', fechaDeNacimiento='" + fechaDeNacimiento + "', " +
                "direccion='" + direccion + "', telefono='" + telefono + "', email='" + email + "', rol='" + rol + "', claves='" + claves + "' WHERE identificacion='" + identificacion + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    // ... otros métodos CRUD, getLista y getListaEnObjetos ...


// ...

    public void setClaves(String claves) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.claves = encoder.encode(claves);
    }

    public boolean verificarClave(String claveIngresada) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(claveIngresada, this.claves);
    }

}