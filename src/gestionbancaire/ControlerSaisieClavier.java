/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbancaire;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class ControlerSaisieClavier {
      //Récupérer le numéro de compte
    public static int recupNumCompte() {
         Scanner numCpteSaisiClavier = new Scanner(System.in);
        int nbreEntierPositif;
        do {
            while (!numCpteSaisiClavier.hasNextInt()) {
                System.out.print(" Le numéro de compte saisi n'est pas un entier positif"
                + "\n Veuillez reprendre la saisie : ");
                numCpteSaisiClavier.next();
            }  
            nbreEntierPositif = numCpteSaisiClavier.nextInt();
            if(nbreEntierPositif < 0){
                System.out.print(" Le numéro de compte saisi n'est pas un entier positif"
                + "\n Veuillez reprendre la saisie : ");
            }
        } while (nbreEntierPositif < 0);

        return nbreEntierPositif;
    }
    
    public static int recupIdClient() {
         Scanner idClientSaisiClavier = new Scanner(System.in);
        int idEntierPositif;
        do {  
                while (!idClientSaisiClavier.hasNextInt()) {
                System.out.println(" L'identifiant du client saisie n'est pas un entier positif"
                        + "\n Veuillez entrer un autre identifiant (entier positif): ");
                idClientSaisiClavier.next();
            }
            idEntierPositif = idClientSaisiClavier.nextInt();
        } while (idEntierPositif < 0);

        return idEntierPositif;
    }

     //Récupérer les chaines de caractères ou textes saisies au clavier
    public static String recupChaineCaracteres() {
        String chaineSaisiClavier="";
        String chaineVideTemoin="";
                Scanner chaineSaisie = new Scanner(System.in);
                chaineSaisiClavier = chaineSaisie.nextLine();
                while(chaineSaisiClavier.equals(chaineVideTemoin)){
                System.out.print(" Vous n'avez pas encore saisi de valeur, veuillez faire une saisie :");
                chaineSaisiClavier = chaineSaisie.nextLine();
                }
                return chaineSaisiClavier;
    }  
         
    //Récupérer un nombre compris entre 0 et 9
    public static int recupEntierPositifChoix_0_9() {

        Scanner nbreSaisiAuClavier = new Scanner(System.in);
        int nbrChoixPositif;
        do {
            System.out.print(" Veuillez entrer un entier positif compris entre 0 et 9 : ");
            while (!nbreSaisiAuClavier.hasNextInt()) {
                System.out.println(" Le nombre saisi n'est pas compris entre 0 et 9"
                                  + "Veuillez reprendre la saisie : " );
                nbreSaisiAuClavier.next();
            }
            nbrChoixPositif = nbreSaisiAuClavier.nextInt();

        } while (nbrChoixPositif < 0 || nbrChoixPositif > 9);

        return nbrChoixPositif;
    }
    
    //méthode pour recevoir en entrée le nombre 0 ou le nombre 9
    public static int getNombrePositif0ou9() {

        Scanner keyboard = new Scanner(System.in);
        
        int nombrePositif;
        do {

            System.out.print(" Veuillez taper 9 pour effectuer une autre"
                    + " operation ou 0 pour sortir : ");

            while (!keyboard.hasNextInt()) {

                System.out.println(" Vous n'avez pas entre un entier");
                System.out.print(" Veuillez taper 9 pour effectuer une autre"
                        + " operation ou 0 pour sortir : ");
                keyboard.next();
            }
            nombrePositif = keyboard.nextInt();

        } while (nombrePositif != 0 && nombrePositif != 9);

        return nombrePositif;
    }
    
    //Récupérer le dépôt initial ou dépôt quelconque effetué
    public static float recupMontantADeposer() {
        float nbreFlottant;
        Scanner nbreClavier = new Scanner(System.in);
        nbreClavier.useLocale(Locale.ENGLISH);
         do {
             while (!nbreClavier.hasNextFloat()) {
                System.out.println(" Vous n'avez saisi la valeur du dépôt initial(valeur positive) ");
                nbreClavier.next();
            }
            nbreFlottant = nbreClavier.nextFloat();

        } while (nbreFlottant < 0.0);

        return nbreFlottant;
    }
    
    //Recevoir en entrée le montant à verser sur un compte
    public static float getMontantAVerser() {

        Scanner keyboard = new Scanner(System.in);
        keyboard.useLocale(Locale.ENGLISH);
        float nombreDecimal;

        do {
            //System.out.print(" Veuillez entrer le montant à verser"
            //        + " dans votre compte (un nombre positif) :");
            while (!keyboard.hasNextDouble()) {

                System.out.println(" Vous n'avez pas entré un nombre décimal");
                System.out.print(" Veuillez entrer le montant à verser"
                        + " dans votre compte (un nombre positif) :");
                keyboard.next();
            }
            nombreDecimal = keyboard.nextFloat();

        } while (nombreDecimal < 0.0);

        return nombreDecimal;
    }
    
    //méthode pour recevoir en entrée le montant à retirer d'un compte
    public static double getMontantARetirer() {

        Scanner keyboard = new Scanner(System.in);
        keyboard.useLocale(Locale.ENGLISH);
        double nombreDecimal;

        do {
            System.out.print(" Veuillez entrer le montant  a retirer"
                    + " de votre compte (un nombre positif) :");
            while (!keyboard.hasNextDouble()) {

                System.out.println(" Vous n'avez pas entre un nombre décimal");
                System.out.print(" Veuillez entrer le montant a retirer"
                        + " de votre compte (un nombre positif) :");
                keyboard.next();
            }
            nombreDecimal = keyboard.nextDouble();

        } while (nombreDecimal < 0.0);

        return nombreDecimal;
    }
    
    //Récupéer le taux d'intérêt saisi au clavier
    public static float recupTauxInteret() {
        float tauxInteretSaisiAuClavier;
        Scanner tauxInteretClavier = new Scanner(System.in);
        tauxInteretClavier.useLocale(Locale.ENGLISH);
         do {
             while (!tauxInteretClavier.hasNextFloat()) {
                System.out.println("Le nombre saisi ne respecte pas le format exigé !(nombre à virgule compris en 0 et 100 sans le symbole \"%\" )"
                        +"\n Veuillez reprendre la saisie : ");
                tauxInteretClavier.next();
            }
            tauxInteretSaisiAuClavier = tauxInteretClavier.nextFloat();

        } while (tauxInteretSaisiAuClavier < 0 || tauxInteretSaisiAuClavier > 100);
        return tauxInteretSaisiAuClavier;
    }
    
     
    
}
