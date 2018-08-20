/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.ucenfotec.multi;

import cr.ac.ucenfotec.db.Conector;

/**
 *
 * @author Carolina L.
 * @version 1.0
 */
public class MultiJuegos {
    
    public void crear(int codigoMundial, String primero, String segundo, String fecha) throws java.sql.SQLException, Exception {
        int rs = 0;
        String sql;
        sql = "INSERT INTO Juegos (codigoMundial, primero, segundo, fecha) "
                + "VALUES ('" + codigoMundial + "', '" + primero + "', '" + segundo + "', '" + fecha + "');";
        try {
            System.out.println("---------- MultiJuegos crear try ----------");
            rs = Conector.getConector().ejecutarSQL(sql, 0);
        } catch (Exception e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }
    }
}
