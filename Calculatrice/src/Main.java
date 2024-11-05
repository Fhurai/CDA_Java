import exception.CalculException;
import model.Calculatrice;

public class Main {
    public static void main(String[] args) {

        Calculatrice calculatrice = new Calculatrice();

        System.out.println("1 + 2 = " + calculatrice.calculer('+', 1, 2));
        System.out.println("2078 - 64 = " + calculatrice.calculer('-', 2078, 64));
        System.out.println("15 * 3 = " + calculatrice.calculer('*', 15, 3));
        System.out.println("42 / 9 = " + calculatrice.calculer('/', 42, 9));
        System.out.println("(15 / 2) + (2 * 3) = " + (calculatrice.calculer('/', 15, 2) + calculatrice.calculer('*', 2, 3)));

        try {
            System.out.println("15 / 0 = " + calculatrice.calculer('/', 15, 0));
        } catch (CalculException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("1 ! 2 = " + calculatrice.calculer('!', 1, 2));
        } catch (CalculException e) {
            e.printStackTrace();
        }
    }
}