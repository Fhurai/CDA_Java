package entites;

import java.util.ArrayList;
import java.util.Comparator;

public class Animaux {

    public static ArrayList<Animal> animals = new ArrayList<>();

    public static class NameComparator implements Comparator<Animal> {

        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getNom().compareToIgnoreCase(o2.getNom());
        }
    }

    public static class AgeComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
