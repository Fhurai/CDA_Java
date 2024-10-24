import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int numberToGuess;
    static int maxNumber;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Guess Number");
        System.out.println("Please enter a max number between 1 and 9999");

        maxNumber = sc.nextInt();
        Random rn = new Random();
        numberToGuess = rn.nextInt(maxNumber) + 1;

        propose();
    }

    public static void propose(){
        boolean guessed = false;

        System.out.println("Guess the number");
        while(!guessed){
            int number = sc.nextInt();
            guessed = verify(number);
        }
    }

    public static boolean verify(int number){
        if(number == numberToGuess){
            System.out.println("You have guessed the number " + numberToGuess);
            System.out.println("Congratulations! ");
            return true;
        } else if (number > numberToGuess) {
            System.out.println("Lower");
        }else {
            System.out.println("Higher");
        }
        return false;
    }
}