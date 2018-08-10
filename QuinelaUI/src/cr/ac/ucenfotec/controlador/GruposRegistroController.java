/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author jeffry
 */
public class GruposRegistroController implements Initializable {


    @FXML
    private AnchorPane registroGrupos;

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<?> sltEquipo1;

    @FXML
    private ComboBox<?> sltEquipo2;

    @FXML
    private ComboBox<?> sltEquipo3;

    @FXML
    private ComboBox<?> sltEquipo4;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnRegresar;

    @FXML
    void registrarGrupos(ActionEvent event) {

    }

    @FXML
    void regresarMenu(ActionEvent event) {

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
