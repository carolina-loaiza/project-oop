/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.gestores.GestorEquipo;
import cr.ac.ucenfotec.gestores.GestorGrupo;
import cr.ac.ucenfotec.gestores.GestorMundial;
import java.net.URL;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
public class GruposRegistroController implements Initializable {


    @FXML
    private AnchorPane registroGrupos;

    @FXML
    private TextField txtNombre;

    @FXML
    private ChoiceBox sltMundial;

    @FXML
    private ChoiceBox sltEquipo1;

    @FXML
    private ChoiceBox sltEquipo2;

    @FXML
    private ChoiceBox sltEquipo3;

    @FXML
    private ChoiceBox sltEquipo4;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnRegresar;
    
    GestorMundial gMundial = new GestorMundial();
    GestorEquipo gEquipo = new GestorEquipo();
    GestorGrupo gGrupo = new GestorGrupo();
    ArrayList<String> listaEquipos = new ArrayList<>();
    
    
    @FXML
    void registrarGrupos(ActionEvent event) throws Exception {
        System.out.println("ActionEvent registrarGrupos ----------------------------");
        String nombre;
        int mundial;
        String equipo1;
        String equipo2;
        String equipo3;
        String equipo4;

        if (vacio()) {
            System.out.println("ActionEvent vacio ----------------------------");
            Alert d = new Alert(Alert.AlertType.WARNING);
            d.setContentText("complete los campos en blanco");
            d.showAndWait();
        } else {
            System.out.println("ActionEvent vacio else ----------------------------");
            mundial = Integer.parseInt(sltMundial.getValue().toString());
            nombre = txtNombre.getText();
            equipo1 = sltEquipo1.getValue().toString();
            equipo2 = sltEquipo2.getValue().toString();
            equipo3 = sltEquipo3.getValue().toString();
            equipo4 = sltEquipo4.getValue().toString();
            
            if (gGrupo.registrarGrupo(mundial, nombre, equipo1, equipo2, equipo3, equipo4) ) {
                Alert d = new Alert(Alert.AlertType.CONFIRMATION);
                d.setContentText("registro realizado");
                d.showAndWait();

                Parent root = null;
                try {
                    sltMundial.getItems().clear();
                    txtNombre.setText(null);
                    setListaEquipos(null, true);
                    //root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/GruposRegistro.fxml"));
                } catch (Exception ex) {
                    System.out.println("---------- "+ex.getMessage()+" ----------");
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.showAndWait();

            } else {
                Alert d = new Alert(Alert.AlertType.ERROR);
                d.setContentText("el mundial ya se encuentra registrado");
                d.showAndWait();
            }
        }
    }

    @FXML
    void regresarMenu(ActionEvent event) {

    }
    
    public void setListaEquipos (ChoiceBox selectedChoiceBox, boolean reset) {
        ArrayList<ChoiceBox> listaChoiceBox = new ArrayList<ChoiceBox>(Arrays.asList(sltEquipo1, sltEquipo2, sltEquipo3, sltEquipo4));
        
        for (ChoiceBox temChoiceBox : listaChoiceBox) {
            String value = "";
            
            if (temChoiceBox.getValue() != null) {
                value = temChoiceBox.getValue().toString();
            };
            
            if (selectedChoiceBox != temChoiceBox) {
                temChoiceBox.getItems().clear();
                for (String temp : listaEquipos) {
                   temChoiceBox.getItems().add(temp);
                }
            }
            
            if (value != "" && reset == false) {
                temChoiceBox.setValue(value);
            }
            System.out.println(value);
        }
    }
    
    public void setChoiceBoxEquipos() {
        ArrayList<ChoiceBox> listaChoiceBox = new ArrayList<ChoiceBox>(Arrays.asList(sltEquipo1, sltEquipo2, sltEquipo3, sltEquipo4));
        
        for (ChoiceBox temChoiceBox : listaChoiceBox) {
            temChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                    String nombreEquipo = temChoiceBox.getItems().get((Integer) number2).toString();
                    System.out.println(nombreEquipo);
                    listaEquipos.remove(nombreEquipo);
                    setListaEquipos(temChoiceBox, false);
                }
            });
        }
    }
    
    @FXML
    private boolean vacio() {

        boolean vacio = false;

        if (txtNombre.getText().equals("")
                || sltMundial.getValue().equals("")
                || sltEquipo1.getValue().equals("")
                || sltEquipo2.getValue().equals("")
                || sltEquipo3.getValue().equals("")
                || sltEquipo4.getValue().equals("")) {
            vacio = true;
        }

        return vacio;
    }


    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Integer> listaMundial = new ArrayList<>();
        
        try {
            listaMundial = (gMundial.listarMundiales());
            listaEquipos = (gEquipo.listaNombre());
            
            
            for (int temp : listaMundial) {
                sltMundial.getItems().add(temp);
            }
            
            setListaEquipos(null, true);
            setChoiceBoxEquipos();
            System.out.println(gGrupo.listaEquipos().toString());
        } catch (Exception e) {
            System.out.println("---------- initialize listaMundial "+e.getMessage()+" ----------");
        };   
    }

}
