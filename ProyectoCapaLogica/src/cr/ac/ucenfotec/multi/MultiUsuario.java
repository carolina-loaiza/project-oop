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

public class MultiUsuario {
    
    public static Usuario crear (int codigoUsuario, String nombre, String apellidos, String correo, Equipo favorito, String UserName, String clave) throws Exception {
        Usuario nuevoUsuario = null;
        int rs;
        String sql;
	sql = "INSERT INTO Usuarios (codigoUsuario, nombre, apellidos, correo, puntos, favorito, userName, clave) "+
              "VALUES ('"+codigoUsuario+"', '"+nombre+"', '"+apellidos+"', '"+correo+"', 0, "+favorito.getCodigoEquipo()+", '"+UserName+"', '"+clave+"');";

        try {
            rs = JDBC.executeUpdate(sql);
            nuevoUsuario = new Usuario(codigoUsuario, nombre, apellidos, correo, favorito, UserName, clave);
	}catch (Exception e) {
            throw new Exception ("El n�mero de identificaci�n ya est� en el sistema.");
	}
        
        return nuevoUsuario;
    }
    
    public Usuario buscarByCodigo(int codigoUsuario) throws java.sql.SQLException,Exception{
	Usuario usuario = null;
        Equipo equipo = null;
	java.sql.ResultSet rs;
	String sql;
        sql = "SELECT codigoUsuario, nombre, apellidos, correo, puntos, favorito, userName, clave, codigoEquipo, codigoPais, nombrePais, ranking "+
              "FROM Usuarios, Equipos "+
              "WHERE codigoUsuario='"+ codigoUsuario +"'"+
              "AND favorito = Equipos.codigoEquipo;";
	rs = JDBC.executeQuery(sql);

        if (rs != null && rs.next()) {
            usuario = new Usuario(
                    rs.getInt("codigoUsuario"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("correo"),
                    rs.getString("UserName"),
                    rs.getString("clave"));

            equipo = new Equipo(rs.getInt("codigoEquipo"),
                    rs.getString("codigoPais"),
                    rs.getString("nombrePais"),
                    rs.getInt("ranking"));
            usuario.setFavorito(equipo);

            rs.close();
        };
                	
	return usuario;
    }
    
    public Usuario login(String userName, String clave) throws java.sql.SQLException,Exception{
	Usuario usuario = null;
        Equipo equipo = null;
	java.sql.ResultSet rs;
	String sql;
        sql = "SELECT codigoUsuario, nombre, apellidos, correo, puntos, favorito, userName, clave, codigoEquipo, codigoPais, nombrePais, ranking "+
              "FROM Usuarios, Equipos "+
              "WHERE userName ='"+ userName +"' AND clave='"+ clave +"'"+
              "AND favorito = Equipos.codigoEquipo;";
	rs = JDBC.executeQuery(sql);

        if (rs != null && rs.next()) {
            usuario = new Usuario(
                    rs.getInt("codigoUsuario"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("correo"),
                    rs.getString("UserName"),
                    rs.getString("clave"));

            equipo = new Equipo(rs.getInt("codigoEquipo"),
                    rs.getString("codigoPais"),
                    rs.getString("nombrePais"),
                    rs.getInt("ranking"));
            usuario.setFavorito(equipo);

            rs.close();
        };
                	
	return usuario;
    }
}
