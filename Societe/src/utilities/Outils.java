package utilities;

import entites.Personne;

public class Outils {

    public static PersonneRole getRole(Personne p){
        return switch (p.getClass().getSimpleName()) {
            case "Stagiaire" -> PersonneRole.STAGIAIRE;
            case "Employe" -> PersonneRole.EMPLOYE;
            case "Cadre" -> PersonneRole.CADRE;
            default -> PersonneRole.PERSONNE;
        };
    }
}
