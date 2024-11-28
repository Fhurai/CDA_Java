package entities;


import utilities.Formats;
import utilities.Patterns;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Classe abstraite Animal
 */
public abstract class Animal {

    // Variables de classe, ou propriétés.
    private String nom;
    private String espece;
    private LocalDate dateNaissance;

    /**
     * Constructeur avec toutes les variables.
     * @param nom Nom de l'animal
     * @param espece Espèce de l'animal.
     * @param dateNaissance Date de naissance de l'animal.
     */
    public Animal(String nom, String espece, LocalDate dateNaissance) throws KennelEntitiesException {
        setNom(nom);
        setEspece(espece);
        setDateNaissance(dateNaissance);
    }

    /**
     * Constructeur vide.
     */
    public Animal() {
    }

    /**
     * Getter nom
     * @return Nom de l'animal.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter nom
     * @param nom Nom de l'animal.
     */
    public void setNom(String nom) throws KennelEntitiesException {
        if((nom == null) || (nom.isEmpty())){
            throw new KennelEntitiesException("Le nom est vide!");
        }
        if(!Patterns.PATTERN_NOM.matcher(nom).matches()){
            throw new KennelEntitiesException("Le nom doit commencer par une " +
                    "majuscule, ne contenir que des lettres et faire 2 " +
                    "caractères minimum.");
        }
        this.nom = nom;
    }

    /**
     * Getter espèce
     * @return Espèce de l'animal
     */
    public String getEspece() {
        return espece;
    }

    /**
     * Setter espèce
     * @param espece Espèce de l'animal
     */
    public void setEspece(String espece) {
        if((espece == null) || (espece.isEmpty())){
            throw new KennelEntitiesException("L'espèce est vide!");
        }
        if(!Patterns.PATTERN_ESPECE.matcher(espece).matches()){
            throw new KennelEntitiesException("L'espèce ne doit pas " +
                    "commencer par une majuscule, ne contenir que des " +
                    "lettres et faire 3 caractères minimum.'");
        }
        this.espece = espece;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) throws KennelEntitiesException {
        if((dateNaissance == null)){
            throw new KennelEntitiesException("La date de naissance est vide!");
        }
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getter age
     * @return Age de l'animal.
     */
    public long getAge() {
        return ChronoUnit.YEARS.between(this.dateNaissance, LocalDate.now());
    }

    /**
     * Méthode pour afficher ce que peut manger l'animal
     * @param nourriture Nourriture pouvant être mangée.
     */
    public void manger(String nourriture) {
        System.out.println("Je peux manger " + nourriture);
    }

    /**
     * Méthode abstraite pour afficher où dort l'animal.
     */
    public abstract void dormir();

    /**
     * Méthode pour afficher l'animal.
     * @return L'animal sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return "Je m'appelle " + nom + ", je suis né le "+this.getDateNaissance().format(Formats.FORMAT_DDMMYYYY)+", j'ai " + this.getAge() + " ans, je suis un " + espece;
    }
}

