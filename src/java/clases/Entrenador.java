<<<<<<< HEAD
=======

import clasesGenericas.ConectorBD;

public class Entrenador extends Persona {
    private String fechaIngreso;
    private String fechaRetiro;

    // Constructores, getters y setters

    // Métodos CRUD (adaptando los de Persona)

    public boolean grabar() {
        String cadenaSQL = "INSERT INTO entrenador (identificacion, nombres, apellidos, fechaDeNacimiento, direccion, telefono, email, rol, claves, fechaIngreso, fechaRetiro) " +
                "VALUES ('" + identificacion + "', '" + nombres + "', '" + apellidos + "', '" + fechaDeNacimiento + "', '" + direccion + "', '" + telefono + "', '" + email + "', '" + rol + "', '" + claves + "', '" + fechaIngreso + "', '" + fechaRetiro + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "UPDATE entrenador SET nombres='" + nombres + "', apellidos='" + apellidos + "', fechaDeNacimiento='" + fechaDeNacimiento + "', " +
                "direccion='" + direccion + "', telefono='" + telefono + "', email='" + email + "', rol='" + rol + "', claves='" + claves + "', fechaIngreso='" + fechaIngreso + "', fechaRetiro='" + fechaRetiro + "' WHERE identificacion='" + identificacion + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    // ... otros métodos CRUD, getLista y getListaEnObjetos ...
}
>>>>>>> 0e8043dbeba24b6a9248b8107ce99ad6887bb1b6
