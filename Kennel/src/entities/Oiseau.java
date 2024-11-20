package entities;

/**
 * Classe Oiseau
 */
public class Oiseau extends Animal {
    // Variable de classe, ou propriété.
    private int nombreDePlumes;

    /**
     * Constructeur avec toutes les variables.
     * @param nom Nom de l'oiseau
     * @param dateNaissance Date de naissance de l'oiseau.
     * @param nombreDePlumes Nombre de plumes de l'oiseau.
     */
    public Oiseau(String nom, String dateNaissance, int nombreDePlumes) throws KennelEntitiesException {
        super(nom, "oiseau", dateNaissance);
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
    public void setNombreDePlumes(int nombreDePlumes) throws KennelEntitiesException {
        if (nombreDePlumes < 0){
            throw new KennelEntitiesException("Le nombre de plumes est négatif!");
        }
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
