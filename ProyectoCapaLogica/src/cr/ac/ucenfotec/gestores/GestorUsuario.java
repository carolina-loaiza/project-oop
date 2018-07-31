/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.*;
import cr.ac.ucenfotec.multi.MultiUsuario;

/**
 *
 * @author carolina l.
 */

public class GestorUsuario {
    public static boolean clienteAgregar(int codigoUsuario, String nombre, String apellidos, String correo, Equipo favorito, String UserName, String clave) throws Exception {
        Usuario nuevoUsuario;
        nuevoUsuario = (new MultiUsuario()).buscarByCodigo(codigoUsuario);

        if (nuevoUsuario != null) {
            return false;
        };
        
        nuevoUsuario = (new MultiUsuario()).crear(codigoUsuario, nombre, apellidos, correo, favorito, UserName, clave);
        return true;
    }
}
