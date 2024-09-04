/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Johan Guaquez
 */
public class TipoCancha {
    private String id;
    private String nombre;
    private String jugadores;
    private String descripcion;
    private String idCategoriaJuego;

    public TipoCancha() {
    }

    
    // falta constructor
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJugadores() {
        return jugadores;
    }

    public void setJugadores(String jugadores) {
        this.jugadores = jugadores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdCategoriaJuego() {
        return idCategoriaJuego;
    }

    public void setIdCategoriaJuego(String idCategoriaJuego) {
        this.idCategoriaJuego = idCategoriaJuego;
    }
    
    
}
