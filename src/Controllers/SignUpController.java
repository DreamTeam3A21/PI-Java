package Controllers;

import static Controllers.LoginController.user;
import Utils.Mail;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entite.BCrypt;
import entite.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import service.UserService;
import javafx.event.ActionEvent;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class SignUpController implements Initializable{

    private double xOffset = 0;
    private double yOffset = 0;
    
    public JFXButton annuler;

    @FXML

    protected JFXButton btnX;
    @FXML
    private AnchorPane pane1;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXButton valider;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXPasswordField pass1;
    @FXML
    private JFXPasswordField txTelephone;

    @FXML
    private JFXComboBox<String> cbType;
    @FXML
    private JFXButton btPicture;
    private String fileName = "No picture";
    
    @FXML
    void upload(ActionEvent event) throws IOException {
        
          FileChooser fileChooser = new FileChooser();
                     FileChooser.ExtensionFilter exjpg = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
                     FileChooser.ExtensionFilter exjpg2 = new FileChooser.ExtensionFilter("JPEG (Joint Photographic Experts Group)", "*.jpeg");
                     FileChooser.ExtensionFilter expng = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
                     fileChooser.getExtensionFilters().addAll(exjpg,exjpg2, expng);
                     fileChooser.setTitle("Choose an image File");

                     File file = fileChooser.showOpenDialog(null);
                     
                     
                             if (file != null) {
            if (file.length() < 6000000) {
                
                
                                
                               fileName= file.getName();
                           //   Upload u = new Upload();
//                               u.upload(file);
                               
                               System.out.println(fileName);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Permiss");
                alert.setHeaderText("Permission denied");
                alert.setContentText("Your Image file is too big to upload \nplease choose another image");
            }


            }

    }

    @FXML
    public void makeAnnuler(ActionEvent event) throws IOException
    {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    public void makeValider(ActionEvent actionEvent) throws IOException, MessagingException {
        
       
        String nomM = nom.getText() ; 
        String prenomM = prenom.getText(); 
        String typeM =  cbType.getValue();
        String tel=txTelephone.getText();
        String email1  = email.getText();
        String Username=this.username.getText();
        String password=BCrypt.hashpw(pass.getText(), BCrypt.gensalt());
        User e = new User(Username, "", 0, password, tel, nomM, prenomM, tel, nomM, typeM) ; 
        e.setEmail(email1);
        
        
        e.setNom_image("file:C:/xampp/htdocs/Images/"+fileName);
         if(isValidEmailAddress(email.getText()))
        {
            if((!nom.getText().equals(""))&&(!prenom.getText().equals(""))&&(!txTelephone.getText().equals(""))&&(!email.getText().equals(""))&&(!pass1.getText().equals("")))
        {
        if(pass.getText().equalsIgnoreCase(pass1.getText())){
        UserService us=new UserService(user);
        us.ajouterUser(e);
        
        
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
           
        
     
         
        
        }else{
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(" mot de passe");
                alert.setContentText("Confirmation differente");
                alert.showAndWait();
        }
       
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(" Control");
                alert.setContentText("All fields are required");
                alert.showAndWait();
            
        }
        }else{
              Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(" Invalid email");
                alert.setContentText("email must in this form: *******@*****.***");
                alert.showAndWait();
         }
    }

    @FXML
    public void close(ActionEvent actionEvent) throws Exception
    {
        Stage stage = (Stage) btnX.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
                pane1.setOnMousePressed((javafx.scene.input.MouseEvent event) -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });

                pane1.setOnMouseDragged((javafx.scene.input.MouseEvent event) -> {
                    Stage stage = (Stage) pane1.getScene().getWindow();
                    stage.setX(event.getScreenX()-xOffset);
                    stage.setY(event.getScreenY()-yOffset);
                });
                
                    ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Médecin",
        "Client"
    );
                    cbType.setItems(options);
    }
    
 
    
    public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
      InternetAddress emailAddr = new InternetAddress(email);
      emailAddr.validate();
   } catch (AddressException ex) {
      result = false;
   }
   return result;
}


    
}
