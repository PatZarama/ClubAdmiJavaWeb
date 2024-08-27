public class Alumno extends Persona {
    private String genero;
    private String seguroMedico;
    private String nivel;
    private String categoria;

    // Constructores, getters y setters

    // Métodos CRUD (adaptando los de Persona)

    public boolean grabar() {
        String cadenaSQL = "INSERT INTO alumno (identificacion, nombres, apellidos, fechaDeNacimiento, direccion, telefono, email, genero, seguroMedico, nivel, categoria) " +
                "VALUES ('" + identificacion + "', '" + nombres + "', '" + apellidos + "', '" + fechaDeNacimiento + "', '" + direccion + "', '" + telefono + "', '" + email + "', '" + genero + "', '" + seguroMedico + "', '" + nivel + "', '" + categoria + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "UPDATE alumno SET nombres='" + nombres + "', apellidos='" + apellidos + "', fechaDeNacimiento='" + fechaDeNacimiento + "', " +
                "direccion='" + direccion + "', telefono='" + telefono + "', email='" + email + "', genero='" + genero + "', seguroMedico='" + seguroMedico + "', nivel='" + nivel + "', categoria='" + categoria + "' WHERE identificacion='" + identificacion + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    // ... otros métodos CRUD, getLista y getListaEnObjetos ...
        public void setGenero(String genero) {
        if (genero.equalsIgnoreCase("masculino") || genero.equalsIgnoreCase("femenino") || genero.equalsIgnoreCase("otro")) {
            this.genero = genero;
        } else {
            throw new IllegalArgumentException("Género no válido");
        }
    }
}