/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.CapaLogica;
import cr.ac.ucenfotec.capalogica.Mundial;
import cr.ac.ucenfotec.multi.MultiMundial;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jeffry
 */
    

public class GestorMundial {

    CapaLogica cl = new CapaLogica();
    
    public GestorMundial() {
    }
    
    public boolean registrarMundial(int year, String pais, int estado) throws Exception {
        System.out.println("---------- Gestor registrarMundial "+year+ " "+ pais + " "+ estado+"----------");
        Mundial nuevoMundial;
        
        boolean existe = (new MultiMundial()).existeByYear(year);

        if (existe) {
            System.out.println("---------- registrarMundial existe ----------");
            return false;
        } else {
            try {
                (new MultiMundial()).crear(year, pais, estado);
            } catch (Exception e) {
                System.out.println("---------- "+e.getMessage()+" ----------");
                return false;
            }
            
            return true;
        }
    }
    
    public ArrayList<Integer> listarMundiales() throws Exception {
        try {
            return (new MultiMundial().listarMundiales());  
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
    
    public Mundial getMundial(int year) throws Exception {
        try {
            return (new MultiMundial().buscarByYear(year));  
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
    
}
