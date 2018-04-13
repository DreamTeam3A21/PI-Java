/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.List;

/**
 *
 * @author Asus
 */
public class method {
 private String societe;
    private String duree;
    private String frais;
    
    public method(String societe, String duree, String frais) {
        this.societe = societe;
        this.duree = duree;
        this.frais = frais;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public method() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getFrais() {
        return frais;
    }

    public void setFrais(String frais) {
        this.frais = frais;
    }

    public List<method> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
