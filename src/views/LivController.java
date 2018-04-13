/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import entite.livraison;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import service.LivService;
import entite.method;
import static java.util.Collections.list;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.methodserv;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class LivController implements Initializable, MapComponentInitializedListener {

    private GoogleMap map;
    public GoogleMapView mapView;
    @FXML
    private TextField longtitude;
    @FXML
    private TextField latitude;
    @FXML
    private TableView<method> tableview;
    @FXML
    private TableColumn<method, String> societe;
    @FXML
    private TableColumn<method, String> duree;
    @FXML
    private TableColumn<method, String> frais;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;

    livraison liv = new livraison();
    methodserv sm = new methodserv();

    /**
     *
     */
    @Override
    public void mapInitialized() {
        

        LatLong latlng = new LatLong(10, 35);

        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(latlng)
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(true)
                .zoom(5);
        map = mapView.createMap(mapOptions);

        map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {

            LatLong latLong = event.getLatLong();
            // RechercherByMap(latLong.getLatitude(), latLong.getLongitude());
            //Add markers to the map
            MarkerOptions markerOptions1 = new MarkerOptions();
            markerOptions1.position(latLong);
            Marker joeSmithMarker = new Marker(markerOptions1);
            map.addMarker(joeSmithMarker);
            latitude.setText(String.valueOf(latLong.getLatitude()));
            longtitude.setText(String.valueOf(latLong.getLongitude()));

        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        mapView.addMapInializedListener(this);
        affichetableview();
        tableview.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldvalue, newValue) ->selectionItemTable(newValue));
    }

    @FXML
    public void makeAnnuler(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/livraison.fxml"));
        Parent root = loader.load();
        root.setId("pane");

        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        //  scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    private void makeValide(ActionEvent event) throws IOException {
        LivService lv = new LivService();
        liv.setLatitude(Double.parseDouble(latitude.getText()));
        liv.setLogtitude(Double.parseDouble(latitude.getText()));
        lv.ajouterLivraison(liv);
       
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/views/livValidée.fxml"));
        Parent root = loader.load();
        root.setId("pane");

        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        //  scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
        
        
    }
    

    private void affichetableview() {
         societe.setCellValueFactory(new PropertyValueFactory<>("societe"));
            frais.setCellValueFactory(new PropertyValueFactory<>("frais"));
             duree.setCellValueFactory(new PropertyValueFactory<>("duree"));
             List<method> list1 = sm.getAll();
           ObservableList<method> item = FXCollections.observableArrayList(list1);
           tableview.setItems(item);
    }

    private void selectionItemTable(method newValue) {
        
    }
    

}
