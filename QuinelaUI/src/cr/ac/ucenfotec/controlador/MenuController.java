/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.gestores.GestorUsuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MenuController implements Initializable {

    @FXML
    private AnchorPane MenuPrincipal;

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
    private Pane menuUsuario;

    @FXML
    private Pane ligasPublicas;

    @FXML
    private Pane ligasPrivadas;

    @FXML
    private Pane cerrarSesion;

    @FXML
    private Label txtPuntaje;

    GestorUsuario controlador = new GestorUsuario();
    //mostrarDetalles();

    @FXML
    void cerrarSesion(MouseEvent event) {

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
    void ligasPrivadas(MouseEvent event) {

    }

    @FXML
    void ligasPublicas(MouseEvent event) {

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

    }

    @FXML
    void registrarGrupo(ActionEvent event) {

    }

    public void mostrarDetalles() {
        String[] usuario;
        usuario = controlador.getSesion();

        if (Integer.parseInt(usuario[8]) == 0) {
            txtUserName.setText("Admin");
            txtPuntaje.setVisible(false);
            menuAdmin.setVisible(true);
        } else {
            menuUsuario.setVisible(true);
            txtUserName.setText(usuario[5]);
            txtPuntaje.setText(usuario[7]);

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
