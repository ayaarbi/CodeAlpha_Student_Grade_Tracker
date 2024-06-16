package CodeAlpha_Student_Grade_Tracker;

public class NotStringException extends Exception {
    public NotStringException() {
		super("The subject's name should contain at least one alphabetic character; zero or more numbers, single quotes and spaces");
		// For examples: J2E, networks' fundamentals...
    }

    public NotStringException(String message) {
        super(message);
    }
}
