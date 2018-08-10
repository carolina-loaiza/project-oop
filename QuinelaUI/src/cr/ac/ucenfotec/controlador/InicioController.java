/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import cr.ac.ucenfotec.gestores.GestorUsuario;
import cr.ac.ucenfotec.multi.MultiUsuario;

public class InicioController implements Initializable {

    @FXML
    private AnchorPane Inicio;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Button btnIngresar;

    @FXML
    private Hyperlink lnkRegistro;

    @FXML
    private ImageView imgInicio;

    GestorUsuario gUsuario = new GestorUsuario();

    @FXML
    void inicioSesión(ActionEvent event) throws IOException, Exception {
        String usuario;
        String pass;

        if (vacio()) {
            Alert d = new Alert(Alert.AlertType.WARNING);
            d.setContentText("complete los campos en blanco");
            d.showAndWait();
        } else {
            usuario = txtUsuario.getText();
            pass = txtPass.getText();

            if (gUsuario.inicioSesion(usuario, pass)) {
                int index = gUsuario.getSesion().length;
                int roll = Integer.parseInt(gUsuario.getSesion()[index - 1]);
                if (roll == 1) {

                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/MenuUsuario.fxml"));
                    } catch (Exception ex) {
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    Stage stg = (Stage) btnIngresar.getScene().getWindow();
                    stg.hide();
                    stage.showAndWait();
                } else {

                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/Menu.fxml"));
                    } catch (Exception ex) {
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    Stage stg = (Stage) btnIngresar.getScene().getWindow();
                    stg.hide();
                    stage.showAndWait();
                }
            } else {
                Alert d = new Alert(Alert.AlertType.WARNING);
                d.setContentText("el usuario no existe, vuelva a intentarlo");
                d.show();
            }

        }
    }

    @FXML
    void registrarUsuario(MouseEvent event) throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/RegistroUsuario.fxml"));
        } catch (Exception ex) {
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    private boolean vacio() {

        boolean vacio = false;

        if (txtUsuario.getText().equals("")
                || txtPass.getText().equals("")) {
            vacio = true;
        }

        return vacio;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
