/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jeffry
 */
public class MenuUsuarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private AnchorPane menuUsuario;

    @FXML
    private ImageView picUsuario;

    @FXML
    private Label txtUserName;

    @FXML
    private Pane menu;

    @FXML
    private Pane ligasPublicas;

    @FXML
    private Pane ligasPrivadas;

    @FXML
    private Pane cerrarSesion;

    @FXML
    private Label txtPuntaje;

    @FXML
    void cerrarSesion(MouseEvent event) {

    }

    @FXML
    void ligasPrivadas(MouseEvent event) {

    }

    @FXML
    void ligasPublicas(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
