
package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Partido {
    
    private String idPartido;
    private String fecha;
    private String lugar;
    private String horaInicio;
    private String horaFin;
    private String equipoLocal;
    private String equipoVisitante;
    private String golesVisitante;
    private String golesLocal;
    private String observaciones;
    private String idEntrenador;
    private String idCategoriaPorEdad;
    private String idCategoriaJuego;
    private String idTipoCancha;
    
   
    public Partido() {
    }
    
    public Partido(String id){
        String CadenaSQL = "select fecha,lugar,grupo,horaInicio,HoraFin,equipoLocal,"
                + "equipoVisitante, golesVisitante, golesLocal, observaciones, idEntrenador, "
                + "idCategoriaPorEdad, idCategoriaJuego, idTipoCancha from Partido where idPartido="+idPartido;
        ResultSet resultado = ConectorBD.consultar(CadenaSQL);
        try {
            if (resultado.next()){
                this.idPartido = idPartido;
                fecha = resultado.getString("fecha");
                lugar = resultado.getString("lugar");
                horaInicio = resultado.getString("horaInicio");
                horaFin = resultado.getString("horaFin");
                equipoLocal = resultado.getString("equipoLocal");
                equipoVisitante = resultado.getString("equipoVisitante");
                golesVisitante = resultado.getString("golesVisitante");
                golesLocal = resultado.getString("golesLocal");
                observaciones = resultado.getString("observaciones");
                idEntrenador = resultado.getString("idEntrenador");
                idCategoriaPorEdad = resultado.getString("idCategoriaPorEdad");
                idCategoriaJuego = resultado.getString("idCategoriaJuego");
                idTipoCancha = resultado.getString("idTipoCancha");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Partido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(String golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public String getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(String golesLocal) {
        this.golesLocal = golesLocal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getIdCategoriaPorEdad() {
        return idCategoriaPorEdad;
    }

    public void setIdCategoriaPorEdad(String idCategoriaPorEdad) {
        this.idCategoriaPorEdad = idCategoriaPorEdad;
    }

    public String getIdCategoriaJuego() {
        return idCategoriaJuego;
    }

    public void setIdCategoriaJuego(String idCategoriaJuego) {
        this.idCategoriaJuego = idCategoriaJuego;
    }

    public String getIdTipoCancha() {
        return idTipoCancha;
    }

    public void setIdTipoCancha(String idTipoCancha) {
        this.idTipoCancha = idTipoCancha;
    }
    
    @Override
    public String toString() {
        return "Partido{" + '}';
    }
   
    public boolean grabar() {
        String cadenaSQL = "insert into Partido(fecha,lugar,horaInicio,horaFin,"
                + "equipoLocal,equipoVisitante,golesVisitante, golesLocal, observaciones"
                + "idEntrenador, idCategoriaPorEdad, idCategoriaJuego, idTipoCancha) values ('" 
                + fecha + "','" 
                + lugar +  "','" 
                + horaInicio + "','" 
                + horaFin + "','" 
                + equipoLocal + "','" 
                + equipoVisitante + "','"
                + golesVisitante + "','"
                + golesLocal + "','"
                + observaciones + "','"
                + idEntrenador + "','"
                + idCategoriaPorEdad + "','"
                + idCategoriaJuego + "','"
                + idTipoCancha + "')";
        System.out.println(cadenaSQL);

        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar() {
        String cadenaSQL = "update Partido set fecha='" + fecha 
                + "',lugar='" + lugar  
                + "',horaInicio='" + horaInicio 
                + "',horaFin='" + horaFin 
                + "',equipoLocal='" + equipoLocal
                + "',equipoVisitante='" + equipoVisitante
                + "',golesLocal='" + golesLocal
                + "',golesVisitante='" + golesVisitante
                + "',observaciones='" + observaciones
                + "',idEntrenador='" + idEntrenador
                + "',idCatgoriaPorEdad='" + idCategoriaPorEdad
                + "',idCategoriaJuego='" + idCategoriaJuego
                + "',idTipoCancha='" + idTipoCancha
                + "' where idPartido=" + idPartido;
        System.out.println(cadenaSQL);
        return ConectorBD.ejecutarQuery(cadenaSQL);

    }

    public boolean eliminar() {
        String cadenaSQL = "delete from Producto where idPartido=" + idPartido;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getLista(String filtro, String orden) {
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
        String cadenaSQL = "select fecha,lugar,horaInicio,horaFin,equipoLocal,equipoVisitante,golesVisitantes,golesLocal,"
                + "observaciones,idEntrenador,idCategoriaPorEdad,idCategoriaJuego,tipoCancha from Partido" + filtro + orden;
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<Partido> getListaEnObjetos(String filtro, String orden) {
        List<Partido> lista = new ArrayList<>();
        ResultSet datos = Partido.getLista(filtro, orden);
        if (datos != null) {
            try {
                while (datos.next()) {
                   Partido partido = new Partido();
                   partido.setIdPartido(datos.getString("idPartido"));
                   partido.setFecha(datos.getString("fecha"));
                   partido.setLugar(datos.getString("lugar"));
                   partido.setHoraInicio(datos.getString("horaInicio"));
                   partido.setHoraFin(datos.getString("horaFin"));
                   partido.setEquipoLocal(datos.getString("equipoLocal"));
                   partido.setEquipoVisitante(datos.getString("equipoVisitante"));
                   partido.setGolesVisitante(datos.getString("golesVisitantes"));
                   partido.setGolesLocal(datos.getString("golesLocal"));  
                   partido.setObservaciones(datos.getString("observaciones")); 
                   partido.setIdEntrenador(datos.getString("idEntrenador"));
                   partido.setIdCategoriaPorEdad(datos.getString("idCategoriaPorEdad"));
                   partido.setIdCategoriaJuego(datos.getString("idCategoriaJuego"));
                   partido.setIdTipoCancha(datos.getString("idTipoCancha"));
                       
                    lista.add(partido);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Partido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    
    }

