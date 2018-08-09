/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.multi;

import cr.ac.ucenfotec.capalogica.*;
import cr.ac.ucenfotec.db.Conector;
import java.sql.ResultSet;

/**
 *
 * @author carolina l.
 */
public class MultiUsuario {

    public static Usuario crear(String nombre, String apellidos, String correo, Equipo favorito, String UserName, String clave) throws Exception {
        Usuario nuevoUsuario = null;
        int rs;
        String sql;
        sql = "INSERT INTO Usuarios (nombre, apellidos, correo, puntos, favorito, userName, clave, tipoUsuario) "
                + "VALUES ('" + nombre + "', '" + apellidos + "', '" + correo + "'," + 100 + ", " + favorito.getCodigoEquipo() + ", '" + UserName + "', '" + clave + "', " + 1 + ");";

        try {
            Conector.getConector().ejecutarSQL(sql);
            nuevoUsuario = new Usuario(nombre, apellidos, correo, 100, favorito, UserName, clave);
        } catch (Exception e) {
            throw new Exception("El n�mero de identificaci�n ya est� en el sistema.");
        }

        return nuevoUsuario;
    }

    public Usuario buscarByCodigo(int codigoUsuario) throws java.sql.SQLException, Exception {
        Usuario usuario = null;
        Equipo equipo = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoUsuario, nombre, apellidos, correo, puntos, favorito, userName, clave, codigoEquipo, codigoPais, nombrePais, ranking ,tipoUsuario"
                + "FROM Usuarios, Equipos "
                + "WHERE codigoUsuario='" + codigoUsuario + "'"
                + "AND favorito = Equipos.codigoEquipo;";
        rs = Conector.getConector().ejecutarSQL(sql, true);

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

    public Usuario buscarByCorreo(String correo) throws java.sql.SQLException, Exception {
        Usuario usuario = null;
        Equipo equipo = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoUsuario, nombre, apellidos, correo, puntos, favorito, userName, clave, codigoEquipo, codigoPais, nombrePais, ranking ,tipoUsuario"
                + "FROM Usuarios, Equipos "
                + "WHERE correo='" + correo + "'"
                + "AND favorito = Equipos.codigoEquipo;";
        rs = Conector.getConector().ejecutarSQL(sql, true);

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

    public Usuario buscarByUserName(String userName) throws java.sql.SQLException, Exception {
        Usuario usuario = null;
        Equipo equipo = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoUsuario, nombre, apellidos, correo, puntos, favorito, userName, clave, codigoEquipo, codigoPais, nombrePais, ranking ,tipoUsuario"
                + "FROM Usuarios, Equipos "
                + "WHERE userName='" + userName + "'"
                + "AND favorito = Equipos.codigoEquipo;";
        rs = Conector.getConector().ejecutarSQL(sql, true);

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

    public Usuario login(String userName, String clave) throws java.sql.SQLException, Exception {
        Usuario usuario = null;
        Equipo equipo = null;
        ResultSet rs;
        String sql;
        sql = "SELECT codigoUsuario, nombre, apellidos, correo, puntos, favorito, userName, clave "
                + "FROM Usuarios u "
                + "WHERE userName ='" + userName + "' AND clave='" + clave + "';";
        rs = Conector.getConector().ejecutarSQL(sql, true);

        if (rs != null) {
            if (rs.next()) {
                int fav = rs.getInt("favorito");
                usuario = new Usuario(
                        rs.getInt("codigoUsuario"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("correo"),
                        rs.getString("UserName"),
                        rs.getString("clave"));
                
                if (fav!=0) {
                    sql = "SELECT codigoEquipo, codigoPais, nombrePais, ranking "
                            + "FROM Equipos "
                            + "WHERE codigoEquipo ='" + fav + "';";
                    rs = Conector.getConector().ejecutarSQL(sql, true);
                    if (rs != null) {
                        if (rs.next()) {
                            equipo = new Equipo(rs.getInt("codigoEquipo"),
                                    rs.getString("codigoPais"),
                                    rs.getString("nombrePais"),
                                    rs.getInt("ranking"));
                            usuario.setFavorito(equipo);
                            rs.close();
                        }
                    }
                }
                rs.close();
            }
        };

        return usuario;
    }
}
