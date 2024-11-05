import entites.CategorieUtilisateur;
import entites.Forum;
import entites.Message;
import entites.Utilisateur;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Initialisation des trois utilisateurs.
        Utilisateur jean = new Utilisateur("Jean", "Dupont", CategorieUtilisateur.STANDARD);
        Utilisateur bernard = new Utilisateur("Bernard", "Morin", CategorieUtilisateur.STANDARD);
        Utilisateur nathalie = new Utilisateur("Nathalie", "Morin", CategorieUtilisateur.MODERATEUR);

        // Initialisation du forum.
        Forum forum = new Forum();

        // Création de messages dans le forum par les différents utilisateurs.
        forum.ajouterUtilisateurMessages(new Message("Java SE", "L'encapsulation est une propriété fondamentale", jean));
        forum.ajouterUtilisateurMessages(new Message("Java SE", "L'héritage est une autre", jean));
        forum.ajouterUtilisateurMessages(new Message("Java SE", "Le polymorphisme est implicite en Java", jean));
        forum.ajouterUtilisateurMessages(new Message("Java EE", "Les annotations sont pratiques en Java.", jean));
        forum.ajouterUtilisateurMessages(new Message("Java EE", "Applications n-tiers", bernard));
        forum.ajouterUtilisateurMessages(new Message("Java EE", "Couche Web : Servlet et JSP", bernard));
        forum.ajouterUtilisateurMessages(new Message("Java EE", "JSF : Framework - Couche Présentation", nathalie));
        forum.ajouterUtilisateurMessages(new Message("Java EE", "JPA - Hibernate", nathalie));
        forum.ajouterUtilisateurMessages(new Message("Java EE", "JDBC", nathalie));

        // Affichage des messages du forum.
        JOptionPane.showMessageDialog(null, forum.getListeMessagesAuteur(), "Messages", JOptionPane.INFORMATION_MESSAGE);
    }
}