/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.gestores.GestorMundial;
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
import javafx.scene.control.ChoiceBox;
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
public class MundialRegistroController implements Initializable {

    @FXML
    private AnchorPane registroMundial;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtNombrePais;

    @FXML
    private ChoiceBox txtEstado;

    @FXML
    private Button btnRegistrar;

    GestorMundial gMundial = new GestorMundial();


    @FXML
    void registrarMundial(ActionEvent event) throws IOException, Exception {

        int year;
        String pais;
        String estadoInput;
        boolean estado;

        if (vacio()) {
            Alert d = new Alert(Alert.AlertType.WARNING);
            d.setContentText("complete los campos en blanco");
            d.showAndWait();
        } else {
            year = Integer.parseInt(txtYear.getText());
            pais = txtNombrePais.getText();
            estadoInput = txtEstado.getValue().toString();
            
            if (estadoInput.equals("Activo")) {
               estado = true;
            } else {
                estado = false;
            };
            
            if (gMundial.registrarMundial(year, pais, estado)) {
                Alert d = new Alert(Alert.AlertType.CONFIRMATION);
                d.setContentText("registro realizado");
                d.showAndWait();

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/Menu.fxml"));
                } catch (Exception ex) {
                    System.out.println("---------- "+ex.getMessage()+" ----------");
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

        if (txtYear.getText().equals("")
                || txtNombrePais.getText().equals("")
                || txtEstado.getValue().equals("")) {
            vacio = true;
        }

        return vacio;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtEstado.getItems().clear();
        txtEstado.getItems().addAll("Activo", "Desactivó");
        //txtEstado.getSelectionModel().select("Activo");
    }

}
