import entites.Cadre;
import entites.Employe;
import entites.Personne;
import entites.Stagiaire;
import utilities.Outils;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Partie stagiaire
        LocalDate birthday1 = LocalDate.of(1995, 9, 4);
        LocalDate debut1 = LocalDate.of(2025, 5, 12);
        LocalDate fin1 = LocalDate.of(2025, 7, 18);

        Stagiaire albert = new Stagiaire("Albert", "Lafont", birthday1, debut1, fin1);
        System.out.println(albert);

        // Partie employe
        LocalDate birthday2 = LocalDate.of(1989, 7, 15);
        LocalDate debut2 = LocalDate.of(2020, 5, 12);

        Employe fabrice = new Employe("Fabrice", "Lamouchi", birthday2, "J2E"
                , debut2);
        System.out.println(fabrice);

        // Partie cast
        LocalDate birthday3 = LocalDate.of(1965, 11, 4);
        LocalDate debut3 = LocalDate.of(1985, 3, 21);
        Personne gerard = new Employe("Gerard", "Dupont", birthday3, "SNCF",
                debut3);
        System.out.println(gerard);

        //Partie cadre
        LocalDate birthday4 = LocalDate.of(1992, 12, 21);
        LocalDate debut4 = LocalDate.of(2015, 5, 15);
        Cadre lucas = new Cadre("Lucas", "Kuntz", birthday4, "OGMI", debut4,
                false, 30000);
        System.out.println(lucas);

        // Partie commune
        System.out.println("Albert est un "+Outils.getRole(albert));
        System.out.println("Fabrice est un "+Outils.getRole(fabrice));
        System.out.println("Gerard est un "+Outils.getRole(gerard));
        System.out.println("Lucas est un "+Outils.getRole(lucas));
    }
}