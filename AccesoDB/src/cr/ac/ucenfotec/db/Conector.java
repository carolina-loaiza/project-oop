package cr.ac.ucenfotec.db;

import java.util.ArrayList;

public class Conector {
    //atributo de la clase	

    private static AccesoBD conectorBD = null;

    /**
     * Metodo estatico que devuelve el objeto AccesoBD para que sea utilizado
     * por las clases
     *
     * @return objeto del tipo AccesoBD del paquete CapaAccesoDatos
     */

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
