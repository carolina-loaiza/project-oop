/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.CapaLogica;
import cr.ac.ucenfotec.capalogica.Equipo;
import cr.ac.ucenfotec.multi.MultiEquipo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Carolina
 */
public class GestorEquipo {

    CapaLogica cl = new CapaLogica();

    public GestorEquipo() {

    }

    public static boolean equipoAgregar(String codigoPais, String nombrePais, int ranking) throws Exception {
        Equipo nuevoEquipo;
        boolean existe=false;
        existe = (new MultiEquipo()).existeByCodigo(codigoPais);

        if (existe) {
            return false;
        }else{

        nuevoEquipo = (new MultiEquipo()).crear(codigoPais, nombrePais, ranking);
        return true;
        }
    }

    public static Equipo buscarPais(String nombrePais) throws Exception {
        try {
            return (new MultiEquipo().buscarByPais(nombrePais));  
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
    
    public ArrayList<String> listaNombre() throws Exception {
        try {
            return (new MultiEquipo()).listarNombres();  
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }

}
