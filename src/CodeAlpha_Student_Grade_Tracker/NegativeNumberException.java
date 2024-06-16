package CodeAlpha_Student_Grade_Tracker;

public class NegativeNumberException extends Exception {
    public NegativeNumberException() {
        super("The number must be positive");
    }

    public NegativeNumberException(String message) {
        super(message);
    }
}
