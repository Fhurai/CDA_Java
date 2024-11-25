package view;

import entities.*;
import logManagement.LogCreator;
import utilities.Formats;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;

public class View {

    static Scanner scan = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void mainView(String[] args) {
        // Création logs.
        try{
            LogCreator.init();
        }catch(IOException ioe){
            alertAdmin("Logs indisponibles !");
        }

        // Lancement des logs de l'application.
        LogCreator.run();

        // Récupération de la saisie utilisateur depuis le menu.
        String answer = secureMenu();

        while (answer.compareToIgnoreCase("A") != 0){
            // Saisie d'animaux et affichage de ceux ci.
            animauxInput(answer);
            animauxOutput();
            answer = secureMenu();
        }

        // Log de l'arrêt de l'application et message utilisateur.
        LogCreator.stop();
        System.out.println("Software stopped");
    }

    /**
     * Méthode d'affichage du menu + récupération réponse utilisateur.
     * @return réponse utilisateur.
     */
    private static String menu(){
        System.out.println("Voulez vous rentrer un (C)hien, un (O)iseau ou (A)rrêter");

        return scan.nextLine();
    }

    /**
     * Méthode de saisie sécurisée de l'input menu de l'utilisateur.
     * @return réponse utilisateur.
     */
    private static String secureMenu(){
        // Premier affichage menu et récupération première saisie utilisateur.
        String answer = menu();

        // Si saisie utilisateur non correcte, force l'utilisateur a donner
        // une valeur correcte.
        while (answer.compareToIgnoreCase("A") != 0 && answer.compareToIgnoreCase("O") != 0 && answer.compareToIgnoreCase("C") != 0){
            System.out.println("Commande inconnue, veuillez donner une " +
                    "commande de la liste fournie.\n");
            answer = menu();
        }

        // Retourne saisie utilisateur correcte.
        return answer;
    }

    /**
     * Méthode d'alerte à l'utilisateur avec message pour alerter les admins.
     * @param message Le message à afficher en plus du message d'alerte.
     */
    private static void alertAdmin(String message){
        System.out.println("Veuillez contacter l'équipe d'administrateurs !");
        System.out.println(message);
        System.exit(1);
    }

    /**
     * Méthode de saisie d'un animal dans la liste des animaux.
     * @param answer L'entrée de l'utilisateur.
     */
    private static void animauxInput(String answer){
        String nom, race, dateNaissance;
        int age, plumes;
        LocalDate dDateNaissance;

        try{
            // Demande nom animal + réponse utilisateur.
            System.out.println("\nVeuillez saisir le nom de l'animal : ");
            nom = scan.nextLine();

            System.out.println("Veuillez saisir la date de naissance de " +
                    "l'animal : ");
            dateNaissance = scan.nextLine();
            dDateNaissance = LocalDate.parse(dateNaissance, Formats.FORMAT_DDMMYYYY);

            switch (answer.toUpperCase()){
                case "C":
                    // Demande race chien + réponse utilisateur +
                    // initialisation chien dans liste animaux.
                    System.out.println("Veuillez saisir la race du chien : ");
                    race = scan.nextLine();
                    Animaux.animals.add(new Chien(nom, dDateNaissance, race));
                    break;
                case "O":
                    // Demande plumes oiseau + réponse utilisateur +
                    // initialisation oiseau dans liste animaux.
                    System.out.println("Veuillez saisir le nombre de plumes " +
                            "de l'oiseau");
                    plumes = Integer.parseInt(scan.nextLine());
                    Animaux.animals.add(new Oiseau(nom, dDateNaissance, plumes));
                    break;
            }
        }catch(NumberFormatException nfe){
            // Exception valeur numérique non valide par utilisateur.
            System.out.println(ANSI_RED+"\nErreur : Valeur numérique non " +
                    "valide!"+ANSI_RESET);
            LogCreator.publisher.log(Level.WARNING,
                    Arrays.toString(nfe.getStackTrace()));
        }catch (KennelEntitiesException aee) {
            // Exception info animal non valide par utilisateur.
            System.out.println(ANSI_RED + "\nErreur : " + aee.getMessage() + ANSI_RESET);
            LogCreator.publisher.log(Level.WARNING, "Erreur : " + Arrays.toString(aee.getStackTrace()));
        }catch(DateTimeException dte){
            System.out.println(ANSI_RED+"\nErreur  : La date de naissance " +
                    "n'est pas au format dd/mm/yyyy"+ANSI_RESET);
            LogCreator.publisher.log(Level.WARNING, "Erreur : " + Arrays.toString(dte.getStackTrace()));
        }catch(Exception e){
            // Exception non attendue attrapée, utilisateur averti et log.
            System.out.println(ANSI_RED+"\nErreur : " + e.getMessage()+ANSI_RESET);
            LogCreator.publisher.log(Level.WARNING, "Erreur : " + Arrays.toString(e.getStackTrace()));
            System.exit(1);
        }
    }

    /**
     * Méthode d'affichage des animaux saisies.
     */
    private static void animauxOutput(){
        // Tri des animaux dans la liste.
        Animaux.animals.sort(new Animaux.NameComparator());

        // Affichage de tous les animaux dans la liste.
        StringBuilder message = new StringBuilder();
        for(Animal a : Animaux.animals) {
            message.append(a.toString()).append("\n");
        }
        System.out.println(ANSI_YELLOW + "\nListe des animaux : ");
        System.out.println(message + ANSI_RESET);
    }
}
