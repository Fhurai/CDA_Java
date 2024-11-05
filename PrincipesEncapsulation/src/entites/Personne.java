package entites;

/**
 * Classe personne.
 */
public class Personne {

    // Constantes
    private static final String PAS_DE_SOCIETE = "?";

    // Variables de classe (ou propriétés).
    private String nom;
    private String societe;

    /**
     * Constructeur 1 variable
     * @param nom Nom de la personne.
     */
    public Personne(String nom) {
        setNom(nom);
        this.societe = PAS_DE_SOCIETE;
    }

    /**
     * Constructeur 2 variables
     * @param nom Nom de la personne.
     * @param societe Nom de la société.
     */
    public Personne(String nom, String societe) {
        setNom(nom);
        setSociete(societe);
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
     * @param nom Nom de la personne.
     */
    public void setNom(String nom) {
        this.nom = nom.toUpperCase();
    }

    /**
     * Getter Societe
     * @return Nom de la société.
     */
    public String getSociete() {
        return societe;
    }

    /**
     * Setter Societe.
     * @param societe Nom de la société
     */
    public void setSociete(String societe) {
        this.societe = validerSociete(societe).toUpperCase();
    }

    /**
     * Méthode d'affichage de la personne.
     */
    public void afficher() {
        System.out.println("Je m'appelle " + this.nom + " et je " +
                (this.societe != PAS_DE_SOCIETE ? "travaille chez " +
                        this.societe : "ne suis pas employé d'une entreprise."));
    }

    /**
     * Méthode pour quitter la société.
     */
    public void quitterSociete() {
        if (this.societe.equals(PAS_DE_SOCIETE)) {
            afficher();
            System.out.println("Je ne suis pas salarié : impossible de " +
                    "quitter la société");
            System.exit(1);
        }

        this.societe = PAS_DE_SOCIETE;
    }

    /**
     * Méthode de validation de la société.
     * @param societe Nom de la société.
     * @return Société si validée sinon chaine vide.
     */
    private String validerSociete(String societe) {

        if (!societe.equals(PAS_DE_SOCIETE) && societe.length() <= 30) {
            // Si la société fournie n'est pas '?' et qu'elle fait plus de 30
            // caracteres.

            if(this.societe != null && !this.societe.equals(PAS_DE_SOCIETE)) {
                // Si la société de la personne n'est pas vide.
                System.out.println("Erreur : \n 1-quitterSociete, puis \n " +
                        "2-setSociete");
                System.exit(1);
            }

            return societe;
        }

        return "";
    }
}
