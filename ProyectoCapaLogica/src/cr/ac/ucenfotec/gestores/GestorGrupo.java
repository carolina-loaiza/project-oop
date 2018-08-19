/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.CapaLogica;
import cr.ac.ucenfotec.capalogica.Grupo;
import cr.ac.ucenfotec.multi.MultiGrupo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jeffry
 */
public class GestorGrupo {
    
    CapaLogica cl = new CapaLogica();
    
    public GestorGrupo() {
    }
    
    public static boolean registrarGrupo(int codigoMundial, String nombre, String equipo1, String equipo2, String equipo3, String equipo4) throws Exception {
        System.out.println("---------- Gestor registrarGrupo ----------");
        
        boolean existe = (new MultiGrupo()).existeByNombre(nombre);

        if (existe) {
            System.out.println("---------- registrarMundial existe ----------");
            return false;
        } else {
            try {
                (new MultiGrupo()).crear(codigoMundial, nombre, equipo1, equipo2, equipo3, equipo4);
            } catch (Exception e) {
                System.out.println("---------- "+e.getMessage()+" ----------");
                return false;
            }
            
            return true;
        }
    }
    
    public ArrayList<String[]> listaEquipos() throws IOException, Exception {
        ArrayList<String[]> lista = new ArrayList<>();
        
        try {
            ArrayList<Grupo> grupos = (new MultiGrupo()).listarGrupos();
            
            for (Grupo tempGrupo : grupos) {
                String[] tempLista = new String[4];
                for (int i = 0; i < 4;) {
                    tempLista[1] = tempGrupo.getEquipos().get(i).getNombrePais();
                    i++;
                }
                
                lista.add(tempLista);
            }
            
            return lista; 
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
    
    
    
    public String[] listarGrupo() throws IOException{
    
        return cl.listarGrupos();
    }
    
}
