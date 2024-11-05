package entites;

/**
 * Classe utilisateur
 */
public class Utilisateur {

    // Variables de classe, ou propriétés
    private String prenom;
    private String nom;
    private CategorieUtilisateur status;

    /**
     * Constructeur avec toutes les variables.
     * @param prenom Le prenom de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     * @param status Le statut de l'utilisateur.
     */
    public Utilisateur(String prenom, String nom, CategorieUtilisateur status) {
        this.prenom = prenom;
        this.nom = nom;
        this.status = status;
    }

    /**
     * Getter Prenom
     * @return Prenom de l'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter Prenom
     * @param prenom Prenom de l'utilisateur.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter Nom
     * @return Nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter Nom
     * @param nom de l'utilisateur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter Status
     * @return Statut de l'utilisateur.
     */
    public CategorieUtilisateur getStatus() {
        return status;
    }

    /**
     * Setter Status
     * @param status Statut de l'utilisateur.
     */
    public void setStatus(CategorieUtilisateur status) {
        this.status = status;
    }

    /**
     * Override de la méthode toString()
     * @return L'utilisateur sous forme d'une chaîne de caractères.
     */
    @Override
    public String toString() {
        return "Utilisateur : " + prenom + " " + nom + ", " + status;
    }
}
