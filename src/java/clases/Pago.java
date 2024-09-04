
package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pago {

    private String id;
    private String fechaPago;
    private String monto;
    private String estado;
    private String identificacionAlumno;

    public Pago() {
    }

    public Pago(String id) {
        String cadenaSQL = "select fechaPago, monto, estado, identificacionAlumno from Pago where id=" + id;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                this.id = id;
                fechaPago = resultado.getString("fechaPago");
                monto = resultado.getString("monto");
                estado = resultado.getString("estado");
                identificacionAlumno = resultado.getString("identificacionAlumno");
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

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdentificacionAlumno() {
        return identificacionAlumno;
    }

    public void setIdentificacionAlumno(String identificacionAlumno) {
        this.identificacionAlumno = identificacionAlumno;
    }

    @Override
    public String toString() {
        return "Pago{" + '}';
    }
        
    public boolean grabar(){
        String cadenaSQL="insert into Pago (fechaPago, monto, estado, identificacionAlumno) values ('"
                +fechaPago+"','"
                +monto+"','"
                +estado+"','"
                +identificacionAlumno+"')";
        return  ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public boolean modificar(){
        String cadenaSQL= "update Pago set fechaPago='"+fechaPago
                +"', monto='"+monto
                +"', estado='"+estado
                +"', identificacionAlumno='"+identificacionAlumno
                +"' where id="+ id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public boolean eliminar(){
        String cadenaSQL="delete from Pago where id="+id;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static  ResultSet getLista(String filtro, String orden){
        if(filtro!=null && filtro !=" ") filtro= " where " + filtro;
        else filtro=" ";
        if(orden!=null && orden!=" ") orden=" order by  "+ orden;
        else orden=" ";
        String cadenaSQL="select fechaPago, monto, estado, identificacionAlumno from Pago "+ filtro+ orden;
        return ConectorBD.consultar(cadenaSQL);     
    }
    
    public static List<Pago> getListaEnObjetos(String filtro, String orden){
        List<Pago> lista= new ArrayList<>();//inicializacion de esta coleccion de datos
        ResultSet datos= Pago.getLista(filtro, orden);
        if (datos!=null){
            try {
                while (datos.next()){
                    Pago pago = new Pago();
                    pago.setId(datos.getString("id"));
                    pago.setFechaPago(datos.getString("fechaPago"));
                    pago.setMonto(datos.getString("monto"));
                    pago.setEstado(datos.getString("estado"));
                    pago.setIdentificacionAlumno(datos.getString("identificacionAlumno"));
                    lista.add(pago);
               }
            } catch (SQLException ex) {
                Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    return lista;
    }

}
