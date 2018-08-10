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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuController implements Initializable {

    @FXML
    private AnchorPane MenuAdmin;

    @FXML
    private ImageView picUsuario;

    @FXML
    private Label txtUserName;

    @FXML
    private Pane menuAdmin;

    @FXML
    private MenuButton menu;

    @FXML
    private Menu menuEquipos;

    @FXML
    private MenuItem registroEquipos;

    @FXML
    private MenuItem listaEquipos;

    @FXML
    private MenuItem registrGrupos;

    @FXML
    private MenuItem listaMundial;

    @FXML
    private MenuItem rankingFifa;

    @FXML
    private MenuItem muestraCronograma;

    @FXML
    private MenuItem publica;

    @FXML
    private MenuItem privadas;

    @FXML
    private MenuItem marcadores;

    @FXML
    private MenuItem cerrarSesionAdmin;

    @FXML
    private Label txtPuntaje;

    @FXML
    void cerrarSesion(ActionEvent event) {

    }

    @FXML
    void ingresarMarcadores(ActionEvent event) {

    }

    @FXML
    void ligaPrivada(ActionEvent event) {

    }

    @FXML
    void ligaPublica(ActionEvent event) {

    }

    @FXML
    void listarEquipos(ActionEvent event) {

    }

    @FXML
    void listarMundiales(ActionEvent event) {

    }

    @FXML
    void mostrarCronogramaMundial(ActionEvent event) {

    }

    @FXML
    void mostrarRanking(ActionEvent event) {

    }

    @FXML
    void registrarEquipos(ActionEvent event) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/EquiposRegistro.fxml"));
        } catch (Exception ex) {
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();

    }

    @FXML
    void registrarGrupo(ActionEvent event) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/GruposRegistro.fxml"));
        } catch (Exception ex) {
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
