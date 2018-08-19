/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.capalogica;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author jeffry
 */
public class Grupo {

    private int codigoGrupo;
    private int codigoMundial;
    private String nombre;
    private ArrayList<Equipo> equipos = new ArrayList<>();

    public Grupo() {
    }

    public Grupo(String nombre, ArrayList<Equipo> equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public Grupo(int codigoGrupo, int codigoMundial, String nombre, ArrayList<Equipo> equipos) {
        this.codigoGrupo = codigoGrupo;
        this.codigoMundial = codigoMundial;
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    public int getCodigoMundial() {
        return codigoMundial;
    }

    public void setCodigoMundial(int codigoMundial) {
        this.codigoMundial = codigoMundial;
    }

    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
      
    /// Revisar equipos.toString
    @Override
    public String toString() {
        return codigoGrupo + "," + nombre + "," + equipos.toString();
    }

    
    
}
