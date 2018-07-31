/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.ucenfotec.multi;

import java.sql.*;

/**
 *
 * @author carolina l.
 */

public class JDBC {

    public static ResultSet executeQuery(String queryDB) throws Exception {
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = null;
            Statement stmt = null;
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/proyecto_quiniela?" +
                    "user=root&password=root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryDB);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return rs;
    }
    
    public static int executeUpdate(String queryDB) throws Exception {
        int rs = 0;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = null;
            Statement stmt = null;
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/proyecto_quiniela?" +
                    "user=root&password=root");
            stmt = conn.createStatement();
            rs = stmt.executeUpdate(queryDB);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return rs;
    }
}
