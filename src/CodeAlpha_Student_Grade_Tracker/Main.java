package CodeAlpha_Student_Grade_Tracker;

public class Main {
    public static void main(String[] args) {
        Subjects.enterSubjects();
        try {
            Class.enterClass();
        } catch (NegativeNumberException e) {
            System.err.println(e.getMessage());
        }
        Class.display();
    }
}
