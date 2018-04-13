/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class methodserv {

    public methodserv(String string, String string1, String string2) {
    }

    public methodserv() {
    }

    
    public List<method> getAll() {
        PreparedStatement preparedStatement;
        List<method> ReclamationAL = new ArrayList<>();
        String req = "select * from method";

        try {
            preparedStatement = connexionDatabase.MyDB.getInstance().getConnexion().prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

               method m = new method( resultSet.getString("societe"), resultSet.getString("duree"), resultSet.getString("frais"));
                ReclamationAL.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(methodserv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ReclamationAL;
    }
    
    
    
}
