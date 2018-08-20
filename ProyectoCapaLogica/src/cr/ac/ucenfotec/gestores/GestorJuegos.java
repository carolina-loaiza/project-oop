/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.multi.MultiJuegos;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Carolina L.
 * @version 1.0
 */
public class GestorJuegos {
    

    public static void crearPartidos(int codigoMundial, ArrayList<String[]> lista) throws IOException, Exception {
        try {
            LocalDate fechaBase = LocalDate.now();
            
            for (String[] tempListaEquipo : lista) {
                for (int i = 1; i < 4; i++) {
                    fechaBase = fechaBase.plusDays(3);
                    
                    (new MultiJuegos()).crear(codigoMundial, tempListaEquipo[0], tempListaEquipo[i], fechaBase.toString());
                }
                
                fechaBase = fechaBase.plusDays(3);
                (new MultiJuegos()).crear(codigoMundial, tempListaEquipo[1], tempListaEquipo[2], fechaBase.toString());
                fechaBase = fechaBase.plusDays(3);
                (new MultiJuegos()).crear(codigoMundial, tempListaEquipo[1], tempListaEquipo[3], fechaBase.toString());
                fechaBase = fechaBase.plusDays(3);
                (new MultiJuegos()).crear(codigoMundial, tempListaEquipo[2], tempListaEquipo[3], fechaBase.toString());
            }
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
    
    public ArrayList<String[]> listaJuegos(int codigoMundial) throws IOException, Exception {
        ArrayList<String[]> lista;
        
        try {
            lista = (new MultiJuegos()).listarJuegos(codigoMundial);
            return lista;
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
}
