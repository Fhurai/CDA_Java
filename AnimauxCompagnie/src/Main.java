import entites.*;
import logs.Log4U;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;

import logs.Log4U.*;

/**
 * Classe principale du programme.
 */
public class Main {

    static Scanner scan = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    /**
     * Méthode principale du programme.
     * @param args Arguments de lancement de la méthode.
     */
    public static void main(String[] args) {

        // Initialisation variables
        String answer, race, nom;
        int age, plumes;

        try{
            Log4U.init();
        } catch (IOException e) {
            System.out.println("Logs non créés!");
            System.exit(1);
        }

        Log4U.logging.log(Level.INFO, "Software running...");

        // Affichage menu + réponse utilisateur.
        answer = menu();

        // Tant que l'utilisateur ne veut pas arreter.
        while(answer.compareTo("A") != 0){

            // Si l'utilisateur n'a pas choisi d'ajouter un chien ou un oiseau.
            while (answer.compareTo("C") != 0 && answer.compareToIgnoreCase(
                    "O") != 0){

                // Affichage message erreur + affichage menu + réponse
                // utilisateur.
                System.out.println("Commande inconnue, veuillez donner une" +
                        " commande de la liste fournie.");
                answer = menu();
            }

            try {
                // Demande nom animal + réponse utilisateur.
                System.out.println("\nVeuillez saisir le nom de l'animal : ");
                nom = scan.nextLine();

                // Demande age animal + réponse utilisateur.
                System.out.println("Veuillez saisir l'age de l'animal : ");
                age = Integer.parseInt(scan.nextLine());

                switch (answer) {

                    // Ajout de chien.
                    case "C":
                        // Demande race chien + réponse utilisateur +
                        // initialisation chien dans liste animaux.
                        System.out.println("Veuillez saisir la race du chien : ");
                        race = scan.nextLine();
                        Animaux.animals.add(new Chien(nom, age, race));
                        break;
                    // Ajout d'oiseau
                    case "O":
                        // Demande plumes oiseau + réponse utilisateur +
                        // initialisation oiseau dans liste animaux.
                        System.out.println("Veuillez saisir le nombre de plumes " +
                                "de l'oiseau");
                        plumes = Integer.parseInt(scan.nextLine());
                        Animaux.animals.add(new Oiseau(nom, age, plumes));
                        break;
                }
            }catch(NumberFormatException nfe){
                // Exception valeur numérique non valide par utilisateur.
                System.out.println(ANSI_RED+"\nErreur : Valeur numérique non " +
                        "valide!"+ANSI_RESET);
                Log4U.logging.log(Level.WARNING, Arrays.toString(nfe.getStackTrace()));
            }catch (AnimalException ae){
                // Exception info animal non valide par utilisateur.
                System.out.println(ANSI_RED+"\nErreur : " + ae.getMessage()+ANSI_RESET);
                Log4U.logging.log(Level.WARNING, "Erreur : " + Arrays.toString(ae.getStackTrace()));
            }catch(Exception e){
                System.out.println(ANSI_RED+"\nErreur : " + e.getMessage()+ANSI_RESET);
                Log4U.logging.log(Level.WARNING, "Erreur : " + Arrays.toString(e.getStackTrace()));
                System.exit(1);
            }

            // Tri des animaux dans la liste.
            Animaux.animals.sort(new Animaux.NameComparator());

            // Affichage de tous les animaux dans la liste.
            StringBuilder message = new StringBuilder();
            for(Animal a : Animaux.animals) {
                message.append(a.toString()).append("\n");
            }
            System.out.println(ANSI_YELLOW + "\nListe des animaux : ");
            System.out.println(message + ANSI_RESET);

            // Affichage menu + réponse utilisateur.
            answer = menu();
        }

        // Message utilisateur pour l'arrêt du programme.
        System.out.println("Arrêt du programme !");
        Log4U.logging.log(Level.INFO, "Software stopping...");
    }

    /**
     * Méthode d'affichage du menu + récupération réponse utilisateur.
     * @return String réponse utilisateur.
     */
    public static String menu(){
        System.out.println("Voulez vous rentrer un (C)hien, un " +
                "(O)iseau ou (A)rrêter");

        return scan.nextLine();
    }
}