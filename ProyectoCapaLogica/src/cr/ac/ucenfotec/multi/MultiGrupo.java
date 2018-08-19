/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.ucenfotec.multi;

import cr.ac.ucenfotec.capalogica.Equipo;
import cr.ac.ucenfotec.capalogica.Grupo;
import cr.ac.ucenfotec.db.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Carolina L.
 * @version 1.0
 */
public class MultiGrupo {
    
    public void crear(int codigoMundial, String nombre, String equipo1, String equipo2, String equipo3, String equipo4) throws java.sql.SQLException, Exception {
        int rs = 0;
        String sql;
        sql = "INSERT INTO Grupos (codigoMundial, nombre, equipo1, equipo2, equipo3, equipo4) "
                + "VALUES ('" + codigoMundial + "', '" + nombre + "', '" + equipo1 + "', '" + equipo2 + "', '" + equipo3 + "', '" + equipo4 + "');";
        try {
            System.out.println("---------- MultiGrupo crear try ----------");
            rs = Conector.getConector().ejecutarSQL(sql, 0);
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
    
    public boolean existeByNombre(String nombre) throws java.sql.SQLException, Exception {
        Grupo grupo = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoMundial, nombre "
                + "FROM Grupos "
                + "WHERE nombre='" + nombre + "';";
        try {
            rs = Conector.getConector().ejecutarSQL(sql, true);
            if (rs != null && rs.next()) {
                System.out.println("---------- existeByYear try ----------");
                System.out.println("---------- existeByYear try"+rs.getInt("codigoMundial")+" ----------");
                rs.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            return false;
        }
    }
    
    public static ArrayList<Grupo> listarGrupos() throws java.sql.SQLException, Exception {
        ArrayList<Grupo> listaGrupos = new ArrayList<>();
        ArrayList<String[]> listaEquipos = new ArrayList<>();
        ArrayList<Integer> listaCodigoGrupo = new ArrayList<>();
        ArrayList<Integer> listaCodigoMundial = new ArrayList<>();
        ArrayList<String> listaNombreGrupo = new ArrayList<>();
        ResultSet rs;
        String sql;
        sql = "SELECT codigoGrupo, codigoMundial, nombre, equipo1, equipo2, equipo3, equipo4 "
                + "FROM Grupos;";
        
        try {
            rs = Conector.getConector().ejecutarSQL(sql, true);
            if (rs != null) {
                while (rs.next()) {
                    String[] listaNombreEquipos = new String[4];
                    listaNombreEquipos[0] = rs.getString("equipo1");
                    listaNombreEquipos[1] = rs.getString("equipo2");
                    listaNombreEquipos[2] = rs.getString("equipo3");
                    listaNombreEquipos[3] = rs.getString("equipo4");

                    listaCodigoGrupo.add(rs.getInt("codigoGrupo"));
                    listaCodigoMundial.add(rs.getInt("codigoMundial"));
                    listaNombreGrupo.add(rs.getString("nombre"));
                    listaEquipos.add(listaNombreEquipos);
                }
                rs.close();
                
                for (int i = 0; i < listaCodigoGrupo.size();) {
                    ArrayList<Equipo> equipos = new ArrayList<>();
                    
                    for (String nombreEquipo : listaEquipos.get(i)) {
                        Equipo tempEquipo = MultiEquipo.buscarByPais(nombreEquipo);
                        equipos.add(tempEquipo);
                    };
                
                    Grupo tempGrupo = new Grupo(
                            listaCodigoGrupo.get(i),
                            listaCodigoMundial.get(i),
                            listaNombreGrupo.get(i),
                            equipos
                    );
                    
                    listaGrupos.add(tempGrupo);
                    i++;
                }
                
                return listaGrupos;
            } else {
                throw new Exception("Empty");
            }
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
}
