/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbancaire;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Hp
 */
public class OperationsBancaires {
    //
    private ArrayList<Client> listeClients;
    List<Compte> listeCpte = new ArrayList<Compte>();
    private Compte compteCourant; //identifie le compte devant être traité
    private Client clientIdentifie;
    private String typeTransaction;
    private ArrayList<TransactionsCompte> listeTransactions = new ArrayList<TransactionsCompte>();
    private Parametres param = new Parametres();
        
    public OperationsBancaires() {
        listeClients = new ArrayList<Client>();
    }

   
    public ArrayList<Client> getListeClients() {
        return listeClients;
    }

    public void setListeClients(ArrayList<Client> listeClients) {
        this.listeClients = listeClients;
    }
    public ArrayList<TransactionsCompte> getListeTransactions() {
        return listeTransactions;
    } //Getters et setters

    public void setListeTransactions(ArrayList<TransactionsCompte> listeTransactions) {
        this.listeTransactions = listeTransactions;
    }

    public Compte getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(Compte compteCourant) {
        this.compteCourant = compteCourant;
    }
    
    //Méthode pour ajouter un nouveau client
    public void ajouterClient(int idClientp, String nomClientp) {
         if (!isClientBanque(idClientp)) {
            listeClients.add(new Client(idClientp, nomClientp));//enlever compte courant       
        } else {
           System.out.println("Client déjà existant");
        }
    }
    //Récupérer le nom du client
    public String recupNomClient(int idClient) {
        String nomClient = "";
        if(listeClients.size()>0){
        for (int i = 0; i < listeClients.size(); i++) {
            if (listeClients.get(i).getIdClient() == idClient) {
                nomClient =listeClients.get(i).getNomClient();
                break;
            } else {
               System.out.println("Client non encore créé");
            }
          }
        }
        return nomClient;
    }
    //Vérifier l'appartenance du client à la banque à partir de son numéro
    public boolean isClientBanque(int idClient) {
        boolean isClient = false;
        for (int i = 0; i < listeClients.size(); i++) {
            if (listeClients.get(i).getIdClient() == idClient) {
                isClient = true;
                break;
            } else {
                isClient = false;
            }
        }
        return isClient;
    }

    //Méthode créer un nouveau compte bancaire
    public void creerNouveauCompte(int numCopmte, float solde, float tauxInteret, Client client) {
        Compte  cpte = new Compte(numCopmte, solde, tauxInteret, client);
        listeCpte.add(cpte);
        // Ajouter la condition de création de compte
        if((client != null)&&listeCpte.size()>0){
            Date todayDate = new Date();
            //typeTransaction = "déposer";
            typeTransaction = param.getDepotParam();
            listeTransactions.add(new TransactionsCompte(typeTransaction, todayDate, solde, cpte.getIdClient(), cpte));
            System.out.println("--- Compte créé avec succès pour le client " + client.getNomClient() + " ---------------------------");
            System.out.println("Numéro du titulaire du compte : " + client.getIdClient());
            System.out.println("Numéro de compte : " + param.formaterNumCpte(numCopmte));
            System.out.println("Taux d'intérêt : " + tauxInteret + param.getPrctageParam());
            System.out.println("Dépôt initial " + solde + " " + param.getMonnaieParam());  
            System.out.println("-----------------------------------------------------------------------------");
        }else{
            System.out.println("Le compte n'a pas pu être créé !!!");
        }
        /*Enlever  
        for(int i = 0; i < listeCpte.size(); i++)
            {
            System.out.println("Enregistrement " + i + " = " + listeCpte.get(i).getIdClient() + " " + listeCpte.get(i).getSoldeCompte());
            }
        */
    }
    
    //Identifier un compte à partir du numéro de compte
    public void identifierCompte(int numeroCompte) {
        boolean isfinded = false;
        compteCourant = null;
        if (listeCpte.size() > 0) {
            for (int i = 0; i < listeCpte.size(); i++) {
                if (listeCpte.get(i).getNumCompte() == numeroCompte) {
                    compteCourant = listeCpte.get(i);
                    isfinded = true;
                    break;
                }
            }
        } else {
            System.out.println(" Aucun compte n'est enregistré. Merci !!!");
       }
        if ((compteCourant == null) && !isfinded) {
            System.out.println("Ce compte n'existe pas. Merci !!!");
        }
    }
    
    //Vérifier si le compte à créer existe déjà
    public boolean traiterNumClient() {
        boolean existe = false;
        int idClient;
        
                       idClient =  ControlerSaisieClavier.recupIdClient();
                       existe = isClientBanque(idClient);
                       if(existe){
                           System.out.print(" Vous êtes entrain d'ajouter un nouveau compte au client numéro << " + idClient + " >> ");
                                   }
        return existe;
    }
    //Vérifier si le compte existe pour des traitements éventuels
    public boolean existenceCompte(int numeroCompte) {
        boolean trouve = false;
            if (listeCpte.size() > 0) {
            for (int i = 0; i < listeCpte.size(); i++) {
                if (listeCpte.get(i).getNumCompte() == numeroCompte) {
                    trouve = true;
                    
                } else {
                    trouve = false;
                }
            }
           }
       return trouve; 
    }
    
    //Vérifier si le compte à créer existe déjà
    public int traiterNumCompteACreer() {
        boolean existe = false;
        int numeroCompte;
        do{
                       numeroCompte =  ControlerSaisieClavier.recupNumCompte();
                       existe = existenceCompte(numeroCompte);
                       if(existe){
                           System.out.print(" Un compte existe déjà sous le numéro saisi << "+ numeroCompte +" >>"
                                           +" \n Veuillez entrer un autre numéro de compte : ");}
                    } while(existe);  
    return numeroCompte;
    }
    
