/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.gestores;

import cr.ac.ucenfotec.capalogica.CapaLogica;
import cr.ac.ucenfotec.capalogica.Equipo;
import java.io.IOException;

/**
 *
 * @author jeffry
 */
public class GestorEquipo {
    
    CapaLogica cl = new CapaLogica();
    
    public GestorEquipo() {
        
    }
    
    public boolean registrarEquipo(String codigoPais, String nombrePais, int ranking) throws IOException{
        
        Equipo nuevo = new Equipo(codigoPais, nombrePais, ranking);
        
        return cl.registrarEquipo(nuevo);
    }
    
    public boolean existeEquipo(String codigo) throws IOException{
        
        return cl.existeEquipo(codigo);
    }
    
    public String buscarCodigo(String nombre) throws IOException{
        
        return cl.buscarCodigoEquipo(nombre);
    }
    
    public Equipo buscarEquipo(String codigo) throws IOException{
    
        return cl.buscarEquipoPorCodigo(codigo);
    }
    
    
    
    public String[] listaEquipos() throws IOException{
    
        return cl.listaEquipos();
    }
    
}
