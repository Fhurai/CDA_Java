package entites;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class Personne {
    private String prenom;
    private String nom;
    private LocalDate dateNaissance;

    public Personne(String prenom, String nom, LocalDate dateNaissance) {
        setPrenom(prenom);
        setNom(nom);
        setDateNaissance(dateNaissance);
    }

    public final String getPrenom() {
        return prenom;
    }

    public final void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public final String getNom() {
        return nom;
    }

    public final void setNom(String nom) {
        this.nom = nom;
    }

    public final LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public final void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public final long getAge(){
        return ChronoUnit.YEARS.between(this.dateNaissance, LocalDate.now());
    }

    protected final DateTimeFormatter getDateFormatter(){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    public String toString() {
        return "Je m'appelle "+this.prenom + " "+this.nom+ ", je suis né le "+dateNaissance.format(this.getDateFormatter())+ " et j'ai "+this.getAge()+" ans";
    }
}
