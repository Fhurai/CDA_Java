package entites;

import java.time.LocalDate;

public class Stagiaire extends Personne {

    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Stagiaire(String prenom, String nom, LocalDate dateNaissance, LocalDate dateDebut, LocalDate dateFin) {
        super(prenom, nom, dateNaissance);
        setDateDebut(dateDebut);
        setDateFin(dateFin);
    }

    public final LocalDate getDateDebut() {
        return dateDebut;
    }

    public final void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public final LocalDate getDateFin() {
        return dateFin;
    }

    public final void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return super.toString() + "\nJe suis en stage du " +
                this.getDateDebut().format(this.getDateFormatter()) + " au " +
                this.getDateFin().format(this.getDateFormatter())+".\n";
    }
}
