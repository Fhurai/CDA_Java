package entites;

import java.text.DateFormat;
import java.util.Date;

/**
 * Classe Message.
 */
public class Message {

    // Variables de classe, ou propriétés.
    private String titre;
    private String texte;
    private final Date dateCreation;
    private final Utilisateur utilisateur;
    private Forum forum;

    /**
     * Constructeur avec toutes les variables.
     * @param titre Titre du message.
     * @param texte Texte du message.
     * @param utilisateur Utilisateur derriere le message.
     */
    public Message(String titre, String texte, Utilisateur utilisateur) {
        this.titre = titre;
        this.texte = texte;
        this.dateCreation = new Date();
        this.utilisateur = utilisateur;
    }

    /**
     * Getter Titre
     * @return Titre du message.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Setter titre
     * @param titre Titre du message.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Getter texte.
     * @return Texte du message.
     */
    public String getTexte() {
        return texte;
    }

    /**
     * Setter texte
     * @param texte Texte du message.
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     * Getter Date création
     * @return Date de création du message.
     */
    public String getDateCreation() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        return df.format(dateCreation);
    }

    /**
     * Getter Utilisateur.
     * @return Utilisateur derrière le message.
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Override de la méthode toString()
     * @return Le message sous forme de chaîne de caractères
     */
    @Override
    public String toString() {
        return titre + " -- " + texte + "\nDate de création : " + getDateCreation() + "\n" + utilisateur;
    }

    /**
     * Méthode donnant l'auteur.
     * @return L'auteur sous forme de chaîne de caractères.
     */
    public String getAuteur() {
        return utilisateur.getPrenom() + " " + utilisateur.getNom() + ", " + utilisateur.getStatus();
    }
}
