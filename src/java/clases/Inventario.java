package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inventario {
    
    private String id;
    private String material;
    private String cantidad;
    private String estado;

    public Inventario() {
    }
    
        public Inventario(String id) {
        String cadenaSQL = "select material, cantidad, estado from Inventario where id=" + id;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                this.id = id;
                material = resultado.getString("material");
                cantidad = resultado.getString("cantidad");
                estado = resultado.getString("estado");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consulta el id " + ex.getMessage());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Inventario{" + '}';
    }
    
    public boolean grabar(){
        String cadenaSQL="insert into Inventario (material, cantidad, estado) values ('"
                +material+"','"
                +cantidad+"','"
                +estado+"')";
        return  ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public boolean modificar(){
        String cadenaSQL= "update Inventario set material='"+material
                +"', cantidad='"+cantidad
                +"', estado='"+estado
                +"' where id="+ id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public boolean eliminar(){
        String cadenaSQL="delete from Inventario where id="+id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static  ResultSet getLista(String filtro, String orden){
        if(filtro!=null && filtro !=" ") filtro= " where " + filtro;
        else filtro=" ";
        if(orden!=null && orden!=" ") orden=" order by  "+ orden;
        else orden=" ";
        String cadenaSQL="select material, cantidad, estado from Inventario "+ filtro+ orden;
        return ConectorBD.consultar(cadenaSQL);     
    }
    
    public static List<Inventario> getListaEnObjetos(String filtro, String orden){
        List<Inventario> lista= new ArrayList<>();//inicializacion de esta coleccion de datos
        ResultSet datos= Inventario.getLista(filtro, orden);
        if (datos!=null){
            try {
                while (datos.next()){
                    Inventario invent = new Inventario();
                    invent.setId(datos.getString("id"));
                    invent.setMaterial(datos.getString("material"));
                    invent.setCantidad(datos.getString("cantidad"));
                    invent.setEstado(datos.getString("estado"));
                    lista.add(invent);
               }
            } catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    return lista;
    }    
    
}
