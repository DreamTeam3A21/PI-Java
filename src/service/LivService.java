/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexionDatabase.MyDB;
import entite.livraison;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.input.KeyCode;
import utils.LivSMS;
/**
 *
 * @author Asus
 */
public class LivService implements iService.iLiv {
 MyDB myDB;
    public LivService()
    {
        myDB = MyDB.getInstance();
    }

   
    public void ajouterLivraison(livraison L ) {
        try 
        {
         Statement stm;
            stm = myDB.getConnexion().createStatement();
       
        String query;//varchar 'var'
            query = "insert into  livraison (longtitude,latitude) "
                    + "values ('"+L.getLogtitude()+"','"+L.getLatitude()+"');";
            int executeUpdate = stm.executeUpdate(query);
      
      //  LivSMS.send();
           
            
            System.out.println("Livraison ajoutée avec succes!");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void ajouterLivraison(KeyCode keyCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterUser(livraison L) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
