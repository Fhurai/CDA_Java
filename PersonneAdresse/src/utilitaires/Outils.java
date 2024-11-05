package utilitaires;

import entites.Personne;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Classe d'outils.
 */
public class Outils {

    /**
     * Méthode d'affichage d'une personne.
     *
     * @param titre Titre de la fenêtre de dialogue.
     * @param p     Personne à afficher.
     */
    static public void afficher(String titre, Personne p) {
        // Affichage de la personne dans une fenêtre de dialogue.
        JOptionPane.showMessageDialog(null, p, titre, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Méthode d'affichage de plusieurs personnes
     *
     * @param titre Titre de la fenêtre de dialogue.
     * @param p     Liste de personnes à afficher.
     */
    static public void afficher(String titre, ArrayList<Personne> p) {
        // Initialisation de la variable stringbuilder.
        StringBuilder infos = new StringBuilder();

        for (Personne personne : p) {
            // Pour chaque personne, ajout de celle ci sous forme de chaine
            // de caractères.
            infos.append(personne.toString()).append("\n");
        }

        // Affichage des personnes dans une fenêtre de dialogue.
        JOptionPane.showMessageDialog(null, infos.toString(), titre,
                JOptionPane.INFORMATION_MESSAGE);
    }
}
