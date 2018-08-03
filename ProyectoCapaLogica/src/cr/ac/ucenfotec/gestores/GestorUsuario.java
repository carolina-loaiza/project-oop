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
    public static boolean clienteAgregar(int tipoUsuario, String nombre, String apellidos, String correo, Equipo favorito, String UserName, String clave) throws Exception {
        Usuario nuevoUsuario;
        nuevoUsuario = (new MultiUsuario()).buscarByCorreo(correo);

        if (nuevoUsuario != null) {
            return false;
        };
        
        nuevoUsuario = (new MultiUsuario()).crear(tipoUsuario, nombre, apellidos, correo, favorito, UserName, clave);
        return true;
    }

    public static Usuario usuarioBuscar(String correo) throws Exception {
        Usuario usuario;
        usuario = (new MultiUsuario()).buscarByCorreo(correo);

        return usuario;
    }

    public static Usuario usuarioLogin(String userName, String clave) throws Exception {
        Usuario usuario;
        usuario = (new MultiUsuario()).login(userName, clave);

        return usuario;
    }
}
