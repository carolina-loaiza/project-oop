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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
public class EquiposRegistroController implements Initializable {

    @FXML
    private AnchorPane registroEquipos;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtRanking;

    @FXML
    private Button btnRegistrar;

    @FXML
    private ImageView imgBandera;

    @FXML
    private Pane bandera;

    GestorEquipo gEquipo = new GestorEquipo();

    @FXML
    void guardarBandera(MouseEvent event) {

    }

    @FXML
    void registrarEquipo(ActionEvent event) throws IOException, Exception {

        String codigo;
        String pais;
        String ranking;
        Image bandera;

        if (vacio()) {
            Alert d = new Alert(Alert.AlertType.WARNING);
            d.setContentText("complete los campos en blanco");
            d.showAndWait();
        } else {
            codigo = txtCodigo.getText();
            pais = txtNombre.getText();
            ranking = txtRanking.getText();
            //bandera=imgBandera.getImage();

            if (gEquipo.equipoAgregar(codigo, pais, Integer.parseInt(ranking))) {
                Alert d = new Alert(Alert.AlertType.CONFIRMATION);
                d.setContentText("registro realizado");
                d.showAndWait();

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/Menu.fxml"));
                } catch (Exception ex) {
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.showAndWait();

            } else {
                Alert d = new Alert(Alert.AlertType.ERROR);
                d.setContentText("el equipo ya se encuentra registrado");
                d.showAndWait();
            }
        }

    }

    @FXML
    private boolean vacio() {

        boolean vacio = false;

        if (txtCodigo.getText().equals("")
                || txtNombre.getText().equals("")
                || txtRanking.getText().equals("")) {
            vacio = true;
        }

        return vacio;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
