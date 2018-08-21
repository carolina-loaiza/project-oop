/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.capalogica.CapaLogica;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        System.out.println("\ncierre de sesion--------------------------\n");
        Parent root = null;
        try {
            (new CapaLogica()).cerrarSesion();
            String[] sesion=(new CapaLogica()).getSesion();
            System.out.println(sesion[1]);
            System.out.println("---------------------------------------\n\n");
            root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/Inicio.fxml"));
        } catch (Exception ex) {
            System.out.println("no se ha cerrado sesion");
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        Stage stg = (Stage) cerrarSesion.getScene().getWindow();
                    stg.hide();
        stage.showAndWait();
    }

    @FXML
    void ligasPrivadas(MouseEvent event) {

    }

    @FXML
    void ligasPublicas(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/Ligas.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] sesion= (new CapaLogica()).getSesion();
        txtUserName.setText(sesion[11]);
        txtPuntaje.setText(sesion[4]);
    }    
    
}
