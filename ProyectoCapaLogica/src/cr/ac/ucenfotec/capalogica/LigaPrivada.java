/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.capalogica;

import java.time.LocalDate;

/**
 *
 * @author jeffry
 */
public class LigaPrivada extends Liga {
    
    private Usuario administrador;
    private int[] puntajes= {100, 300, -45, 500, 100};

    public LigaPrivada() {
    }

    public LigaPrivada(Usuario administrador) {
        this.administrador = administrador;
    }

    public LigaPrivada(Usuario administrador, String nombre, LocalDate fechaCreacion, Mundial torneo, boolean estado) {
        super(nombre, fechaCreacion, torneo, estado);
        this.administrador = administrador;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }

    public int[] getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(int[] puntajes) {
        this.puntajes = puntajes;
    }

    @Override
    public String toString() {
        return super.toString()+","+ administrador + "," + puntajes;
    }
    
    
    
}
