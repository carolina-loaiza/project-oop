/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.capalogica;

/**
 *
 * @author jeffry
 */
public class Prediccion {
    
    private Usuario jugador;
    private Juego partido;
    private Equipo prediccionGanador;
    private String prediccionMarcador;

    public Prediccion() {
    }

    public Prediccion(Usuario jugador, Juego partido, Equipo prediccionGanador, String prediccionMarcador) {
        this.jugador = jugador;
        this.partido = partido;
        this.prediccionGanador = prediccionGanador;
        this.prediccionMarcador = prediccionMarcador;
    }

    public Usuario getJugador() {
        return jugador;
    }

    public void setJugador(Usuario jugador) {
        this.jugador = jugador;
    }

    public Juego getPartido() {
        return partido;
    }

    public void setPartido(Juego partido) {
        this.partido = partido;
    }

    public Equipo getPrediccionGanador() {
        return prediccionGanador;
    }

    public void setPrediccionGanador(Equipo prediccionGanador) {
        this.prediccionGanador = prediccionGanador;
    }

    public String getPrediccionMarcador() {
        return prediccionMarcador;
    }

    public void setPrediccionMarcador(String prediccionMarcador) {
        this.prediccionMarcador = prediccionMarcador;
    }

    @Override
    public String toString() {
        return jugador + "," + partido + "," + prediccionGanador + "," + prediccionMarcador;
    }
    
    
    
}
