package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.gestores.GestorEquipo;
import cr.ac.ucenfotec.gestores.GestorUsuario;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
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
    private ComboBox<String> sltEquipo;

    @FXML
    private Button btnRegistrar;

    GestorUsuario controladorU = new GestorUsuario();
    GestorEquipo controladorE = new GestorEquipo();

    @FXML
    void imgFotoDragDropped(DragEvent event) {
//respalda la imagen default para ser utilizada cuando se limpie el formulario
        //imagenOriginal = imgFoto.getImage();

        Dragboard board = event.getDragboard();
        List<File> archivos = board.getFiles();

        byte[] avatar = getBytesArrayDesdeImagen(archivos.get(0));

        imgFoto.setImage(getImagenDesdeBytesArray(avatar));

        //imagenCargada = true;
    }

    @FXML
    void imgFotoDragOver(DragEvent event) {
        Dragboard board = event.getDragboard();
        if (board.hasFiles()) {

            List<File> phil = board.getFiles();
            String path = phil.get(0).toPath().toString();

            if (path.endsWith(".jpg")
                    || path.endsWith(".JPG")
                    || path.endsWith(".jpeg")
                    || path.endsWith(".JPEG")
                    || path.endsWith(".gif")
                    || path.endsWith(".GIF")
                    || path.endsWith(".png")
                    || path.endsWith(".PNG")
                    || path.endsWith(".bmp")
                    || path.endsWith(".BMP")) {
                event.acceptTransferModes(TransferMode.ANY);
            }
        }
    }

    private byte[] getBytesArrayDesdeImagen(File archivoImagen) {
        byte[] retorno = null;
        ByteArrayOutputStream bos = null;
        FileInputStream fileInput = null;
        byte[] buf = new byte[1024];
        try {
            fileInput = new FileInputStream(archivoImagen);
            bos = new ByteArrayOutputStream();

            for (int i = 0; (i = fileInput.read(buf)) != -1;) {
                bos.write(buf, 0, i);
            }

            fileInput = new FileInputStream(archivoImagen);

            retorno = bos.toByteArray();
        } catch (IOException ex) {
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException ex) {
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException ex) {
                }
            }
        }
        return retorno;
    }

    private Image getImagenDesdeBytesArray(byte[] pImagenEnBytes) {
        Image retorno = null;
        if (pImagenEnBytes != null) {
            retorno = new Image(new ByteArrayInputStream(pImagenEnBytes));
        }
        return retorno;
    }

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
        String[] equipos = null;
        String[] uno = null;
        ObservableList<String> options = null;
        
        
        Rectangle rectangulo = new Rectangle(imgFoto.getFitWidth(), imgFoto.getFitHeight());
		rectangulo.setArcWidth(imgFoto.getFitWidth());
		rectangulo.setArcHeight(imgFoto.getFitHeight());
		imgFoto.setClip(rectangulo);
        
        
        
        
        try {
            options = FXCollections.observableArrayList(controladorE.listaNombre());
        } catch (Exception ex) {
            Logger.getLogger(RegistroUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        sltEquipo.getItems().addAll(options);

    }

}
