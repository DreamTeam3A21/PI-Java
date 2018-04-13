package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import connexionDatabase.MyDB;
import entite.User;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.UserService;

public class LoginController implements Initializable
{public static User LoggedUser;
     
   private static int idCnx;

    public static int getIdCnx() {
        return idCnx;
    }

    
    private double xOffset = 0;
    private double yOffset = 0;
    
    public JFXButton signUp;
    @FXML
    protected JFXButton btnX;

    
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXButton login;
    @FXML
    private AnchorPane loginPane;
    
    static User user;

    @FXML
    private void makeSignUp(ActionEvent event) throws IOException
    {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/signUp.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    public void close(ActionEvent actionEvent) throws Exception
    {
        Stage stage = (Stage) btnX.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void makeLogin(ActionEvent event)  throws IOException
    {
       try {
           
          MyDB myDB= MyDB.getInstance();
            System.out.println("blababla");
            Statement stm = myDB.getConnexion().createStatement();
            
            ResultSet rest=stm.executeQuery("select * from utilisateur where username = '"+username.getText()+"'");
            System.out.println(username.getText());
            user = new User();
            while(rest.next())
            {
                System.out.println("blababla");
                user.setId(rest.getInt(1));
                user.setUsername(rest.getString(2));
                user.setEmail(rest.getString(4));

                user.setEnabled(rest.getInt(6));
                user.setPassword(rest.getString(7));
                user.setNom(rest.getString(12));
                user.setNumTel(rest.getString(14));
                user.setPrenom(rest.getString(13));
               user.setType(rest.getString(16));


                
                
               
                
            
            }
            idCnx =user.getId();
            
            
            
            
            System.out.println("###############"+user.getEnabled());
           
          
                if(username.getText().equals(user.getUsername())) {
                    System.out.println("True Password");
                    System.out.println("enabled:"+user.getEnabled());
                    if(user.getEnabled()==1){
                        System.out.println(user.getType());
                    if( (!user.getType().equals("Admin")))
                    {
                         System.out.println("nchalla stage");
                         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/livraison.fxml"));
                    Parent root = loader.load();
                    root.setId("pane");

                    Scene scene1 = new Scene(root);
                    stage.setScene(scene1);
                   // scene1.getStylesheets().addAll(this.getClass().getResource("/css/styleSheet.css").toExternalForm());
                    stage.show();}
                    
                    else{
                        
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                              System.out.println("Hello");
                             
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dash.fxml"));
                            
                            Parent root = loader.load();
                           
                            root.setId("pane");
                            

                            Scene scene1 = new Scene(root);
                            
                            stage.setScene(scene1);
                           // scene1.getStylesheets().addAll(this.getClass().getResource("/css/stylesheet.css").toExternalForm());
                            stage.show();
                          
                        }
                    }
            } else System.out.println("false password!");
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("bjaddik?");
            
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
                
                
                
                loginPane.setOnMousePressed((javafx.scene.input.MouseEvent event) -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });

                loginPane.setOnMouseDragged((javafx.scene.input.MouseEvent event) -> {
                    Stage stage = (Stage) loginPane.getScene().getWindow();
                    stage.setX(event.getScreenX()-xOffset);
                    stage.setY(event.getScreenY()-yOffset);
                });

    }

    private void makeLoginFB(ActionEvent event) throws IOException {
        
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/FXMLwebviewFB.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
        
        
        
        
    }
    
      private void LoginAction(ActionEvent event) throws SQLException, IOException {
			UserService su = new UserService(user);

			

			if (!username.getText().equals("") || !pass.getText().equals("")) 
			{
				//if ((su.IsActif(username.getText(), password.getText())) ) 
                           

				
					if ((su.CanLog(username.getText(), pass.getText()))) 
					{	//si le prestataire can login

						LoggedUser = su.searchUserByEmail(pass.getText(), username.getText());
    
    

    
}
         }       
      }


   
}
