import entites.Personne;

public class Main {
    public static void main(String[] args) {

        Personne durand = new Personne ("durand", "J2E SA");
        durand.afficher() ;
        durand.quitterSociete();
        durand.afficher() ;
        durand.setSociete("EJB Corporate");
        durand.afficher() ;
        durand.setSociete("EJB Corporate");
        durand.afficher() ;


    }
}