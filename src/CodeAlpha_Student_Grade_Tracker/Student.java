package CodeAlpha_Student_Grade_Tracker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student {
	//Each student has an ID, a first and last name, his scores in different subjects and then the system calculate his average
    private int studentId;
    private String firstName;
    private String lastName;
    private Map<String, Double> scoresMap = new HashMap<>();
    private double average;

    public Student(int studentId, String firstName, String lastName, Map<String, Double> scoresMap) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.scoresMap = scoresMap;
        this.average = computeAverage();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Double> getScoresMap() {
        return scoresMap;
    }

    public void setScoresMap(Map<String, Double> scoresMap) {
        this.scoresMap = scoresMap;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", scoresMap=" + scoresMap + "]";
    }

    public static Student enterStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\t-----Enter the student's ID:-----");
        int studentId = scanner.nextInt();

        System.out.println("\t\t-----Enter the student's first name:-----");
        String firstName = scanner.next();

        System.out.println("\t\t-----Enter the student's last name:-----");
        String lastName = scanner.next();

        Map<String, Double> scoresMap = new HashMap<>();
        System.out.println("\t\t-----Enter now this student's scores in different subjects:-----");
        for (String subject : Subjects.getSubjectsList()) {
            while (true) {
                try {
                    System.out.println(subject + ": ");
                    double score = scanner.nextDouble();
                    if (score <= 0) {
                        throw new NegativeNumberException();
                    }
                    scoresMap.put(subject, score);
                    System.out.println("\t\t-----SAVED!-----\n");
                    
                    break; 
                } catch (NegativeNumberException e) {
                	System.err.println(e.getMessage());
                	scanner.nextLine(); 
                }
            }
        }

        System.out.println("\n\t\t-----You have entered a student with ID= " + studentId + " successfully!-----");
        return new Student(studentId, firstName, lastName, scoresMap);
    }

    public double computeAverage() {
        double total = 0;
        for (double score : scoresMap.values()) {
            total += score;
        }
        return total / Subjects.getSubjectsNumber();
    }
}