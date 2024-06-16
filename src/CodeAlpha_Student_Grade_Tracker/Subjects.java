package CodeAlpha_Student_Grade_Tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subjects {
	//The teacher enter the total number of subjects and the name of each one
    private static int subjectsNumber;
    private static List<String> subjectsList = new ArrayList<>();

    public static int getSubjectsNumber() {
        return subjectsNumber;
    }

    public static void setSubjectsNumber(int subjectsNumber) {
        Subjects.subjectsNumber = subjectsNumber;
    }

    public static List<String> getSubjectsList() {
        return subjectsList;
    }

    public static void setSubjectsList(List<String> subjectsList) {
        Subjects.subjectsList = subjectsList;
    }

    @Override
    public String toString() {
        return "Subjects [subjectsNumber=" + subjectsNumber + ", subjectsList=" + subjectsList + "]";
    }

    public static void enterSubjects() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t-----Welcome to Student Grade Tracker-----\n\n");

        while (true) {
            try {
                System.out.println("\t\t-----Enter the total number of subjects----- ");
                subjectsNumber = scanner.nextInt();
                if (subjectsNumber <= 0) {
                    throw new NegativeNumberException();
                }
                break; 
            } catch (NegativeNumberException e) {
                System.err.println(e.getMessage());
                scanner.nextLine();
            }
        }

        System.out.println("\n\t\t-----SAVED-----\n\n\t\t-----Enter now subjects' names-----\n\n●");
        scanner.nextLine(); 
        for (int i = 0; i < subjectsNumber; i++) {
            while (true) {
                try {
                    String subject = scanner.nextLine().trim();
                    if (subject.matches("^(?=.*[a-zA-Z])[a-zA-Z0-9 ']*$\r\n")) { 
                    	//A valid subject name should contain at least one alphabetic character; zero or more numbers, single quotes and spaces
                        throw new NotStringException();
                    }
                    subjectsList.add(subject);
                    System.out.println("\t\t-----SAVED!-----\n●");
                    break; 
                } catch (NotStringException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("\n\t\t-----You have entered " + subjectsNumber + " subjects successfully!-----");
    }
}