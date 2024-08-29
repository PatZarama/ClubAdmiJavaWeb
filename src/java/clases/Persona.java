/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johan Guaquez
 */
public class Persona {
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private String clave; 
    private String tipo;
       
    
    public Persona(){
        
    }
    
    public Persona(String identificacion){
        String cadenaSQL= "select nombres, apellidos, fechaNacimiento, direccion, telefono, email, clave, tipo from persona "
                + "where identificacion ="+identificacion+"";
        ResultSet resultado=ConectorBD.consultar(cadenaSQL);
        
        try {
            if (resultado.next()) {
                this.identificacion=identificacion;
                nombres=resultado.getString("nombres");
                apellidos=resultado.getString("apellidos");
                fechaNacimiento=resultado.getString("fechaNacimiento");
                direccion=resultado.getString("direccion");
                telefono=resultado.getString("telefono");
                email=resultado.getString("email");
                clave=resultado.getString("clave");
                tipo=resultado.getString("tipo");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
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
         this.identificacion = identificacion != null ? identificacion.trim() : "";
    }
    
    //Cambios en el nombre
    public String getNombres() {
        String resultado = nombres;
        if(nombres==null) resultado="";
        return resultado;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    //Cambios en el gett apellidos
    public String getApellidos() {
        String resultado = apellidos;
        if(apellidos==null) resultado="";
        return resultado;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    //Cambios en el getter de telefono = null
    public String getTelefono() {
        String resultado=telefono;
        if(telefono==null) resultado="";
        return resultado;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //cambios en get email
    public String getEmail() {
        String resultado = email;
        if(email==null) resultado="";
        return resultado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Modificacion en la clave, quitar el null
    public String getClave() {
        String resultado=clave;
            if (clave==null) resultado="";
           return resultado;
    }

    public void setClave(String clave) {
        if (clave==null || clave.trim().length()==0) clave=identificacion;
        if (clave.length()<32){
            this.clave="md5('" + clave + "')";
        } else {
            this.clave="'" + clave + "'";
        }
       
    }
   //tipoPersona
    public TipoPersona getTipoEnObjeto(){
        return new TipoPersona(tipo);
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString() {
        String datos="";
        if (identificacion!=null) {
           datos=identificacion+" - "+nombres+" "+apellidos; 
        }
        return datos;
    }
   
    public boolean grabar() {
        String cadenaSQL = "insert into Persona (identificacion, nombres, apellidos, fechaNacimiento, direccion, telefono, email, clave, tipo) "
    + "values ('"
    + identificacion + "','" + nombres + "','" + apellidos + "','" + fechaNacimiento
    + "','" + direccion
    + "','" + telefono + "','" + email + "','" + clave + "'," + tipo + ")";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
   
    public boolean modificar (String identificacionAnterior){
        String cadenaSQL = "UPDATE persona SET identificacion='" + identificacion + "', nombres='" + nombres + "', apellidos='" + apellidos + "', fechaNacimiento='" + fechaNacimiento +  "', direccion='" + direccion + "', telefono='" + telefono + "', email='" + email + "', clave='" + clave + "', tipo=" + tipo + " WHERE identificacion='" + identificacionAnterior + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
   
    public boolean eliminar() {
        String cadenaSQL = "DELETE FROM Persona WHERE identificacion='" + identificacion + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
   
    public static ResultSet getlista(String filtro, String orden) {
        if (filtro != null && filtro != "") {
            filtro = " where " + filtro;
        } else {
            filtro = "";
        }
        if (orden != null && orden != "") {
            orden = " order by " + orden;
        } else {
            orden = "";
        }
        String cadenaSQL = "select identificacion, nombres, apellidos, fechaNcimiento, direccion, telefono, email, clave, tipo from persona" +filtro + orden;
        return ConectorBD.consultar(cadenaSQL);
    }
    
      public static String getListaEnArregloJS(String filtro, String orden) {
        String lista = "[";
        List<Persona> datos = Persona.getListaEnObjetos(filtro, orden);
        for (int i = 0; i < datos.size(); i++) {
            Persona persona = datos.get(i);
            if (i > 0) {
                lista = "[";
            }
            lista += "'" + persona.getIdentificacion() + " - " + persona + "'";
        }
        lista += "]";
        return lista;
    }
    
    public static Persona validar(String identificacion, String clave ){
        Persona persona = null;
        List<Persona> lista = Persona.getListaEnObjetos("identificacion='" + identificacion + "' and clave = md5('" + clave + "')", null);
        if (lista.size()>0) {
            persona=lista.get(0);
        }
        return persona;
         
     }

     public static List<Persona> getListaEnObjetos(String filtro, String orden) {
        List<Persona> lista = new ArrayList<>();
        ResultSet datos = Persona.getlista(filtro, orden);
        if (datos!=null) {
            try {
                while (datos.next()) {
                    Persona persona = new Persona();
                    persona.setIdentificacion(datos.getString("identificacion"));
                    persona.setNombres(datos.getString("nombres"));
                    persona.setApellidos(datos.getString("apellidos"));
                    persona.setFechaNacimiento(datos.getString("fechaNacimiento"));
                    persona.setDireccion(datos.getString("direccion"));
                    persona.setTelefono(datos.getString("telefono"));
                    persona.setEmail(datos.getString("email"));
                    persona.setClave(datos.getString("clave"));
                    persona.setTipo(datos.getString("tipo"));

                    lista.add(persona);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}