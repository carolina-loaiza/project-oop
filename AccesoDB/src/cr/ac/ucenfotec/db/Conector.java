package cr.ac.ucenfotec.db;

import java.util.ArrayList;

/**
 * Clase Conector
 *
 * @version 1.0
 * @author Laura Monge Izaguirre Clase que inicializa la conexi�n con los
 * valores correctos y permite manejar una unica conexion para todo el proyecto
 *
 */
public class Conector {
    //atributo de la clase	

    private static AccesoBD conectorBD = null;

    /**
     * Metodo estatico que devuelve el objeto AccesoBD para que sea utilizado
     * por las clases
     *
     * @return objeto del tipo AccesoBD del paquete CapaAccesoDatos
     */
//	public static AccesoBD getConector() throws 
//	java.sql.SQLException,Exception{
//		if (conectorBD == null){			
////			conectorBD = new AccesoBD("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:BDCxC","sa","jass2002");
//			conectorBD = new AccesoBD("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:BDCxCAccess","","");
//		}
//		return conectorBD;
//	}
//	
    public static AccesoBD getConector() throws java.sql.SQLException, Exception {
        Persistencia archivo = new Persistencia("conexion.txt");
        ArrayList<String> datos = archivo.getData();
        String[] info = new String[datos.size()];
        int cont = 0;
        for (String i : datos) {
            info[cont] = i;
            cont++;
        }
        if (conectorBD == null) {
            conectorBD = new AccesoBD(info[2],
                    info[4]);
        }
        return conectorBD;
    }

}
