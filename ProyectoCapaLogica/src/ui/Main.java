/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;
import cr.ac.ucenfotec.capalogica.*;
import cr.ac.ucenfotec.gestores.*;

/**
 *
 * @author Carolina L.
 * @version 1.0
 * @return null
 * @param param
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Equipo equipo = new Equipo(200, "BRA", "Brasil", 1431);
        
        boolean usuario = GestorUsuario.clienteAgregar(200, "Carlos", "Paz", "carlos@gmail.com", equipo, "carlos07", "carlos1898");
        
        System.out.println("MAIN");
        System.out.println(usuario);
    }
}
