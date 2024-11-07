package entites;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employe extends Personne{
    private String societe;
    private LocalDate dateEntree;

    public Employe(String prenom, String nom, LocalDate dateNaissance, String societe, LocalDate dateEntree) {
        super(prenom, nom, dateNaissance);
        setSociete(societe);
        setDateEntree(dateEntree);
    }

    public final String getSociete() {
        return societe;
    }

    public final void setSociete(String societe) {
        this.societe = societe;
    }

    public final LocalDate getDateEntree() {
        return dateEntree;
    }

    public final void setDateEntree(LocalDate dateEntree) {
        this.dateEntree = dateEntree;
    }

    public final long getDureeSociete(){
        return ChronoUnit.YEARS.between(this.dateEntree, LocalDate.now());
    }

    @Override
    public String toString() {
        return super.toString()+ "\nJe travaille chez "+this.societe+" depuis" +
                " le "+this.dateEntree.format(this.getDateFormatter())+", " +
                "soit depuis "+this.getDureeSociete()+" ans.\n";
    }
}
