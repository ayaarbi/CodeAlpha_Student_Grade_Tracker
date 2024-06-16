package CodeAlpha_Student_Grade_Tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class {
	//A class has its list of students
    private static int studentsNumber;
    private static List<Student> studentsList = new ArrayList<>();

    public static int getStudentsNumber() {
        return studentsNumber;
    }

    public static void setStudentsNumber(int studentsNumber) {
        Class.studentsNumber = studentsNumber;
    }

    public static List<Student> getStudentsList() {
        return studentsList;
    }

    public static void setStudentsList(List<Student> studentsList) {
        Class.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "Class []";
    }

    public static void enterClass() throws NegativeNumberException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t\t-----Enter the total number of students----- ");
        studentsNumber = scanner.nextInt();
        if (studentsNumber <= 0) {
            throw new NegativeNumberException();
        }
        System.out.println("\n\t\t-----SAVED-----\n\n\t\t-----Enter now students' informations-----\n\n●");
        for (int i = 0; i < studentsNumber; i++) {
            studentsList.add(Student.enterStudent());
            System.out.println("\t\t-----SAVED!-----\n●");
        }
        System.out.println("\n\t\t-----You have entered " + studentsNumber + " students successfully!-----");
    }

    public static void display() {
    	//After entering informations to the system, it shows all students with their informations and average
        System.out.println("\n\t\t-----Your registered students:-----\n");
        for (Student student : studentsList) {
            System.out.println(student);
            System.out.println("---The student with ID= " + student.getStudentId() + " has an average= " + student.getAverage() + "---\n");
        }
        //Then the system show the highest and the lowest average in the class
        System.out.println("\n\n\t\t-----The highest average is: " + highestAverage() + "-----");
        System.out.println("\n\n\t\t-----The lowest average is: " + lowestAverage() + "-----");
    }

    public static double highestAverage() {
        double max = 0d;
        for (Student student : studentsList) {
            if (student.getAverage() > max) {
                max = student.getAverage();
            }
        }
        return Math.round(max*100.0)/100.0; //this formula allows to set a double like x.abcdef...to x.ab
    }

    public static double lowestAverage() {
        double min = Double.MAX_VALUE;
        for (Student student : studentsList) {
            if (student.getAverage() < min) {
                min = student.getAverage();
            }
        }
        return Math.round(min*100.0)/100.0;
    }
}
