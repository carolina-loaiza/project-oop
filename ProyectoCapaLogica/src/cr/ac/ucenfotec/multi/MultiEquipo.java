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

    public Equipo buscarByCodigo(String codigoEquipo) throws java.sql.SQLException, Exception {
        Equipo equipo = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoEquipo, codigoPais, nombrePais, ranking "
                + "FROM Equipos "
                + "WHERE codigoEquipo='" + codigoEquipo + "';";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        if (rs != null) {
            if (rs.next()) {
                equipo = new Equipo(
                        rs.getInt("codigoEquipo"),
                        rs.getString("codigoPais"),
                        rs.getString("nombrePais"),
                        rs.getInt("ranking"));
            } else {

                //si el else devuelve este mensaje como Exception y la funcion retorna un objeto tipo Equipo
                //no se puede hacer una alerta al usuario porque el exception esta en el multi y no tengo como retornarlo
                //es necesario ver que tipo de retorno vamos a tener en estas funciones
                throw new Exception("El equipo no est� registrado.");
            }

            rs.close();
        } else {
            equipo = new Equipo();
        }
        return equipo;
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
