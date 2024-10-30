import model.Personne;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Personne martin, dupont;

        martin = new Personne("Martin", "JAVA SARL");
        martin.setDateNaissance(1985, 7, 12);
        martin.afficher();

        dupont = new Personne("Dupont", "J2EE SA");
        dupont.setDateNaissance(1997, 9, 21);
        dupont.afficher();
    }
}