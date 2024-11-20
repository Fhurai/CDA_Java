package entites;

/**
 * Classe Chien
 */
public class Chien extends Animal {
    // Variable de classe, ou propriété.
    private String race;

    /***
     * Constructeur avec toutes les variables.
     * @param nom Nom du chien
     * @param age Age du chien
     * @param race Race du chien
     */
    public Chien(String nom, int age, String race) throws AnimalException {
        super(nom, "chien", age);
        setRace(race);
    }

    /**
     * Getter race
     * @return Race du chien.
     */
    public String getRace() {
        return race;
    }

    /**
     * Setter race
     * @param race Race du chien
     */
    public void setRace(String race) throws AnimalException {
        if((race == null) || (race.length() < 3)){
            throw new AnimalException("Race nom identifiable!");
        }
        this.race = race;
    }

    /**
     * Methode pour afficher l'aboiement du chien
     */
    public void aboyer() {
        System.out.println("J'aboie");
    }

    /**
     * Methode pour afficher où dort le chien
     */
    public void dormir() {
        System.out.println("Je dors dans une niche");
    }

    /**
     * Méthode pour afficher le chien
     * @return Le chien sous forme d'une chaîne de caractères
     */
    @Override
    public String toString() {
        return super.toString() + " et je suis de race " + getRace();
    }
}
