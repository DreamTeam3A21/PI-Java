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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import entite.panier;
import javafx.scene.control.cell.PropertyValueFactory;
import service.paniersr;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class LivraisonController implements Initializable {

    @FXML
    private ImageView image3;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView tof1;
    @FXML
    private ImageView tof2;
    @FXML
    private TableView<panier> tableView1;
    @FXML
    private TableColumn<panier, String> nomproduit;
    @FXML
    private TableColumn<panier, String> quantite;
    @FXML
    private TableColumn<panier, String> soustotal;
      paniersr pm = new paniersr();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      affichetableview();
        tableView1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldvalue, newValue) ->selectionItemTable(newValue));
    }    

    @FXML
    private void makeSuivant(ActionEvent event) throws IOException {
   
             
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/liv.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
       // scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
        
        
        
    }

    private void affichetableview() {
         nomproduit.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));
            quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
             soustotal.setCellValueFactory(new PropertyValueFactory<>("soustotal"));
             List<panier> list2 = pm.getAll();
           ObservableList<panier> item = FXCollections.observableArrayList(list2);
           tableView1.setItems(item);
           System.out.println("item"+item);
    }

    private void selectionItemTable(panier newValue) {
    }
    
}
