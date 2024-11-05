package entites;

/**
 * Classe Message d'utilisateur.
 */
public class MessageUtilisateur {

    // Variables de classe, ou propriétés.
    private final Utilisateur utilisateur;
    private final Message message;

    /**
     * Constructeur
     * @param utilisateur Utilisateur derriere le message.
     * @param message Message.
     */
    public MessageUtilisateur(Utilisateur utilisateur, Message message) {
        this.utilisateur = utilisateur;
        this.message = message;
    }

    /**
     * Getter Utilisateur
     * @return l'utilisateur du message.
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Getter Message
     * @return Message de l'utilisateur.
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Override de la méthode toString().
     * @return Le message de l'utilisateur sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return "Titre : "+this.message.getTitre() + " -- Texte : " + this.message.getTexte() + " -- Auteur : " + this.message.getAuteur();
    }
}
