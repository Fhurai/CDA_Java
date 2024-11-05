import entites.Adresse;
import entites.Personne;
import utilitaires.Outils;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Set des trois adresses.
        Adresse adresseParis = new Adresse(2, "rue Victor Hugo", 75008, "Paris");
        Adresse adresseNantes = new Adresse(17, "rue de la République", 44000
                , "Nantes");
        Adresse adresseLille = new Adresse(55, "Bld de la Libération", 59000,
                "Lille");

        // Set des trois personnes.
        Personne jean = new Personne("Jean", "Dupont", 30, adresseLille);
        Personne bernard = new Personne("Bernard", "Morin", 45, adresseParis);
        Personne nathalie = new Personne("Nathalie", "Durand", 35,
                adresseNantes);

        // Jean déménage.
        jean.setAdresse(new Adresse(44, "Rue des Docks", 33000, "Bordeaux"));
        Outils.afficher("Jean", jean);

        // Nathalie se marie et déménage.
        nathalie.setAdresse(adresseParis);

        ArrayList<Personne> maries = new ArrayList<Personne>();
        maries.add(bernard);
        maries.add(nathalie);
        Outils.afficher("Vive les mariés !!", maries);

    }
}