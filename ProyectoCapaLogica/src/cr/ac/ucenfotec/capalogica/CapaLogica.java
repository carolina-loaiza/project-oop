/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.capalogica;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jeffry
 */
public class CapaLogica {

    public CapaLogica() {

    }

    public boolean registrarUsuario(Usuario nuevo) throws IOException {

        Persistencia archivo = new Persistencia("usuarios.txt");
        boolean registrado = true;

        if (existeUsuario(nuevo.getCorreo())) {
            registrado = false;
        } else {
            archivo.setData(nuevo.toString());
        }

        return registrado;
    }

    public boolean existeUsuario(String correo) throws IOException {
        Persistencia archivo = new Persistencia("usuarios.txt");
        boolean existe = false;
        ArrayList<String> listaUsuarios = archivo.getData();
        String[] usuario;

        for (String i : listaUsuarios) {
            usuario = i.split(",");
            if (correo.equals(usuario[2])) {
                existe = true;
            }
        }

        return existe;
    }

    public boolean iniciarSesion(String userName, String clave) throws IOException {
        boolean sesionIniciada = true;

        Persistencia archivo = new Persistencia("usuarios.txt");

        ArrayList<String> listaUsuarios = archivo.getData();
        String[] datosUsuario;

        for (String i : listaUsuarios) {
            datosUsuario = i.split(",");
            if (userName.equals(datosUsuario[5]) && clave.equals(datosUsuario[6])) {
                sesionIniciada = true;
            }
        }
        return sesionIniciada;
    }

    public boolean registrarMundial(Mundial campeonato) throws IOException {
        boolean registrado = true;

        Persistencia archivo = new Persistencia("mundiales.txt");
        if (existeMundial(campeonato.getPais())) {
            registrado = false;
        } else {
            archivo.setData(campeonato.toString());
        }

        return registrado;

    }

    public String[] listarMundiales() throws IOException {
        Persistencia archivo = new Persistencia("mundiales.txt");
        ArrayList<String> lista = archivo.getData();
        String[] mundiales = new String[lista.size()];
        
        int cont = 0;
        for (String i : lista) {
            mundiales[cont]=i;
            cont++;
        }

        return mundiales;
    }

    public boolean existeMundial(String pais) throws IOException {
        Persistencia archivo = new Persistencia("mundiales.txt");
        boolean existe = false;
        ArrayList<String> listaMundiales = archivo.getData();
        String[] torneo;

        for (String i : listaMundiales) {
            torneo = i.split(",");
            if (pais.equals(torneo[1])) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarGrupo(Grupo nuevo) throws IOException {
        boolean registrado = true;

        Persistencia archivo = new Persistencia("grupos.txt");
        if (existeGrupo(Integer.toString(nuevo.getCodigoGrupo()))) {
            registrado = false;
        } else {
            archivo.setData(nuevo.toString());
        }

        return registrado;

    }

    public boolean existeGrupo(String codigo) throws IOException {
        Persistencia archivo = new Persistencia("grupos.txt");
        boolean existe = false;
        ArrayList<String> listaGrupos = archivo.getData();
        String[] grupo;

        for (String i : listaGrupos) {
            grupo = i.split(",");
            if (codigo.equals(grupo[0])) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarEquipo(Equipo seleccion) throws IOException {
        boolean registrado = true;
        Persistencia archivo = new Persistencia("equipos.txt");
        
        if (existeEquipo(Integer.toString(seleccion.getCodigoPais()))) {
            registrado = false;
        } else {
            archivo.setData(seleccion.toString());
        }

        return registrado;
    }

    public boolean existeEquipo(String codigo) throws IOException {
        Persistencia archivo = new Persistencia("equipos.txt");
        boolean existe = false;
        ArrayList<String> listaEquipos = archivo.getData();
        String[] seleccion;

        for (String i : listaEquipos) {
            seleccion = i.split(",");
            if (codigo.equals(seleccion[0])) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarPublica(LigaPublica nuevaLiga) throws IOException {
        boolean registrado = true;

        Persistencia archivo = new Persistencia("publicas.txt");
        if (existePublica(nuevaLiga.getNombre())) {
            registrado = false;
        } else {
            archivo.setData(nuevaLiga.toString());
        }

        return registrado;
    }

    public boolean existePublica(String codigo) throws IOException {
        Persistencia archivo = new Persistencia("publicas.txt");
        boolean existe = false;
        ArrayList<String> listaPublicas = archivo.getData();
        String[] liga;

        for (String i : listaPublicas) {
            liga = i.split(",");
            if (codigo.equals(liga[0])) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarPrivada(LigaPrivada nuevaLiga) throws IOException {
        boolean registrado = true;

        Persistencia archivo = new Persistencia("privadas.txt");
        if (existePrivada(nuevaLiga.getNombre())) {
            registrado = false;
        } else {
            archivo.setData(nuevaLiga.toString());
        }

        return registrado;
    }

    public boolean existePrivada(String codigo) throws IOException {
        Persistencia archivo = new Persistencia("privadas.txt");
        boolean existe = false;
        ArrayList<String> listaPrivadas = archivo.getData();
        String[] liga;

        for (String i : listaPrivadas) {
            liga = i.split(",");
            if (codigo.equals(liga[0])) {
                existe = true;
            }
        }
        return existe;
    }

}
