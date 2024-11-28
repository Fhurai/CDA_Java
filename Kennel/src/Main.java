import entities.Animaux;
import entities.Chien;
import entities.Oiseau;
import logManagement.LogCreator;
import utilities.Formats;
import view.Menu;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    /**
     * Méthode principale du programme.
     *
     * @param args Arguments de lancement de la méthode.
     */
    public static void main(String[] args) {
        try {
            LogCreator.init();
        } catch (IOException ioe) {
            System.out.println("Erreur de IO");
        }

        LogCreator.run();
        initLists();
        new Menu().setVisible(true);
    }

    private static void initLists() {
        Animaux.animals.add(new Chien("Milou", LocalDate.parse("08/05/2014", Formats.FORMAT_DDMMYYYY), "white yorshire"));
        Animaux.animals.add(new Chien("Idefix", LocalDate.parse("06/10/2020", Formats.FORMAT_DDMMYYYY), "gaulois"));
        Animaux.animals.add(new Oiseau("Titi", LocalDate.parse("14/11/2021", Formats.FORMAT_DDMMYYYY), 200));
        Animaux.animals.add(new Oiseau("Bipbip", LocalDate.parse("04/07/2019", Formats.FORMAT_DDMMYYYY), 1000));
    }
}