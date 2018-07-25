/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.capalogica;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jeffry
 */
public class Liga {

    private String nombre;
    private ArrayList<Usuario> participantes = new ArrayList<>();
    private LocalDate fechaCreacion;
    private Mundial torneo;
    private boolean estado;
    private Usuario[] ranking = new Usuario[10];

    public Liga() {
    }

    public Liga(String nombre, LocalDate fechaCreacion, Mundial torneo, boolean estado) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.torneo = torneo;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Usuario> participantes) {
        this.participantes = participantes;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Mundial getTorneo() {
        return torneo;
    }

    public void setTorneo(Mundial torneo) {
        this.torneo = torneo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario[] getRanking() {
        return ranking;
    }

    public void setRanking(Usuario[] ranking) {
        this.ranking = ranking;
    }

    
    
    @Override
    public String toString() {
        return nombre + "," + participantes.toString() + "," + fechaCreacion + "," + torneo.toString() + "," + estado +","+ ranking.toString();
    }

}
