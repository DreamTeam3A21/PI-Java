/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class LivValidéeController implements Initializable {
 
    @FXML
    private ImageView ph1;
    @FXML
    private ImageView ph2;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void makeTerminer(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/livraison.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
      //  scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
        
        
    }
    
}
