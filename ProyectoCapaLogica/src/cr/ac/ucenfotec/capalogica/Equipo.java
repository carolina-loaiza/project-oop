/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.capalogica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author jeffry
 */
public class Equipo {
    
    private int codigoPais;
    private String nombrePais;
    private int ranking;
    //private ImageIcon bandera;

    public Equipo() {
    }

    public Equipo(int codigoPais, String nombrePais, int ranking) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.ranking = ranking;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return codigoPais + "," + nombrePais + "," + ranking;
    }  
    
    
}
