/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class DashController implements Initializable {

    @FXML
    private HBox boxMenus;
    @FXML
    private AnchorPane paneUsers;
    @FXML
    private AnchorPane paneTickets;
    @FXML
    private AnchorPane paneDrivers;
    @FXML
    private AnchorPane paneUsers1;
    @FXML
    private Label Ser;
    @FXML
    private StackPane fabsContainer;
    @FXML
    private HBox boxMenus1;
    @FXML
    private AnchorPane paneTickets1;
    @FXML
    private AnchorPane paneBuses1;
    @FXML
    private AnchorPane paneDrivers11;
    @FXML
    private AnchorPane paneTickets11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DepClick(MouseEvent event) {
    }

    @FXML
    private void selectDep(MouseEvent event) {
    }

    @FXML
    private void selectServ(MouseEvent event) {
    }

    @FXML
    private void switchToDrivers(MouseEvent event) {
    }

    @FXML
    private void switchToUsers(MouseEvent event) throws IOException {
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dash.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
      // scene1.getStylesheets().addAll(this.getClass().getResource("/Content/").toExternalForm());
        stage.show();
    }

    @FXML
    private void switchToTickets(MouseEvent event) throws IOException {
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
      // scene1.getStylesheets().addAll(this.getClass().getResource("/Content/").toExternalForm());
        stage.show();
    }

    @FXML
    private void switchToBuses(MouseEvent event) {
    }

    @FXML
    private void selectCons(MouseEvent event) {
    }

    @FXML
    private void deconnexion(ActionEvent event) {
    }
    
}