    //Vérifier si le compte à opérer existe déjà
    public int verifExistenceCompte_A_Operer() {
        boolean existe = false;
        int numeroCompte;
        do{
                       numeroCompte =  ControlerSaisieClavier.recupNumCompte();
                       existe = existenceCompte(numeroCompte);
                       if(!existe){
                           System.out.print(" Ce compte << "+ numeroCompte +" >> pas n'existe !!! "
                                           +" \n Veuillez entrer un autre numéro de compte : ");}
                    } while(!existe);  
    return numeroCompte;
    }

    //Calcul de l'intérêt de chaque compte et leur solde mis à jour
    public void claculerInteretComptes() {
        if (listeCpte.isEmpty()) {
            System.out.println("Aucun compte disponible à mettre à jour");
        } else {
            System.out.println("Client " + " Compte " + "   " + " Solde " + "   " + " Taux ");
            for(int i = 0; i < listeCpte.size(); i++){
                listeCpte.get(i).setSoldeCompte(listeCpte.get(i).getSoldeCompte()*(1 + listeCpte.get(i).getTauxInteret()));
                System.out.println(listeCpte.get(i).getIdClient().getNomClient() + "  " + listeCpte.get(i).getNumCompte() + "      " + listeCpte.get(i).getSoldeCompte() + " " + listeCpte.get(i).getTauxInteret()+"%");
            }
        }
    }

    //Créditer compte
    public void crediterCompte(float montant, int numeroCompte) {
        identifierCompte(numeroCompte);
        if (compteCourant != null) {
            Date todayDate = new Date();
            compteCourant.setSoldeCompte(compteCourant.getSoldeCompte() + montant);
            typeTransaction = param.getDepotParam();
            listeTransactions.add(new TransactionsCompte(typeTransaction, todayDate, montant, compteCourant.getIdClient(), compteCourant));
            System.out.println("---> " + param.formaterNumCpte(numeroCompte) + " :   " + typeTransaction + " ---   " + montant + "  " + param.getMonnaieParam());
        }
       /* for(int i = 0; i < listeTransactions.size(); i++)
            {
            System.out.println("---> " + listeTransactions.get(i).getIdClient().getNomClient() + " :   "
                  + listeTransactions.get(i).getTypeTranscation() + " ---   " + listeTransactions.get(i).getMontantTransaction() + " Euros ");
            }*/
    }

    //Débiter compte
    public void debiterCompte(float montant, int numeroCompte) {
        identifierCompte(numeroCompte);
        if (compteCourant != null) {
            if (compteCourant.getSoldeCompte() < montant) {
                System.out.println(" Solde insuffisant par rapport au montant à retirer");
            } else {
                Date todayDate = new Date();
                compteCourant.setSoldeCompte(compteCourant.getSoldeCompte() - montant);
                typeTransaction = param.getRetraitParam();
                listeTransactions.add(new TransactionsCompte(typeTransaction, todayDate, montant, compteCourant.getIdClient(), compteCourant));
                System.out.println("---> " + numeroCompte + " :   " + typeTransaction + " ---   " + montant + "  " + param.getMonnaieParam());
            }
        }
    }
    //Consulter le solde d'un compte
    public void consulterSolde(int numeroCompte) {
        identifierCompte(numeroCompte);
        if (compteCourant != null) {
            System.out.println(" Le solde du compte " + numeroCompte + " est : " + compteCourant.getSoldeCompte() + "  " + param.getMonnaieParam());
        }
    }

    //Afficher le rapport d'activités de la banque listeTransactions
    public void afficherRapport() {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
        if (listeTransactions.isEmpty()) {
            System.out.println(" Aucun dépôt ni retrait n'est encore effectué !!! ");
        } else {
            for (int i = 0; i < listeTransactions.size(); i++) {
                   System.out.println("----- " + listeTransactions.get(i).getTypeTranscation() + " un montant de " +
                          listeTransactions.get(i).getMontantTransaction() + "  "+ param.getMonnaieParam() +" pour le compte " +  
                          param.formaterNumCpte(listeTransactions.get(i).getNumCompte().getNumCompte()) + " au " +
                          DATE_FORMAT.format(listeTransactions.get(i).getDate()));
                    }
            }
    }
    
    //Trouver le nombre compte(s) d'un client à partir de son numéro d'identification
    public void chercherNombreComptesClient(int numeroId) {
        if (isClientBanque(numeroId)&&(listeCpte.size()>0)) {
                System.out.println("Numéro de compte " + "   " + " Solde " + "   " + " Taux ");
                for (int i = 0; i < listeCpte.size(); i++) {
                System.out.println(param.formaterNumCpte(listeCpte.get(i).getNumCompte()) + "                  " + listeCpte.get(i).getSoldeCompte()+ "         " + listeCpte.get(i).getTauxInteret() + param.getMonnaieParam());
                }
                System.out.println("---------------------------------------------------");
                System.out.println("Nombre total de comptes : " + " " + listeCpte.size());
           } else {
                System.out.println(" Client non encore enregistré !!! ");
        }
    }
  
    //Afficher le choix de continuer l'exécution ou sortir
    public static void effectuerAutreOperation() {
        System.out.print(" Veuillez taper 9 pour effectuer une autre"
                + " operation ou 0 pour sortir :");

    }
    
}
