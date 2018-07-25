/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.CapaLogica;
import cr.ac.ucenfotec.capalogica.Mundial;
import java.io.IOException;

/**
 *
 * @author jeffry
 */
    

public class GestorMundial {

    CapaLogica cl = new CapaLogica();
    
    public GestorMundial() {
    }
    
    public boolean registrarMundial() throws IOException{
        
        Mundial campeonato = new Mundial();
        
        return cl.registrarMundial(campeonato);
    }
    
    
    
    public String[] listarMundial() throws IOException{
    
        return cl.listarMundiales();
    }
    
    
}
