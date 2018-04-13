/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package service;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
/*public class afficherProd {
    
public List<panier> AfficherProduit()
    {   List ALLproducts = new ArrayList();
        try {  
           String query="select * from panier WHERE stock > 0 OR stock=null";
            Statement st= connexionDatabase.MyDB.getInstance().getConnexion().createStatement();
            ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            panier pr = new panier();
            
            
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            ALLproducts.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return ALLproducts;       
    
    }
    
}
*/