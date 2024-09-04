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
public class Foto {
    private String id;
    private String tipo;
    private String idInventarioMateriales;

    public Foto() {
    }
    
    // Falta constructor

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdInventarioMateriales() {
        return idInventarioMateriales;
    }

    public void setIdInventarioMateriales(String idInventarioMateriales) {
        this.idInventarioMateriales = idInventarioMateriales;
    }
    
    
}
