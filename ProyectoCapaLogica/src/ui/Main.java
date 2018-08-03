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
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Equipo equipo = new Equipo(3, "BEl", "Brasil", 1431);
        
        boolean usuario = GestorUsuario.clienteAgregar(1, "Maria", "Castro", "castro@gmail.com", equipo, "castro0232", "castro345");
        
        System.out.println("MAIN");
        System.out.println(usuario);
    }
}
