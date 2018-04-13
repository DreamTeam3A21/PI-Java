/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entite.panier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
/**
 *
 * @author Asus
 */
public class paniersr {
    
  

    public paniersr() {
    }

    
    public List<panier> getAll() {
          PreparedStatement preparedStatement;
        List<panier> pan = new ArrayList<>();
        String req = "select * from panier";

        try {
           preparedStatement = connexionDatabase.MyDB.getInstance().getConnexion().prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

               panier p= new panier(resultSet.getString("quantite"), resultSet.getString("nomproduit"), resultSet.getString("soustotal"));
                pan.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(methodserv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pan;
    }
    
    
    
}
