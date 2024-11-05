package entites;

/**
 * Classe Personne.
 */
public class Personne {

    // Variables de classe ou propriétés.
    private String prenom;
    private String nom;
    private int age;
    private Adresse adresse;

    /**
     * Constructeur
     * @param prenom Prénom
     * @param nom Nom
     * @param age Age
     * @param adresse Adresse
     */
    public Personne(String prenom, String nom, int age, Adresse adresse) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.adresse = adresse;
    }

    /**
     * Getter Prénom
     * @return Prénom de la personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter Prénom
     * @param prenom Prénom de la personne.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter Nom
     * @return Nom de la personne.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter Nom
     * @param nom Nom  de la personne.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter Age
     * @return Age de la personne.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter Age
     * @param age Age de la personne.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter adresse
     * @return Adresse de la personne.
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setter adresse
     * @param adresse Adresse de la personne.
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Override de la méthode toString()
     * @return La personne sous forme d'une chaîne de caractères.
     */
    @Override
    public String toString() {
        return this.prenom + " " + this.nom + " " + this.age + " ans, habite " +
                "au " + this.adresse;
    }
}
