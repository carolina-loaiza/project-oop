/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.gestores.GestorEquipo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jeffry
 */
public class EquiposRegistroController implements Initializable {

        @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtRanking;

    @FXML
    private Pane bandera;

    @FXML
    private ImageView imgBandera;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TableView<?> menuEquipos;
    

    GestorEquipo controladorE = new GestorEquipo();
    

    @FXML
    void guardarBandera(MouseEvent event) {

    }

    @FXML
    void registrarEquipo(ActionEvent event) {
        
        String codigo;
        String nombre;
        String Ranking;

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
