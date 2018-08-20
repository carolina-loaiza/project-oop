/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.gestores.GestorJuegos;;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAttribute;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.beans.GridPane;

/**
 * FXML Controller class
 *
 * @author Carolina L.
 */
public class CronogramaController implements Initializable {

    @FXML
    private AnchorPane mostrarCronograma;

    @FXML
    private ChoiceBox sltMundial;

    GestorJuegos gJuegos = new GestorJuegos();
    
    public void mostrarCronograma(int mundial) {
        System.out.println("ActionEvent registrarGrupos "+mundial+" ----------------------------");
        
        try {
            ArrayList<String[]> listaEquiposGrupo = (gJuegos.listaJuegos(mundial));
            
            for (String[] listaJuegos : listaEquiposGrupo) {
                for (int i = 0; i < 4; i++) {
                    Label nuevoLabel = new Label();
                    nuevoLabel.GridPane.columnIndex = "2";
                    nuevoLabel.setText(listaJuegos[0]+" vrs "+listaJuegos[1]);
                }
            }
         
        } catch (Exception ex) {
            System.out.println("---------- "+ex.getMessage()+" ----------");
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sltMundial.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                String mundial = sltMundial.getItems().get((Integer) number2).toString();
                mostrarCronograma(Integer.parseInt(mundial));
            }
        });

    }
    


}
