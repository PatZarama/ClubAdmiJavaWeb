

package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FichaTecnicaEntrenador {

    private String idFichaEntrenador;
    private String fechaEvaluacion;
    private String añosEnClub;
    private String partidosGanados;
    private String partidosPerdidos;
    private String partidosEmpatados;
    private String cumplimientoHorario;
    private String tacticaEquipo;
    private String identificacionUsuario;
    private String identificacionEntrenador;
   

    public FichaTecnicaEntrenador() {
    }

    public FichaTecnicaEntrenador(String idFichaEntrenador) {
        String cadenaSQL = "select fechaEvaluacion, añosEnClub, partidosGanados, partidosPerdidos, "
                + "partidosEmpatados, cumplimientoHorario, tacticaEquipo, identificacionUsuario, "
                + "identificacionEntrenador from FichaTecnicaEntrenador where idFichaEntrenador=" + idFichaEntrenador;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                this.idFichaEntrenador = idFichaEntrenador;
                fechaEvaluacion = resultado.getString("fechaEvaluacion");
                añosEnClub = resultado.getString("añosEnClub");
                partidosGanados = resultado.getString("partidosGanados");
                partidosPerdidos = resultado.getString("partidosPerdidos");
                partidosEmpatados = resultado.getString("partidosEmpatados");
                cumplimientoHorario = resultado.getString("cumplimientoHorario");
                tacticaEquipo = resultado.getString("tacticaEquipo");
                identificacionUsuario = resultado.getString("identificacionUsuario");
                identificacionEntrenador = resultado.getString("identificacionEntrenador");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la identificacion" + ex.getMessage());
        }
    }

    public String getIdFichaEntrenador() {
        return idFichaEntrenador;
    }

    public void setIdFichaEntrenador(String idFichaEntrenador) {
        this.idFichaEntrenador = idFichaEntrenador;
    }

    public String getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(String fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getAñosEnClub() {
        return añosEnClub;
    }

    public void setAñosEnClub(String añosEnClub) {
        this.añosEnClub = añosEnClub;
    }

    public String getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(String partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public String getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(String partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public String getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(String partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public String getCumplimientoHorario() {
        return cumplimientoHorario;
    }

    public void setCumplimientoHorario(String cumplimientoHorario) {
        this.cumplimientoHorario = cumplimientoHorario;
    }

    public String getTacticaEquipo() {
        return tacticaEquipo;
    }

    public void setTacticaEquipo(String tacticaEquipo) {
        this.tacticaEquipo = tacticaEquipo;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public String getIdentificacionEntrenador() {
        return identificacionEntrenador;
    }

    public void setIdentificacionEntrenador(String identificacionEntrenador) {
        this.identificacionEntrenador = identificacionEntrenador;
    }
    
    @Override
    public String toString() {
        return "FichaTecnicaEntrenador{" + '}';
    }
    
    public boolean grabar() {
        String cadenaSQL = "INSERT INTO FichaTecnicaEntrenador (fechaEvaluacion, añosEnClub, partidosGanados, "
                + "partidosPerdidos, partidosEmpatados, cumplimientoHorario, tacticaEquipo, identificacionUsuario, identificacionEntrenador) "
                + "VALUES ('" 
                + fechaEvaluacion + "', '" 
                + añosEnClub + "', '" 
                + partidosGanados + "', '" 
                + partidosPerdidos + "', '" 
                + partidosEmpatados + "', '" 
                + cumplimientoHorario + "', '" 
                + tacticaEquipo + "', '"
                + identificacionUsuario + "', '"
                + identificacionEntrenador + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar(String idFichaTecnica) {
        String cadenaSQL = "UPDATE FichaTecnicaEntrenador SET fechaEvaluacion='"+fechaEvaluacion
                + "' ,añosEnClub='" + añosEnClub 
                + "', partidosGanados='" + partidosGanados 
                + "', partidosPerdidos='" + partidosPerdidos 
                + "', partidosEmpatados='" + partidosEmpatados 
                + "', cumplimientoHorario='" + cumplimientoHorario
                + "', tacticaEquipo='" + tacticaEquipo
                + "', identificacionUsuario='" + identificacionUsuario
                + "', identificacionEntrenador='" + identificacionEntrenador 
                + "' WHERE idFichaEntrenador=" + idFichaEntrenador;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean eliminar() {
        String cadenaSQL = "DELETE FROM FichaTecnicaEntrenador WHERE idFichaEntrenador='" + idFichaEntrenador + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getLista(String filtro, String orden) {
        if(filtro!=null && filtro !="") filtro= " where " + filtro;
        else filtro=" ";
        if(orden!=null && orden!="") orden=" order by  "+ orden;
        else orden=" ";
        String cadenaSQL="SELECT fechaEvaluacion, añosEnClub, partidosGanados, partidosPerdidos, "
                + "partidosEmpatados, cumplimientoHorario, tacticaEquipo, identificacionUsuario, identificacionEntrenador "
                + "FROM FichaTecnicaEntrenador "+ filtro + orden;
 
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<FichaTecnicaEntrenador> getListaEnObjetos(String filtro, String orden) {
        List<FichaTecnicaEntrenador> lista = new ArrayList<>();
        ResultSet datos = FichaTecnicaEntrenador.getLista(filtro, orden);
        if(datos!=null){
            try {
                while(datos.next()){
                FichaTecnicaEntrenador fte = new FichaTecnicaEntrenador();
                fte.setIdFichaEntrenador(datos.getString("idFichaEntrenador"));
                fte.setFechaEvaluacion(datos.getString("FechaEvaluacion"));
                fte.setAñosEnClub(datos.getString("Categoria"));
                fte.setPartidosGanados(datos.getString("AñosEnCategoria"));
                fte.setPartidosPerdidos(datos.getString("TipoPrueba"));
                fte.setPartidosEmpatados(datos.getString("Valoracion"));
                fte.setCumplimientoHorario(datos.getString("MejorMarcaPersonal"));
                fte.setTacticaEquipo(datos.getString("FechaMarca"));
                fte.setIdentificacionUsuario(datos.getString("NivelCompetitivo"));
                fte.setIdentificacionEntrenador(datos.getString("Sanciones"));
                lista.add(fte);
                }
             } catch (SQLException ex) {
                Logger.getLogger(FichaTecnicaEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}

