/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.gestores.*;
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
    GestorJuegos gJuegos = new GestorJuegos();
    ArrayList<String> listaEquipos = new ArrayList<>();
    ArrayList<String[]> listaEquiposGrupo;
    
    
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
                Parent root = null;
                
                try {
                    listaEquiposGrupo = (gGrupo.listaEquipos());
                    sltMundial.getItems().clear();
                    txtNombre.setText(null);
                    setListaEquipos(null, true);
                    System.out.println(listaEquiposGrupo.size());
                    
                    Alert d = new Alert(Alert.AlertType.CONFIRMATION);
                    if (listaEquiposGrupo.size() == 8) {
                        d.setContentText("Registro realizado. Máximo de grupos creados.");
                    } else {
                        d.setContentText("Registro realizado.");
                    }
                    
                    d.showAndWait();
                    
                    if (listaEquiposGrupo.size() == 8) {
                        crearPartidos(mundial, listaEquiposGrupo);
                        //root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/cronograma.fxml"));
                    }
                } catch (Exception ex) {
                    System.out.println("---------- "+ex.getMessage()+" ----------");
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.showAndWait();

            } else {
                Alert d = new Alert(Alert.AlertType.ERROR);
                d.setContentText("El grupo ya se encuentra registrado.");
                d.showAndWait();
            }
        }
    }

    @FXML
    void regresarMenu(ActionEvent event) {

    }
    
    public void crearPartidos(int mundial, ArrayList<String[]> listaEquiposGrupo) {
        try {
            gJuegos.crearPartidos(mundial, listaEquiposGrupo);
        } catch (Exception e) {
            System.out.println("---------- crearPartidos "+e.getMessage()+" ----------");
        }
    }
    
    public void setListaEquipos (ChoiceBox selectedChoiceBox, boolean reset) {
        ArrayList<ChoiceBox> listaChoiceBox = new ArrayList<ChoiceBox>(Arrays.asList(sltEquipo1, sltEquipo2, sltEquipo3, sltEquipo4));
        
        for (ChoiceBox temChoiceBox : listaChoiceBox) {
            
            if ((selectedChoiceBox != temChoiceBox && temChoiceBox.getValue() == null) || reset)  {
                temChoiceBox.getItems().clear();
                for (String temp : listaEquipos) {
                   temChoiceBox.getItems().add(temp);
                }
            }
        }
    }
    
    public void removerEquipos() {
        for (String[] equipos : listaEquiposGrupo) {
            for (String equipo : equipos) {
                if (listaEquipos.contains(equipo)) {
                    listaEquipos.remove(equipo);
                }
            }
        }
    }
    
    public void setChoiceBoxEquipos() {
        ArrayList<ChoiceBox> listaChoiceBox = new ArrayList<ChoiceBox>(Arrays.asList(sltEquipo1, sltEquipo2, sltEquipo3, sltEquipo4));
        
        for (ChoiceBox temChoiceBox : listaChoiceBox) {
            temChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                    String nombreEquipo = temChoiceBox.getItems().get((Integer) number2).toString();
                    listaEquipos.remove(nombreEquipo);
                    System.out.println(nombreEquipo);
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
            listaEquiposGrupo = (gGrupo.listaEquipos());
            
            for (int temp : listaMundial) {
                sltMundial.getItems().add(temp);
            }
            
            removerEquipos();
            setListaEquipos(null, false);
            setChoiceBoxEquipos();
        } catch (Exception e) {
            System.out.println("---------- initialize listaMundial "+e.getMessage()+" ----------");
        };   
    }

}
