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
public class Mundial {

    private int year;
    private String pais;
    private boolean estado;
    private Grupo[] campeonato = new Grupo[8];

    public Mundial() {
    }

    public Mundial(int year, String pais, boolean estado) {
        this.year = year;
        this.pais = pais;
        this.estado = estado;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Grupo[] getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Grupo[] campeonato) {
        this.campeonato = campeonato;
    }

    @Override
    public String toString() {
        return year + "," + pais + "," + estado + "," + campeonato.toString();
    }

    
    
}
