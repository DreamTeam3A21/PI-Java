/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Asus
 */
public class livraison {
    private int id;
    private int idproduit;
    private int iduser;
    private int quantité;
    private double logtitude;
    private double latitude;
  

    public livraison(int idproduit, int iduser, int quantité, double logtitude, double latitude) {
        this.idproduit = idproduit;
        this.iduser = iduser;
        this.quantité = quantité;
        this.logtitude = logtitude;
        this.latitude = latitude;
        
    }

  /*  public livraison() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public livraison() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public double getLogtitude() {
        return logtitude;
    }

    public void setLogtitude(double logtitude) {
        this.logtitude = logtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

   

    @Override
    public String toString() {
        return "livraison{" + "id=" + id + ", idproduit=" + idproduit + ", iduser=" + iduser + ", quantit\u00e9=" + quantité + ", logtitude=" + logtitude + ", latitude=" + latitude +  '}';
    }

    public void setIdproduit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
