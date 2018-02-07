/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbancaire;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Hp
 */
public class TransactionsCompte {
    private String typeTranscation;
    private Date date;
    private float montantTransaction;
    private Client idClient;
    private Compte numCompte;

    //constructeur
    public TransactionsCompte(String typeTranscation, Date date, float montantTransaction, Client idClientp, Compte numComptep) {
        this.typeTranscation = typeTranscation;
        this.date = date;
        this.montantTransaction = montantTransaction;
        this.idClient = idClientp;
        this.numCompte = numComptep;
    }

    //getters et setters
    public String getTypeTranscation() {
        return typeTranscation;
    }

    public void setTypeTranscation(String typeTranscation) {
        this.typeTranscation = typeTranscation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(float montantTransaction) {
        this.montantTransaction = montantTransaction;
    }

    //Redefinition de la methode toString
    public String toString() {
        return "--" + typeTranscation + " un montant de " + montantTransaction
                + " Euros le " + date;
    }

    /**
     * @return the numCompte
     */
    public Compte getNumCompte() {
        return numCompte;
    }

    /**
     * @param numCompte the numCompte to set
     */
    public void setNumCompte(Compte numCompte) {
        this.numCompte = numCompte;
    }

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
}
