package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FichaTecnicaAlumno {

    private String idFichaTecnica;
    private String fechaEvaluacion;
    private String categoria;
    private String añosEnCategoria;
    private String tipoPrueba;
    private String valoracion;
    private String mejorMarcaPersonal;
    private String fechaMarca;
    private String nivelCompetitivo;
    private String sanciones;
    private String motivo;

    public FichaTecnicaAlumno() {
    }

    public FichaTecnicaAlumno(String idFichaTecnica) {
        String cadenaSQL = "select fechaEvaluacion, categoria, añosEnCategoria, tipoPrueba, "
                + "valoracion, mejorMarcaPersonal, fechaMarca, nivelCompetitivo, sanciones, "
                + "motivo from FichaTecnicaAlumno where idFichaTecnica=" + idFichaTecnica;
        ResultSet resultado = ConectorBD.consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                this.idFichaTecnica = idFichaTecnica;
                fechaEvaluacion = resultado.getString("fechaEvaluacion");
                categoria = resultado.getString("categoria");
                añosEnCategoria = resultado.getString("añosEnCategoria");
                tipoPrueba = resultado.getString("tipoPrueba");
                valoracion = resultado.getString("valoracion");
                mejorMarcaPersonal = resultado.getString("mejorMarcaPersonal");
                fechaMarca = resultado.getString("fechaMarca");
                nivelCompetitivo = resultado.getString("nivelCompetitivo");
                sanciones = resultado.getString("sanciones");
                motivo = resultado.getString("motivo");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la identificacion" + ex.getMessage());
        }
    }

    public String getIdFichaTecnica() {
        return idFichaTecnica;
    }

    public void setIdFichaTecnica(String idFichaTecnica) {
        this.idFichaTecnica = idFichaTecnica;
    }

    public String getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(String fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAñosEnCategoria() {
        return añosEnCategoria;
    }

    public void setAñosEnCategoria(String añosEnCategoria) {
        this.añosEnCategoria = añosEnCategoria;
    }

    public String getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getMejorMarcaPersonal() {
        return mejorMarcaPersonal;
    }

    public void setMejorMarcaPersonal(String mejorMarcaPersonal) {
        this.mejorMarcaPersonal = mejorMarcaPersonal;
    }

    public String getFechaMarca() {
        return fechaMarca;
    }

    public void setFechaMarca(String fechaMarca) {
        this.fechaMarca = fechaMarca;
    }

    public String getNivelCompetitivo() {
        return nivelCompetitivo;
    }

    public void setNivelCompetitivo(String nivelCompetitivo) {
        this.nivelCompetitivo = nivelCompetitivo;
    }

    public String getSanciones() {
        return sanciones;
    }

    public void setSanciones(String sanciones) {
        this.sanciones = sanciones;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "FichaTecnicaAlumno{" + '}';
    }
    
    public boolean grabar() {
        String cadenaSQL = "INSERT INTO FichaTecnicaAlumno (fechaEvaluacion, categoria, añosEnCategoria, "
                + "tipoPrueba, valoracion, mejorMarcaPersonal, fechaMarca, nivelCompetitivo, sanciones, motivo) "
                + "VALUES ('" 
                + fechaEvaluacion + "', '" 
                + categoria + "', '" 
                + añosEnCategoria + "', '" 
                + tipoPrueba + "', '" 
                + valoracion + "', '" 
                + mejorMarcaPersonal + "', '" 
                + fechaMarca + "', '"
                + nivelCompetitivo + "', '"
                + sanciones + "', '"
                + motivo + "')";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean modificar(String idFichaTecnica) {
        String cadenaSQL = "UPDATE FichaTecnicaAlumno SET fechaEvaluacion='"+fechaEvaluacion
                + "' ,categoria='" + categoria 
                + "', añosEnCategoria='" + añosEnCategoria 
                + "', tipoPrueba='" + tipoPrueba 
                + "', valoracion='" + valoracion 
                + "', mejorMarcaPersonal='" + mejorMarcaPersonal
                + "', fechaMarca='" + fechaMarca
                + "', nivelCompetitivo='" + nivelCompetitivo
                + "', sanciones='" + sanciones 
                + "', motivo='" + motivo 
                + "' WHERE idFichaTecnica=" + idFichaTecnica;
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public boolean eliminar() {
        String cadenaSQL = "DELETE FROM FichaTecnicaAlumno WHERE idFichaTecnica='" + idFichaTecnica + "'";
        return ConectorBD.ejecutarQuery(cadenaSQL);
    }

    public static ResultSet getLista(String filtro, String orden) {
        if(filtro!=null && filtro !="") filtro= " where " + filtro;
        else filtro=" ";
        if(orden!=null && orden!="") orden=" order by  "+ orden;
        else orden=" ";
        String cadenaSQL="SELECT fechaEvaluacion, categoria, añosEnCategoria, tipoPrueba, "
                + "valoracion, mejorMarcaPersonal, fechaMarca, nivelCompetitivo, sanciones, "
                + "motivo FROM FichaTecnicaAlumno "+ filtro + orden;
 
        return ConectorBD.consultar(cadenaSQL);
    }

    public static List<FichaTecnicaAlumno> getListaEnObjetos(String filtro, String orden) {
        List<FichaTecnicaAlumno> lista = new ArrayList<>();
        ResultSet datos = FichaTecnicaAlumno.getLista(filtro, orden);
        if(datos!=null){
            try {
                while(datos.next()){
                FichaTecnicaAlumno fta = new FichaTecnicaAlumno();
                fta.setIdFichaTecnica(datos.getString("IdFichaTecnica"));
                fta.setFechaEvaluacion(datos.getString("FechaEvaluacion"));
                fta.setCategoria(datos.getString("Categoria"));
                fta.setAñosEnCategoria(datos.getString("AñosEnCategoria"));
                fta.setTipoPrueba(datos.getString("TipoPrueba"));
                fta.setValoracion(datos.getString("Valoracion"));
                fta.setMejorMarcaPersonal(datos.getString("MejorMarcaPersonal"));
                fta.setFechaMarca(datos.getString("FechaMarca"));
                fta.setNivelCompetitivo(datos.getString("NivelCompetitivo"));
                fta.setSanciones(datos.getString("Sanciones"));
                fta.setMotivo(datos.getString("Motivo"));
                lista.add(fta);
                }
             } catch (SQLException ex) {
                Logger.getLogger(FichaTecnicaAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}

