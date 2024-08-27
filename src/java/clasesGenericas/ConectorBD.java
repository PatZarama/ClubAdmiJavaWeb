/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesGenericas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Johan Guaquez
 */
public class ConectorBD {
     private String servidor;
    private String puerto;
    private String usuario;
    private String clave;
    private String baseDatos;
    private Connection conexion; 
    public ConectorBD () {
        servidor="localhost";
        puerto="3306";
        usuario="adso";
        clave="utilizar";
        baseDatos="Deporte";
    }
    public  boolean conectar() {
        boolean conectado=false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Activo ");
            String cadenaConexion= "jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDatos + "?characterEncoding=UTF-8";
            conexion=DriverManager.getConnection(cadenaConexion, usuario, clave);
            System.out.println("Conectado a la bd");
            conectado=true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el controlador de la bd. "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la bd. "+ex.getMessage());
        }
        return conectado;
    }
    
    public void desconectar (){
        try {
            conexion.close();
            System.out.println("Se ha desconectado de la bd");
        } catch (SQLException ex) {
            System.out.println("Error al desconectar la red. "+ex.getMessage());
        }
    }
    public static ResultSet consultar(String cadenaSQL){
        ResultSet resultado =null;
        ConectorBD conector =new ConectorBD();
        if(!conector.conectar()) System.out.println("error al conectarse a la bd. ");
        try {
            PreparedStatement sentencia=conector.conexion.prepareStatement(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE,0 );
            resultado=sentencia.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error en la cadena sql"+ cadenaSQL+","+ex.getMessage());
        }
        return resultado;
    }
    public static boolean ejecutarQuery(String cadenaSQL) {
        boolean resultado=false;
        ConectorBD conector=new ConectorBD();
        if (!conector.conectar()) System.out.println("Error al conectarme a la bd.");
        try {
            PreparedStatement sentencia=conector.conexion.prepareStatement(cadenaSQL);
            resultado=sentencia.execute();
            resultado=true;
        } catch (SQLException ex) {
            System.out.println("Error en la cadena sql. "+cadenaSQL+". "+ex.getMessage());
        }
        conector.desconectar();
        return resultado;
    }     
       
    
    
    
}
