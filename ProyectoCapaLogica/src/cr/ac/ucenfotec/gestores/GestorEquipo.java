/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.*;
import cr.ac.ucenfotec.multi.MultiEquipo;

/**
 *
 * @author carolina l.
 */

public class GestorEquipo {
    public static boolean equipoAgregar(String codigoPais, String nombrePais, int ranking) throws Exception {
        Equipo nuevoEquipo;
        nuevoEquipo = (new MultiEquipo()).buscarByCodigo(codigoPais);

        if (nuevoEquipo != null) {
            return false;
        };
        
        nuevoEquipo = (new MultiEquipo()).crear(codigoPais, nombrePais, ranking);
        return true;
    }

    public static Equipo equipoBuscar(String codigoPais) throws Exception {
        Equipo equipo;
        equipo = (new MultiEquipo()).buscarByCodigo(codigoPais);

        return equipo;
    }
}
