package Controllers;

public class Commande {
    
    private int id;
    private int iduser;
    private int idproduit;
    private int quantite;
    private String nomproduit;
    private float prixproduit;
    private float soustotal;
    private String photo;

    public Commande() {
    }

    public Commande( int id,
     int iduser,
    int idproduit,
    int quantite,
     String nomproduit,
     float prixproduit,
     float soustotal,
     String photo) {
        this.id = id;
        this.iduser = iduser;
        this.idproduit = idproduit;
        this.quantite=quantite;
        this.nomproduit = nomproduit;
        this.prixproduit=prixproduit;
        this.soustotal=soustotal; 
        this.photo= photo;
     
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public float getPrixproduit() {
        return prixproduit;
    }

    public void setPrixproduit(float prixproduit) {
        this.prixproduit = prixproduit;
    }

    public float getSoustotal() {
        return soustotal;
    }

    public void setSoustotal(float soustotal) {
        this.soustotal = soustotal;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", iduser=" + iduser + ", idproduit=" + idproduit + ", quantite=" + quantite + ", nomproduit=" + nomproduit + ", prixproduit=" + prixproduit + ", soustotal=" + soustotal + ", photo=" + photo + '}';
    }

 


   

  
    
}