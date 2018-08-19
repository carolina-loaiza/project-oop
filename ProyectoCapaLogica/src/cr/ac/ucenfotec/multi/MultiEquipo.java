/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.multi;

import cr.ac.ucenfotec.capalogica.*;

import cr.ac.ucenfotec.db.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author carolina l.
 */
public class MultiEquipo {

    public static Equipo crear(String codigoPais, String nombrePais, int ranking) throws Exception {
        Equipo equipo = null;
        int rs = 0;
        String sql;
        sql = "INSERT INTO Equipos (codigoPais, nombrePais, ranking) "
                + "VALUES ('" + codigoPais + "', '" + nombrePais + "', '" + ranking + "');";

        try {
            rs = Conector.getConector().ejecutarSQL(sql, 0);
            equipo = new Equipo(codigoPais, nombrePais, ranking);
        } catch (Exception e) {
            throw new Exception("El n�mero de identificaci�n ya est� en el sistema.");
        }

        return equipo;
    }

    public Equipo buscarByCodigo(int codigoEquipo) throws java.sql.SQLException, Exception {
        Equipo equipo = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoEquipo, codigoPais, nombrePais, ranking "
                + "FROM Equipos "
                + "WHERE codigoEquipo='" + codigoEquipo + "';";
        
        try {
            rs = Conector.getConector().ejecutarSQL(sql, true);
            if (rs != null && rs.next()) {
                equipo = new Equipo(
                    rs.getInt("codigoEquipo"),
                    rs.getString("codigoPais"),
                    rs.getString("nombrePais"),
                    rs.getInt("ranking"));
                    
                rs.close();
                return equipo;
            } else {
                throw new Exception("El equipo no est� registrado.");
            }
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
    
    public static Equipo buscarByPais(String nombrePais) throws java.sql.SQLException, Exception {
        Equipo equipo = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoEquipo, codigoPais, nombrePais, ranking "
                + "FROM Equipos "
                + "WHERE nombrePais='" + nombrePais + "';";
        
        try {
            rs = Conector.getConector().ejecutarSQL(sql, true);
            if (rs != null && rs.next()) {
                equipo = new Equipo(
                    rs.getInt("codigoEquipo"),
                    rs.getString("codigoPais"),
                    rs.getString("nombrePais"),
                    rs.getInt("ranking"));
                    
                rs.close();
                return equipo;
            } else {
                throw new Exception("El equipo no est� registrado.");
            }
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }

    public boolean existeByCodigo(String codigoPais) throws java.sql.SQLException, Exception {
        Equipo equipo = null;
        ResultSet rs;
        boolean existe = false;
        String sql;
        sql = "SELECT codigoEquipo, codigoPais, nombrePais, ranking "
                + "FROM Equipos "
                + "WHERE codigoPais='" + codigoPais + "';";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        if (rs != null) {
            if (rs.next()) {
                equipo = new Equipo(
                        rs.getInt("codigoEquipo"),
                        rs.getString("codigoPais"),
                        rs.getString("nombrePais"),
                        rs.getInt("ranking"));
                rs.close();

            }

        }
        if (equipo == null) {
            existe = false;
        } else {
            if (codigoPais.equals(equipo.getCodigoPais())) {
                existe = true;
            }
        }
        return existe;
    }

    public ArrayList<String> listarNombres() throws java.sql.SQLException, Exception {
        ArrayList<String> lista = new ArrayList<>();
        ResultSet rs;
        String sql;
        sql = "SELECT  nombrePais "
                + "FROM Equipos;";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        if (rs != null) {
            while (rs.next()) {

                lista.add(rs.getString("nombrePais"));
            }

            rs.close();

        }
        return lista;
    }
}
