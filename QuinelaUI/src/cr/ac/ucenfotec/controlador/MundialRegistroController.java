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

/**
 * FXML Controller class
 *
 * @author jeffry
 */
public class MundialRegistroController implements Initializable {

    
    
    @FXML
    private TextField txtAnno;

    @FXML
    private TextField txtPais;

    @FXML
    private ComboBox<?> sltGrupo1;

    @FXML
    private ComboBox<?> sltGrupo2;

    @FXML
    private ComboBox<?> sltGrupo3;

    @FXML
    private ComboBox<?> sltGrupo4;

    @FXML
    private ComboBox<?> sltGrupo5;

    @FXML
    private ComboBox<?> sltGrupo6;

    @FXML
    private ComboBox<?> sltGrupo7;

    @FXML
    private ComboBox<?> sltGrupo8;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnRegresar;

    @FXML
    void registrarMundial(ActionEvent event) {

    }

    @FXML
    void regresarVentana(ActionEvent event) {

    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
