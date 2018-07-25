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
public class Grupo {

    private int codigoGrupo;
    private char nombre;
    private Equipo[] equipos = new Equipo[4];

    public Grupo() {
    }

    public Grupo(int codigoGrupo, char nombre) {
        this.codigoGrupo = codigoGrupo;
        this.nombre = nombre;
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

    public Equipo[] getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipo[] equipos) {
        this.equipos = equipos;
    }

    public void setUnEquipo(Equipo nuevo, int posicion) {
        this.equipos[posicion] = nuevo;
    }

    @Override
    public String toString() {
        return codigoGrupo + "," + nombre + "," + equipos.toString();
    }

    
    
}
