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
public class LigaPublica extends Liga {
    
    private final int[] puntajes= {100, 300, -45, 500, 100};

    public LigaPublica() {
    }

    public LigaPublica(String nombre, LocalDate fechaCreacion, Mundial torneo, boolean estado) {
        super(nombre, fechaCreacion, torneo, estado);
    }

    public int[] getPuntajes() {
        return puntajes;
    }

    @Override
    public String toString() {
        return super.toString()+","+ puntajes;
    }
    
    
}
