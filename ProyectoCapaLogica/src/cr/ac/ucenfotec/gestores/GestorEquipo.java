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
 * @author jeffry
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

    public static Equipo equipoBuscar(String codigoPais) throws Exception {
        Equipo equipo;
        equipo = (new MultiEquipo()).buscarByCodigo(codigoPais);

        return equipo;
    }

    public boolean existeEquipo(String codigo) throws IOException {

        return cl.existeEquipo(codigo);
    }

    public String buscarCodigo(String nombre) throws IOException {

        return cl.buscarCodigoEquipo(nombre);
    }

    public Equipo buscarEquipo(String codigo) throws IOException {

        return cl.buscarEquipoPorCodigo(codigo);
    }

    public String[] listaEquipos() throws IOException {

        return cl.listaEquipos();
    }
    
    public ArrayList<String> listaNombre() throws Exception{
    
        return (new MultiEquipo()).listarNombres();
        
    }

}
