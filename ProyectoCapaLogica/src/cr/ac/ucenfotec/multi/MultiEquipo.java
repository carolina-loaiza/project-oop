/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.ucenfotec.multi;

import cr.ac.ucenfotec.capalogica.*;
import cr.ac.ucenfotec.multi.JDBC;
import java.sql.ResultSet;

/**
 *
 * @author carolina l.
 */

public class MultiEquipo {
    
    public static Equipo crear (int codigoEquipo, String codigoPais, String nombrePais, int ranking) throws Exception{
        Equipo equipo = null;
        int rs = 0;
        String sql;
        sql = "INSERT INTO Equipos (codigoEquipo, codigoPais, nombrePais, ranking) "+
            "VALUES ('"+codigoEquipo+"', '"+codigoPais+"', '"+nombrePais+"', '"+ranking+"');";

        try {
            rs = JDBC.executeUpdate(sql);
            equipo = new Equipo(codigoEquipo, codigoPais, nombrePais, ranking);
        } catch (Exception e) {
            throw new Exception ("El n�mero de identificaci�n ya est� en el sistema.");
        }
    
        return equipo;
    }   
    
    public Equipo buscarByCodigo(int codigoEquipo) throws java.sql.SQLException,Exception{
        Equipo equipo = null;
	java.sql.ResultSet rs;
	String sql;
	sql = "SELECT codigoEquipo, codigoPais, nombrePais, ranking"+
              "FROM Equipos "+
              "WHERE codigoEquipo='"+ codigoEquipo +"';";
	rs = JDBC.executeQuery(sql);
        
        if (rs.next()) {
            equipo = new Equipo(
                    rs.getInt("codigoEquipo"),
                    rs.getString("codigoPais"),
                    rs.getString("nombrePais"),
                    rs.getInt("ranking"));
        } else {
            throw new Exception ("El cliente no est� registrado.");
	}
                
	rs.close();
	return equipo;
    }
}
