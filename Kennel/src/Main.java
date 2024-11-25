import logManagement.LogCreator;
import view.View;

import java.io.IOException;

public class Main {

    static View view;

    /**
     * Méthode principale du programme.
     * @param args Arguments de lancement de la méthode.
     */
    public static void main(String[] args) {

        view = new View();
        View.mainView(args);
    }
}