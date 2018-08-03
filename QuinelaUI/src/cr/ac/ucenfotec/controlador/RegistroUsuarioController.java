package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.gestores.GestorEquipo;
import cr.ac.ucenfotec.gestores.GestorUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistroUsuarioController implements Initializable {

    @FXML
    private AnchorPane registroUsuario;

    @FXML
    private ImageView imgFoto;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtApellido2;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPass;

    @FXML
    private PasswordField txtConfirma;

    @FXML
    private TextField txtUName;

    @FXML
    private ChoiceBox<?> sltEquipo;

    @FXML
    private Button btnRegistrar;

    @FXML
    void guardarFoto(MouseEvent event) {

    }

    GestorUsuario controladorU = new GestorUsuario();
    GestorEquipo controladorE = new GestorEquipo();

    @FXML
    void registroUsuario(ActionEvent event) throws IOException {
        String nombre;
        String user;
        String apellido;
        String apellido2;
        String correo;
        String contrasenna;
        String confirmacion;
        String equipo;
        Image foto;

        if (vacio()) {
            Alert d = new Alert(Alert.AlertType.WARNING);
            d.setContentText("existen algunos campos requeridos sin completar");
            d.showAndWait();
        } else {
            foto = imgFoto.getImage();
            nombre = txtNombre.getText().trim();
            apellido = txtApellido.getText().trim();
            apellido2 = txtApellido2.getText().trim();
            correo = txtCorreo.getText().trim();
            user = txtUName.getText().trim();
            contrasenna = txtPass.getText().trim();
            confirmacion = txtConfirma.getText().trim();
            equipo = (String) sltEquipo.getValue();

            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

            Matcher mather = pattern.matcher(correo);

            if (!mather.find() == true) {
                System.out.println("El email ingresado es inválido.");
            } else {
                if (!contrasenna.equals(confirmacion)) {
                    System.out.println("los campos de contraseña no coincide con la confirmación.");
                } else {
                    if (controladorU.existeUsuario(correo)) {
                        System.out.println("ya existe un usuario con esta cuenta de correo, intente con una diferente");

                    } else {
                        if (controladorU.existeUName(user)) {
                            System.out.println("el nombre de usuario ya existe, intente uno diferente");
                        } else {
                            controladorU.registrarUsuario(nombre, apellido, correo, equipo, user, contrasenna);
                        }
                    }
                }
            }

            Parent root = null;
            Parent x = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/Inicio.fxml"));
                x = FXMLLoader.load(getClass().getResource("/cr/ac/ucenfotec/vistas/RegistroUsuario.fxml"));
            } catch (IOException ex) {
            }

            Scene esta = new Scene(x);
            Stage una = new Stage();
            una.setScene(esta);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            una.close();
            stage.showAndWait();
        }
    }

    @FXML
    private boolean vacio() {

        boolean vacio = false;

        if (txtNombre.getText().equals("")
                || txtApellido.getText().equals("")
                || txtApellido2.getText().equals("")
                || txtUName.getText().equals("")
                || txtPass.getText().equals("")
                || txtConfirma.getText().equals("")
                || sltEquipo.getValue().equals("")) {
            vacio = true;
        }

        return vacio;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String [] equipos = null;
        String [] uno = null;
        try {
            equipos = controladorE.listaEquipos();
        } catch (IOException ex) {
            Logger.getLogger(RegistroUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(String i : equipos){
            uno= i.split(",");
            sltEquipo.setAccessibleText(uno[1]);
            
        }
    }

}
