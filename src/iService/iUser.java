/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;

import entite.User;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Radhi
 */
public interface iUser {
    
    
    public void ajouterUser(User u);
    public void supprimerUser(int id);
    public ObservableList<User>selectUsers();
    public User selectUser(int id)throws SQLException;
    public void modifierUser(User u,int id);
    
}
