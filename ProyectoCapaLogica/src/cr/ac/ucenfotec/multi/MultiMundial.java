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
public class MultiMundial {

    public void crear(int year, String pais, int estado) throws java.sql.SQLException, Exception {
        Mundial mundial = null;
        int rs = 0;
        String sql;
        sql = "INSERT INTO Mundial (year, pais, estado) "
                + "VALUES ('" + year + "', '" + pais + "', '" + estado + "');";
        try {
            System.out.println("---------- crear try ----------");
            rs = Conector.getConector().ejecutarSQL(sql, 0);
            mundial = new Mundial(year, pais, estado);
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }

    public Mundial buscarByYear(int year) throws java.sql.SQLException, Exception {
        Mundial mundial = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoMundial, year, pais, estado "
                + "FROM Mundial "
                + "WHERE year='" + year + "';";
        try {
            rs = Conector.getConector().ejecutarSQL(sql, true);
            if (rs != null && rs.next()) {
                System.out.println("---------- buscarByYear try ----------");
                mundial = new Mundial(
                    rs.getInt("codigoMundial"),
                    rs.getInt("year"),
                    rs.getString("pais"),
                    rs.getInt("estado"));
                rs.close();
                return mundial;
            } else {
                System.out.println("---------- Error en registro. ----------");
                throw new Exception("Error en registro.");
            }
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
    
    public boolean existeByYear(int year) throws java.sql.SQLException, Exception {
        Mundial mundial = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoMundial, year, pais, estado "
                + "FROM Mundial "
                + "WHERE year='" + year + "';";
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

    public ArrayList<Integer> listarMundiales() throws java.sql.SQLException, Exception {
        ArrayList<Integer> lista = new ArrayList<>();
        ResultSet rs;
        String sql;
        sql = "SELECT year "
                + "FROM Mundial "
                + "WHERE estado=1;";
        
        try {
            rs = Conector.getConector().ejecutarSQL(sql, true);
            if (rs != null) {
                while (rs.next()) {
                    lista.add(rs.getInt("year"));
                }
                rs.close();
            }
            return lista;
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
}
