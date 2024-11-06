package entites;

/**
 * Classe abstraite Animal
 */
public abstract class Animal {

    // Variables de classe, ou propriétés.
    int age;
    private String nom;
    private String espece;

    /**
     * Constructeur avec toutes les variables.
     * @param nom Nom de l'animal
     * @param espece Espèce de l'animal.
     * @param age Age de l'animal.
     */
    public Animal(String nom, String espece, int age) {
        setNom(nom);
        setEspece(espece);
        setAge(age);
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
    public void setNom(String nom) {
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
        this.espece = espece;
    }

    /**
     * Getter age
     * @return Age de l'animal.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter age
     * @param age Age de l'animal.
     */
    public void setAge(int age) {
        this.age = age;
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
        return "Je m'appelle " + nom + ", j'ai " + age + " ans, je suis un " + espece;
    }
}
