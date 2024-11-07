package entites;

import java.time.LocalDate;

public class Cadre extends Employe{
    private boolean dirigeService;
    private double salaire;

    public Cadre(String prenom, String nom, LocalDate dateNaissance, String societe, LocalDate dateEntree, boolean dirigeService, double salaire) {
        super(prenom, nom, dateNaissance, societe, dateEntree);
        setDirigeService(dirigeService);
        setSalaire(salaire);
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public boolean isDirigeService() {
        return dirigeService;
    }

    public void setDirigeService(boolean dirigeService) {
        this.dirigeService = dirigeService;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + (this.dirigeService ? "Je suis" :
                "Je ne suis pas") + " responsable d'un service et je gagne un" +
                " salaire de "+this.salaire+"€ par an.";
    }
}
