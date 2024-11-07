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

    public final double getSalaire() {
        return salaire;
    }

    public final void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public final boolean isDirigeService() {
        return dirigeService;
    }

    public final void setDirigeService(boolean dirigeService) {
        this.dirigeService = dirigeService;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + (this.dirigeService ? "Je suis" :
                "Je ne suis pas") + " responsable d'un service et je gagne un" +
                " salaire de "+this.salaire+"€ par an.";
    }
}
