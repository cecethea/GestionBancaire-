/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbancaire;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Compte {
    private int numCompte;
    private Client idClient;
    private float soldeCompte;
    private float tauxInteret;
  
    public Compte(int numComptep, float soldep, float tauxInteretp, Client idClientp) {
        this.numCompte = numComptep;
        this.soldeCompte = soldep;
        this.tauxInteret = tauxInteretp;
        this.idClient = idClientp;
    }
    

    //getters et setters
     /**
     * @return the idClient
     */
    public Client getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }
  
  /*  public static int getCompteurNumeroId() {
        return compteurNumeroId;
    }

    public static void setCompteurNumeroId(int compteurNumeroId) {
        Compte.compteurNumeroId = compteurNumeroId;
    }

    public static int getCompteurNumeroCompte() {
        return compteurNumeroCompte;
    }

    public static void setCompteurNumeroCompte(int compteurNumeroCompte) {
        Compte.compteurNumeroCompte = compteurNumeroCompte;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
    }*/

    public float getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(float soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    //Redefinition de la methode toString
 /*   public String toString() {
        String affichageTransactions = "";
        for (int indexeListeTransactions = 0;
                indexeListeTransactions < listeTransactions.size();
                indexeListeTransactions++) {
            affichageTransactions += "" + listeTransactions.get(indexeListeTransactions) + "\n";
        }
        return "----------------------------------------------"
                + "\n Nnuméro de compte       : " + numeroCompte
                + "\n Nom du titulaire        : " + nomTitulaire
                + "\n Numéro d identification : " + numeroId
                + "\n Solde                   : " + soldeCompte + " vnd"
                + "\n Taux d intérêt          : " + tauxInteret + "%"
                + "\n \n Transactions du compte numero " + numeroCompte + ":"
                + "\n" + affichageTransactions;

    } */

    //Redefinition de la methode equals
  /*  public boolean equals(Object o) {

        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        Compte compte;
        compte = (Compte) o;
        return this.numeroCompte == compte.numeroCompte
                && this.nomTitulaire.equals(compte.nomTitulaire)
                && this.numeroId == compte.numeroId
                && this.soldeCompte == compte.soldeCompte
                && this.tauxInteret == compte.tauxInteret;

    }  */  

    /**
     * @return the numCompte
     */
    public int getNumCompte() {
        return numCompte;
    }

    /**
     * @param numCompte the numCompte to set
     */
    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }
}
