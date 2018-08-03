/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.capalogica;

import java.util.Date;

/**
 *
 * @author jeffry
 */
public class Juego {
    
    private int codigoJuego;
    private Equipo primero;
    private Equipo segundo;
    private Date fecha;
    private Equipo ganador;
    private String marcador;

    public Juego() {
    }

    public Juego(int codigoJuego, Equipo primero, Equipo segundo, Date fecha) {
        this.codigoJuego = codigoJuego;
        this.primero = primero;
        this.segundo = segundo;
        this.fecha = fecha;
    }

    public Equipo getPrimero() {
        return primero;
    }

    public void setPrimero(Equipo primero) {
        this.primero = primero;
    }

    public Equipo getSegundo() {
        return segundo;
    }

    public void setSegundo(Equipo segundo) {
        this.segundo = segundo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }
    
    public int getCodigoJuego() {
        return codigoJuego;
    }

    public void setCodigoJuego(int codigoJuego) {
        this.codigoJuego = codigoJuego;
    }

    @Override
    public String toString() {
        return primero.toString() + "," + segundo.toString() + "," + fecha + "," + ganador.toString() + "," + marcador;
    }
    
    
    
    
}
