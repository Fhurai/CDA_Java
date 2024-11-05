package entites;

/**
 * Classe adresse
 */
public class Adresse {

    // Variables de classe
    private int numero_rue;
    private String nom_rue;
    private int codePostal;
    private String ville;

    /**
     * Constructeur
     * @param numero_rue Numéro de la rue
     * @param nom_rue Nom de la rue
     * @param codePostal Code postal
     * @param ville Nom de la ville.
     */
    public Adresse(int numero_rue, String nom_rue, int codePostal, String ville) {
        this.numero_rue = numero_rue;
        this.nom_rue = nom_rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    /**
     * Getter Numero rue
     * @return Numéro de la rue.
     */
    public int getNumero_rue() {
        return numero_rue;
    }

    /**
     * Setter Numero rue
     * @param numero_rue Numéro de la rue.
     */
    public void setNumero_rue(int numero_rue) {
        this.numero_rue = numero_rue;
    }

    /**
     * Getter Nom rue
     * @return Nom de la rue.
     */
    public String getNom_rue() {
        return nom_rue;
    }

    /**
     * Setter Nom rue
     * @param nom_rue Nom de la rue.
     */
    public void setNom_rue(String nom_rue) {
        this.nom_rue = nom_rue;
    }

    /**
     * Getter Code postal
     * @return Code postal
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * Setter Code postal
     * @param codePostal Code postal
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Getter ville
     * @return Nom de la ville.
     */
    public String getVille() {
        return ville;
    }

    /**
     * Setter ville
     * @param ville Nom de la ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Override de la méthode toString()
     * @return L'adresse sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return this.numero_rue + " " + this.nom_rue + ", " + this.codePostal + " " + this.ville;
    }
}
