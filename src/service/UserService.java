/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Utils.Mail;
import connexionDatabase.MyDB;
import entite.BCrypt;
import entite.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Sms;

/**
 *
 * @author Radhi
 */
public class UserService implements iService.iUser
{
public static User user;
    MyDB myDB;
    public UserService(User u)
    {
        myDB = MyDB.getInstance();
    }
    
    
    @Override
    public void ajouterUser(User u) {
        try 
        {
        
        Statement stm = myDB.getConnexion().createStatement();
        String query;//varchar 'var'
            query = "insert into  utilisateur (username,username_canonical,email,email_canonical,password,roles,nom,prenom,numTel,nom_image,type,enabled) "
                    + "values ('"+u.getUsername()+"','"+u.getUsername()+"','"+u.getEmail()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getRoles()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getnumTel()+"','"+u.getNom_image()+"','"+u.getType()+"','1')";
            int executeUpdate = stm.executeUpdate(query);
            Sms.send(u);
             Mail.send(u.getEmail(), "Confirmation", "Bienvenu chez nous cher visiteur");
            
            System.out.println("Ajout OK!");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override   
    public void supprimerUser(int id) 
    {
        PreparedStatement prep;
        try 
        {
            prep = myDB.getConnexion().prepareStatement("delete from utilisateur where id = ?");
            prep.setInt(1, id);
            prep.executeUpdate();
            System.out.println("delete OK!");
        }
        catch (SQLException ex) 
        {
            System.out.println("Probleme de suppression!");
        }
        
    }

    @Override
    public ObservableList<User> selectUsers() {
         ObservableList<User> users = FXCollections.observableArrayList();
        try {
           
            
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest=stm.executeQuery("select * from utilisateur");
            while(rest.next())
            {
                User u = new User();
                
                u.setId(rest.getInt(1));
                u.setUsername(rest.getString(2));
                u.setEmail(rest.getString(4));
                u.setPassword(rest.getString(8));
                u.setNom(rest.getString(13));
                u.setPrenom(rest.getString(14));
                u.setNumTel(rest.getString(15));
                u.setNom_image(rest.getString(16));
                u.setType(rest.getString(17));
                
                
                users.add(u);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    @Override
    public void modifierUser(User u,int id){
        
        
        try {
            PreparedStatement prep;
            String req;
            req = "UPDATE utilisateur SET `username`=?,`username_canonical`=?,`email`=?,`email_canonical`=?,`enabled`=?,`password`=?,`roles`=?,`nom`=?,`prenom`=?,`numTel`=?,`nom_image`=?,`type`=? WHERE id = "+id;
            //username,username_canonical,email,email_canonical,
            //enabled,password,roles,nom,prenom,numTel,nom_image,type
            prep= myDB.getConnexion().prepareStatement(req);
            
            prep.setString(1, u.getUsername());
            prep.setString(2, u.getUsername());
            prep.setString(3, u.getEmail());
            prep.setString(4, u.getEmail());
            prep.setInt(5, 1);
            prep.setString(6, u.getPassword());
            prep.setString(7, u.getRoles());
            prep.setString(8, u.getNom());
            prep.setString(9, u.getPrenom());
            prep.setString(10, u.getnumTel());
            prep.setString(11, u.getNom_image());
            prep.setString(12, u.getType());
            prep.executeUpdate();
            System.out.println("Modification OK!");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      }

    @Override
    public User selectUser(int id) throws SQLException {
        User u = new User();
        
        Statement stm = myDB.getConnexion().createStatement();
        ResultSet rest=stm.executeQuery("select * from utilisateur where id ="+id+"");
            
            while(rest.next())
            {
                u.setId(rest.getInt(1));
                u.setUsername(rest.getString(2));
                u.setEmail(rest.getString(4));
                u.setPassword(rest.getString(8));
                u.setNom(rest.getString(13));
                u.setPrenom(rest.getString(14));
                u.setNumTel(rest.getString(15));
                u.setNom_image(rest.getString(16));
                u.setType(rest.getString(17));
            }
            System.out.println(u.toString());
            return u;
    }
    
    public void acceptAdmin(int id){
        
        
        try {
            PreparedStatement prep;
            String req;
            req = "UPDATE utilisateur SET `etat`=1 WHERE id = "+id;
            
            prep= myDB.getConnexion().prepareStatement(req);
            
            
           
            prep.executeUpdate();
            System.out.println("Accepter OK!");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      }
    
    public ObservableList<User> selectUsersAdmin() {
        ObservableList<User> users = FXCollections.observableArrayList();
        try
        {
        Statement stm = myDB.getConnexion().createStatement();
        ResultSet rest=stm.executeQuery("select * from utilisateur WHERE etat=0");
        while(rest.next())
        {
            User u = new User();
            
            u.setId(rest.getInt(1));
            u.setUsername(rest.getString(2));
            u.setEmail(rest.getString(4));
            u.setPassword(rest.getString(8));
            u.setNom(rest.getString(13));
            u.setPrenom(rest.getString(14));
            u.setNumTel(rest.getString(15));
            u.setNom_image(rest.getString(16));
            u.setType(rest.getString(17));
            
            
            users.add(u);
        }
        }
        catch (SQLException ex)
        {
            System.out.println("Probleme affichage");
        }
        return users;
    }
    
     public void bannerUser(int id){
        
        
        try {
            PreparedStatement prep;
            String req;
            req = "UPDATE utilisateur SET `enabled`=0 WHERE id = "+id;
            
            prep= myDB.getConnexion().prepareStatement(req);
            
            
           
            prep.executeUpdate();
            System.out.println("Accepter OK!");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      }
     
     public void desactiverUser(int id){
        
        
        try {
            PreparedStatement prep;
            String req;
            req = "UPDATE utilisateur SET `enabled`=2 WHERE id = "+id;
            
            prep= myDB.getConnexion().prepareStatement(req);
            
            
           
            prep.executeUpdate();
            System.out.println("Accepter OK!");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      }
    
    public User GetUserById (Integer id) throws ParseException, SQLException {
        
        
       PreparedStatement prep;
       Statement stm = myDB.getConnexion().createStatement();
        ResultSet rest=stm.executeQuery("select * from utilisateur where id="+id);
        User e = null;
            
            while (rest.next()) {
                e = 
                     new User(rest.getString("username"), rest.getString("email"), rest.getString("password"), rest.getString("nom"), rest.getString("prenom"), rest.getString("numTel"), rest.getString("nom_image"), rest.getString("type"));
                e.setId(Integer.valueOf(rest.getString("id")));
                return e;
            }
       
         return e;
      
    }
    
    public void edit(User e) throws SQLException {
        PreparedStatement prep;
       Statement stm = myDB.getConnexion().createStatement();
       
        String req="UPDATE utilisateur SET nom='"+e.getNom()+"',prenom='"+e.getPrenom()+"',numTel='"+e.getnumTel()+"',email='"+e.getEmail()+"',username='"+e.getUsername()+"'WHERE id=8";
         
        
        try {
            stm.executeUpdate(req);
           
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ObservableList<User> rechercheUsers(String recherche) {
        ObservableList<User> users = FXCollections.observableArrayList();
        try
        {
        Statement stm = myDB.getConnexion().createStatement();
        ResultSet rest=stm.executeQuery("select * from utilisateur WHERE etat=1 AND (nom LIKE '%" + recherche + "%' OR prenom LIKE '%" + recherche + "%' OR numTel LIKE '%" + recherche + "%')");
        while(rest.next())
        {
            User u = new User();
            
            u.setId(rest.getInt(1));
            u.setUsername(rest.getString(2));
            u.setEmail(rest.getString(4));
            u.setPassword(rest.getString(8));
            u.setNom(rest.getString(13));
            u.setPrenom(rest.getString(14));
            u.setNumTel(rest.getString(15));
            u.setNom_image(rest.getString(16));
            u.setType(rest.getString(17));
            
            
            users.add(u);
        }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return users;
    }
    
    public ObservableList<User> rechercheUsers2(String recherche) {
        ObservableList<User> users = FXCollections.observableArrayList();
        try
        {
        Statement stm = myDB.getConnexion().createStatement();
        ResultSet rest=stm.executeQuery("select * from utilisateur WHERE etat=0 AND (nom LIKE '%" + recherche + "%' OR prenom LIKE '%" + recherche + "%'OR numTel LIKE '%" + recherche + "%')");
        while(rest.next())
        {
            User u = new User();
            
            u.setId(rest.getInt(1));
            u.setUsername(rest.getString(2));
            u.setEmail(rest.getString(4));
            u.setPassword(rest.getString(8));
            u.setNom(rest.getString(13));
            u.setPrenom(rest.getString(14));
            u.setNumTel(rest.getString(15));
            u.setNom_image(rest.getString(16));
            u.setType(rest.getString(17));
            
            
            users.add(u);
        }
        }
        catch (SQLException ex)
        {
            System.out.println("Probleme affichage");
        }
        return users;
    }
    public boolean CanLog(String pseudo, String password) throws SQLException {
        User user = null;
        String req = "SELECT (password) FROM utilisateur where (username_canonical=? OR email_canonical=?)";
        PreparedStatement st1 = MyDB.getInstance().getConnexion().prepareStatement(req);
        st1.setString(1, pseudo.toLowerCase());
        st1.setString(2, pseudo.toLowerCase());
        ResultSet rs1 = st1.executeQuery();
        while (rs1.next()) {
            if (BCrypt.checkpw(password, "$2a$" + rs1.getString("password").substring(4, rs1.getString("password").length()))) {
                String requete = "SELECT * FROM utilisateur where (username_canonical=? OR email_canonical=?)";
                PreparedStatement st = MyDB.getInstance().getConnexion().prepareStatement(requete);
                st.setString(1, pseudo.toLowerCase());
                st.setString(2, pseudo.toLowerCase());

                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setUsername(rs.getString("username_canonical"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setNom(rs.getString("nom"));
                    user.setPrenom(rs.getString("Prenom"));
                    user.setNumTel(rs.getString("numtel"));
                    user.setNom_image(rs.getString("image"));
                    user.setType(rs.getString("type"));
                    System.out.println("User found");
                    return true;
                }
            }
        }
        return false;
    }



    public User searchUserByEmail(String pseudo, String password) throws SQLException {
        User user = null;
        String req = "SELECT (password) FROM utilisateur where (username_canonical=? OR email_canonical=?)";
        PreparedStatement st1 = MyDB.getInstance().getConnexion().prepareStatement(req);
        st1.setString(1, pseudo.toLowerCase());
        st1.setString(2, pseudo.toLowerCase());
        ResultSet rs1 = st1.executeQuery();
        while (rs1.next()) {
            if (BCrypt.checkpw(password, "$2a$" + rs1.getString("password").substring(4, rs1.getString("password").length()))) {
                String requete = "SELECT * FROM utilisateur where (username_canonical=? OR email_canonical=?)";
                PreparedStatement st = MyDB.getInstance().getConnexion().prepareStatement(requete);
                st.setString(1, pseudo.toLowerCase());
                st.setString(2, pseudo.toLowerCase());

                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
              
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setNom(rs.getString("nom"));
                    user.setPrenom(rs.getString("Prenom"));
                    user.setNumTel(rs.getString("numtel"));
               
                    user.setNom_image(rs.getString("image"));
                    user.setType(rs.getString("type"));
                    System.out.println("User found");
                }
            } else {
                System.out.println("no");
            }
        }

        return user;
    }
    
    
}
