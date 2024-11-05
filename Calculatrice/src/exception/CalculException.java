package exception;

public class CalculException extends RuntimeException {

    public CalculException(String message) {
        super(message);
    }

    public CalculException(char operateur) {
        super("Opérateur '" + operateur + "' inconnu");
    }
}
