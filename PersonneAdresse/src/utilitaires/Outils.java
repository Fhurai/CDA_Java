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
     * @param titre Titre de la fenêtre de dialogue.
     * @param p Personne à afficher.
     */
    static public void afficher(String titre, Personne p) {
        JOptionPane.showMessageDialog(null, p, titre, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Méthode d'affichage de plusieurs personnes
     * @param titre Titre de la fenêtre de dialogue.
     * @param p Liste de personnes à afficher.
     */
    static public void afficher(String titre, ArrayList<Personne> p) {
        StringBuilder infos = new StringBuilder();

        for (Personne personne : p) {
            infos.append(personne.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, infos.toString(), titre,
                JOptionPane.INFORMATION_MESSAGE);
    }
}
