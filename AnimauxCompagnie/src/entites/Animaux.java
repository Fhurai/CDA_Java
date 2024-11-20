package entites;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe de listage des animaux.
 */
public class Animaux {

    // La liste des animaux
    public static ArrayList<Animal> animals = new ArrayList<>();

    /**
     * Classe de comparaison des animaux sur le nom.
     */
    public static class NameComparator implements Comparator<Animal> {

        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getNom().compareToIgnoreCase(o2.getNom());
        }
    }

    /**
     * Classe de comparaison des animaux sur l'âge.
     */
    public static class AgeComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    /**
     * Getter liste animaux
     * @return Liste des animaux.
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
