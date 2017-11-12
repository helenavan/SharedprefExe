package com.helenacorp.android.sharedpreferenceexercice;

/**
 * Created by helena on 12/11/2017.
 */

public class MaClasseObjectJson {
    private String  nom;
    private String prenom;
    private String company;

    public MaClasseObjectJson(String nom, String prenom, String company) {
        this.nom = nom;
        this.prenom = prenom;
        this.company = company;
    }

    public String getNom() {
        return nom;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "MaClasseObjectJson{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
