import entites.Animal;
import entites.Chien;
import entites.Oiseau;

/**
 * Classe principale du programme.
 */
public class Main {

    /**
     * Méthode principale du programme.
     * @param args Arguments de lancement de la méthode.
     */
    public static void main(String[] args) {

        // Partie chien.
        Chien toutou = new Chien("Idefix",  10, "West highland white terrier");
        System.out.println(toutou);
        toutou.manger("sanglier");
        toutou.dormir();
        toutou.aboyer();

        // Partie oiseau.
        Oiseau birbjima = new Oiseau("Birbjima", 5, 200);
        System.out.println(birbjima);
        birbjima.manger("graines");
        birbjima.dormir();
        birbjima.senvoler();
    }
}