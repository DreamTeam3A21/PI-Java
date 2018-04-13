/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Radhi
 */
public class User {
    private int id;
    private String username;
    private String email;
    private int enabled;
    private String password;
    private String roles;
    private String nom;
    private String prenom;
    private String numTel;
    private String nom_image;
    private String type;

    public User(String username, String email, String password, String nom, String prenom, String numTel, String nom_image, String type) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.nom_image= nom_image;
        this.type = type;
    }

  
    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getnumTel() {
        return numTel;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User( String username, String email, int enabled, String password, String roles, String nom, String prenom, String numTel, String nom_image, String type) {
      
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.nom_image = nom_image;
        this.type = type;
    }
    
    public User()
    {
        
    }
    
    
    @Override
    public String toString()
    {
        return "\nBUser:\nID: "+id+"\nUsername: "+username+"\nE-mail: "+email+"\nPassword: "+password+"\nNom: "+nom
                +"\nPrenom: "+prenom+"\nnumTel: "+numTel+"\nnom_image: "+nom_image+"\nType: "+type+"\n";
    }
    
}
