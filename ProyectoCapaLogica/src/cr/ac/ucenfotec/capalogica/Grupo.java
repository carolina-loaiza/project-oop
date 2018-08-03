/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.capalogica;

import java.util.TreeMap;

/**
 *
 * @author jeffry
 */
public class Grupo {

    private int codigoGrupo;
    private int codigoMuldial;
    private char nombre;
    private TreeMap<Integer, Equipo> equipos = new TreeMap<Integer, Equipo>();

    public Grupo() {
    }

    public Grupo(int codigoMuldial, int codigoGrupo, char nombre, TreeMap<Integer, Equipo> equipos) {
        this.codigoGrupo = codigoGrupo;
        this.nombre = nombre;
        this.equipos = equipos;
        this.codigoMuldial = codigoMuldial;
    }

    public int getCodigoMuldial() {
        return codigoMuldial;
    }

    public void setCodigoMuldial(int codigoMuldial) {
        this.codigoMuldial = codigoMuldial;
    }

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public TreeMap<Integer, Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(TreeMap<Integer, Equipo> equipos) {
        this.equipos = equipos;
    }

    public void setUnEquipo(Equipo equipoNuevo) {
        this.equipos.put(equipoNuevo.getCodigoEquipo(), equipoNuevo);
    }
    
    /// Revisar equipos.toString
    @Override
    public String toString() {
        return codigoGrupo + "," + nombre + "," + equipos.toString();
    }

    
    
}
