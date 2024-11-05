package entites;

import javax.swing.*;

/**
 * Classe forum
 */
public class Forum {

    // Variables de classen ou propriétés.
    private final int NBR_MESSAGES = 20;
    private int NBR_MSG = 0;
    private final MessageUtilisateur[] messages;

    /**
     * Constructeur.
     */
    public Forum() {
        this.messages = new MessageUtilisateur[NBR_MESSAGES];
    }

    /**
     * Méthode d'ajout d'un message dans le forum.
     * @param message Message de l'utilisateur.
     * @return Message posté avec succès.
     */
    public boolean ajouterUtilisateurMessages(Message message) {

        // Par défaut, le message n'est pas posté.
        boolean result = false;

        // Création de la liaison message/utilisateur.
        MessageUtilisateur messageUtilisateur = new MessageUtilisateur(message.getUtilisateur(), message);

        try {
            // Ajout du message dans le tableau des messages.
            this.messages[NBR_MSG] = messageUtilisateur;
            NBR_MSG++;

            // Message bien posté.
            result = true;
        } catch (Exception e) {
            // Erreur rencontrée, message à l'utilisateur.
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        // Retourne si le message a bien été posté.
        return result;
    }

    /**
     * Méthode qui retoure l'ensemble des messages du forum.
     * @return L'ensemble des messages sous forme d'une chaîne de caractères.
     */
    public String getListeMessagesAuteur() {
        // Initialisation StringBuilder.
        StringBuilder listeMessages = new StringBuilder();

        for (MessageUtilisateur msgUtil : this.messages) {
            // Pour chaque message non nul, ajout au StringBuilder.
            if(msgUtil != null) listeMessages.append(msgUtil.toString() + "\n");
        }

        // Retourne la chaine créée par le StringBuilder.
        return listeMessages.toString();
    }
}
