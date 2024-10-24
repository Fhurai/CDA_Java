import java.util.Random;
import java.util.Scanner;

/**
 * Principale classe du jeu.
 */
public class Main {

    /**
     * Variables statiques du jeu.
     */
    static int numberToGuess;
    static int maxNumber;
    static Scanner sc = new Scanner(System.in);

    /**
     * Principale méthode du jeu.
     * @param args Arguments de lancement.
     */
    public static void main(String[] args) {
        // Demande au joueur de choisir un nombre max dans lequel choisir un
        // nombre random.
        System.out.println("Welcome to Guess Number");
        System.out.println("Please enter a max number between 1 and 9999");

        maxNumber = sc.nextInt();
        Random rn = new Random();
        numberToGuess = rn.nextInt(maxNumber) + 1;

        // Lancement du jeu.
        propose();
    }

    /**
     * Methode de proposition du nombre.
     */
    public static void propose(){
        // Par défaut, le nombre à deviner n'est pas trouvé.
        boolean guessed = false;

        // Lancement de la partie.
        System.out.println("Guess the number");

        while(!guessed){
            // Tant que le nombre n'est pas deviné, demande d'une réponse et
            // vérification.
            int number = sc.nextInt();
            guessed = verify(number);
        }
    }

    /**
     * Methode de vérification
     * @param number Le nombre donné par le joueur.
     * @return Status si le nombre donné est le nombre à deviner.
     */
    public static boolean verify(int number){

        if(number < numberToGuess){
            // Le nombre à deviner est plus grand.
            System.out.println("Higher");
        } else if (number > numberToGuess) {
            // Le nombre à deviner est plus petit.
            System.out.println("Lower");
        }else {
            // Si le nombre donné est bien le nombre à deviner.

            // Message de réussite + Status à vrai.
            System.out.println("You have guessed the number " + numberToGuess);
            System.out.println("Congratulations! ");
            return true;
        }
        // Nombre non trouvé, Status à faux.
        return false;
    }
}