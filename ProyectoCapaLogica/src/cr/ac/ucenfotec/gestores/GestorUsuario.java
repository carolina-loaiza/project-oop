/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.CapaLogica;
import cr.ac.ucenfotec.capalogica.Equipo;
import cr.ac.ucenfotec.capalogica.Usuario;
import cr.ac.ucenfotec.multi.MultiEquipo;
import cr.ac.ucenfotec.multi.MultiUsuario;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author jeffry
 */
public class GestorUsuario {

    CapaLogica cl = new CapaLogica();

    public GestorUsuario() {
    }


    public boolean usuarioAgregar(String nombre, String apellidos, String correo, String favorito, String UserName, String clave) throws Exception {
        Usuario nuevoUsuario;
        Equipo nuevoEquipo;      
        boolean hecho = false;
        nuevoUsuario = (new MultiUsuario()).buscarByCorreo(correo);
        nuevoEquipo = (new GestorEquipo()).buscarPais(favorito);
        if (nuevoUsuario == null) {
            hecho = true;
            nuevoUsuario = (new MultiUsuario()).crear( nombre, apellidos, correo, nuevoEquipo, UserName, clave);
        }
        
        return hecho;
    }

    public String[] listarUsuario() throws IOException {

        return cl.listarUsuarios();
    }

    public boolean inicioSesion(String usuario, String pass) throws SQLException, Exception {
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

    public boolean existeUsuario(String correo) throws SQLException, Exception {

        return (new MultiUsuario()).existeByCorreo(correo);
    }

    public boolean existeUName(String correo) throws SQLException, Exception {


        return (new MultiUsuario()).existeByUserName(correo);
    }

}
