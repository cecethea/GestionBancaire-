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
public class Client {
    private int idClient;
    private String nomClient;
    private ArrayList<Compte> listeComptesClient = new ArrayList<Compte>();
    
    public Client(int idClientp, String nomClientp) {
        this.idClient = idClientp;
        this.nomClient = nomClientp;
    }

    //getters et setters
     /**
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public ArrayList<Compte> getListeComptesClient() {
        return listeComptesClient;
    }

    public void setListeComptesClient(ArrayList<Compte> listeComptesClient) {
        this.listeComptesClient = listeComptesClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
}
