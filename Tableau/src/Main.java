import java.util.Random;
import java.util.Scanner;

/**
 * Programme de tableau.
 */
public class Main {

    /**
     * Variables.
     */
    static int[] tableau;
    static Scanner sc = new Scanner(System.in);
    static int tailleTableau;

    /**
     * Méthode principale.
     *
     * @param args Arguments de lancement.
     */
    public static void main(String[] args) {

        // Demande de la taille de tableau + initialisation du tableau.
        System.out.println("Veuillez donner la taille du tableau : ");
        tailleTableau = sc.nextInt();
        tableau = new int[tailleTableau];

        // Remplissage tableau de valeurs aléatoires.
        remplirTableau();

        // Tri à bulles sur les valeurs du tableau (tri pas ouf).
        triBulles();

        // Recherche dichotomique sur les valeurs du tableau.
        dichotomicSearch();
    }

    /**
     * Méthode de remplissage du tableau avec des valeurs aléatoires.
     */
    public static void remplirTableau() {

        // Initialisation du RNG.
        Random rn = new Random();

        // Parcours du tableau et entrée d'une valeur random.
        for (int i = 0; i < tailleTableau; i++) {
            tableau[i] = rn.nextInt(tailleTableau) + 1;
        }
    }

    /**
     * Méthode d'affichage du tableau avec ses valeurs et ses indices.
     */
    public static void presentTableau(String message) {

        System.out.println("\n" + message);

        // Affichage du tableau
        for (int i = 0; i < tailleTableau; i++) {
            System.out.println("tableau[" + i + "] = " + tableau[i]);
        }
    }

    /**
     * Méthode de tri à bulles.
     */
    public static void triBulles() {

        // Parcours des valeurs du tableau
        for (int i = 0; i < tailleTableau - 1; i++) {

            // Comparaison avec le reste des valeurs du tableau.
            for (int j = 0; j < tailleTableau - 1; j++) {

                // Si la valeur du tableau à la position j est plus grande
                // que la valeur à la position j + 1, inversion des valeurs.
                if (tableau[j] > tableau[j + 1]) {
                    int temp = tableau[j];
                    tableau[j] = tableau[j + 1];
                    tableau[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Recherche dichotomique.
     */
    public static void dichotomicSearch() {
        // Demande d'un nombre à l'utilisateur.
        System.out.println("Veuillez donner une valeur dont vous souhaitez " +
                "l'indice");

        // Initialisation des variables
        int value = sc.nextInt();
        int borneMax = tailleTableau;
        int borneMin = 0;
        int middle = (borneMax + borneMin) / 2;
        int compteur = 0;
        boolean found = false;

        // Tant que la valeur n'a pas été trouvée
        while (!found) {

            if (tableau[middle] < value) {
                // Si la valeur au milieu de la plage est inférieure
                // à la valeur cherchée, la valeur milieu devient borne mini.
                borneMin = middle;
            } else if (tableau[middle] > value) {
                // Si la valeur au milieu de la plage est supérieur
                // à la valeur cherchée, la valeur milieu devient borne max.
                borneMax = middle;
            } else {
                // Valeur au milieu de la plage est égale à la valeur cherchée.
                found = true;
            }

            // Nouvelle valeur de milieu avec les nouvelles bornes.
            middle = (borneMax + borneMin) / 2;

            // Incrémentation du compteur de tour.
            compteur++;

            // Si le compte de tours égal la taille du tableau, c'est que la
            // valeur n'existe pas.
            if (compteur == tailleTableau) {
                break;
            }
        }

        // Message à l'utilisateur si la valeur a été trouvée ou non avec le
        // nombre de tours utilisés.
        if (found) {
            System.out.println("Your value " + value + " was found at index " + middle + " after " + compteur + " turns.");
        } else {
            System.out.println("Your value " + value + " was not found " +
                    "after " + compteur + " turns.");
        }
    }
}