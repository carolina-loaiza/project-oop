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
    
    private int codigoEquipo;
    private String codigoPais;
    private String nombrePais;
    private int ranking;
    //private ImageIcon bandera;

    public Equipo() {
    }

    public Equipo(String codigoPais, String nombrePais, int ranking) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.ranking = ranking;
    }
    
    

    public Equipo(int codigoEquipo, String codigoPais, String nombrePais, int ranking) {
        this.codigoEquipo = codigoEquipo;
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.ranking = ranking;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
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
    
    public int getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(int codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    @Override
    public String toString() {
        return codigoPais + "," + nombrePais + "," + ranking;
    }  
    
    
}
