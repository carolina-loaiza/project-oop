/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.CapaLogica;
import cr.ac.ucenfotec.capalogica.Grupo;
import java.io.IOException;

/**
 *
 * @author jeffry
 */
public class GestorGrupo {
    
    CapaLogica cl = new CapaLogica();
    
    public GestorGrupo() {
    }
    
    public boolean registrarGrupo() throws IOException{
        
        Grupo nuevo = new Grupo();
        
        return cl.registrarGrupo(nuevo);
    }
    
    
    
    public String[] listarGrupo() throws IOException{
    
        return cl.listarGrupos();
    }
    
}
