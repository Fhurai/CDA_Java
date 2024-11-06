package entites;

/**
 * Classe Oiseau
 */
public class Oiseau extends Animal {
    // Variable de classe, ou propriété.
    private int nombreDePlumes;

    /**
     * Constructeur avec toutes les variables.
     * @param nom Nom de l'oiseau
     * @param age Age de l'oiseau
     * @param nombreDePlumes Nombre de plumes de l'oiseau.
     */
    public Oiseau(String nom, int age, int nombreDePlumes) {
        super(nom, "oiseau", age);
        setNombreDePlumes(nombreDePlumes);
    }

    /**
     * Getter nombre de plumes
     * @return nombre de plumes de l'oiseau.
     */
    public int getNombreDePlumes() {
        return nombreDePlumes;
    }

    /**
     * Setter nombre de plumes.
     * @param nombreDePlumes Nombre de plumes de l'oiseau.
     */
    public void setNombreDePlumes(int nombreDePlumes) {
        this.nombreDePlumes = nombreDePlumes;
    }

    /**
     * Méthode pour afficher le vol de l'oiseau
     */
    public void senvoler() {
        System.out.println("Je vole");
    }

    /**
     * Méthode pour afficher ce que peut manger l'oiseau.
     * @param nourriture Nourriture pouvant être mangée.
     */
    public void manger(String nourriture) {
        System.out.println("Je ne mange que " + nourriture);
    }

    /**
     * Méthode pour afficher où dort l'oiseau.
     */
    public void dormir() {
        System.out.println("Je dors dans un nid");
    }

    /**
     * Méthode pour afficher l'oiseau
     * @return L'oiseau sous forme d'une chaîne de caractères.
     */
    @Override
    public String toString() {
        return super.toString() + " et j'ai " + nombreDePlumes + " plumes";
    }
}
