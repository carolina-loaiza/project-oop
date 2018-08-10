/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.CapaLogica;
import cr.ac.ucenfotec.capalogica.Equipo;
import cr.ac.ucenfotec.capalogica.Usuario;
import cr.ac.ucenfotec.multi.MultiUsuario;
import java.io.IOException;

/**
 *
 * @author jeffry
 */
public class GestorUsuario {

    CapaLogica cl = new CapaLogica();

    public GestorUsuario() {
    }

    public boolean registrarUsuario(String nombre, String apellidos, String correo, String favorito, String UserName, String clave) throws IOException {

        Usuario nuevo = new Usuario();

        return cl.registrarUsuario(nuevo);
    }

    public boolean usuarioAgregar(String nombre, String apellidos, String correo, Equipo favorito, String UserName, String clave) throws Exception {
        Usuario nuevoUsuario;
        boolean hecho = false;
        nuevoUsuario = (new MultiUsuario()).buscarByCorreo(correo);

        if (nuevoUsuario == null) {
            hecho = true;
            nuevoUsuario = (new MultiUsuario()).crear( nombre, apellidos, correo, favorito, UserName, clave);
        }
        
        return hecho;
    }

    public String[] listarUsuario() throws IOException {

        return cl.listarUsuarios();
    }

    public boolean inicioSesion(String usuario, String pass) throws IOException, Exception {
        boolean iniciada = false;
        Usuario nuevo = (new MultiUsuario()).login(usuario, pass);
        if (nuevo != null) {
            cl.setSesion(nuevo);
            iniciada = true;
        }

        return iniciada;

    }

    public String[] getSesion() {
        return cl.getSesion();
    }

    public boolean existeUsuario(String correo) throws IOException {

        return cl.existeUsuario(correo);
    }

    public boolean existeUName(String correo) throws IOException {

        return cl.existeNombreUsuario(correo);
    }

}
