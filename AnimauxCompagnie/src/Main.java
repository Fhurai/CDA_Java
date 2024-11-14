import entites.Animal;
import entites.Animaux;
import entites.Chien;
import entites.Oiseau;

import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe principale du programme.
 */
public class Main {

    /**
     * Méthode principale du programme.
     * @param args Arguments de lancement de la méthode.
     */
    public static void main(String[] args) {

        Chien toutou = new Chien("Idefix",  10, "West highland white terrier");
        Oiseau birbjima = new Oiseau("Birbjima", 5, 200);
        Chien milou = new Chien("Milou", 12, "Wire Fox Terrier");
        Oiseau titi = new Oiseau("Titi", 7, 100);
        Chien cerbere = new Chien("Cerbere", 3000, "Hell spawn");

        Animaux animaux = new Animaux();
        animaux.getAnimals().add(toutou);
        animaux.getAnimals().add(birbjima);
        animaux.getAnimals().add(milou);
        animaux.getAnimals().add(titi);
        animaux.getAnimals().add(cerbere);

//        Comparator.comparing(Animal::getNom).thenComparing(Animal::getAge);
        animaux.getAnimals().sort(new Animaux.NameComparator());

        StringBuilder message = new StringBuilder();
        for(Animal a : animaux.getAnimals()) {
            message.append(a.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, message.toString(), "1ère liste " +
                        "triée par nom",
                JOptionPane.INFORMATION_MESSAGE);

        /*
         * PARTIE RECHERCHE + MODIFICATION.
         */

        int index = -1;
        if(!animaux.getAnimals().isEmpty()){
            if(animaux.getAnimals().contains(milou)){
                index = animaux.getAnimals().indexOf(milou);
            }

            if(index != -1){
                System.out.println(animaux.getAnimals().get(index));
                animaux.getAnimals().get(index).setNom("Milou de Tintin");
                System.out.println(animaux.getAnimals().get(index));
            }
        }

        message = new StringBuilder();
        for(Animal a : animaux.getAnimals()) {
            message.append(a.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, message.toString(), "2ème liste " +
                        "triée par nom", JOptionPane.INFORMATION_MESSAGE);
    }
}