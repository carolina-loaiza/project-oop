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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jeffry
 */
public class LigasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private Pane cuadro2;

    @FXML
    private Label grupo2;

    @FXML
    private Label equipo13;

    @FXML
    private Label equipo21;

    @FXML
    private Label equipo31;

    @FXML
    private Label equipo41;

    @FXML
    private Label equipo51;

    @FXML
    private Label equipo61;

    @FXML
    private Label equipo71;

    @FXML
    private Label equipo81;

    @FXML
    private Label equipo91;

    @FXML
    private Label equipo101;

    @FXML
    private Label equipo111;

    @FXML
    private Label equipo121;

    @FXML
    private TextField marcador110;

    @FXML
    private TextField marcador25;

    @FXML
    private TextField marcador31;

    @FXML
    private TextField marcador41;

    @FXML
    private TextField marcador51;

    @FXML
    private TextField marcador61;

    @FXML
    private TextField marcador71;

    @FXML
    private TextField marcador81;

    @FXML
    private Label marcador91;

    @FXML
    private Label marcador101;

    @FXML
    private TextField marcador111;

    @FXML
    private Label marcador121;

    @FXML
    private TextField marcador20;

    @FXML
    private TextField marcador21;

    @FXML
    private TextField marcador22;

    @FXML
    private TextField marcador23;

    @FXML
    private TextField marcador24;

    @FXML
    private Label marcador26;

    @FXML
    private Label marcador27;

    @FXML
    private Label marcador28;

    @FXML
    private Label marcador29;

    @FXML
    private TextField marcador220;

    @FXML
    private TextField marcador221;

    @FXML
    private Pane cuadro3;

    @FXML
    private Label grupo3;

    @FXML
    private Label equipo14;

    @FXML
    private Label equipo22;

    @FXML
    private Label equipo32;

    @FXML
    private Label equipo42;

    @FXML
    private Label equipo52;

    @FXML
    private Label equipo62;

    @FXML
    private Label equipo72;

    @FXML
    private Label equipo82;

    @FXML
    private Label equipo92;

    @FXML
    private Label equipo102;

    @FXML
    private Label equipo112;

    @FXML
    private Label equipo122;

    @FXML
    private Label marcador112;

    @FXML
    private TextField marcador32;

    @FXML
    private TextField marcador42;

    @FXML
    private TextField marcador52;

    @FXML
    private TextField marcador62;

    @FXML
    private TextField marcador72;

    @FXML
    private TextField marcador82;

    @FXML
    private Label marcador92;

    @FXML
    private Label marcador102;

    @FXML
    private Label marcador122;

    @FXML
    private TextField marcador30;

    @FXML
    private Label marcador33;

    @FXML
    private Label marcador34;

    @FXML
    private Label marcador35;

    @FXML
    private Label marcador36;

    @FXML
    private Label marcador37;

    @FXML
    private TextField marcador38;

    @FXML
    private TextField marcador39;

    @FXML
    private TextField marcador330;

    @FXML
    private TextField marcador332;

    @FXML
    private Pane cuadro4;

    @FXML
    private Label grupo4;

    @FXML
    private Label equipo15;

    @FXML
    private Label equipo23;

    @FXML
    private Label equipo33;

    @FXML
    private Label equipo43;

    @FXML
    private Label equipo53;

    @FXML
    private Label equipo63;

    @FXML
    private Label equipo73;

    @FXML
    private Label equipo83;

    @FXML
    private Label equipo93;

    @FXML
    private Label equipo103;

    @FXML
    private Label equipo113;

    @FXML
    private Label equipo123;

    @FXML
    private Label marcador113;

    @FXML
    private TextField marcador43;

    @FXML
    private TextField marcador53;

    @FXML
    private TextField marcador63;

    @FXML
    private TextField marcador73;

    @FXML
    private TextField marcador83;

    @FXML
    private Label marcador93;

    @FXML
    private Label marcador103;

    @FXML
    private Label marcador123;

    @FXML
    private TextField marcador40;

    @FXML
    private Label marcador44;

    @FXML
    private Label marcador45;

    @FXML
    private Label marcador46;

    @FXML
    private Label marcador47;

    @FXML
    private TextField marcador48;

    @FXML
    private TextField marcador49;

    @FXML
    private TextField marcador440;

    @FXML
    private TextField marcador441;

    @FXML
    private Pane cuadro5;

    @FXML
    private Label grupo5;

    @FXML
    private Label equipo16;

    @FXML
    private Label equipo24;

    @FXML
    private Label equipo34;

    @FXML
    private Label equipo44;

    @FXML
    private Label equipo54;

    @FXML
    private Label equipo64;

    @FXML
    private Label equipo74;

    @FXML
    private Label equipo84;

    @FXML
    private Label equipo94;

    @FXML
    private Label equipo104;

    @FXML
    private Label equipo114;

    @FXML
    private Label equipo124;

    @FXML
    private Label marcador114;

    @FXML
    private TextField marcador54;

    @FXML
    private TextField marcador64;

    @FXML
    private TextField marcador74;

    @FXML
    private TextField marcador84;

    @FXML
    private Label marcador94;

    @FXML
    private Label marcador104;

    @FXML
    private Label marcador124;

    @FXML
    private TextField marcador50;

    @FXML
    private Label marcador55;

    @FXML
    private Label marcador56;

    @FXML
    private Label marcador57;

    @FXML
    private TextField marcador58;

    @FXML
    private TextField marcador59;

    @FXML
    private TextField marcador550;

    @FXML
    private TextField marcador551;

    @FXML
    private Pane cuadro6;

    @FXML
    private Label grupo6;

    @FXML
    private Label equipo17;

    @FXML
    private Label equipo25;

    @FXML
    private Label equipo35;

    @FXML
    private Label equipo45;

    @FXML
    private Label equipo55;

    @FXML
    private Label equipo65;

    @FXML
    private Label equipo75;

    @FXML
    private Label equipo85;

    @FXML
    private Label equipo95;

    @FXML
    private Label equipo105;

    @FXML
    private Label equipo115;

    @FXML
    private Label equipo125;

    @FXML
    private Label marcador115;

    @FXML
    private TextField marcador65;

    @FXML
    private TextField marcador75;

    @FXML
    private TextField marcador85;

    @FXML
    private Label marcador95;

    @FXML
    private Label marcador105;

    @FXML
    private Label marcador125;

    @FXML
    private TextField marcador60;

    @FXML
    private Label marcador66;

    @FXML
    private Label marcador67;

    @FXML
    private TextField marcador68;

    @FXML
    private TextField marcador69;

    @FXML
    private TextField marcador660;

    @FXML
    private TextField marcador661;

    @FXML
    private Pane cuadro7;

    @FXML
    private Label grupo7;

    @FXML
    private Label equipo18;

    @FXML
    private Label equipo26;

    @FXML
    private Label equipo36;

    @FXML
    private Label equipo46;

    @FXML
    private Label equipo56;

    @FXML
    private Label equipo66;

    @FXML
    private Label equipo76;

    @FXML
    private Label equipo86;

    @FXML
    private Label equipo96;

    @FXML
    private Label equipo106;

    @FXML
    private Label equipo116;

    
    @FXML
    private Label equipo126;

    @FXML
    private Label marcador116;

    @FXML
    private Label marcador210;

    @FXML
    private TextField marcador76;

    @FXML
    private TextField marcador86;

    @FXML
    private Label marcador96;

    @FXML
    private Label marcador106;

    @FXML
    private Label marcador126;

    @FXML
    private TextField marcador70;

    @FXML
    private Label marcador77;

    @FXML
    private TextField marcador78;

    @FXML
    private TextField marcador79;

    @FXML
    private TextField marcador770;

    @FXML
    private TextField marcador771;

    @FXML
    private Pane cuadro8;

    @FXML
    private Label grupo8;

    @FXML
    private Label equipo19;

    @FXML
    private Label equipo27;

    @FXML
    private Label equipo37;

    @FXML
    private Label equipo47;

    @FXML
    private Label equipo57;

    @FXML
    private Label equipo67;

    @FXML
    private Label equipo77;

    @FXML
    private Label equipo87;

    @FXML
    private Label equipo97;

    @FXML
    private Label equipo107;

    @FXML
    private Label equipo117;

    @FXML
    private Label equipo127;

    @FXML
    private Label marcador117;

    @FXML
    private Label marcador217;

    @FXML
    private TextField marcador87;

    @FXML
    private Label marcador97;

    @FXML
    private Label marcador107;

    @FXML
    private Label marcador127;

    @FXML
    private TextField marcador80;

    @FXML
    private TextField marcador88;

    @FXML
    private TextField marcador89;

    @FXML
    private TextField marcador880;

    @FXML
    private TextField marcador881;

    @FXML
    private Pane cuadro1;

    @FXML
    private Label grupo1;

    @FXML
    private Label equipo1;

    @FXML
    private Label equipo2;

    @FXML
    private Label equipo3;

    @FXML
    private Label equipo4;

    @FXML
    private Label equipo5;

    @FXML
    private Label equipo6;

    @FXML
    private Label equipo7;

    @FXML
    private Label equipo8;

    @FXML
    private Label equipo9;

    @FXML
    private Label equipo10;

    @FXML
    private Label equipo11;

    @FXML
    private Label equipo12;

    @FXML
    private Label marcador1;

    @FXML
    private Label marcador2;

    @FXML
    private Label marcador3;

    @FXML
    private Label marcador4;

    @FXML
    private Label marcador5;

    @FXML
    private Label marcador6;

    @FXML
    private Label marcador7;

    @FXML
    private Label marcador8;

    @FXML
    private Label marcador9;

    @FXML
    private TextField marcador10;

    @FXML
    private TextField marcador11;

    @FXML
    private TextField marcador12;

    @FXML
    private TextField marcador13;

    @FXML
    private TextField marcador14;

    @FXML
    private TextField marcador16;

    @FXML
    private TextField marcador17;

    @FXML
    private TextField marcador18;

    @FXML
    private TextField marcador19;

    @FXML
    private TableView<?> tabla;

    @FXML
    private TableColumn<?, ?> listanombre;

    @FXML
    private TableColumn<?, ?> listapuntos;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnJugar;

    @FXML
    void guardar(ActionEvent event) {

    }

    @FXML
    void recargaLista(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
