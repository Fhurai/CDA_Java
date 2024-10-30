package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe Personne
 */
public class Personne {

    private String nom;
    private String societe;
    private Calendar dateNaissance;

    public Personne(String nom, String societe) {
        this.nom = nom.toUpperCase();
        this.societe = societe;
    }

    public Personne(String nom) {
        this.nom = nom.toUpperCase();
        this.societe = "?";
        this.dateNaissance = null;
    }

    public String getNom() {
        return nom;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe.substring(0, 1).toUpperCase() + societe.substring(1).toLowerCase();
    }

    public Calendar getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Calendar dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setDateNaissance(int year, int month, int day) {
        this.dateNaissance =  new GregorianCalendar(year, month, day);;
    }

    public int getAge() {
        if (this.dateNaissance != null) {
            return new GregorianCalendar().compareTo(this.dateNaissance);
        } else {
            return 0;
        }
    }

    /**
     * Méthode d'affichage des infos de la personne.
     *
     * @return
     */
    public void afficher() {
        System.out.println("Bonjour, je suis " + nom);

        if (societe.equals("?")) {
            System.out.println("Je ne suis actuellement pas employé.");
        } else {
            System.out.println("J'appartiens à la société " + societe);
        }

        if (dateNaissance != null) {
            System.out.println("J'ai actuellement "+this.getAge()+" ans.");
        }
    }
}
