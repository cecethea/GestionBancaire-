/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbancaire;

/**
 *
 * @author Hp
 */
public class GestionBancaire {
    public static void main(String[] args) {
        OperationsBancaires operations = new OperationsBancaires();
        int optionChoisi = 0;
        int numCompteTmp;
        int idClientTmp;
        String nomClientTmp;
        float tauxInteretTmp;
        float soldeCompteTmp;
        float montantTmp;
        boolean existe;
        
        System.out.println(" ====================================================================================="
         +"\n Bienvenue dans l'application << GestionBancaire version 1.0 >>"
         +"\n ====================================================================================="
         +"\n | Choisir une option en fonction de l'action à effectuer."
	 +"\n | Par exemple pour créer un nouveau bancaire, au clavier -> tapez 1 -> puis Entrée."
         +"\n  -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
       
        do {
            afficherMenuPrincipal(); // Afficher le menu principal
            optionChoisi = ControlerSaisieClavier.recupEntierPositifChoix_0_9();

            switch (optionChoisi) {
                case 0:
                    break;
                case 1:
                    System.out.println(" ------------------------------------------------------------ ");
                    System.out.println(" CREATION D'UN NOUVEAU COMPTE BANCAIRE ");
                    System.out.print(" Numéro de compte (entier positif) : ");
                    numCompteTmp = operations.traiterNumCompteACreer();
                    System.out.print(" Identifiant du client (entier positif) : ");
                        idClientTmp =  ControlerSaisieClavier.recupIdClient();
                        if(!operations.isClientBanque(idClientTmp)){
                             System.out.print(" Nom du client : ");
                             nomClientTmp = ControlerSaisieClavier.recupChaineCaracteres();
                        }
                        else{
                             nomClientTmp = operations.recupNomClient(idClientTmp);
                             System.out.println("Info : Vous êtes en train de créer un compte de plus pour le client " + nomClientTmp + "("+idClientTmp+")");
                        }
                    System.out.print(" Taux d'intérêt (nombre à virgule compris entre 0 et 100 sans le symbole \"%\" ): ");
                        tauxInteretTmp = ControlerSaisieClavier.recupTauxInteret();
                    System.out.print(" Montant du dépôt initial en Euros(valeur positive) : ");
                        soldeCompteTmp = ControlerSaisieClavier.recupMontantADeposer();
                        operations.ajouterClient(idClientTmp, nomClientTmp);
                        operations.creerNouveauCompte(numCompteTmp, soldeCompteTmp, tauxInteretTmp, new Client(idClientTmp, nomClientTmp));
                     break;
                case 2:
                    System.out.println(" -------- CREDITER UN COMPTE ---------------");
                    System.out.print(" Numéro du compte à créditer (entier positif) : ");
                    numCompteTmp = operations.verifExistenceCompte_A_Operer();
                    System.out.print(" Veuillez entrer le montant à déposer : ");
                    montantTmp = ControlerSaisieClavier.getMontantAVerser();
                    operations.crediterCompte(montantTmp, numCompteTmp);
                    break;
                case 3:
                    System.out.println(" -------- DEBITER UN COMPTE ---------------");
                    System.out.print(" Numéro du compte à débiter (entier positif) : ");
                    numCompteTmp = operations.verifExistenceCompte_A_Operer();
                    System.out.print(" Veuillez entrer le montant à débiter : ");
                    montantTmp = ControlerSaisieClavier.getMontantAVerser();
                    operations.debiterCompte(montantTmp, numCompteTmp);
                    break;
                case 4:
                    System.out.println(" -------- CONSULTATION D'UN SOLDE DE COMPTE  ---------------");
                    System.out.print(" Numéro du compte à consultation (entier positif) : ");
                    numCompteTmp = operations.verifExistenceCompte_A_Operer();
                    //numCompteTmp = ControlerSaisieClavier.recupNumCompte();
                    operations.consulterSolde(numCompteTmp);
                    break;
                case 5:
                    System.out.println("--- CALCUL DU TAUX D'INTERET ET MISE A JOUR DE SOLDE -------");
                    operations.claculerInteretComptes();
                    //System.out.println("\n Mise à jour des comptes :");
                    break;
                case 6:
                    System.out.println("----------- RAPPORT D'ACTIVITE DE LA BANQUE -------------- ");
                    //System.out.print(" \n Rapport d'activités de la banque : ");
                    operations.afficherRapport();
                    break;
                case 7:
                    //System.out.println("----------- LISTE DES COMPTES DES CLIENTS -------------- ");
                    System.out.print("Saisir le numéro du client : ");
                    idClientTmp = ControlerSaisieClavier.recupIdClient();
                    System.out.println(" Liste des comptes du client de la banque : ");
                    operations.chercherNombreComptesClient(idClientTmp);
                    break;
                case 8:
                    afficherAide();
                    break;
                case 9:
                    afficherMenuPrincipal();
                    break;
            }
            if (optionChoisi != 0) {
                optionChoisi = ControlerSaisieClavier.getNombrePositif0ou9();
            }
        } while (optionChoisi != 0);
    }
    //Pour afficher le menu principal
    public static void afficherAide() {
        System.out.println(" En construction ... Merci !");
    }
    //Pour afficher le menu principal
    public static void afficherMenuPrincipal() {
        System.out.println(" 1-Création d'un nouveau compte"
	 +"\n 2-Créditer un compte"
	 +"\n 3-Débiter un compte"
	 +"\n 4-Consultation de solde de compte"
	 +"\n 5-Calcul des taux d'interet et mise à jour des soldes"
	 +"\n 6-Listes des opérations effectuées"
	 +"\n 7-Rechercher les comptes d'un client"
	 +"\n 8-Aide"
	 +"\n 9-Quitter");
    }
    //Méthode afficher le choix de continuer l'exécution ou sortir
    public static void effectuerAutreOperation() {
        System.out.print(" Veuillez taper 9 pour effectuer une autre"
                + " operation ou 0 pour sortir : ");
    }
}
