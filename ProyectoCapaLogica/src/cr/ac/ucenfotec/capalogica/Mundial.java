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
public class Mundial {

    private int codigoMundial;
    private int year;
    private String pais;
    private int estado;
    private TreeMap<Integer, Grupo> faseGrupos = new TreeMap<Integer, Grupo>();
    private TreeMap<Integer, Juego> listaJuegos = new TreeMap<Integer, Juego>();

    public Mundial() {
    }

    public Mundial(int year, String pais, int estado) {
        this.year = year;
        this.pais = pais;
        this.estado = estado;
    }

    public Mundial(int codigoMundial, int year, String pais, int estado) {
        this.codigoMundial = codigoMundial;
        this.year = year;
        this.pais = pais;
        this.estado = estado;
    }

    public int getCodigoMundial() {
        return codigoMundial;
    }

    public void setCodigoMundial(int codigoMundial) {
        this.codigoMundial = codigoMundial;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int isEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public TreeMap<Integer, Grupo> getFaseGrupos() {
        return faseGrupos;
    }

    public void setFaseGrupos(TreeMap<Integer, Grupo> grupos) {
        this.faseGrupos = grupos;
    }
    
    public void setGrupo(Grupo nuevoGrupo) {
        this.faseGrupos.put(nuevoGrupo.getCodigoGrupo(), nuevoGrupo);
    }
    
    public TreeMap<Integer, Juego> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(TreeMap<Integer, Juego> lista) {
        this.listaJuegos = lista;
    }
    
    public void setJuego(Juego nuevoJuego) {
        this.listaJuegos.put(nuevoJuego.getCodigoJuego(), nuevoJuego);
    }

    /// Revisar faseGrupos.toString
    @Override
    public String toString() {
        return year + "," + pais + "," + estado + "," + faseGrupos.toString();
    }

    
    
}
