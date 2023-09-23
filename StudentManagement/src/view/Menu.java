package view;

import java.util.List;
import java.util.Scanner;
import model.Student;

public class Menu {

    public void displayWelcomeMessage() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Please choose an option (1-5): ");
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Student getStudentInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Course Name (Java, .Net, C/C++): ");
        String courseName = scanner.nextLine();
        return new Student(id, name, semester, courseName);
    }

    public String getSearchQuery() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name or part of it: ");
        return scanner.nextLine();
    }

    public int getStudentIdInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        return scanner.nextInt();
    }

    public char getUpdateOrDeleteAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to update (U) or delete (D) the student? ");
        return scanner.next().charAt(0);
    }

    public void displayStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Found Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void displayReport(List<String> report) {
        if (report.isEmpty()) {
            System.out.println("No report data available.");
        } else {
            System.out.println("Report:");
            for (String line : report) {
                System.out.println(line);
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
