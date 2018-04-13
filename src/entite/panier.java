/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.List;

/**
 *
 * @author marwen b-al
 */
public class panier {
    
 
    String quantite ;
    String nomproduit ;

    String soustotal ;
   

    public panier() {
    }

    public panier( String quantite, String nomproduit, String soustotal) {
       
        this.quantite = quantite;
        this.nomproduit = nomproduit;
        this.soustotal = soustotal;
       
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getSoustotal() {
        return soustotal;
    }

    public void setSoustotal(String soustotal) {
        this.soustotal = soustotal;
    }
public List<panier> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
  
   

    
    
    
   
    
    
}
