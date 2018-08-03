
package cr.ac.ucenfotec.multi;
 
import java.io.*;
import java.util.ArrayList;

public class Conector{
	
    private static AccesoBD conectorBD = null;
    
    public static ArrayList<String> getAccesoData() throws java.io.IOException {
        ArrayList<String> data = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader("accesoBD.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            
            while ((datos = buffer.readLine()) != null) {
                data.add(datos);
            }
            
            reader.close();
            return data;
            
        } catch(IOException e) { 
            throw e;
        }
    }
	
    public static AccesoBD getConector() throws java.sql.SQLException,Exception{
        ArrayList<String> accesoData = getAccesoData();
        
        if(conectorBD==null){
            conectorBD = new AccesoBD(accesoData.get(1), accesoData.get(3));
	}
	return conectorBD;
    }	
}